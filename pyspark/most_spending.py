from pyspark import SparkContext

sc = SparkContext('local[*]', "mostSpending")

input = sc.textFile(r"C:\\Users\\joharapk\\OneDrive - AMDOCS\Backup Folders\Desktop\share_path\spark_dataset\\customerorders.csv")

rdd1 = input.map(lambda x: (x.split(',')[0], float(x.split(',')[2])))

rdd2 = rdd1.reduceByKey(lambda x,y: x + y)

rdd3 = rdd2.sortBy(lambda x: x[1], ascending=False).collect()
