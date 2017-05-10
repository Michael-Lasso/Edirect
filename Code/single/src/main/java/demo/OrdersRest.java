package demo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redrunner.connector.mapper.HotelMapper;

@RestController
public class OrdersRest {

	// @Autowired
	private HotelMapper hotelMapper;

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping("/order")
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Order");
		return model;
	}
}
