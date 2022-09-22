import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.Dataset
import org.apache.spark.sql.Row
import java.security.Timestamp

case class OrderData(order_id: Int, order_date: Timestamp, order_customer_id: Int, order_status: String)

object dataFrameSet extends App{
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name", "data frame")
  sparkConf.set("spark.master", "local[2]")
  
  val spark = SparkSession.builder()
  .config(sparkConf)
  .getOrCreate()
  
  val orderDf: Dataset[Row] = spark.read    // Dataset[Row] is return type of read csv function
  .option("header", true)
  .option("inferSchema", true)
  .csv("C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/week_11/orders.csv")
  
  import spark.implicits._
  
  val orderDS = orderDf.as[OrderData]
  
  orderDS.filter(x => x.order_id < 10)
  
//  orderDf.filter("order_ids <10").show()
  
  scala.io.StdIn.readLine()
  spark.stop()
}