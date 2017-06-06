package com.mathworks.core

import com.mathworks.utils.ListUtil

object ScalaSparkApp extends App {
  println(ListUtil.last(List(1,2,3)))
  println(ListUtil.last(List("a", "b")))

  println(List(1,2,3,4,5).map(x => x * 2))

  val x: Int = 2

  val multiply: Int => Int = x => {
    x * 2
  }

  val even: Int => Boolean = x => { // function returning boolean is a "predicate"
    x % 2 == 0
  }

  val posEl: Int => Boolean = x => { // function returning boolean is a "predicate"
    x > 0
  }

  println(List(1,2,3,4).map(multiply))

  // when we have a predicate, we need to call the method "filter" (not "map")
  println(List(1,2,3,4).filter(even))

  println(List(-1,-2,3,4).filter(posEl))

  println(List(-1,-2,3,4).filter(x => x > 0))

  println(List(-1,-2,3,4).filter(_ > 0))

  println(List(-1,-2,3,4).filterNot(_ > 0))

  println(List(-1,2,-3,4).partition(_ > 0))
}
