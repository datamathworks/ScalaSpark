package com.mathworks.utils

object SparkUtil {

  /**
    *  Example 1 - Taking a list, parallelizing it (converting it to an RDD), traversing it, and printing
    *  its elements
    */

  val a = sc.parallelize (List(1, 2, 3, 4, 5)

  a take 3 foreach println

  // This will print  1
  //                  2

}
