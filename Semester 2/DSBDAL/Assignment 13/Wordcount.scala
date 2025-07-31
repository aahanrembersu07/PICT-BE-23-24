// Load the text file
val data = sc.textFile("input.txt")
data.collect

// Split each line into words
val splitdata = data.flatMap(line => line.split(" "))
splitdata.collect

// Map each word to a tuple (word, 1)
val mapdata = splitdata.map(word => (word, 1))
mapdata.collect

// Reduce by key to get word counts
val reducedata = mapdata.reduceByKey(_ + _)
reducedata.collect

println()
// Print the word frequencies directly in a clean format
reducedata.collect.foreach { case (word, count) =>
  println(s"$word\t$count")
}