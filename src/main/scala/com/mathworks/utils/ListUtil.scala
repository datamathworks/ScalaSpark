package com.mathworks.utils

/**
  * head - the first element of the list
  * tail - the list of all elements except the first one
  * isEmpty - 'true' if the list is empty, 'false' otherwise
  *
  *  -- Decomposition --
  *  p :: ps                   A pattern that matches a list with head = p and tail = ps
  *  List(p1, ... ,pn)         Same as p1 :: ... :: pn :: Nil
  *  1 :: 2 :: xs              List starts with 1 and then 2
  *  x :: Nil                  List of length 1  (or List(x))
  *  List()                    Empty list (or Nil)
  *
  * -- List Functions --
  * xs.length                  The number of elements of xs
  * xs.last                    The list's last element (exception if xs is empty)
  * xs.init                    A list containing of all elements of xs except the last one (exception if xs is empty)
  * xs take n                  A list consisting of the first n elements of xs (or xs itself if shorter than n)
  * xs drop n                  The rest of the collection after taking n elements
  * xs(n)                      The element of xs at index n (also written as xs apply n)
  * 
  */

object ListUtil {


  List() // the empty list
  List(1) // the list with a single element 1
  List(2, 3) // list with elements 2 and 3

  // :: -> constructor operation (cons)
  val fruits: List[String] = List("apples", "oranges", "pears") = "apples" :: "oranges" :: "pears" :: Nil
  fruits.head == "apples"
  fruits.tail ==  List("oranges", "pears")

  List(1, 2, 3, 4) = 1 :: 2 :: 3 :: 4 :: Nil


}
