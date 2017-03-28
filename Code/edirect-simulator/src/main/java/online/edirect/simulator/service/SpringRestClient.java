package online.edirect.simulator.service;

import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import online.edirect.simulator.model.AuthTokenInfo;
import online.edirect.simulator.model.RedRunner;

public class SpringRestClient {

	// http://localhost:8080/red-runner-rest
	// http://lokiz-rest.us-east-1.elasticbeanstalk.com

	private static final String URL = "http://localhost:8080/edirect-rest";

	public static final String REST_SERVICE_URI = URL;

	public static final String AUTH_SERVER_URI = URL + "/oauth/token";

	public static final String QPM_PASSWORD_GRANT = "?grant_type=password&username=micha32&password=cordoba32";

	public static final String QPM_ACCESS_TOKEN = "?access_token=";
	private AuthTokenInfo tokenInfo;

	/*
	 * Prepare HTTP Headers.
	 */
	private static HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		// headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return headers;
	}

	/*
	 * Add HTTP Authorization header, using Basic-Authentication to send
	 * client-credentials.
	 */
	private static HttpHeaders getHeadersWithClientCredentials() {
		String plainClientCredentials = "web-redrunner:021587";
		String base64ClientCredentials = new String(Base64.encodeBase64(plainClientCredentials.getBytes()));

		HttpHeaders headers = getHeaders();
		headers.add("Authorization", "Basic " + base64ClientCredentials);
		return headers;
	}

	/*
	 * Send a POST request [on /oauth/token] to get an access-token, which will
	 * then be send with each request.
	 */
	@SuppressWarnings({ "unchecked" })
	public void sendTokenRequest() {
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<String> request = new HttpEntity<String>(getHeadersWithClientCredentials());
		ResponseEntity<Object> response = restTemplate.exchange(AUTH_SERVER_URI + QPM_PASSWORD_GRANT, HttpMethod.POST,
				request, Object.class);
		LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) response.getBody();

		if (map != null) {
			tokenInfo = new AuthTokenInfo();
			tokenInfo.setAccess_token((String) map.get("access_token"));
			tokenInfo.setToken_type((String) map.get("token_type"));
			tokenInfo.setRefresh_token((String) map.get("refresh_token"));
			tokenInfo.setExpires_in((int) map.get("expires_in"));
			tokenInfo.setScope((String) map.get("scope"));
			System.out.println(tokenInfo);
		} else {
			System.out.println("No user exist----------");
		}

	}

	/*
	 * Send a POST request to create a new user.
	 */
	public void createRedRunner(RedRunner redrunner) {
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<Object> request = new HttpEntity<Object>(redrunner, getHeaders());
		
		restTemplate.postForLocation(REST_SERVICE_URI + "/authenticate/" + QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(),
				request, RedRunner.class);
	}

	public static void main(String args[]) {
		String[] list = { "-72.936249/41.308289", "-72.937494/41.308877", "-72.939457/41.309457",
				"-72.941764/41.309924", "-72.944875/41.310657", "-72.941796/41.314745" };
		for (int i = 0; i < list.length; i++) {
			RedRunner redrunner = new RedRunner(list[i].split("/")[0], list[i].split("/")[1],
					System.currentTimeMillis(), "");
			SpringRestClient rest = new SpringRestClient();
			rest.sendTokenRequest();
			rest.createRedRunner(redrunner);
			System.out.println(redrunner.toString() + "\nSleeping for 6 seconds");
			try {
				TimeUnit.SECONDS.sleep(25);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}