package online.edirect.controller;

import java.io.File;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import online.edirect.geocoordinates.Coordinates;
import online.edirect.geocoordinates.GeoCodeSample;
import online.edirect.simulator.model.RedRunner;
import online.edirect.simulator.service.SpringRestClient;
import online.edirect.utils.Constants;
import online.edirect.utils.FileParser;

@Component
public class ScheduledTasks {
	static Logger log = Logger.getLogger(ScheduledTasks.class);

	@Scheduled(fixedRate = 20000)
	public void reportCurrentTime() {

		boolean hasChanged = fileChanged(Constants.TRAFFIC_FILE_PATH, Constants.TIMESTAMP_FILE_PATH);
		if (hasChanged) {
			String data = FileParser.FileReader(Constants.TRAFFIC_FILE_PATH);
			String lines[] = data.trim().split("\\r?\\n");
			File trafficFile = new File(Constants.TRAFFIC_FILE_PATH);
			Long trafficTimeStamp = trafficFile.lastModified();
			FileParser.FileCleaner(Constants.TIMESTAMP_FILE_PATH);
			FileParser.FileCleaner(Constants.TRAFFIC_FILE_PATH);
			FileParser.FileWritter(Constants.TIMESTAMP_FILE_PATH, trafficTimeStamp + "");
			log.info(
					"\n\n\t---------------------+Saving lattest batch into DB and resetting files+---------------------");

			SpringRestClient rest = new SpringRestClient();
			rest.sendTokenRequest();

			for (int i = 0; i < lines.length; i++) {
				if (lines[i].trim().length() == 0) {
					continue;
				}
				// post to database

				String latitude = lines[i].split(Constants.SEPARATOR)[0];
				String longitude = lines[i].split(Constants.SEPARATOR)[1];
				// DAO.insertRecord(coord);
				RedRunner redrunner = new RedRunner(latitude, longitude, System.currentTimeMillis(), "");
				log.info("--XXTrying to save: " + redrunner.toString());
				rest.createRedRunner(redrunner);
				log.info("--XXSaved: " + redrunner.toString());
			}
			log.info("\n\n\t---------------------+Starting new batch+---------------------");

		}
	}

	private boolean fileChanged(String trafficFilePath, String timestampFile) {
		File trafficFile = new File(trafficFilePath);
		Long trafficTimeStamp = trafficFile.lastModified();
		Long timestamp = Long.parseLong(FileParser.FileReader(timestampFile));
		return !trafficTimeStamp.equals(timestamp);
	}
}
