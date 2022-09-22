import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession


case class WindowData(country: String, weeknum: Integer, numinvoices: Int, totalquantity: Int, invoicevalue: Float)

object write_parquet extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val spark_conf = new SparkConf()
  .set("spark.app.name", "assign 1")
  .set("spark.master", "local[2]")
  
  val spark = SparkSession.builder().config(spark_conf).getOrCreate()
  
  val windowRdd = spark.read.format("csv")
    .option("path", "C:\\Users\\joharapk\\OneDrive - AMDOCS\\Backup Folders\\Desktop\\share_path\\week_11\\windowdata.csv")
    .load()
  import spark.implicits._
  
  val finalWindowRdd = windowRdd.as[WindowData]
}