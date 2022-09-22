import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions


object maxUserShopping extends App{
    Logger.getLogger("org").setLevel(Level.ERROR)
    val sc = new SparkContext("local[*]","maxShop")
    val input = sc.textFile("C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/share_path/spark_dataset/customerorders.csv")
    val selectCols = input.map(x => (x.split(",")(0),x.split(",")(2).toFloat))
    val groupCustOnId = selectCols.reduceByKey((x,y) => x + y)
    val highestSpend = groupCustOnId.sortBy(x => x._2, false)
    //val result = highestSpend.collect
    //result.foreach(println)
    
    //save data on local or hdfs directory
    highestSpend.saveAsTextFile("C:/Users/joharapk/OneDrive - AMDOCS/Backup Folders/Desktop/Kushagra/maxUserShopping")       
}