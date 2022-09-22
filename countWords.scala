
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkContext

object countWords extends App{
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sc = new SparkContext("local[*]","wordCount")
  
 val inputList = List("WARN: Tuesday",
    "ERROR: Tuesday",
"ERROR: Tuesday",
"ERROR: Tuesday"
)

val originalInput = sc.parallelize(inputList)

val convertToArray = originalInput.map(x => {
   val column =  x.split(':')
   val logLevel = column(0)
   (logLevel, 1)
  })

 val cnt = convertToArray.reduceByKey((x, y) => x + y)
 val result = cnt.collect().foreach(println)
 
}