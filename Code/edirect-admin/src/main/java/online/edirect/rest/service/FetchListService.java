package online.edirect.rest.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import online.edirect.connector.domain.Product;

//@RestController
//@RequestMapping("/list")
public interface FetchListService{
	
	/**
	 * @param category
	 * @param ucBuilder
	 * @return
	 * @throws Exception
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
//	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public  Map<String, Object> createCategory() throws Exception;


	// -------------------Create a
	// category-------------------------------------------
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public ResponseEntity<?> createProduct(@RequestBody Product product, UriComponentsBuilder ucBuilder)
			throws Exception; 
}
