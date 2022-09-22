from pyspark import SparkContext

sc = SparkContext("local[*]", "friendsPerAge")

def parse_line(line):
    fields = line.split("::")
    age = fields[2]
    friends = int(fields[3])

    return (age, friends)

input = sc.textFile(r"C:\\Users\\joharapk\\OneDrive - AMDOCS\Backup Folders\Desktop\share_path\spark_dataset\\friendsdata.csv")

age_friends = input.map(parse_line)
#(33,385)

friends_cal = age_friends.mapValues(lambda x: (x, 1))
#(33, (385,1))

cal = friends_cal.reduceByKey(lambda  x, y: (x[0]+y[0], x[1]+y[1]))

final_res = cal.mapValues(lambda x: x[0]/x[1]).collect()

for i in final_res:
    print(i)




