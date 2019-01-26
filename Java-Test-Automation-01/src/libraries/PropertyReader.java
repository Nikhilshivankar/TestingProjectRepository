package libraries;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	public Properties properties;
	private final String propertyFilePath = "src\\configs\\Configuration.properties";

	public void readConfigProperties() {

		FileReader reader;

		try {

			reader = new FileReader(propertyFilePath);
			properties = new Properties();

			try {
				properties.load(reader);
				reader.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();

			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getBrowserType() {

		String browserType = properties.getProperty("browserType");
		if (browserType != null)
			return browserType;

		else
			throw new RuntimeException("browserType not specified in the Configuration.properties file.");
	}

	public String getBrowserDriverPath() {
		String driverPath = properties.getProperty("browserDriverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("browserDriverPath not specified in the Configuration.properties file.");
	}

	public long getImplicitlyWait() {
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
	}

	public String getApplicationUrl() {
		String url = properties.getProperty("testUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("testUrl not specified in the Configuration.properties file.");
	}
	
	public String getTestDataExcel() {

		String dataFile = properties.getProperty("testDataExcel");
		if (dataFile != null)
			return dataFile;

		else
			throw new RuntimeException("testDataExcel not specified in the Configuration.properties file.");
	}

}
