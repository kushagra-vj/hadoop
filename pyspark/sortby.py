from pyspark import SparkContext

sc = SparkContext("local[*]", "sortby")

input = sc.textFile("input_file.txt")

words = input.flatMap(lambda x: x.split(" "))

lower_words = words.map(lambda x: (x.lower(),1))

final_count = lower_words.reduceByKey(lambda x, y: (x + y)).sortBy(lambda x: x[1], ascending=False).collect()

for i in final_count:
    print(i)