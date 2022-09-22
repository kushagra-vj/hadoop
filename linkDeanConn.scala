// ID, Username, Age, Linkdean connection
// find avg no. of connection for each age

import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkContext



object linkDeanConn extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sc = new SparkContext("local[*]", "cntLinkDeanConn")
  
  val input = sc.textFile("C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/spark_dataset/friendsdata.csv")
  val splitInput = input.map(x => (x.split("::")(2).toInt,x.split("::")(3).toInt)) 
  val gpAccordingToAge = splitInput.map(x => (x._1, (x._2,1)))
  //input
  // (33,(100,1))
  // (33,(200,1))
  // (33,(300,1))
  
  //output
  //(33,(600,3))
  
  val findAgeConnSum = gpAccordingToAge.reduceByKey((x,y) => (x._1 + y._1, x._2 + y._2))
  val avgAgeWiseConn = findAgeConnSum.map(x => (x._1, x._2._1/x._2._2)).sortBy(x => x._2)
  avgAgeWiseConn.collect.foreach(println)
  
  
  
  
  
  
  
  
  
  
}