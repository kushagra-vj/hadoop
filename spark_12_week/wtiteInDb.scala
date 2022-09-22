import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.SaveMode

object wtiteInDb extends App{
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name", "spark sql db write")
  sparkConf.set("spark.master", "local[2]")
  
  val spark = SparkSession.builder()
  .config(sparkConf)
  .enableHiveSupport()
  .getOrCreate()
  
  val orderDf = spark.read
  .format("csv")
  .option("header", true)
  .option("inferSchema", true)
  .option("path", "C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/week_12/orders.csv")
  .load()
  
  spark.sql("create database if not exists retail")
  
  orderDf.write
  .format("csv")
  .mode(SaveMode.Overwrite)
  .saveAsTable("retail.orders")
  
  spark.catalog.listTables("retail").show()
  
  spark.stop()
}

