package online.edirect.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import online.edirect.connector.dao.ObjectDao;
import online.edirect.connector.domain.Product;
import online.edirect.connector.domain.Warehouse;
import online.edirect.rest.service.FetchListService;
import online.edirect.utils.QueryId;

@RestController
@RequestMapping("/list")
public class FetchListRest implements FetchListService {
	public static final Logger log = Logger.getLogger(FetchListRest.class);

	@Autowired
	private ObjectDao dao;

	/**
	 * @param category
	 * @param ucBuilder
	 * @return
	 * @throws Exception
	 */
	// @PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public Map<String, Object> createCategory() throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("content", dao.getList(QueryId.RETRIEVE_ALL_CATEGORIES, null));
		return model;
	}

	@RequestMapping(value = "/warehouse", method = RequestMethod.GET)
	public Map<String, Object> createWarehouse() throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Warehouse> list = dao.getList(QueryId.RETRIEVE_ALL_WAREHOUSES, null);
		list.forEach(log::info);
		model.put("content", list);
		return model;
	}

	// -------------------Create a
	// category-------------------------------------------
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public Map<String, Object> getProducts() throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Product> products = dao.getList(QueryId.RETRIEVE_ALL_PRODUCTS, null);
		products.forEach(log::info);
		model.put("content", products);
		return model;
	}
}
