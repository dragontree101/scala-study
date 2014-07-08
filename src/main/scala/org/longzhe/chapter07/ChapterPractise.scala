
/**
 * Created by dragon on 14-7-3.
 */

package random {

//package object 当前包下定义
package object random {
  var seed : Int = _  //赋值为"_"表示缺省值(根据不同的类型，可能表示为0, 0.0, false, null)
  val a = BigDecimal(1664525)
  val b = BigDecimal(1013904223)
  val n = 32

  def nextInt(): Int = {
    val temp = (seed * a + b) % (BigDecimal(2).pow(n))
    seed = temp.toInt
    seed
  }

  def nextDouble(): Double = {
    val temp = (seed * a + b) % (BigDecimal(2).pow(n))
    seed = temp.toInt
    temp.toDouble
  }

}

}

package org.longzhe.chapter07 {
 //引入包对象
import random.random

object ChapterPractise {

  abstract class UnitConversion {

    def inchesToCentimeters() {}

    def gallonsToLiters() {}

    def milesToKilometers() {}

  }

  object InchesToCentimeters extends UnitConversion {
    override def inchesToCentimeters() {
      println("InchesToCentimeters()")
    }
  }

  object GallonsToLiters extends UnitConversion {
    override def gallonsToLiters() {
      println("GallonsToLiters()")
    }
  }

  object MilesToKilometers extends UnitConversion {
    override def milesToKilometers() {
      println("MilesToKilometers()")
    }
  }

  //伴生对象测试(私有构造函数)
  class Point private (x: Int, y: Int) {
    override def toString(): String = {
      "x = " + x + ", y = " + y
    }
  }

  //继承了App特质，表示可以执行该object对象
  object Point extends App {
    def apply(x: Int, y: Int) = {
      new Point(x, y)
    }
  }

  //继承了枚举类型
  object Card extends Enumeration {
    val M = Value("♣")
    //Value最多支持2个值:(int和string)
    val T = Value("♠")
    val H = Value("♥")
    val F = Value("♦")


    def color(c: Card.Value): String = {
      if (c == Card.M || c == Card.T) "Black"
      else "Red"
    }

    override def toString(): String = {
      Card.M + "--" + Card.T + "--" + Card.H + "--" + Card.F;
    }
  }

  def main(args: Array[String]) {
    val obj1 = InchesToCentimeters
    val obj2 = GallonsToLiters
    val obj3 = MilesToKilometers

    obj1.inchesToCentimeters()
    obj2.gallonsToLiters()
    obj3.milesToKilometers()

    val point = Point(1, 2)
    println(point)

    println(Card)
    for(i <- Card.values) println(i.id + "----" + i)
    println(Card.color(Card.H))

    //使用包对象内的object
    random.seed = 4
    println(random.nextDouble())
    println(random.nextDouble())
    println(random.nextInt())
    println(random.nextInt())
  }
}

}


