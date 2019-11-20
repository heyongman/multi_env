package com.he

import org.apache.spark.sql.SparkSession
import org.joda.time.LocalDateTime

object Demo {
  def main(args: Array[String]): Unit = {
//    configTest()
      configTest1()
  }

  def configTest(): Unit ={
    val spark = SparkSession.builder().appName("demo")
      .master("local[*]").getOrCreate()
    spark.sparkContext.setLogLevel("warn")
    val conf = Configuration.from("my.properties")
    val a = conf.getString("a")
    val source = spark.sparkContext.parallelize(Seq(1,2,3,4,5))
    source.foreachPartition(it =>{
      it.foreach(x => {
        println(x+a)
      })
    })


  }

  def configTest1(): Unit ={
    val name = SparkConfig.getAppName
    print(name)
  }
}
