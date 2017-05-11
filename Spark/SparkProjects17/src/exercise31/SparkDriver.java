package exercise31;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class SparkDriver {

	
	
	public static void main(String[] args) {
		
		String inputPath = args[0];
		String outputPath = args[1];
		
		
		SparkConf conf=new SparkConf().setAppName("Spark Exercise #31");
		
		
		
		JavaSparkContext cf = new JavaSparkContext(conf);
		
		
		JavaRDD<String> input = cf.textFile(inputPath);
		
		JavaRDD<String> filtered = input.filter(new FilterFunction());
		
		
		
		
	}
}
