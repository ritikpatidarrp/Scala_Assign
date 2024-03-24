object BucketizeArray {
  def bucketizeArray(input: Array[Double]): Array[String] = {
    // Define the range interval
    val rangeInterval = 0.050

    // Initialize an empty list to store bucketized values
    var bucketizedArray = List[String]()

    // Iterate through each value in the input array
    for (value <- input) {
      // Calculate the lower and upper bounds of the bucket
      val lowerBound = ((value*100) / (rangeInterval*100)).toInt * rangeInterval
      val upperBound = lowerBound + rangeInterval-0.001

      // Format the bucket range as a string with three decimal places
      val formattedRange = f"$lowerBound%.3f - $upperBound%.3f"

      // Add the formatted bucket range to the bucketized array
      bucketizedArray :+= formattedRange
    }

    // Convert the list to an array and return
    bucketizedArray.toArray
  }

  def main(args: Array[String]): Unit = {
    // Sample input array
    val inputArray = Array(12.05, 12.03, 10.33, 11.45, 13.50)

    // Bucketize the input array
    val result = bucketizeArray(inputArray)

    // Print the bucketized array
    println(result.mkString(", "))
  }
}

