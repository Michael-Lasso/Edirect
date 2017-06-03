package online.edirect.rest;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardRest {

	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}

	 @PreAuthorize("hasRole('ADMIN')")
	@RequestMapping("/resource")
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Dashboard");
		return model;
	}
}
