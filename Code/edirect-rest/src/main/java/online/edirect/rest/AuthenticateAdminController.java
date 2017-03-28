/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package online.edirect.rest;

import java.security.Principal;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import online.edirect.model.domain.Coordinates;
import online.edirect.model.domain.RedRunner;
import online.edirect.model.domain.StreetIntersection;
import online.edirect.model.repos.AccountRepository;
import online.edirect.model.repos.RedRunnerRepository;
import online.edirect.model.repos.StreetIntersectionRepository;
import online.edirect.rest.security.UserNotFoundException;

@Component
@RestController
@RequestMapping("/authenticate")
class AuthenticateAdminController {

	static Logger log = Logger.getLogger(AuthenticateAdminController.class);

	@Autowired
	private StreetIntersectionRepository streetIntersectionRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private RedRunnerRepository red_RunnerRepository;

	@RequestMapping(method = RequestMethod.GET)
	Resources<IntersectionResource> readBookmarks(Principal principal) {
		this.validateUser(principal);

		// List<IntersectionResource> bookmarkResourceList =
		// bookmarkRepository.findByAccountUsername(principal.getName())
		// .stream().map(IntersectionResource::new).collect(Collectors.toList());

		return new Resources<>(null);
	}

	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<RedRunner> add(Principal principal, @RequestBody RedRunner input) {
		this.validateUser(principal);
		if (input == null) {
			return new ResponseEntity<RedRunner>(HttpStatus.NOT_FOUND);
		} else {
			Optional<StreetIntersection> obj = streetIntersectionRepository
					.findByLongitudeAndLatitude(input.getLongitude(), input.getLatitude());
			if (obj.isPresent()) {
				log.info("Object exists: " + input.toString());
				red_RunnerRepository.save(new RedRunner(input.getLatitude(), input.getLongitude(), input.getTimestamp(),
						obj.get().getStreetName()));
			} else {
				log.info("No object exists: " + input.toString());
				Coordinates coord = new Coordinates();
				coord.setLatitude(input.getLatitude());
				coord.setLongitude(input.getLongitude());
				
				
				

				streetIntersectionRepository
						.save(new StreetIntersection("name", input.getLongitude(), input.getLatitude()));

				red_RunnerRepository.save(input);
				log.info("saved: " + input.toString());
			}
			return new ResponseEntity<RedRunner>(input, HttpStatus.OK);
		}
	}

	private void validateUser(Principal principal) {
		String userId = principal.getName();
		this.accountRepository.findByUsername(userId).orElseThrow(() -> new UserNotFoundException(userId));
	}
}
// end::code[]