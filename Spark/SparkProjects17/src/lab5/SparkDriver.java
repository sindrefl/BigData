package lab5;

import org.apache.spark.api.java.*;

import lab5.FilterGoogle;

import org.apache.spark.SparkConf;
	
public class SparkDriver {
	
	public static void main(String[] args) {
		
		System.setProperty("hadoop.home.dir", "C:\\winutil\\");

		String inputPath;
		String outputPath;
		
		inputPath=args[0];
		outputPath=args[1];
	
		// Create a configuration object and set the name of the application
		SparkConf conf=new SparkConf().setAppName("Spark Exercise #30");
		
		// Create a Spark Context object
		JavaSparkContext sc = new JavaSparkContext(conf);

		
		// Read the content of the input file
		// Each element/string of the logRDD corresponds to one line of the input file  
		JavaRDD<String> logRDD = sc.textFile(inputPath);

		// Solution based on an named class
		// An object of the FilterGoogle is used to filter the content of the RDD.
		// Only the elements of the RDD satisfying the filter imposed by means 
		// of the call method of the FilterGoogle class are included in the 
		// googleRDD RDD
		JavaRDD<String> googleRDD = logRDD.filter(new FilterGoogle());
		
		// Store the result in the output folder
		googleRDD.saveAsTextFile(outputPath);

		// Close the Spark context
		sc.close();
	}
}
