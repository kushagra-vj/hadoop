import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Logger
import org.apache.log4j.Level

object dataframe extends App {
  
//  Logger.getLogger("org").setLevel(Level.ERROR)
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name","first app")
  sparkConf.set("spark.master","local[2]")
  
  val spark = SparkSession.builder()
  .config(sparkConf)
  .getOrCreate()
  
//  val ordersDf = spark.read.csv("C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/week_11/orders.csv") // just read csv file
  
  val ordersDf = spark.read
  .option("header", true)
  .option("inferSchema", true) // Not recommanded
  .csv("C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/week_11/orders.csv")
  
  //ordersDf.show()
  //ordersDf.printSchema()
  
  val order_per_cust = ordersDf.repartition(4)
  .where("order_customer_id > 10000")
  .select("order_id", "order_customer_id")
  .groupBy("order_customer_id")
  .count()
  
  order_per_cust.show()
  
//  scala.io.StdIn.readLine()
  Logger.getLogger(getClass.getName).info("Custom Logger!!!!!!!!!!!!!!!!!!!!!!!!!!!")
  spark.stop()
}