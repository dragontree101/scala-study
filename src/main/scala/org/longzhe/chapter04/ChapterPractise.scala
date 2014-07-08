package org.longzhe.chapter04

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/**
 * Created by dragon on 14-7-1.
 */
object ChapterPractise {

  def untilAndToTest(n : Int) = {
    //until关键字是小于等于n的值
    for(i <- 0 until n) {
      print(i + "----")
    }
    println()

    //to是等于n的值
    for(i <- 0 to n) {
      print(i + "----")
    }
    println()

  }

  def randomArray(n : Int) = {
    for(i <- 0 until n) yield Random.nextDouble() * n toInt
  }

  def swapArray1(arr : Array[Int]) : Array[Int] = {
    val a = arr.toBuffer
    for(i <- 1 until (arr.length, 2); tmp = a(i); j <- i -1 until i) {
      a(i) = a(j)
      a(j) = tmp
    }
    a.toArray

  }

  def swapArray2(arr : Array[Int]) : Array[Int] = {
    val a = arr.toBuffer
    //通过yield产生了多个array构成的数组，然后通过flatten变成一个数组
    val arrayInArray = (for(i <- 0 until (arr.length, 2)) yield
    if (i + 1 < arr.length) Array(arr(i+1), arr(i))
    else Array(arr(i)))

    arrayInArray foreach(arrInArr => print(arrInArr.toBuffer+ "------"))
    println
    arrayInArray.flatten.toArray
    //Flattens a two-dimensional array by concatenating all its rows into a single array.
  }

  def resortArray1(arr : Array[Int]) : Array[Int] = {
    var res1 = ArrayBuffer[Int]()//可变的一个集合类型
    var res2 = ArrayBuffer[Int]()
    for(a <- arr) a match {
      case a if a > 0 => res1 += a //加入单个的元素
      case _ => res2 += a
    }

    print(res1.mkString("-"))
    println()
    print(res2.mkString("-"))
    println()
    res1 ++= res2  //加入一系列的元素
    res1.toArray

  }

  def resortArray2(arr : Array[Int]) : Array[Int] = {
    val res1 = arr.filter(_ > 0).map(1 * _)
    val res2 = arr.filter(_ <= 0).map(1 * _)
    val res = res1.toBuffer  //to a new mutable array
    res ++= res2
    res.toArray
  }

  def arrayAvrage(arr : Array[Double]) : Double = {
    if (arr.length == 0)
      0.0
    else
      arr.sum/arr.length
  }

  def reverseArray(arr:Array[Int]):Array[Int]={
    arr.reverse
  }

  def distinctArray(arr:Array[Int]):Array[Int]={
    val t = arr.toBuffer
    t.distinct.toArray //去掉重复的元素
  }

  def main(args: Array[String]) {
    untilAndToTest(10)

    //mkString把数组里面的元素拼接成字符串
    print(randomArray(10).mkString(","))
    println()

    print(swapArray1(Array(1,2,3,4,5)).mkString(","))
    println()

    print(swapArray2(Array(1,2,3,4,5)).mkString(","))
    println()

    print(resortArray1(Array(1,-2,9,0,4,-4)).mkString(","))
    println()

    print(resortArray2(Array(1,-2,9,0,4,-4)).mkString(","))
    println()

    print(arrayAvrage(Array(1.0,2.0,3.0,4.0,5.0)) + "-----" + arrayAvrage(Array()))
    println()

    print(reverseArray(Array(1,2,3,4,5)).mkString(","))
    println()

    print(distinctArray(Array(1,1,5,4,5)).mkString(","))
    println()
  }
}
