from pyspark import SparkConf
from pyspark.sql import SparkSession

my_conf = SparkConf()
my_conf.set("spark.app.name", "1st application")
my_conf.set("spark.master", "local[2]")

spark = SparkSession.builder.config(conf=my_conf).getOrCreate()

order_df = spark.read.option("header", True).option("inferSchema", True).csv(r"C:\\Users\\joharapk\\OneDrive - AMDOCS\Backup Folders\Desktop\share_path\week_11\\orders.csv")


customer_orders = order_df.repartition(4).where("order_customer_id > 10000")\
    .select("order_id", "order_customer_id")\
    .groupBy("order_customer_id").count()

customer_orders.show()

# order_df.printSchema()
# order_df.show()

spark.stop()
