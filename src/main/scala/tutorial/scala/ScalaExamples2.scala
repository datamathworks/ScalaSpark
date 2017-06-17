package tutorial.scala


object ScalaExamples2 extends App {

  val list = 1 :: 2 :: 3 :: Nil

  val fruit = List("apples", "oranges", "pears")
  val nums = List(1, 2, 3, 4)
  val diag3 =
    List(
      List(1, 0, 0),
      List(0, 1, 0),
      List(0, 0, 1)
    )
  val empty = List()

  val studentNames = List("Rohan", "Andreas", "Rob", "John")

  val em: List[Nothing] = List()

  // more list examples
  val names= "Harry" :: ("Adam" :: ("Jill" :: Nil))
  val age = Nil

  println( "Head of names array : " + names.head )
  println( "Tail of names array : " + names.tail )
  println( "Check if names is empty : " + names.isEmpty )
  println( "Check if age is empty : " + age.isEmpty )

  // Concatenating Lists
  val country_1 =  List("India","SriLanka","Algeria")
  val country_2 = List("Austria","Belgium","Canada")

  val country = country_1 ::: country_2
  println( "country_1 ::: country_2 : " + country )

  val cont = country_1.:::(country_2)
  println( "country_1.:::(country_2) : " + cont )
  val con = List.concat(country_1, country_2)
  println( "List.concat(country_1, country_2) : " + con  )

  val country3 = List("Denmark","Sweden","France")
  println("Country3 List before reversal :" + country3)
  println("Country3 List after reversal :" + country3.reverse)

  //Creating Uniform Lists

  val name = List.fill(6)("Rehan")
  println( "Name : " + name  )

  // Set
  val name1 = Set("Smith", "Brown", "Allen")
  val id: Set[Int] = Set()

  println( "Head of name1 : " + name1.head )
  println( "Tail of name1 : " + name1.tail )
  println( "Check if name1 is empty : " + name1.isEmpty )
  println( "Check if id is empty : " + id.isEmpty )

  // Concatenating Sets
  val furniture_1 = Set("Sofa", "Table", "chair")
  val furniture_2 = Set("Bed", "Door")

  var furniture = furniture_1 ++ furniture_2
  println( "furniture_1 ++ furniture_2 : " + furniture )

  var furn = furniture_1.++(furniture_2)
  println( "furniture_1.++(furniture_2) : " + furn )

  val n1 = Set(11,45,67,78,89,86,90)
  val n2 = Set(10,20,45,67,34,78,98,89)

  println( "n1.&(n2) : " + n1.&(n2) )
  println( "n1.intersect(n2) : " + n1.intersect(n2) )

  // max and min in a set
  val num1 = Set(125,45,678,34,20,322,10)

  println( "Minimum  element in the Set is : " + num1.min )
  println( "Maximum  element in the Set is : " + num1.max )
////////////////////////////////////////////////////////////////////

  //Useful Operations
  val range = 1 to 10
  val range2 = 1 until 10
  val range3 = 2 until 10 by 3

  println(range3.toList)

  //Number convenience methods
  val num = -5
  val numAbs = num.abs
  val max5or7 = numAbs.max(7)
  val min5or7 = numAbs.min(7)

  println(numAbs)
  println(max5or7)
  println(min5or7)

  // String operations
  val reverse = "Scala".reverse
  println(reverse)

  val cap = "scala".capitalize
  println(cap)

  val multi = "Scala!" * 7
  println(multi)

  val int = "123".toInt
  println(int)

  // Useful methods on collections

  // filter - keep only items > 4
  val moreThan4 = range.filter(_ > 4)
  println(moreThan4)

  // map - transform each item in the collection
  val doubleIt = range2.map(_ * 2)
  println(doubleIt)

  // calling a function
  def addd(x: Int, y: Int): Int = {
    return x + y
  }

  println(addd(41, 113))

  def addd2(x: Int, y: Int): Int = x + y

  println(addd2(37, 103))

  // Anonymous Functions
  //a method that requires a function as a parameter
  //the function's type is (Int,Int) => Int
  //e.g. maps from 2 Ints to an Int

  def doWithOneAndTwo(f: (Int, Int) => Int)  = {
    f(2, 5)
  }

  // Different ways to call "doWithOneAndTwo"

  // 1
  val call1 = doWithOneAndTwo((x: Int, y: Int) => x + y)
  println(call1)

  // 2
  val call2 = doWithOneAndTwo((x, y) => x * y)
  println(call2)

  // 3
  val call3 = doWithOneAndTwo(_ + _)
  println(call3)

  ///////////////////////////////////////////

  def add1(x: Int, y: Int) = x + y //method
  println(add1(20, 40))

  val add2 = (x: Int, y: Int) => x + y //anonymous function
  println(add2(20, 40))

  val add3:(Int, Int) =>  Int = _ + _
  println(add3(20, 40))

  val add4 = (_ + _):(Int, Int) => Int
  println(add4(20, 40))

  // return multiple variables
  def swap(x: String, y: String) = (y, x)

  val (a, b) = swap("hello", "world")
  println(a, b)

  // multiple variables
  var x, y, z = 0
  var c, python, java = false

  println(x, y, z, c, python, java)

  // match example
  val selection = "One"
  selection match {
    case "One" => println("You selected option one!")
    case "Two" => println("You selected option two!")
    case _ => println("You selected something else: ")
  }

  // arrays

  def printArray[K](array: Array[K]) = println(array.mkString("Array(" , ", " , ")"))

  // Mutable array of type Array[Int]
  val array1 = Array(1, 2, 3)
  printArray(array1)
  // Mutable array of type Array[Any]
  val array2 = Array("a", 2, true)
  printArray(array2)
  // Mutable array of type Array[String]
  val array3 = Array("a", "b", "c")
  printArray(array3)
  //Access items using (index) not [index]
  val itemAtIndex0 = array3(0)

  array3(0) = "d"
  printArray(array3)

  // Concatenating - using ++ operator
  // Prepending items (adding items in the beginning) - using +: and
  // Appending (adding items at the end) - using :+
  val concatenated = "prepend" +: (array1 ++ array2) :+ "append"
  printArray(concatenated)

  // Finding the index of an item
  println(array3.indexOf("b"))

  // Diff
  val diffArray = Array(1,2,3,4).diff(Array(2,3))
  printArray(diffArray)

  // Find item (stops when found)
  val personArray = Array(("Alice", 1), ("Bob", 2), ("Carol", 3))

  def findByName(name: String) = personArray.find(_._1 == name).getOrElse(("David",4))

  val findBob = findByName("Bob")
  println(findBob)

  val findEli = findByName("Eli")
  println(findEli)

  val bobFound = findBob._2
  println(bobFound)

  val eliFound = findEli._2
  println(eliFound)

  // Lists
  // Immutable list of type List[Int]
  val list1 = List(1,2,3)
  // Immutable list of type List[Any]
  val list2 = List("a",2,true)

  import collection.mutable

  // The "mutable version" of list
  val mList = mutable.ArrayBuffer("a", "b", "c")

  // Access items using (index) not [index]
  val firstItem = list1(0)
  println(firstItem)

  // Modify items the same way (mutable Lists only)
  mList(0) = "d"
  mList

  // Concatenation using the ++ operator or ::: (lists only)
  println(list1 ++ list2)
  println(list1 ::: list2)

  println(0 :: list1)
  println(0 +: list1)

  println(list1 :+ 4)

  val concatenated2 = 1 :: list1 ::: list2 ++ mList

  // Removing elements (mutable list only, creates a new array)

  val mListRemoved = mList - "c"
  println(mListRemoved)

  mList - "c"
  println(mList)

  mList -- List("e", "f")
  println(mList)

  println(mList)

  mList -= "c"
  println(mList)

  mList --= List("e", "f")
  println(mList)

  mList += "e"
  mList ++= List("f", "g")
  println(mList)

  // Diff
  val diffList = List(1,2,3,4) diff List(2,3)

  // Find (stop when item is found)
  val personList = List(("Alice", 1), ("Bob", 2), ("Carol", 3))

  def findByName1(name: String) = personList.find(_._1 == name).getOrElse(("David",4))

  val findBob1 = findByName1("Bob")
  val findEli1 = findByName1("Eli")

  println(findBob1)
  println(findEli1)

  println(findBob1._2)
  println(findEli1._2)

  (1 to 100).map(x => "foo") foreach println

  // Sets

  val set1 = Set(1,2,3)
  val set2 = Set("a",2,true)

  import collection.mutable

  val mset = mutable.HashSet("a", "b", "c")

  println(Set(1,2,3,4,3,2,1,2))

  val oneExists = set1(1)
  val fourExists = set1(4)

  println(oneExists)
  println(fourExists)

  mset("a") = false
  println(mset)

  val concatenated3 = set1 ++ set2 ++ mset
  println(concatenated3)

  println(set1)

  mset -= "c"
  println(mset)

  mset += "e"
  mset ++= Set("f", "g")

  println(mset)

  //Diff
  val diffSet = Set(1,2,3,4) diff Set(2,3)
  println(diffSet) // Set(1, 4)

  // Maps

  //Map of type Map[String, Int]
  val map1 = Map("one" -> 1, "two" -> 2, "three" -> 3)
  //Map of type Map[Any, Any]
  val map2 = Map(1 -> "one", "2" -> 2.0, 3.0 -> false)

  import collection.mutable

  // mutable version of map
  val mmap = mutable.HashMap("a" -> 1, "b" -> 2, "c" -> 3)

  // Map removes duplicate keys
  println(Map("a" -> 1, "a" -> 2))

  // Get items using map(key)
  val one = map1("one")
  println(one)

  //NoSuchElementException will be thrown if key doesn't exist!
  //e.g. this code: val fourExists = map1("four")
  //throws NoSuchElementException: key not found: four
  //the get method returns an Option, which will be explained later
  val fourExistsOption = map1.get("four")
  println(fourExistsOption.isDefined) // false

  // You can set/modify items using map(key) = value
  mmap("d") = 4
  println(mmap)

  //Concatenation using the ++ operator
  //(removes duplicate keys, order not guaranteed)
  val concatenated4 = map1 ++ map2 ++ mmap
  println(concatenated4)

  // Map(three -> 3, 1 -> one, two -> 2, a -> 1, b -> 2, 3.0 -> false, 2 -> 2.0, c -> 3, one -> 1, d -> 4)
  //Concatenation doesn't modify the maps themselves
  println(map1) //Map(one -> 1, two -> 2, three -> 3)

  //Removing elements (mutable Sets only)
  mmap -= "c"
  println (mmap) //Map(b -> 2, d -> 4, a -> 1)

  //Adding elements (mutable Lists only)
  mmap += "e" -> 5
  mmap ++= Map("f" -> 6, "g" -> 7)

  println (mmap) //Map(e -> 5, b -> 2, d -> 4, g -> 7, a -> 1, f -> 6)

  // Classes

  // Simple class that does nothing
  class Person(fname: String, lname: String)

  val p1 = new Person("Alice", "In Chains")
  // p1.fname/lname is not accessible

  // A class with a method
  class Person2(fname: String, lname: String) {
    def greet = s"Hi $fname $lname!"
  }

  val p2 = new Person2("Bob", "Marley")
  println(p2.greet)
  // p2.fname/lname is not accessible

  //A class with a public read only variable
  class Person3(fname:String, lname:String){
    // a public read only field
    val fullName = s"$fname $lname"
    def greet = s"Hi $fullName!"
  }

  val p3 = new Person3("Carlos", "Santana")
  println(p3.greet)
  println(p3.fullName)
  //p3.fname / lname is not accessible

  //auto creates a getter for fname, and getter + setter to lname
  class Person4(val fname:String, var lname:String)

  val p4 = new Person4("Dave", "Matthews") {
    //override the default string representation
    override def toString = s"$fname $lname"
  }

  println(p4.fname)
  println(p4.lname)

  p4.lname = "Grohl"
  println(p4)
}
