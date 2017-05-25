package online.edirect.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
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
import online.edirect.connector.domain.Product;
import online.edirect.utils.QueryId;

@RestController
@RequestMapping("/list")
public class FetchListRest {
	public static final Logger logger = Logger.getLogger(FetchListRest.class);

	@Autowired
	private ObjectDao dao;

	/**
	 * @param category
	 * @param ucBuilder
	 * @return
	 * @throws Exception
	 */
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public Resources<IntersectionResource> createCategory() throws Exception {
		List<IntersectionResource> bookmarkResourceList = dao.getList(QueryId.RETRIEVE_ALL_CATEGORIES, null).stream()
				.map(IntersectionResource::new).collect(Collectors.toList());
		return new Resources<>(bookmarkResourceList);

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
