from pyspark import SparkConf
from pyspark.sql import SparkSession
from pyspark.sql.types import StringType, StructField, IntegerType, FloatType, StructType


spark_conf = SparkConf()
spark_conf.set("spark.app.name", "assignment 1")
spark_conf.set("spark.master", "local[2]")

spark = SparkSession.builder.config(conf=spark_conf).getOrCreate()


schema = StructType([
    StructField("country", StringType()),
    StructField("weeknum", IntegerType()),
    StructField("numinvoices", IntegerType()),
    StructField("totalquantity", IntegerType()),
    StructField("invoicevalue", FloatType())
])


df = spark.read.format("csv").schema(schema=schema) \
    .option("path", r"C:\\Users\\joharapk\\OneDrive - AMDOCS\Backup Folders\Desktop\share_path\week_11\\windowdata.csv") \
    .load()

df.show()

# df.write.partitionBy("country","weeknum").parquet("window_output")
df.write.partitionBy("country", "weeknum").json("C:\\Users\\joharapk\\OneDrive - AMDOCS\Backup Folders\Desktop\share_path\week_11\\json_window_output")


spark.stop()
