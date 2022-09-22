/*
ex: "2013-07-25",11599,"CLOSED"
		"2014-07-25",256,"PENDING_PAYMENT"
		"2013-07-25",11599,"COMPLETE"
		"2019-07-25",8827,"CLOSED"
		
1). create scala list
2). from list create dataframe : columns(orderid, orderdate,customerid,status)
3). convert orderid field to epoch timestamp(unixtimestamp ie. no. of seconds after Jan 1970)
4). create new col "newid" and should be unqiue
5). drop duplicates (orderdate, customerid)
6). drop orderid col
7). Sort ot based on orderdate

*/

import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.sql.Dataset
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.DateType
import org.apache.spark.sql.functions._

object dfWorkingExample extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val conf = new SparkConf()
  conf.set("spark.app.name", "working example")
  conf.set("spark.master", "local[2]")
  
  val spark = SparkSession.builder().config(conf).getOrCreate()
  
  
  val myList = List((1,"2013-07-25",11599,"CLOSED"),
		(2,"2014-07-25",256,"PENDING_PAYMENT"),
		(3,"2013-07-25",11599,"COMPLETE"),
		(4,"2019-07-25",8827,"CLOSED"))
  
	
	val ordersDf = spark.createDataFrame(myList)
	.toDF("orderid", "orderdate","customerid","status")
	
	val newDf = ordersDf
	.withColumn("orderdate",unix_timestamp(col("orderdate")
	 .cast(DateType)))
	 .withColumn("newid", monotonically_increasing_id) // add new column with unique id
	 .dropDuplicates("orderdate", "customerid")
	 .drop("orderid")
	 .sort("orderdate")
	
	
	newDf.printSchema()
	newDf.show()
	  spark.stop()
}