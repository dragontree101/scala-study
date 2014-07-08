package org.longzhe.chapter05

import scala.collection.immutable
import scala.collection.mutable

import java.util.Calendar

/**
 * Created by dragon on 14-7-2.
 */
object ChapterPractise {

  def operateMap(map : immutable.Map[String, Double]) : immutable.Map[String, Double]= {
    for((k,v) <- map) yield (k, v*0.9)
  }

  //使用scala和java混用
  def operateLinkedMap() : mutable.Map[String, Int] = {
    val map = new mutable.LinkedHashMap[String, Int]

    map += ("Monday"->Calendar.MONDAY)
    map += ("Tuesday"->Calendar.TUESDAY)
    map += ("Wednesday"->Calendar.WEDNESDAY)
    map += ("Thursday"->Calendar.THURSDAY)
    map += ("Friday"->Calendar.FRIDAY)
    map += ("Saturday"->Calendar.SATURDAY)
    map += ("Sunday"->Calendar.SUNDAY)

  }

  def minmax(arr : Array[Int]) = {
    (arr.min, arr.max)
  }

  def lteqgt1(arr : Array[Int], v : Int) = {
    var i1 = 0;
    var i2 = 0;
    var i3 = 0;
    for(a <- arr) a match {
      case a if a < v => i1  +=  1
      case a if a > v => i3  +=  1
      case _ => i2  +=  1
    }

    (i1, i2, i3)
  }

  def lteqgt2(arr : Array[Int], v : Int) = {
    (arr.count(_ < v), arr.count(_ == v), arr.count(_ > v))
  }

  def main(args: Array[String]) {

    var map = immutable.Map("book"->10.0, "computer"->1000.0, "ipad"->2300.0)
    //不可变映射与可变映射的区别就是，每次添加元素，都会返回一个新的映射
    map += ("iphone"->4000.0) //不可变map的写法
//    map("testKey") =  2000.0 //可变的map的写法
    println(operateMap(map).mkString(","))

    println(operateLinkedMap().mkString(","))

    println(minmax(Array(1,2,6,4,5)))

    println(lteqgt1(Array(1,2,3,4,2,4,5), 3))
    println(lteqgt2(Array(1,2,3,4,2,4,5), 3))
  }
}
