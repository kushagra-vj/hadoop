
import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger



//object wordCount {
// 
// def main(args: Array[String]){
//   Logger.getLogger("org").setLevel(Level.ERROR)
//   val sc = new SparkContext("local[*]", "wordCount") // 1st Param: local[*] -> working on local and use all cpu cores, 2nd Param: it will show in mention name when running code and for tracking purpose 
//   val input = sc.textFile("C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/spark_dataset/search_data.txt")
//   val words = input.flatMap(x => x.split(" ")) // take each row and convert it into words 
//   val mapWords = words.map(x => (x,1)) // take same no. of input and get exact output
//   val counts = mapWords.reduceByKey((x,y) => x + y) // calculate each word count
//   counts.collect.foreach(println)
// }
//}

object wordCount extends App{
 
   Logger.getLogger("org").setLevel(Level.ERROR)
   val sc = new SparkContext("local[*]", "wordCount") // 1st Param: local[*] -> working on local and use all cpu cores, 2nd Param: it will show in mention name when running code and for tracking purpose 
   val input = sc.textFile("C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/spark_dataset/search_data.txt")
   val words = input.flatMap(x => x.split(" ")) // take each row and convert it into words 
   val lowerWords = words.map(x => x.toLowerCase())
   val mapWords = lowerWords.map(x => (x,1)) // take same no. of input and get exact output
   val counts = mapWords.reduceByKey((x,y) => x + y) // calculate each word count
   
   // to display top 10 elements from result use sortByKey() as
   // sortByValue() is not available
   val finalCount = counts.map(x => (x._2,x._1))
   val top10Values = finalCount.sortByKey(false, 10)
//   val top10Values = counts.sortBy(x => x._2, false)
   val finalCnt = top10Values.map(x => (x._1, x._2))
   top10Values.collect.foreach(println)
   
   scala.io.StdIn.readLine()
}