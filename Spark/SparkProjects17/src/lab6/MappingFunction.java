package lab6;

import org.apache.spark.api.java.function.PairFunction;

import scala.Tuple2;

@SuppressWarnings("serial")
public class MappingFunction implements PairFunction<String, String, String> {

	@Override
	public Tuple2<String, String> call(String arg0) throws Exception {
		String[] parts = arg0.split(",");
		return new Tuple2<String, String>(parts[2], parts[1]);
	}

}
