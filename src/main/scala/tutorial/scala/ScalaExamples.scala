package tutorial.scala

object ScalaExamples extends App{
  var names: List[String] = List("Bob", "James", "Kyle", "John")
  var names2: List[String] = List("Sally", "Jenna", "Jessica", "Ashley")

  //appending "Tom" to "names" list
  names :+= "Tom"

  // printing each element
  names foreach println

  //printing elements in list format
  println("Names: "+ names)

  println(names.length)
  println(names.size)

  println(names.head)

  println(names.last)

  names2 :+= "Paula"

  names2 foreach println

  println("Names: " + names2)

  val people: List[String] = names ::: names2

  println("Different people's names are: ")

  people.reverse foreach println

  //drops first 3 elements of the list
  println(people.drop(3))

  names2 take 2 foreach println

  val numberss = List(List(1, 5, 7), List(9, 6, 2), List(8, 3, 4))

  println(numberss.flatten.sorted)

  // more examples
  println("Example 1")
  println()

  var x = 10

  if(x < 12)
    println("X is less than 12")

  x = x + 2

  if (x == 12) {
    println("X equals 12")
  }

  x = x + 1

  if (x > 12)
    println("X is greater than 12")

  println("############################")

  // if else condition ex 2

  println("Example 2")
  println()

  var y = 17

  if(y == 10) {
    println("y is 10")
  } else if(y == 13) {
    println("y is 13")
  } else if(y == 17) {
    println("y is 17")
  } else {
    println("none of the above")
  }

  println("############################")

  println("Example 3")
  println()

  val a = 30
  val b = 40

  if(a == 30) {
    if (b == 40) {
      println("a is 30 and b is 40")
    }
  }

  println("############################")

  // Lists

  println("Example 4")
  println()

  val fruits: List[String] = List("apple", "banana", "orange")

  fruits foreach println

  println ("The size of fruits list is " + fruits.size)

  println()

  val numbers: List[Int] = List (1, 2, 3, 4, 5)

  numbers foreach println

  println ("The size of numbers list is " + numbers.size)

  println()

  val nofruits: List[Nothing] = List()

  println("The size of nofruits list is " + nofruits.size)

  println("############################")

  // Multi-dimensional List

  val dim_numbers: List[List[Int]] = List(List(1, 0, 0), List(0, 0, 1), List(1, 1, 0), List(0, 1, 0))

  dim_numbers foreach println

  println("############################")

  // Other way to define a List

  val fruits1 = "raspberry" :: ("coconut" :: ("strawberry" :: Nil))

  println("Head of fruits1: " + fruits1.head)

  println("Tail of fruits1: " + fruits1.tail)

  println("Check if fruits1 list is empty: " + fruits1.isEmpty)

  println("fruits1 reversed: " + fruits1.reverse)

  println()

  val numbers1 = 1 :: (2 :: (3 :: (4 :: Nil)))

  println("Head of numbers1: " + numbers1.head)

  println("Tail of numbers1: " + numbers1.tail)

  println("Check if numbers1 list is empty: " + numbers1.isEmpty)

  println()

  // Concatenating 2 lists (using ::: operator)

  val fruits_and_numbers = fruits1 ::: numbers1

  println("fruits1 ::: numbers1 => " + fruits_and_numbers)

  // uniform lists

  // repeat "apple" in a list 4 times
  val apples = List.fill(4)("apples")

  println("apples list: " + apples)

  // repeat 2 10 times
  val num = List.fill(10)(2)

  println("num: " + num)

  // Maps

  var A: Map[Char, Int] = Map()

  var colors1 = Map ("red" -> "#FF0000", "blue" -> "#F00F00", "green" -> "#F00000" )
  var colors2 = Map ("white" -> "#000000", "black" -> "#FFFFFF", "grey" -> "#FFFFF00" )

  colors1 foreach println

  println(colors1.keys)
  println(colors1.values)

  colors2 foreach println

  println(colors2.keys)
  println(colors2.values)

  var colors3 = colors1 ++ colors2

  println("colors1.++ colors2 => " + colors3)

  colors1 += ("purple" -> "#F0F0F0")
  println("colors1: " + colors1)

  colors2 += ("yellow" -> "#FF00FF")
  println("colors2: " + colors2)

  colors3 = colors1 ++ colors2
  println("colors1.++ colors2 => " + colors3)

  colors1.keys.foreach { i =>
    print("Key = " + i + " ")
    println("Value = " + colors1(i))

  }

  //multi-line strings
  val foo =
    """This is
      |a multiline
      |String
    """.stripMargin
  println(foo)

  "hello world".split(" ").foreach(println)

  val s = "eggs, milk, butter, Coco Puffs"
  s.split(",").map(_.trim)

  println(s)

  //Substituting variables into strings

  val name = "Fred"
  val age = 33
  val weight = 200.00

  println(s"$name is $age years old, and weights $weight pounds")

  //using expressions in String literals

  println(s"Age next year: ${age + 1}")
  println(s"You are 33 years old: ${age == 33}")

  println(f"$name is $age years old, and weighs $weight%.2f pounds.")

  //case class example

  case class Student(name: String, score: Int)

  val hannah = Student("Hannah", 95)

  println(s"${hannah.name} has a score of ${hannah.score}")

  //make each character UPPERCASE from a string

  val upper = "hello, world".map (c => c.toUpper)

  for (c <- "hello") println(c)

  val upper2 = "hello, world".map (_.toUpper)
  println(upper)
  println(upper2)

  //"map" examples

  println("HELLO".map(c => (c.toByte+32).toChar))

  // "map" with function example
  def toLower(c: Char): Char = (c.toByte + 33).toChar

  println("HELLO".map(toLower))

  //Example
  val MOD_ADLER = 65521

  val sum = adler32sum("Wikipedia")
  printf("checksum (int) = %d\n", sum)
  printf("checksum (hex) = %s\n", sum.toHexString)

  def adler32sum(s: String): Int = {
    var a = 1
    var b = 0

    s.getBytes.foreach { char =>
      a = (char + a) % MOD_ADLER
      b = (b + a) % MOD_ADLER
    }

    b * 65536 + a
  }

  //finding patterns in Strings
  val numPattern = "[0-9]+".r
  val address = "123 Main Street Suite 101"

  val match1 = numPattern.findFirstIn(address)

  println(match1)

  //range, list or array

  val r = 1 to 10
  println(r)

  for (i <- 1 to 5) println(i)

  // looping over a map
  val namess = Map("fname" -> "Robert",
    "lname" -> "Goren")
  for ((k,v) <- namess) println(s"key: $k, value: $v")
}
