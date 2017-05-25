package online.edirect.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import online.edirect.connector.dao.ObjectDao;
import online.edirect.connector.domain.Category;
import online.edirect.connector.domain.Product;
import online.edirect.utils.QueryId;

@RestController
@RequestMapping("/create")
public class CreateRest {
	public static final Logger logger = Logger.getLogger(CreateRest.class);

	@Autowired
	private ObjectDao dao;

	/**
	 * @param category
	 * @param ucBuilder
	 * @return
	 * @throws Exception
	 */
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public ResponseEntity<?> createCategory(@RequestBody Category category, UriComponentsBuilder ucBuilder)
			throws Exception {
		logger.info("Creating category : {" + category + "}");

		// Category cat = new Category();
		// hotelMapper.saveHotel(user);
		logger.info("Success rest");

		dao.insertQuery(QueryId.SAVE_CATEGORY, category);

		// hotelMapper.saveCategory(cat);
		logger.info("Created: " + category.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/create/{id}").buildAndExpand(category.getCategory_name()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// -------------------Create a
	// category-------------------------------------------
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public ResponseEntity<?> createProduct(@RequestBody Product product, UriComponentsBuilder ucBuilder)
			throws Exception {
		logger.info("Creating Product : {" + product + "}");

		dao.insertQuery(QueryId.SAVE_PRODUCT, product);

		// hotelMapper.saveCategory(cat);
		logger.info("Created: " + product.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/create/{id}").buildAndExpand(product.getProduct_name()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
}
