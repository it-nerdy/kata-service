/**
 * 
 */
package com.carfax.service.vinservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * @author Mallikarjun Nuti
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@DirtiesContext
public class KataIT {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	/**
	 * Integration Test for the kata service application.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpload() throws Exception {
		String filePath = this.getClass().getClassLoader().getResource("vehicles.csv").getPath();
		File inputFile = new File(filePath);
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(inputFile);
			Resource resource = new ByteArrayResource(IOUtils.toByteArray(fileInputStream));
			HttpHeaders binaryHeaders = new HttpHeaders();
			binaryHeaders.setContentDispositionFormData("file", "vehicles.csv");
			MultiValueMap<String, Object> allArguments = new LinkedMultiValueMap<String, Object>();
			HttpEntity<Resource> entity = new HttpEntity<Resource>(resource, binaryHeaders);
			allArguments.add("file", entity);
			ResponseEntity<String> response = restTemplate
					.postForEntity("http://localhost:" + this.port + "/uploadFile", new HttpEntity<>(allArguments), String.class);
			String expected = "{response:Success}";
			JSONAssert.assertEquals(expected, response.getBody(), true);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
