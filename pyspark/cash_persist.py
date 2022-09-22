from pyspark import SparkContext, StorageLevel

sc = SparkContext("local[*]", "cash_persist")

base_rdd = sc.textFile(r"C:\\Users\\joharapk\\OneDrive - AMDOCS\Backup Folders\Desktop\share_path\spark_dataset\\customerorders.csv")

mapped_input = base_rdd.map(lambda x : (x.split(',')[0], float(x.split(',')[2])))

total_by_cust = mapped_input.reduceByKey(lambda x, y: x + y)

premium_cust = total_by_cust.filter(lambda x: x[1] > 5000).persist(StorageLevel.MEMORY_ONLY)

doubled_amt = premium_cust.map(lambda x: (x[0], x[1] * 2))

res = doubled_amt.collect()


for x in res:
    print(x)

print(doubled_amt.count())