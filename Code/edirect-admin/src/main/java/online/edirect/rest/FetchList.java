package online.edirect.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import online.edirect.connector.dao.ObjectDao;
import online.edirect.connector.domain.Product;
import online.edirect.connector.domain.Warehouse;
import online.edirect.utils.QueryId;

@RestController
@RequestMapping("/list")
public class FetchList {
	public static final Logger log = Logger.getLogger(FetchList.class);

	@Autowired
	private ObjectDao dao;

	/*
	 * Fetch all Categories from DB
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public Map<String, Object> retrieveAllCategories() throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("content", dao.getList(QueryId.RETRIEVE_ALL_CATEGORIES, null));
		return model;
	}

	/**
	 * Fetch all Warehouses from DB
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/warehouse", method = RequestMethod.GET)
	public Map<String, Object> retrieveAllWarehouses() throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Warehouse> list = dao.getList(QueryId.RETRIEVE_ALL_WAREHOUSES, null);
		list.forEach(log::info);
		model.put("content", list);
		return model;
	}

	/*
	 * Fetch all Products from DB
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public Map<String, Object> retrieveAllProducts() throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Product> products = dao.getList(QueryId.RETRIEVE_ALL_PRODUCTS, null);
		model.put("content", products);
		return model;
	}
}
