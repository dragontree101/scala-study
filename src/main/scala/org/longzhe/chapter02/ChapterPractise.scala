package org.longzhe.chapter02

import scala.math.{sqrt, BigInt}
import scala.util.Random

/**
 * Created by dragon on 14-7-1.
 */
object ChapterPractise {

  def calSqrt(num : Double) : Double  = {
    val a = sqrt(num)
    val b = a * a
    b - num
  }

  def timesStr(times : Int, str : String) : String = {
    str * times
  }

  def maxNum(a : Int, b : Int) : Int = {
    a max b
  }

  def bigIntPow(a : BigInt, times : Int) : BigInt = {
    a pow times
  }

  def randomBigInt2Str() : String = {
    //如果函数不需要参数， 可以不加()
    BigInt(Random nextInt).toString(36)
  }

  def strFunTest(str : String) = {
    println(str take 1)  //第一个字符
    println(str takeRight 1) //最后一个字符
    println(str reverse 0) //最后一个字符
    println(str drop 1) //去掉第一个字符后的结果
    println(str dropRight 1) //去掉最后一个字符后的结果
  }


  def main (args: Array[String]) {
    println(calSqrt(3))

    println(timesStr(4, "longzhe"))

    println(maxNum(3,2))

    println(bigIntPow(2, 1024))
    println(bigIntPow(BigInt(2), 1024))

    println(randomBigInt2Str())

    strFunTest("longzhe")
  }
}
