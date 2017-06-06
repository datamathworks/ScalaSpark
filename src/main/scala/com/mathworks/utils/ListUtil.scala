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
  var fruits: List[String] = List("apples", "oranges", "pears") // "apples" :: "oranges" :: "pears" :: Nil
  fruits.head == "apples"
  fruits.tail ==  List("oranges", "pears")

  List(1, 2, 3, 4) // = 1 :: 2 :: 3 :: 4 :: Nil
  /**
    * Returns the last element of a list
    *
    * @param xs
    * @tparam T
    * @return
    */
  def last[T](xs: List[T]): T = xs match {
    case List() => throw new Error("last of empty list")
    case List(x) => x
    case y :: ys => last(ys)
  }

  /**
    * Returns all the elements except the last one from a given list
    *
    * @param xs
    * @tparam T
    * @return
    */
  def init[T](xs: List[T]): List[T] = xs match {
    case List() => throw new Error("init of empty list")
    case List(x) => List()
    case y :: ys => y :: init(ys)
  }

  /**
    * xs ::: ys
    *
    * @param xs
    * @param ys
    * @tparam T
    * @return
    */
  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case List() => ys
    case List(x) => x :: ys
    case z :: zs => z :: concat(zs, ys)
  }

  /**
    * reverse a list
    *
    * @param xs
    * @tparam T
    * @return
    */
  def reverse[T](xs: List[T]): List[T] = xs match {
    case List() => List()
    case List(x) => List(x)
    case y :: ys => reverse(ys) ::: List(y)
  }

  /**
    * remove the nth element from the list
    *
    * @param n
    * @param xs
    * @tparam T
    * @return
    */
  def removeAt[T](n: Int, xs: List[T]): List[T] = (xs take n) ::: (xs drop n + 1)

  /**
    * multiply each element of a list by a factor
    *
    * @param xs
    * @param factor
    * @return
    */
  def scaleList(xs: List[Double], factor: Double): List[Double] = xs match {
    case List() => List()
    case y :: ys => (y * factor) :: scaleList(ys, factor)
  }
}
