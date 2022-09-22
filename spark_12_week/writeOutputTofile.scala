import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkConf
import org.apache.spark.sql.SaveMode

object writeOutputTofile extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val conf = new SparkConf()
  conf.set("spark.app.name", "write to output file")
  conf.set("spark.master", "local[2]")
  
  val spark = SparkSession.builder().config(conf).getOrCreate()
  
  val orderDf = spark.read.format("csv")
    .option("header", true)
    .option("inferSchema", true)
    .option("path", "C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/week_12/orders.csv")
    .load()
    
/*   orderDf.write
   .format("csv")
   .mode(SaveMode.Overwrite)
   .option("path","C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/week_12/output_folder")
   .save()
  */
    
  /*
   orderDf.write
   .format("json")
   .mode(SaveMode.Overwrite)
   .option("path","C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/week_12/output_folder")
   .save()
   */
    
//    orderDf.write
//   .mode(SaveMode.Overwrite)
//   .option("path","C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/week_12/output_folder")
//   .save()
    
    print("orderDf has: "+ orderDf.rdd.getNumPartitions+" ")
    
    val orderRePartition = orderDf.repartition(4)
    
//  orderRePartition.write
//   .mode(SaveMode.Overwrite)
//   .option("path","C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/week_12/output_folder")
//   .save()
    
//   orderDf.write
//   .format("csv")
//   .partitionBy("order_status")
//   .mode(SaveMode.Overwrite)
//   .option("path","C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/week_12/output_folder")
//   .save()    
   
    orderDf.write
   .format("avro")
   .partitionBy("order_status")
   .mode(SaveMode.Overwrite)
   .option("maxRecordsPerFile", 2000)
   .option("path","C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/week_12/output_folder")
   .save()
   
   spark.stop()
}