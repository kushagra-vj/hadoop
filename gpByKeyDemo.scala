import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkContext

object gpByKeyDemo extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sc = new SparkContext("local[*]","gpByKey")
  
  val baseRDD = sc.textFile("C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/week_10/bigLogtxt/bigLog.txt")
  val mapRDD = baseRDD.map(x => {
    val fields = x.split(":")
    //(fields(0), fields(1))
    (fields(0),1)
  })
  //mapRDD.groupByKey.collect().foreach(x => (x._1, x._2.size))
  mapRDD.reduceByKey(_+_).collect().foreach(println)
  scala.io.StdIn.readLine()
}