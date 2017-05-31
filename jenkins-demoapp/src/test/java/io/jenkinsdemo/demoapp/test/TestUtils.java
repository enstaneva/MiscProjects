package io.jenkinsdemo.demoapp.test;

public class TestUtils {

	public static final String HOSTNAME = System.getProperty("app.host.name", "localhost");
	
	public static final String APP_PORT = System.getProperty("app.port", "8090");
}
