// user_id, movie_id, rating_given, timestamp all are seperated by tabs
// how many times moview rated 5 starts, 4 starts, ...

import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkContext

/*
object cntStarts extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sc = new SparkContext("local[*]","star cnt")
  
  val input = sc.textFile("C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/spark_dataset/moviedata.data")
  val starData = input.map(x => (x.split("\t")(2).toInt))
  val mapStar = starData.map(x => (x,1))
  val cntStar = mapStar.reduceByKey((x,y) => x+y)
  cntStar.collect.foreach(println)
}
*/

object cntStarts extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sc = new SparkContext("local[*]","star cnt")
  
  val input = sc.textFile("C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/spark_dataset/moviedata.data")
  val starData = input.map(x => x.split("\t")(2))
  val cntStar = starData.countByValue
  cntStar.foreach(println)
}