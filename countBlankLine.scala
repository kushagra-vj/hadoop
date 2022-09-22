
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkContext


object countBlankLine extends App {
  val sc = new SparkContext("local[*]", "countEmptyLine")
  
  Logger.getLogger("org").setLevel(Level.ERROR)
   val input = sc.textFile("C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/week_10/sampleText.txt")
   
   val accumulator = sc.longAccumulator("blank lines accumulator")
   
   input.foreach(x => (if (x == "") accumulator.add(1)))
   
   println("Blank Lines found in file are:"+accumulator.value)
}