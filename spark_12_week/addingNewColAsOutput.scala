import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.sql.Dataset
import org.apache.spark.sql.Row
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._


case class Person(name:String, age:Integer, city:String)

object addingNewColAsOutput extends App{
     Logger.getLogger("org").setLevel(Level.ERROR)
     
     def ageCheck(age: Int):String = {
       if (age > 18) "Y" else "N"
     }
     
     val config = new SparkConf()
     config.set("spark.app.name", "refer columns")
     config.set("spark.master", "local[2]")
     
     val spark = SparkSession.builder().config(config)
     .getOrCreate()
     
     val orderDf = spark.read
     .format("csv")
     .option("inferSchema", true)
     .option("path","C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/week_12/sample.dataset1")
     .load()
     
     import spark.implicits._
     
     val newDf: Dataset[Row] = orderDf.toDF("name","age","city")
     
     val ds1 = newDf.as[Person]
     
//     Column object expression UDF
//     val parseAgeFunction = udf(ageCheck(_:Int): String)
//     
//     val resultDf = newDf.withColumn("adult", parseAgeFunction(col("age")))
//     
//     resultDf.show()
     
//     spark.catalog.listFunctions().filter(x => x.name=="parseAgeFunction").show()
//     sql expression
     spark.udf.register("parseAgeFunction", ageCheck(_:Int): String)
     
     val df2 = newDf.withColumn("adult", expr("parseAgeFunction(age)"))
     
     df2.show()
//    spark.catalog.listFunctions().filter(x => x.name=="parseAgeFunction").show()
     
     df2.createOrReplaceTempView("peopletable")
     // Stopping spark session
     spark.stop()
}