import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object standardWays extends App{
  
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name", "standard ways")
  sparkConf.set("spark.master","local[2]")
  
  val spark = SparkSession.builder()
  .config(sparkConf)
  .getOrCreate()
  
  /*
  val orderDf = spark.read
  .format("csv")
  .option("header", true)
  .option("inferSchema", true)
  .option("path", "C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/week_11/orders.csv")
  .load
  */
  
  // load json file format
  /*
   val orderDf = spark.read
  .format("json")
  //.option("inferSchema", true) //for json schema infer bydefault
//  .option("mode","DROPMALFORMED")
  .option("mode", "FAILFAST")
  .option("path", "C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/week_11/player.json")
  .load
  */
  
  // load parquet file format
   val orderDf = spark.read
  .option("path", "C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/week_11/users.parquet")
  .load
  
  orderDf.printSchema()
  orderDf.show(false) //bydefault data is corrupt data is truncated 
  
//  scala.io.StdIn.readLine()
  spark.stop()
  
}