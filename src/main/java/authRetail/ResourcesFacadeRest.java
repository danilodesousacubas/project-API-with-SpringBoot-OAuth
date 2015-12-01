package authRetail;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/services/v1")
public class ResourcesFacadeRest {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.POST, value = "/geraToken")
	public ResponseEntity<String> createToken( @RequestHeader(value = "Authorization", required = true) String authorization)
			throws Exception {

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", authorization);
		HttpEntity<String> entityHeader = new HttpEntity<String>(headers);

		ResponseEntity<String> entity = null;

		RestTemplate restTemplate = new RestTemplate();

		entity = restTemplate.exchange("http://localhost:8080/authRetail/oauth/token?grant_type=password&username=user&password=123",
				HttpMethod.POST,
				entityHeader, String.class);

		return new ResponseEntity(entity.toString(), HttpStatus.OK);

	}
}
