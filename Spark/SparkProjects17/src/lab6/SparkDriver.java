package lab6;

import org.apache.spark.api.java.*;
import org.apache.spark.SparkConf;
	
public class SparkDriver {
	
	public static void main(String[] args) {
		
		System.setProperty("hadoop.home.dir", "C:\\winutil\\");

		String inputPath;
		String outputPath;
		
		inputPath=args[0];
		outputPath=args[1];

	
		// Create a configuration object and set the name of the application
		SparkConf conf=new SparkConf().setAppName("Spark Exercise lab6");
		
		// Create a Spark Context object
		JavaSparkContext sc = new JavaSparkContext(conf);

		
		// Read the content of the input file
		// Each element/string of the logRDD corresponds to one line of the input file  
		JavaRDD<String> logRDD = sc.textFile(inputPath);

		JavaPairRDD<String, String> mapped = logRDD.mapToPair(new MappingFunction());
		
		JavaPairRDD<String, Iterable<String>> result = mapped.groupByKey();
		
		//JavaPairRDD<> test = result.flatMapValues()
		
		JavaRDD<Iterable<String>> test = result.values();
		
		JavaPairRDD<String,String,Integer> freq = test.mapToPair();
		
		// Store the result in the output folder
		result.saveAsTextFile(outputPath);

		// Close the Spark context
		sc.close();
	}
}