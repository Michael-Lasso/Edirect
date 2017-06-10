package online.edirect.rest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import online.edirect.utils.UploadResponseRep;

@RestController
@RequestMapping("/upload")
public class UploadController {
	public static final Logger log = Logger.getLogger(UploadController.class);
	/**
	 * Injected just so we can return information about it. If Spring's
	 * multipart support is enabled in {@code application.properties}, and/or we
	 * add back CommonsMultipartResolver in our configuration, re-autowire this
	 * so we get more information.
	 */
	@Autowired
	private MultipartResolver multipartResolver;

	@Autowired
	private Environment environment;

	/**
	 * Creates and initializes basic properties of a response about an upload.
	 *
	 * @param request
	 *            The request received.
	 * @return A response rep, with some fields populated.
	 */
	private UploadResponseRep createUploadResponseRep(HttpServletRequest request) {
		UploadResponseRep rep = new UploadResponseRep();
		rep.setRequestType(request.getClass().getName());
		rep.setMultipartResolverType(multipartResolver == null ? null : multipartResolver.getClass().getName());
		rep.setFileSizeThreshold(environment.getProperty("spring.http.multipart.file-size-threshold"));
		return rep;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/part", consumes = {
			MediaType.MULTIPART_FORM_DATA_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public UploadResponseRep getViaRequestPart(HttpServletRequest request) throws Exception {

		Collection<Part> parts = request.getParts();
		if (parts.isEmpty()) {
			throw new FileUploadException(
					"No parts found on request.  Make sure Spring's multipart support is enabled for this upload method to work");
		}
		log.info("Success file upload");
		UploadResponseRep rep = createUploadResponseRep(request);

		Part part = parts.iterator().next();
		rep.setDesc("Part type == " + part.getClass().getName());
		try (InputStream in = part.getInputStream()) {
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			StringBuilder sb = new StringBuilder();

			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			log.info("FILE: "+sb.toString());
			rep.setInputStreamType(in.getClass().getName());
		}

		return rep;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/multipartFile", consumes = {
			MediaType.MULTIPART_FORM_DATA_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public UploadResponseRep getViaMultipartFile(@RequestParam(required = false) MultipartFile file,
			HttpServletRequest request) throws Exception {

		if (file == null) {
			throw new FileUploadException(
					"MultipartFile was null (likely no parts on request).  Make sure Spring's multipart support is enabled for this upload method to work");
		}

		UploadResponseRep rep = createUploadResponseRep(request);

		try (InputStream in = file.getInputStream()) {
			rep.setInputStreamType(in.getClass().getName());
		}

		return rep;
	}

	/**
	 * Use commons-fileupload's streaming API to read the uploaded file straight
	 * off of the socket, as an InputStream. This won't work if
	 * spring.http.multipart.enabled=true, due to the request being
	 * pre-processed.
	 *
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/commonsFileUploadStreamingApi", consumes = {
			MediaType.MULTIPART_FORM_DATA_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UploadResponseRep> getViaCommonsFileUploadStreamingApi(HttpServletRequest request)
			throws Exception {

		UploadResponseRep rep = createUploadResponseRep(request);

		ServletFileUpload upload = new ServletFileUpload();

		// NOTE: We're doing no real validation here, this is just for test
		// purposes
		FileItemIterator iter = upload.getItemIterator(request);
		if (!iter.hasNext()) {
			throw new FileUploadException("FileItemIterator was empty");
		}
		FileItemStream item = iter.next();

		try (InputStream in = item.openStream()) {
			rep.setInputStreamType(in.getClass().getName());
		}

		return new ResponseEntity<>(rep, HttpStatus.OK);
	}

}