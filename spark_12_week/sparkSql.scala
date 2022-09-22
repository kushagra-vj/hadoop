import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object sparkSql extends App{
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name", "spark sql session")
  sparkConf.set("spark.master", "local[2]")
  
  val spark = SparkSession.builder().config(sparkConf).getOrCreate()
  
  val orderDf = spark.read
  .format("csv")
  .option("header", true)
  .option("inferSchema", true)
  .option("path", "C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/week_12/orders.csv")
  .load()
  
  orderDf.createOrReplaceTempView("orders")
//  val sqlResult = spark.sql("select order_status, count(*) from orders group by order_status")
  val sqlResult = spark.sql("select order_customer_id, count(*)"+ 
      " as no_of_order_placed from orders where order_status='CLOSED'"+
      " group by order_customer_id order by no_of_order_placed DESC")
  
  sqlResult.show()
  
  
  
  spark.stop()
}