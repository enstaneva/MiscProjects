package io.jenkinsdemo.demoapp.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class TestHello {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGreeting() {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://" + TestUtils.HOSTNAME + ":" + TestUtils.APP_PORT).path("hello");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.TEXT_PLAIN);
		Response response = invocationBuilder.get();
		Assert.assertEquals(200, response.getStatus());
		Assert.assertTrue(response.readEntity(String.class).contains("Jenkins 2 demo"));

	}

}
