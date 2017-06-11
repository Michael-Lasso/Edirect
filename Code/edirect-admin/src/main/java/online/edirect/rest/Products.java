package online.edirect.rest;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import online.edirect.connector.dao.ObjectDao;
import online.edirect.connector.domain.Category;
import online.edirect.connector.domain.Users;
import online.edirect.connector.mapper.HotelMapper;
import online.edirect.errors.CustomErrorType;
import online.edirect.utils.QueryId;

@RestController
@RequestMapping("/product")
public class Products {
	public static final Logger logger = Logger.getLogger(Products.class);

	@Autowired
	private HotelMapper hotelMapper;

	@Autowired
	private ObjectDao dao;

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping("/product")
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Products");
		return model;
	}

	// -------------------Create a
	// User-------------------------------------------

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody Users user, UriComponentsBuilder ucBuilder) {
		logger.info("Creating User : {" + user + "}");

		if (user != null) {
			logger.info("Unable to create. A User with name {} already exist: " + user.toString());
			// return new ResponseEntity<CustomErrorType>(
			// new CustomErrorType("Unable to create. A User with name " +
			// user.getName() + " already exist."),
			// HttpStatus.CONFLICT);
		}
		// Category cat = new Category();
		// hotelMapper.saveHotel(user);
		logger.info("Success rest");
		try {
			dao.insertQuery(QueryId.TEST_QUERY, user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// hotelMapper.saveCategory(cat);
		logger.info("Created: " + user.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/product/{id}").buildAndExpand(user.toString()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a User
	// ------------------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody Category category) throws Exception {
		logger.info("Updating User with id {" + id + "}");

		Category currentUser = dao.getEdirectRecord("test", id);

		if (currentUser == null) {
			logger.error("Unable to update. User with id {} not found: " + id);
			return new ResponseEntity<CustomErrorType>(
					new CustomErrorType("Unable to upate. User with id " + id + " not found."), HttpStatus.NOT_FOUND);
		}

		currentUser.setCategory_name(category.getCategory_name());

		try {
			dao.insertQuery(QueryId.TEST_QUERY, currentUser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Category>(currentUser, HttpStatus.OK);
	}
	//
	// // ------------------- Delete a
	// // User-----------------------------------------
	//
	// @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	// public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
	// logger.info("Fetching & Deleting User with id {"+id+"}");
	//
	// City user = hotelMapper.findById(id);
	// if (user == null) {
	// logger.error("Unable to delete. User with id {} not found.", id);
	// return new ResponseEntity(new CustomErrorType("Unable to delete. User
	// with id " + id + " not found."),
	// HttpStatus.NOT_FOUND);
	// }
	// hotelMapper.deleteUserById(id);
	// return new ResponseEntity<City>(HttpStatus.NO_CONTENT);
	// }
	//
	// // ------------------- Delete All Users-----------------------------
	//
	// @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
	// public ResponseEntity<City> deleteAllUsers() {
	// logger.info("Deleting All Users");
	//
	// hotelMapper.deleteAllUsers();
	// return new ResponseEntity<City>(HttpStatus.NO_CONTENT);
	// }
}
