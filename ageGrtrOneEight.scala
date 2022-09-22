import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkContext


object ageGrtrOneEight extends App {
   Logger.getLogger("org").setLevel(Level.ERROR)
   
   val sc = new SparkContext("local[*]", "assign1")
   val input = sc.textFile("C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/spark_dataset/prob1.dataset1")

   val rdd1 = input.map(x => {
       val fields = x.split(',')
       if(fields(1).toInt > 18){
         (fields(0),fields(1),fields(2),'Y')
       }
       else{
         (fields(0),fields(1),fields(2),'N')
       }
   })
   rdd1.collect.foreach(println)
}