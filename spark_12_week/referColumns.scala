import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkConf
import org.apache.spark.sql.functions._

object referColumns extends App{
     Logger.getLogger("org").setLevel(Level.ERROR)
     
     val config = new SparkConf()
     config.set("spark.app.name", "refer columns")
     config.set("spark.master", "local[2]")
     
     val spark = SparkSession.builder().config(config)
     .getOrCreate()
     
     val orderDf = spark.read
     .format("csv")
     .option("header", true)
     .option("inferSchema", true)
     .option("path","C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/week_12/orders.csv")
     .load()
    
     // column string notation
     orderDf.select("order_id", "order_status").show()
     
     // column object notation
//     import spark.implicits._
//     orderDf.select(column("order_id"), col("order_date"), $"order_customer_id",'order_status).show
     
     //column expression
     orderDf.select(column("order_id"), expr("concat(order_status, '_STATUS')")).show(false)
    
     orderDf.selectExpr("order_id", "concat(order_status, '_STATUS')").show(false)
     
     spark.stop()
    
}