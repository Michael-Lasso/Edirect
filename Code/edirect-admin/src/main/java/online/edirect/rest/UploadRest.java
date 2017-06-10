package online.edirect.rest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import online.edirect.utils.UploadModel;

@RestController
@RequestMapping("/api")
public class UploadRest {

	public static final Logger log = Logger.getLogger(UploadRest.class);

	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/inventory", method = RequestMethod.GET)
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();

		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Order");
		return model;
	}

	private static String UPLOADED_FOLDER = "F://temp//";

	// 3.1.1 Single file upload
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadfile) {

		log.info("Single file upload!");

		if (uploadfile.isEmpty()) {
			return new ResponseEntity<String>("please select a file!", HttpStatus.OK);
		}

		try {

			saveUploadedFiles(Arrays.asList(uploadfile));

		} catch (IOException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<String>("Successfully uploaded - " + uploadfile.getOriginalFilename(),
				new HttpHeaders(), HttpStatus.OK);

	}

	// 3.1.2 Multiple file upload
	@PostMapping("/upload/multi")
	public ResponseEntity<?> uploadFileMulti(@RequestParam("extraField") String extraField,
			@RequestParam("files") MultipartFile[] uploadfiles) {

		log.debug("Multiple file upload!");

		// Get file name
		String uploadedFileName = Arrays.stream(uploadfiles).map(x -> x.getOriginalFilename())
				.filter(x -> !StringUtils.isEmpty(x)).collect(Collectors.joining(" , "));

		if (StringUtils.isEmpty(uploadedFileName)) {
			return new ResponseEntity<String>("please select a file!", HttpStatus.OK);
		}

		try {

			saveUploadedFiles(Arrays.asList(uploadfiles));

		} catch (IOException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<String>("Successfully uploaded - " + uploadedFileName, HttpStatus.OK);

	}

	// 3.1.3 maps html form to a Model
	@PostMapping("/upload/multi/model")
	public ResponseEntity<?> multiUploadFileModel(@ModelAttribute UploadModel model) {

		log.debug("Multiple file upload! With UploadModel");

		try {

			saveUploadedFiles(Arrays.asList(model.getFiles()));

		} catch (IOException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<String>("Successfully uploaded!", HttpStatus.OK);

	}

	// save file
	private void saveUploadedFiles(List<MultipartFile> files) throws IOException {

		for (MultipartFile file : files) {
			if (file.isEmpty()) {
				continue; // next pls
			}
			log.info("FILE: "+file.getBytes().toString());

			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);

		}

	}

}
