package online.edirect.rest;

import javax.annotation.PostConstruct;

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
import online.edirect.connector.domain.Administrator;
import online.edirect.connector.domain.AffiliatedCompany;
import online.edirect.connector.domain.Category;
import online.edirect.connector.domain.Deal;
import online.edirect.connector.domain.DiscountCode;
import online.edirect.connector.domain.EmailAlert;
import online.edirect.connector.domain.Image;
import online.edirect.connector.domain.Product;
import online.edirect.connector.domain.Warehouse;
import online.edirect.utils.QueryId;

@RestController
@RequestMapping("/create")
public class Create {
	public static final Logger log = Logger.getLogger(Create.class);

	@Autowired
	private ObjectDao dao;

	@PostConstruct
	public void init() {
		try {
			log.info("Initializing Rest create controller");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Persists category into DB, if conflict, category name already exists.
	 * 
	 * @param category
	 * @param ucBuilder
	 * @return
	 * @throws Exception
	 */
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public ResponseEntity<?> createCategory(@RequestBody Category category, UriComponentsBuilder ucBuilder)
			throws Exception {
		String name = dao.getEdirectRecord(QueryId.GET_CATEGORY_BY_NAME, category.getCategory_name());
		if (name != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		dao.insertQuery(QueryId.CREATE_CATEGORY, category);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/create/{id}").buildAndExpand(category.getCategory_name()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	/**
	 * Persists product into DB, if conflict, product name already exists.
	 * 
	 * @param product
	 * @param ucBuilder
	 * @return
	 * @throws Exception
	 */
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public ResponseEntity<?> createProduct(@RequestBody Product product, UriComponentsBuilder ucBuilder)
			throws Exception {
		String name = dao.getEdirectRecord(QueryId.GET_PRODUCT_BY_NAME, product.getProduct_name());
		if (name != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		dao.insertQuery(QueryId.CREATE_PRODUCT, product);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/create/{id}").buildAndExpand(product.getProduct_name()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	/**
	 * Persists warehouse into DB, if conflict, warehouse name already exists.
	 * 
	 * @param warehouse
	 * @param ucBuilder
	 * @return
	 * @throws Exception
	 */
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/warehouse", method = RequestMethod.POST)
	public ResponseEntity<?> createWarehouse(@RequestBody Warehouse warehouse, UriComponentsBuilder ucBuilder)
			throws Exception {
		String name = dao.getEdirectRecord(QueryId.GET_WAREHOUSE_BY_NAME, warehouse.getWarehouse_name());
		if (name != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		dao.insertQuery(QueryId.CREATE_WAREHOUSE, warehouse);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/create/{id}").buildAndExpand(warehouse.getWarehouse_name()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	/**
	 * Persists company into DB, if conflict, company name already exists.
	 * 
	 * @param company
	 * @param ucBuilder
	 * @return
	 * @throws Exception
	 */
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/affiliated_company", method = RequestMethod.POST)
	public ResponseEntity<?> createCompany(@RequestBody AffiliatedCompany company, UriComponentsBuilder ucBuilder)
			throws Exception {
		String name = dao.getEdirectRecord(QueryId.GET_COMPANY_BY_NAME, company.getCompany_name());
		if (name != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		dao.insertQuery(QueryId.CREATE_AFFILIATED_COMPANY, company);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/create/{id}").buildAndExpand(name).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public ResponseEntity<?> createAdmin(@RequestBody Administrator admin, UriComponentsBuilder ucBuilder)
			throws Exception {
		if (admin == null) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		dao.insertQuery(QueryId.CREATE_ADMINISTRATOR, admin);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/image", method = RequestMethod.POST)
	public ResponseEntity<?> createImage(@RequestBody Image image, UriComponentsBuilder ucBuilder) throws Exception {
		if (image == null) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		dao.insertQuery(QueryId.CREATE_IMAGE, image);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/email_alert", method = RequestMethod.POST)
	public ResponseEntity<?> createEmailAlert(@RequestBody EmailAlert email_alert, UriComponentsBuilder ucBuilder)
			throws Exception {
		if (email_alert == null) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		dao.insertQuery(QueryId.CREATE_EMAIL_ALERT, email_alert);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/discount_code", method = RequestMethod.POST)
	public ResponseEntity<?> createDiscountCode(@RequestBody DiscountCode discount_code, UriComponentsBuilder ucBuilder)
			throws Exception {
		if (discount_code == null) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		dao.insertQuery(QueryId.CREATE_DISCOUNT_CODE, discount_code);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/deal", method = RequestMethod.POST)
	public ResponseEntity<?> createDeal(@RequestBody Deal deal) throws Exception {
		if (deal == null) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		dao.insertQuery(QueryId.CREATE_DEAL, deal);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
}
