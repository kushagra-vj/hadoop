from pyspark import SparkContext

sc = SparkContext("local[*]","wordcount")
sc.setLogLevel('ERROR')

input = sc.textFile(r"C:\\Users\\joharapk\\OneDrive - AMDOCS\Backup Folders\Desktop\\Kushagra\\practice\\Hadoop_course\\pyspark\\input_file.txt")

rdd1 = input.flatMap(lambda x : x.split(" "))
rdd2  = rdd1.map(lambda x: (x.upper(), 1))
rdd3 = rdd2.reduceByKey(lambda x, y: x + y)
word_count = rdd3.collect()

for i in word_count:
    print(i)