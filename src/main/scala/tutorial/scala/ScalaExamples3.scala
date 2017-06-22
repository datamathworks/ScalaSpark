package tutorial.scala

import java.util.{Date, Locale}
import java.text.DateFormat._
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.text.SimpleDateFormat

import scala.util.Random


object ScalaExamples3 extends App {
  val now = new Date
  val df = getDateInstance(LONG, Locale.CANADA)

  println(df format now)
  println (now)

  val date = LocalDate.parse("01/01/2020", DateTimeFormatter.ofPattern("MM/dd/yyyy"))

  print(date.toString)

  date.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"))

  println(date.toString)

  val formatString = "d, D, MMMM, EEEE"
  val cal = Calendar.getInstance

  cal.add(Calendar.DAY_OF_YEAR, 8)

  println(new SimpleDateFormat(formatString) format cal.getTime)


  /////////////////////////////////////////////////////////////

  // Scala Examples
  var favoriteDonut: String = "Glazed Donut"

  favoriteDonut = "Vanilla Donut"



  // lazy init
  lazy val donutService = "Initialize some donut service"

  // supported types
  val donutsBought: Int = 5
  val bigNumberOfDonuts: Long =10000000000L
  val smallNumberOfDonuts: Short = 1
  val priceOfDonut: Double = 2.50
  val donutPrice: Float = 2.50f
  val donutStoreName: String = "allaboutscala Donut Store"
  val donutByte: Byte = 0xa
  val donutFirstLetter: Char = 'D'
  val nothing: Unit = ()

  // declare var without initialization
  var leastFavoriteDonut: String = _
  leastFavoriteDonut = "Plain Donut"

  // Scala String Interpolation - Print And Format Variables

  // using string interpolation to print a variable
  println("Step1: Using String interpolation to print a variable")

  val favoriteDonut2: String = "Glazed Donut"

  println(s"My favorite donut = $favoriteDonut2")

  // Using String interpolation on object properties
  println("\nStep 2: Using String interpolation on object properties")

  case class Donut(name: String, tasteLevel: String)

  val favoriteDonut3: Donut = Donut("Glazed Donut", "Very Tasty")

  println(s"My favorite donut name = ${favoriteDonut3.name}, tasteLevel = ${favoriteDonut3.tasteLevel}")

  //  Using String interpolation to evaluate expressions

  val qtyDonutsToBuy: Int = 10

  println(s"Are we buying 10 donuts = ${qtyDonutsToBuy == 10}")

  // Using String interpolation for formatting text

  val donutName: String = "Vanilla Donut"
  val donutTasteLevel: String = "Tasty"
  println(f"$donutName%20s $donutTasteLevel")

  // Using f interpolation to format numbers

  val donutPrice2: Double = 2.50
  println(s"Donut price = $donutPrice2")
  println(f"Formatted donut price = $donutPrice2%.2f")

  // Escape Characters And Create Multi-line String

  // Escape a Json String
  //val donutJson: String ="{"donut_name":"Glazed Donut","taste_level":"Very Tasty","price":2.50}"

  // Using backslash to escape quotes
  val donutJson2: String ="{\"donut_name\":\"Glazed Donut\",\"taste_level\":\"Very Tasty\",\"price\":2.50}"
  println(s"donutJson2 = $donutJson2")

  // Using triple quotes """ to escape characters
  val donutJson3: String = """{"donut_name":"Glazed Donut","taste_level":"Very Tasty","price":2.50}"""
  println(s"donutJson3 = $donutJson3")

  // Creating multi-line text using stripMargin
  val donutJson4: String =
    """
      |{
      |"donut_name":"Glazed Donut",
      |"taste_level":"Very Tasty",
      |"price":2.50
      |}
    """   .stripMargin

  // Using Scala compiler to convert from one data type to another
  val numberOfDonuts: Short = 1
  val minimumDonutsToBuy: Int = numberOfDonuts

  // Converting from a Short to an Int was fine because there was no precision loss, i.e. an Int is larger than a Short.

  // User driven conversion from one data type to another
  val minimumDonutsToSell: String = numberOfDonuts.toString()

  // Filter values using if conditions in for loop
  val donutIngredients = List("flour", "sugar", "egg yolks", "syrup", "flavouring")
  for(ingredient <- donutIngredients if ingredient == "sugar") {
    println(s"Found sweetening ingredient = $ingredient")
  }
    // Filter values using if conditions in for loop and return the result back using the yield keyword
    val sweeteningIngredients = for {
      ingredient <- donutIngredients
      if (ingredient == "sugar" || ingredient == "syrup")
    } yield ingredient
    println(s"Sweetening ingredients = $sweeteningIngredients")

  // Range

  // Create a simple numeric range from 1 to 5 inclusive
  val from1To5 = 1 to 5
  println(s"Range from 1 to 5 inclusive = $from1To5")

  // Create a numeric range from 1 to 5 but excluding the last integer number 5
  println("\nStep 2: Create a numeric range from 1 to 5 but excluding the last integer number 5")
  val from1Until5 = 1 until 5
  println(s"Range from 1 until 5 where 5 is excluded = $from1Until5")

  // Create a numeric range from 0 to 10 but increment with multiples of 2
  val from0To10By2 = 0 to 10 by 2
  println(s"Range from 0 to 10 with multiples of 2 = $from0To10By2")

  1 to 100 map (x => println("foo"))

  // Create an alphabetical range to represent letter a to z
  val alphabetRangeFromAToZ = 'a' to 'z'
  println(s"Range of alphabets from a to z = $alphabetRangeFromAToZ")

  // Convert the Scala Range into collections
  val listFrom1To5 = (1 to 5).toList
  println(s"Range to list = ${listFrom1To5.mkString(" ")}")

  val setFrom1To5 = (1 to 5).toSet
  println(s"Range to set = ${setFrom1To5.mkString(" ")}")

  val sequenceFrom1To5 = (1 to 5).toSeq
  println(s"Range to sequence = ${sequenceFrom1To5.mkString(" ")}")

  val arrayFrom1To5 = (1 to 5).toArray
  println(s"Range to array = `${arrayFrom1To5.mkString(" ")}")

  // Pattern Matching
  val donutType = "Glazed Donut"

  donutType match {
    case "Glazed Donut" => println("Very Tasty")
    case "Plain Donut" => println("Tasty")
  }

 // Pattern matching and return the result
  val tasteLevel = donutType match {
    case "Glazed Donut" => "Very Tasty"
    case "Plain Donut" => "Tasty"
  }

  println(s"Taste level of $donutType = $tasteLevel")

  // Pattern matching using the wildcard operator

  val tasteLevel2 = donutType match {
    case "Glazed Donut" => "Very Tasty"
    case "Plain Donut" => "Tasty"
    case _ => "Tasty"
  }
  println(s"Taste level of $donutType = $tasteLevel2")

  // Pattern matching with two or more items on the same condition

  val donutType2 = "Strawberry Donut"

  val tasteLevel3 = donutType2 match {
    case "Glazed Donut" | "Strawberry Donut" => "Glazed or Strawberry donuts are very Tasty"
    case "Plain Donut" => "Tasty"
    case _ => "Tasty"
  }
  println(s"Taste level of $donutType = $tasteLevel3")

  // Pattern matching and using if expressions in the case clause
  val tasteLevel4 = donutType match {
    case donut if (donut.contains("Glazed") || donut.contains("Strawberry")) => "Very tasty"
    case "Plain Donut"  => "Tasty"
    case _  => "Tasty"
  }
  println(s"Taste level of $donutType = $tasteLevel4")

  // Pattern matching by types
  val priceOfDonut1: Any = 2.50
  val priceType = priceOfDonut1 match {
    case price: Int => "Int"
    case price: Double => "Double"
    case price: Float => "Float"
    case price: String => "String"
    case price: Boolean => "Boolean"
    case price: Char => "Char"
    case price: Long => "Long"
  }
  println(s"Donut price type = $priceType")

  // Tuples
  val glazedDonutTuple = Tuple2("Glazed Donut", "Very Tasty")
  println(s"Glazed Donut with 2 data points = $glazedDonutTuple")

  // Access each element in tuple
  val donutType3 = glazedDonutTuple._1
  val donutTasteLevel3 = glazedDonutTuple._2

  println(s"$donutType3 taste level is $donutTasteLevel3")

  // How to use Option and Some - a basic example
  val glazedDonutTaste: Option[String] = Some("Very Tasty")
  println(s"Glazed Donut taste = ${glazedDonutTaste.get}")

  // How to use Option and None - a basic example
  val glazedDonutName: Option[String] = None
  println(s"Glazed Donut name = ${glazedDonutName.getOrElse("Glazed Donut")}")

  // Pattern Matching with Option
  glazedDonutName match {
    case Some(name) => println(s"Received donut name = $name")
    case None       => println(s"No donut name was found!")
  }

  glazedDonutTaste.map(taste => println(s"glazedDonutTaste = $taste"))
  glazedDonutName.map(name => println(s"glazedDonutName = $name"))

  // Declare a variable of type Any
  val favoriteDonut5: Any = "Glazed Donut"
  println(s"favoriteDonut of type Any = $favoriteDonut5")

  // Declare a variable of type AnyRef
  val donutName5: AnyRef = "Glazed Donut"
  println(s"donutName of type AnyRef = $donutName5")

  //  Declare a variable of type AnyVal
  val donutPrice5: AnyVal = 2.50
  println(s"donutPrice of type AnyVal = $donutPrice5")

  // Enumerations
  object Donut extends Enumeration {
    type Donut = Value

    val Glazed      = Value("Glazed")
    val Strawberry  = Value("Strawberry")
    val Plain       = Value("Plain")
    val Vanilla     = Value("Vanilla")
  }

  // How to print the String value of the enumeration
  println(s"Vanilla Donut string value = ${Donut.Vanilla}")

  // How to print the id of the enumeration
  println(s"Vanilla Donut's id = ${Donut.Vanilla.id}")

  // How to print all the values listed in Enumeration
  println(s"Donut types = ${Donut.values}")

  // How to pattern match on enumeration values
  Donut.values.foreach {
    case d if (d == Donut.Strawberry || d == Donut.Glazed) => println(s"Found favourite donut = $d")
    case _ => None
  }

  // How to change the default ordering of enumeration values
  object DonutTaste extends Enumeration{
    type DonutTaste = Value

    val Tasty       = Value(0, "Tasty")
    val VeryTasty   = Value(1, "Very Tasty")
    val Ok          = Value(-1, "Ok")
  }

  println(s"Donut taste values = ${DonutTaste.values}")
  println(s"Donut taste of OK id = ${DonutTaste.Ok.id}")

  // Functions
  def favoriteDonut1(): String = {
    "Glazed Donut"
  }

  val myFavoriteDonut = favoriteDonut1()
  println(s"My favorite donut is $myFavoriteDonut")

  // How to define and use a function with no parenthesis
  def leastFavoriteDonut1 = "Plain Donut"
  println(s"My least favorite donut is $leastFavoriteDonut1")

  // How to define and use a function with no return type
  def printDonutSalesReport(): Unit = {
    // lookup sales data in database and create some report
    println("Printing donut sales report... done!")
  }
  printDonutSalesReport()

  // Use type inference to define function with no return type
  def printReport {
    // lookup sales data in database and create some report
    println("Printing donut report... done!")
  }
  printReport

  // define function with parameters
  def calculateDonutCost(donutName: String, quantity: Int): Double = {
    println(s"Calculating cost for $donutName, quantity = $quantity")

    2.50 * quantity
  }

  println(calculateDonutCost("Vanilla Donut", 4).toInt)

  def calculateDonutCost(donutName: String, quantity: Int, couponCode: String = "NO CODE"): Double = {
    println(s"Calculating cost for $donutName, quantity = $quantity, couponCode = $couponCode")
    // make some calculations ...
    2.50 * quantity
  }

  println("\nStep 4: How to call a function with parameters that has default values")
  val totalCostWithDiscount = calculateDonutCost("Glazed Donut", 4, "COUPON_12345")
  val totalCostWithoutDiscount = calculateDonutCost("Glazed Donut", 4)

  // define an Option in a function parameter
  def calculateDonutCost(donutName: String, quantity: Int, couponCode: Option[String]): Double = {
    println(s"Calculating cost for $donutName, quantity = $quantity")

    couponCode match {
      case Some(coupon) =>
        val discount = 0.1 // Let's simulate a 10% discount
      val totalCost = 2.50 * quantity * (1 - discount)
        totalCost

      case None => 2.50 * quantity
    }
  }

  // Create Function With Option Return Type

  // define a function which returns an Option of type String
  def dailyCouponCode(): Option[String] = {
    // look up in database if we will provide our customers with a coupon today
    val couponFromDb = "COUPON_1234"
    Option(couponFromDb).filter(_.nonEmpty)

  }

  // call function with Option return type using getOrElse
  val todayCoupon: Option[String] = dailyCouponCode()
  println(s"Today's coupon code = ${todayCoupon.getOrElse("No Coupon's Today")}")

  // call a function with Option return type using pattern matching
  dailyCouponCode() match {
    case Some(couponCode) => println(s"Today's coupon code = $couponCode")
    case None => println(s"Sorry there is no coupon code today!")
  }

  // call function with Option return type using map() function
  dailyCouponCode().map(couponCode => println(s"Today's coupon code = $couponCode"))

  def calculateDonutCost1(donutName: String, quantity: Int, couponCode: Option[String]): Double = {
    println(s"Calculating cost for $donutName, quantity = $quantity")

    couponCode match {
      case Some(coupon) =>
        val discount = 0.1 // Let's simulate a 10% discount
      val totalCost = 2.50 * quantity * (1 - discount)
        totalCost

      case None => 2.50 * quantity
    }
  }

  println(s"""Total cost with daily coupon code = ${calculateDonutCost1("Glazed Donut", 5, dailyCouponCode())}""")

  // define a function which has an implicit parameter
  def totalCost(donutType: String, quantity: Int)(implicit discount: Double): Double = {
    println(s"Calculating the price for $quantity $donutType")
    val totalCost = 2.50 * quantity * (1 - discount)
    totalCost
  }

  // define an implicit value
  implicit val discount: Double = 0.1
  println(s"All customer will receive a ${discount * 100}% discount")

  // How to call a function which has an implicit parameter
  println("\nStep 3: How to call a function which has an implicit parameter")
  println(s"""Total cost with discount of 5 Glazed Donuts = ${totalCost("Glazed Donut", 5)}""")

  // How to define a function which takes multiple implicit parameters
  def totalCost2(donutType: String, quantity: Int)(implicit discount: Double, storeName: String): Double = {
    println(s"[$storeName] Calculating the price for $quantity $donutType")
    val totalCost = 2.50 * quantity * (1 - discount)
    totalCost
  }

  // How to call a function which takes multiple implicit parameters
  implicit val storeName: String = "Tasty Donut Store"
  println(s"""Total cost with discount of 5 Glazed Donuts = ${totalCost2("Glazed Donut", 5)}""")

  // How to manually pass-through implicit parameters
  println("\nStep 6: How to manually pass-through implicit parameters")
  println(s"""Total cost with discount of 5 Glazed Donuts, manually passed-through = ${totalCost2("Glazed Donut", 5)(0.1, "Scala Donut Store")}""")

  // How To Create Implicit Function

  // How to create a wrapper String class which will extend the String type
  class DonutString(s: String) {
    def isFavoriteDonut: Boolean = s == "Glazed Donut"
  }

  // How to create an implicit function to convert a String to the wrapper String class
  object DonutConverstions {
    implicit def stringToDonutString(s: String) = new DonutString(s)
  }

  // How to import the String conversion so that it is in scope
  import DonutConverstions._

  // How to create String values
  val glazedDonut = "Glazed Donut"
  val vanillaDonut = "Vanilla Donut"

  // How to access the custom String function called isFavoriteDonut
  println(s"Is Glazed Donut my favorite Donut = ${glazedDonut.isFavoriteDonut}")
  println(s"Is Vanilla Donut my favorite Donut = ${vanillaDonut.isFavoriteDonut}")

  // How To Create Typed Function

  // How to define a function which takes a String parameter
  def applyDiscount(couponCode: String) {
    println(s"Lookup percentage discount in database for $couponCode")
  }

  // How to define a function which takes a parameter of type Double
  def applyDiscount(percentageDiscount: Double) {
    println(s"$percentageDiscount discount will be applied")
  }

  // Calling applyDiscount function with String or Double parameter type
  applyDiscount("COUPON_1234")
  applyDiscount(10)

  // How to define a generic typed function which will specify the type of its parameter
  def applyDiscount[T](discount: T) {
    discount match {
      case d: String =>
        println(s"Lookup percentage discount in database for $d")

      case d: Double =>
        println(s"$d discount will be applied")

      case _ =>
        println("Unsupported discount type")
    }
  }

  // How to call a function which has typed parameters
  applyDiscount[String]("COUPON_123")
  applyDiscount[Double](10)

  // How to define a polymorphic typed function which also has a generic return type
  def applyDiscountWithReturnType[T](discount: T): Seq[T] = {
    discount match {
      case d: String =>
        println(s"Lookup percentage discount in database for $d")
        Seq[T](discount)

      case d: Double =>
        println(s"$d discount will be applied")
        Seq[T](discount)

      case d @ _ =>
        println("Unsupported discount type")
        Seq[T](discount)
    }
  }

  // How to call a generic polymorphic function which also has a generic return type
  println(s"Result of applyDiscountWithReturnType with String parameter = ${applyDiscountWithReturnType[String]("COUPON_123")}")

  println()
  println(s"Result of applyDiscountWithReturnType with Double parameter = ${applyDiscountWithReturnType[Double](10.5)}")

  println()
  println(s"Result of applyDiscountWithReturnType with Char parameter = ${applyDiscountWithReturnType[Char]('U')}")

  // How To Create Variable Argument Function - varargs _: *

  // How to define function which takes variable number of arguments
  def printReport(names: String*) {
    println(s"""Donut Report = ${names.mkString(", ")}""")
  }

  // How to call function which takes variable number of String arguments
  printReport("Glazed Donut", "Strawberry Donut", "Vanilla Donut")
  printReport("Chocolate Donut")

  // How to pass a List to a function with variable number of arguments
  val listDonuts: List[String] = List("Glazed Donut", "Strawberry Donut", "Vanilla Donut")
  printReport(listDonuts: _*)

  // How to pass a Sequence to a function with variable number of arguments
  val seqDonuts: Seq[String] = Seq("Chocolate Donut", "Plain Donut")
  printReport(seqDonuts: _*)

  // How to pass an Array to a function with variable number of arguments
  val arrDonuts: Array[String] = Array("Coconut Donut")
  printReport(arrDonuts: _*)

  // Learn How To Create Function Currying With Parameter Groups

  // How to define function with curried parameter groups
  def totalCost1(donutType: String)(quantity: Int)(discount: Double): Double = {
    println(s"Calculating total cost for $quantity $donutType with ${discount * 100}% discount")
    val totalCost = 2.50 * quantity
    totalCost - (totalCost * discount)
  }

  // How to call a function with curried parameter groups
  println(s"Total cost = ${totalCost1("Glazed Donut")(10)(0.1)}")

  // How to create a partial function from a function with curried parameter groups
  val totalCostForGlazedDonuts = totalCost1("Glazed Donut") _

  // How to call a partial function
  println(s"\nTotal cost for Glazed Donuts ${totalCostForGlazedDonuts(10)(0.1)}")

  // How to define a higher order function which takes another function as parameter
  //  A Higher Order Function is a function which takes another function as its parameters.
  def totalCostWithDiscountFunctionParameter(donutType: String)(quantity: Int)(f: Double => Double): Double = {
    println(s"Calculating total cost for $quantity $donutType")
    val totalCost = 2.50 * quantity
    f(totalCost)
  }

  // How to call higher order function and pass an anonymous function as parameter
  val totalCostOf5Donuts = totalCostWithDiscountFunctionParameter("Glazed Donut")(5){totalCost =>
    val discount = 2 // assume you fetch discount from database
    totalCost - discount
  }
  println(s"Total cost of 5 Glazed Donuts with anonymous discount function = $totalCostOf5Donuts")

  // How to define and pass a function to a higher order function
  def applyDiscount1(totalCost: Double): Double = {
    val discount = 2 // assume you fetch discount from database
    totalCost - discount
  }

  println(s"Total cost of 5 Glazed Donuts with discount function = ${totalCostWithDiscountFunctionParameter("Glazed Donut")(5)(applyDiscount1(_))}")

  // Learn How To Create Higher Order Function - Call-By-Name Function

  // How to define a List with Tuple3 elements
  val listOrders = List(("Glazed Donut", 5, 2.50), ("Vanilla Donut", 10, 3.50))

  // How to define a function to loop through each Tuple3 elements of the List and calculate total cost
  def placeOrder(orders: List[(String, Int, Double)])(exchangeRate: Double): Double = {
    var totalCost: Double = 0.0
    orders.foreach {order =>
      val costOfItem = order._2 * order._3 * exchangeRate
      println(s"Cost of ${order._2} ${order._1} = £$costOfItem")
      totalCost += costOfItem
    }
    totalCost
  }

  println(s"Total cost of order = £${placeOrder(listOrders)(0.5)}")

  // How to define a call-by-name function
  def placeOrderWithByNameParameter(orders: List[(String, Int, Double)])(exchangeRate: => Double): Double = {
    var totalCost: Double = 0.0
    orders.foreach {order =>
      val costOfItem = order._2 * order._3 * exchangeRate
      println(s"Cost of ${order._2} ${order._1} = £$costOfItem")
      totalCost += costOfItem
    }
    totalCost
  }

  // How to define a simple USD to GBP function
  val randomExchangeRate = new Random(10)
  def usdToGbp: Double = {
    val rate = randomExchangeRate.nextDouble()
    println(s"Fetching USD to GBP exchange rate = $rate")
    rate
  }

  // How to call function with call-by-name parameter
  println(s"Total cost of order = £${placeOrderWithByNameParameter(listOrders)(usdToGbp)}")

  // Learn How To Create Higher Order Function - Callback Function Parameter

  // How to define a function with a callback parameter
  def printReport(sendEmailCallback: () => Unit) {
    println("Printing report ... started")
    // look up some data in database and create a report
    println("Printing report ... finished")
    sendEmailCallback()
  }

  // How to call a function which has a callback parameter
  printReport(() =>
    println("Sending email ... finished")
  )

  // How to call a function without providing its callback parameter
  printReport(() => {})

  // How to define a function with an Option callback
  def printReportWithOptionCallback(sendEmailCallback: Option[() => Unit] = None) {
    println("Printing report ... started")
    // look up some data in database and create a report
    println("Printing report ... finished")
    sendEmailCallback.map(callback => callback())
  }

  // How to call a function without providing its callback parameter
  printReportWithOptionCallback()

  // How to call a function with Option callback parameter
  printReportWithOptionCallback(Some(() =>
    println("Sending email wrapped in Some() ... finished")
  ))
}
