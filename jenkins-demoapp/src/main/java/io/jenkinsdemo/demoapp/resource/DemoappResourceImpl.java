package io.jenkinsdemo.demoapp.resource;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Main API. No-arg constructor instantiation is required by Jersey.
 */
@Path("/")
public class DemoappResourceImpl {

	private static final Logger LOGGER = LogManager.getLogger(DemoappResourceImpl.class);

	/**
	 * Demo endpoint 1.
	 * 
	 * @return 204
	 */
	@POST
	@Path("/endpoint1")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response demoEndpoint1() {
		LOGGER.debug("Received a request on demo endpoint 1");
		return Response.noContent().build();
	}

	/**
	 * Demo hello.
	 * 
	 * @return 200
	 */
	@GET
	@Path("hello")
	@Produces(MediaType.TEXT_PLAIN)
	public Response hello() {
		LOGGER.debug("Received a request on demo hello");
		if (System.getProperty("user.name").isEmpty()) {
			return Response.ok("Hello, Jenkins users!").build();
		} else {
			return Response.ok("Hello, " + System.getProperty("user.name") + "! Are you enjoying the Jenkins demo?").build();
		}

	}

	/**
	 * Demo machine.
	 * 
	 * @return 200
	 */
	@GET
	@Path("hostname")
	@Produces(MediaType.TEXT_PLAIN)
	public Response hostname() {
		LOGGER.debug("Received a request for the current hostname");
		InetAddress addr;
		String hostname;
		try {
			addr = InetAddress.getLocalHost();
			hostname = addr.getHostName();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).entity("Hostname cannot be resolved").build();
		}

		return Response.ok("Hostname of the current vm is: " + hostname).build();
	}
}
