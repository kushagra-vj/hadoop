# Movie rating

from ntpath import join
from pyspark import SparkContext

sc = SparkContext("local[*]", "movieRating")

input = sc.textFile(r"C:\\Users\\joharapk\\OneDrive - AMDOCS\Backup Folders\Desktop\share_path\week_10\\ratings.dat")

movie_rating = input.map(lambda x: (x.split("::")[1], x.split("::")[2]))

mapped_values = movie_rating.mapValues(lambda x : (float(x), 1))
result_rdd = mapped_values.reduceByKey(lambda x,y: (x[0]+y[0],x[1]+y[1]))

review_rating = result_rdd.filter(lambda x : x[1][1] > 100)

highest_rating_movie = review_rating.mapValues(lambda x : (x[0]/x[1])).filter(lambda x: x[1]>3)

movie_data = sc.textFile(r"C:\\Users\\joharapk\\OneDrive - AMDOCS\Backup Folders\Desktop\share_path\week_10\\movies.dat")

movie_cols = movie_data.map(lambda x: (x.split("::")[0], x.split("::")[1]))

join_rdds = movie_cols.join(highest_rating_movie)

output = join_rdds.map(lambda x: x[1][0]).collect()

for i in output:
    print(i)




