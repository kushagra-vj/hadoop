from pyspark import SparkContext

sc = SparkContext("local[*]", "wordcount_new")

input = sc.textFile("input_file.txt")

words = input.flatMap(lambda x: x.split(" "))
lower_words = words.map(lambda x: x.lower())

final_res = lower_words.countByKey()

for i in final_res:
    print(i)