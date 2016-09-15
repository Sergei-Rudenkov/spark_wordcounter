package by.epam.rudenkov;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;


public class WordCount {
    public static final String FILE_FILTER = "^(.*?).java";
    public static void main(String[] args) {
        String rootDir = args[0];
        String outputPath = args[1];
        SparkConf conf = new SparkConf().setAppName("by.epam.rudenkov.WordCount").setMaster("local");
        JavaSparkContext context = new JavaSparkContext(conf);
        JavaPairRDD<Integer, String> words = context
                .textFile(String.join(",", Util.readDirRecursively(rootDir, FILE_FILTER)))
                .flatMap(Util::getWord)
                .map(String::toLowerCase)
                .mapToPair((word) -> new Tuple2<>(word, 1))
                .reduceByKey(Integer::sum)
                .mapToPair(Tuple2::swap)
                .sortByKey(false)
                .coalesce(1);

        words.saveAsTextFile(outputPath);
    }
}