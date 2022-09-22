from pyspark import SparkConf
from pyspark.sql import SparkSession
from pyspark.sql.types import (IntegerType, StringType, StructField,
                               StructType, TimestampType)

conf = SparkConf()
conf.set("spark.app.name", "standard ways")
conf.set("spark.master", "local[2]")

# order_schema = StructType([
#     StructField("order_id", IntegerType()),
#     StructField("order_data", TimestampType()),
#     StructField("customer_id", IntegerType()),
#     StructField("status", StringType()),
# ])


# DDL schema
order_ddl = """
    order_id Integer, order_data Timestamp, customer_id Integer,
    status String
"""

spark = SparkSession.builder.config(conf=conf).getOrCreate()

# order_df = spark.read.format("csv")\
#     .option("header", True).option("path", r"C:\\Users\\joharapk\\OneDrive - AMDOCS\Backup Folders\Desktop\share_path\week_11\\orders.csv").load()

# order_df = spark.read.format("csv")\
#     .option("header", True)\
#     .schema(order_schema)\
#     .option("path", r"C:\\Users\\joharapk\\OneDrive - AMDOCS\Backup Folders\Desktop\share_path\week_11\\orders.csv")\
#     .load()

#DDL Schema
order_df = spark.read.format("csv")\
    .option("header", True)\
    .schema(order_ddl)\
    .option("path", r"C:\\Users\\joharapk\\OneDrive - AMDOCS\Backup Folders\Desktop\share_path\week_11\\orders.csv")\
    .load()


# customer_orders = order_df.repartition(4).where("order_customer_id > 10000")\
#     .select("order_id", "order_customer_id")\
#     .groupBy("order_customer_id").count()

# customer_orders.show()

order_df.printSchema()

spark.stop()
