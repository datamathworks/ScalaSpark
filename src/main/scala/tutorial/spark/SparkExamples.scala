package tutorial.spark

object SparkExamples {

  /**
    *  Example 1 - Reading data from .json file, showing it in a table, and printing the scheme
    *
    *
    */

  //employee.json file
  //
  //{"id" : "1201", "name" : "satish", "age" : "25"}
  //{"id" : "1202", "name" : "krishna", "age" : "28"}
  //{"id" : "1203", "name" : "amith", "age" : "39"}
  //{"id" : "1204", "name" : "javed", "age" : "23"}
  //{"id" : "1205", "name" : "prudvi", "age" : "23"}

 // val sqlcontext = new org.apache.spark.sql.SQLContext(sc)

 // val dfs = sqlcontext.read.json("employee.json")

//  dfs.show()

 // dfs.printSchema()

  // using "Select" method
 // dfs.select("name").show()

  // using "age" filter
 // dfs.filter(dfs("age") > 23).show()

  // using "groupBy" method
 // dfs.groupBy("age").count().show()

  /**
    * Example 2 - Reading data from .txt file and processing it
    *
    * In this example, the schema is inferred using the reflection
    */

  //customers.txt file:
  //
  //100, John Smith, Austin, TX, 78727
  //200, Joe Johnson, Dallas, TX, 75201
  //300, Bob Jones, Houston, TX, 77028
  //400, Andy Davis, San Antonio, TX, 78227
  //500, James Williams, Austin, TX, 78727

  // Create the SQLContext first from the existing Spark Context
 // val sqlContext = new org.apache.spark.sql.SQLContext(sc)

  // Import statement to implicitly convert an RDD to a DataFrame
 // import sqlContext.implicits._

  // Create a custom class to represent the Customer
  case class Customer(customer_id: Int, name: String, city: String, state: String, zip_code: String)

  // Create a DataFrame of Customer objects from the dataset text file.
 // val dfCustomers = sc.textFile("data/customers.txt").map(_.split(",")).map(p => Customer(p(0).trim.toInt, p(1), p(2), p(3), p(4))).toDF()

  // Register DataFrame as a table.
 // dfCustomers.registerTempTable("customers")

  // Display the content of DataFrame
//  dfCustomers.show()

  // Print the DF schema
 // dfCustomers.printSchema()

  // Select customer name column
 // dfCustomers.select("name").show()

  // Select customer name and city columns
 // dfCustomers.select("name", "city").show()

  // Select a customer by id
 // dfCustomers.filter(dfCustomers("customer_id").equalTo(500)).show()

  // Count the customers by zip code
 // dfCustomers.groupBy("zip_code").count().show()

  /**
    * Example 3 - Programmatically Specifying the Schema
    *
    * In this example, we specify the schema using the new data type classes StructType, StringType, and StructField
    */

  // Create SQLContext from the existing SparkContext.
  //val sqlContext = new org.apache.spark.sql.SQLContext(sc)

  // Create an RDD
 // val rddCustomers = sc.textFile("data/customers.txt")

  // The schema is encoded in a string
  val schemaString = "customer_id name city state zip_code"

  // Import Spark SQL data types and Row.
  import org.apache.spark.sql._

  import org.apache.spark.sql.types._;

  // Generate the schema based on the string of schema
  val schema = StructType(schemaString.split(" ").map(fieldName => StructField(fieldName, StringType, true)))

  // Convert records of the RDD (rddCustomers) to Rows.
  //val rowRDD = rddCustomers.map(_.split(",")).map(p => Row(p(0).trim,p(1),p(2),p(3),p(4)))

  // Apply the schema to the RDD.
//  val dfCustomers = sqlContext.createDataFrame(rowRDD, schema)

  // Register the DataFrames as a table.
 // dfCustomers.registerTempTable("customers")

  // SQL statements can be run by using the sql methods provided by sqlContext.
  //val custNames = sqlContext.sql("SELECT name FROM customers")

  // The results of SQL queries are DataFrames and support all the normal RDD operations.
  // The columns of a row in the result can be accessed by ordinal.
 // custNames.map(t => "Name: " + t(0)).collect().foreach(println)

  // SQL statements can be run by using the sql methods provided by sqlContext.
 // val customersByCity = sqlContext.sql("SELECT name,zip_code FROM customers ORDER BY zip_code")

  // The results of SQL queries are DataFrames and support all the normal RDD operations.
  // The columns of a row in the result can be accessed by ordinal.
 // customersByCity.map(t => t(0) + "," + t(1)).collect().foreach(println)
}
