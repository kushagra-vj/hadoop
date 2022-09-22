import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.types.TimestampType

object explicitSchema extends App{
  
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name", "Explicit schema")
  sparkConf.set("spark.master", "local[2]")
  
  val spark = SparkSession.builder()
  .config(sparkConf)
  .getOrCreate()
  
  // Programatic schema
//  val orderSchema = StructType(List(
//        StructField("order_id", IntegerType),
//        StructField("order_date", TimestampType),
//        StructField("order_customer_id", IntegerType),
//        StructField("order_status", StringType)
//      ))
  
  // DDL Schema
  
  val orderSchema = "order_id Int, order_date Timestamp, order_customer_id Int, order_status String"
      
  val orderDf = spark.read
  .format("csv")
  .option("header", true)
  .schema(orderSchema)
  .option("path", "C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/week_11/orders.csv")
  .load
  
  orderDf.printSchema()
  orderDf.show()
  
  spark.stop()
  
}