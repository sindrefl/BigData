package exercisetest;

import org.apache.spark.api.java.function.Function;

// Define a class implementing the Function<String, Boolean> interface
@SuppressWarnings("serial")
public class FilterGoogle implements Function<String, Boolean> {
	// Implement the call method
	// The call method receives one element (one string) 
	// and returns true if the element contains the word google.
	// Otherwise, it returns false.			
	public Boolean call(String logLine) { 
		return logLine.toLowerCase().contains("google"); 
	}
}
