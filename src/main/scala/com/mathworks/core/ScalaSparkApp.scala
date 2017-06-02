package com.mathworks.core

import com.mathworks.utils.ListUtil

object ScalaSparkApp extends App {
  println(ListUtil.last(List(1,2,3)))
  println(ListUtil.last(List("a", "b")))

}
