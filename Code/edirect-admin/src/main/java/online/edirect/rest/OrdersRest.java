package online.edirect.rest;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import online.edirect.connector.mapper.HotelMapper;

@RestController
public class OrdersRest {

	@Autowired
	private HotelMapper hotelMapper;

	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping("/order")
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();
		System.out.println(hotelMapper.selectByCityId(1).getName());
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Order");
		return model;
	}
}
