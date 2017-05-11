package lab6;

import org.apache.spark.api.java.*;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.python.PairwiseRDD;
import org.apache.spark.api.r.PairwiseRRDD;
import org.apache.spark.SparkConf;
	
public class SparkDriver {
	
	public static void main(String[] args) {

		String inputPath;
		String outputPath;
		String startWord;
		
		inputPath=args[0];
		outputPath=args[1];
		startWord=args[2];

	
		// Create a configuration object and set the name of the application
		SparkConf conf=new SparkConf().setAppName("Spark Exercise #30");
		
		// Create a Spark Context object
		JavaSparkContext sc = new JavaSparkContext(conf);

		
		// Read the content of the input file
		// Each element/string of the logRDD corresponds to one line of the input file  
		JavaRDD<String> logRDD = sc.textFile(inputPath);

		Function<String, Boolean> f = ;
		
		JavaPairRDD<String,String> mapped = logRDD.mapToPair(f);
		
		// Store the result in the output folder
		resultRDD.saveAsTextFile(outputPath);

		// Close the Spark context
		sc.close();
	}
}
