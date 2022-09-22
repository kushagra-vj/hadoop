import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkConf
import org.apache.spark.sql.SaveMode


object unstructureDfExample extends App {
  
  val regex = """^(\S+) (\S+)\t(\S+),(\S+)""".r
  
  case class Order(order_id: Int, customer_id: Int, order_status: String)

  def parser(line: String) = {
    line match {
      case regex(order_id, data, customer_id, order_status)=>
        Order(order_id.toInt, customer_id.toInt, order_status)
    }
  }
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val conf = new SparkConf()
  conf.set("spark.app.name", "write to output file")
  conf.set("spark.master", "local[2]")
  
  val spark = SparkSession.builder().config(conf).getOrCreate()
  
  // RDD
  val lines = spark.sparkContext
        .textFile("C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/week_12/orders_new.csv")      
   
  import spark.implicits._
  val structredRDDOrDataSets = lines.map(parser).toDS()
    .cache()
    
   structredRDDOrDataSets.printSchema()
   
   structredRDDOrDataSets.select("order_id").show()
   structredRDDOrDataSets.groupBy("order_status").count().show()

   spark.stop()
}