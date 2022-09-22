
import org.apache.spark.SparkContext


object totalCostAdv extends App {

  
//  def loadStopWords():Set[String] = { // making of this function is on local machine
//    var stopWords:Set[String] = Set()
//    val lines = Source.fromFile("C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/week_10/boringWords.txt").getLines()
//    
//    for (line <- lines){
//      stopWords += line
//    }
//    stopWords
//  }
//  
//  Logger.getLogger("org").setLevel(Level.ERROR)
//  
  val sc = new SparkContext("local[*]","totalCost")
//  var stopWords = sc.broadcast(loadStopWords) // broadcasting the stop words across the nodes 
//  val input = sc.textFile("C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/week_10/bigdatacampaigndata.csv")
//  
//  val input_val = input.map(x => (x.split(",")(0),x.split(",")(10).toFloat))
//  
//  val new_input_val = input_val.map(x => (x._2, x._1))
//  
//  val words = new_input_val.flatMapValues(x => x.split(" ")).map(x => (x._2.toLowerCase(), x._1))
// 
//  val finalWords = words.filter(x => !stopWords.value(x._1)) // whatever is not in stopWords we need to consider that's why we use negation. No shuffling required
//  val aggregate = finalWords.reduceByKey((x,y) => x+y)
//  val res = aggregate.sortBy(x => x._2, ascending=false)
//// res.take(20).foreach(println)
//  res.collect.foreach(println)

  
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
  
  highestRatingMoview.saveAsTextFile("C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/week_11/highestMoviewRating.txt")

  
}