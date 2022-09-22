from pyspark import SparkContext

sc = SparkContext("local[*]", "sortByKey")

input = sc.textFile("input_file.txt")

words = input.flatMap(lambda x: x.split(" "))

lower_words = words.map(lambda x: (x.lower(), 1))

final_count = lower_words.reduceByKey(lambda x,y: (x + y)).map(lambda x: (x[1], x[0]))

result = final_count.sortByKey(ascending=False).map(lambda x: (x[1], x[0])).collect()

for i in result:
    print(i)
