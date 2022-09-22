// 1. atleast 100 people should give movie rating
// 2. avg movie reating > 3.5

import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkContext


object goodMovies extends App{
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sc = new SparkContext("local[*]", "high-reviews")
  
  val ratings = sc.textFile("C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/week_11/ratings-201019-002101.dat")
  val movieAndRating = ratings.map(x => {
    val cols = x.split("::")
    (cols(1),cols(2))
  })
  
  // input
  // (1193, 4)
  // (1193, 3)
  
  //output :-> (1193, (4.0,1)),(1193,(3.0,1.0))
  
  val mappedValues = movieAndRating.mapValues(x => (x.toFloat, 1.0))
  
  //input :-> (1193, (4.0,1)),(1193,(3.0,1.0))
  //output :-> (1193, (7.0,2.0))
  
  val redByKey = mappedValues.reduceByKey((x, y) => ((x._1 + y._1, x._2 + y._2)))
  
  //input :-> (1193, (7.0,2.0)) as x so to get 2.0 it should be x._2._2
  //output :-> filter based on count as we want atleast 1000 review for 1 movie
      
  val reviewRating = redByKey.filter(x => x._2._2 > 100)
  
  //input :-> (1193, (7.0,2.0))
  //output :-> (1193, 7/2:-> (3.5))
  
  val highestRatingMoview = reviewRating.mapValues(x => (x._1/ x._2)).filter(x => x._2 > 3.5)
  
//  highestRatingMoview.saveAsTextFile("C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/week_11/highestMoviewRating.txt")
  
//  highestRatingMoview.collect.foreach(println)
  
  val movieRating = sc.textFile("C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/week_11/movies-201019-002101.dat")
  
  val finalCols = movieRating.map(x => (x.split("::")(0),x.split("::")(1)))
  
  val joinRDD = finalCols.join(highestRatingMoview)
  
  //input x = (101, (Toy Story, 4.7))
  //output: x._2._1
  
  val out = joinRDD.map(x => x._2._1)
  
  out.collect.foreach(println)
  scala.io.StdIn.readLine()
}