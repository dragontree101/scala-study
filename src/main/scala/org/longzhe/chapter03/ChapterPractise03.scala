package org.longzhe.chapter03

/**
 * Created by dragon on 14-7-1.
 */
object ChapterPractise03 {

  def signnum(a : Int) : Int = {
    if(a > 0) {
      1
    } else if (a < 0) {
      -1
    } else {
      0
    }
  }

  def scalaFor() = {
    //逆序 从10到0输出
    for(i <- 0 to 10 reverse) {
      print(i + " ")
    }
    println()
  }

  def countDown(n : Int) = {
    n to(0, -1) foreach(print _)
    println()

    (0 to n reverse) foreach(i => print(i + " "))
    println()
  }

  def calUnicode(str : String) : BigInt = {
    var res = BigInt(1)
//    str foreach(s => {res *= s.toLong})
    str foreach(res *= _.toLong)
    res
  }

  def testRecursion(x: Double, n : Int) : Double = {
    if(n == 0) 1
    else if(n < 0) 1/testRecursion(x, -n)
    else
      if(n %2 == 1) x * testRecursion(x, n-1)
      else testRecursion(x, n/2)* testRecursion(x, n/2)
  }

  def testRecursion2(x: Double, n : Int) : Double = {
    n match {
      case n if n < 0 => 1/testRecursion2(x, -n)
      case n if n > 0 && n % 2 == 1 => x * testRecursion2(x, n-1)
      case n if n > 0 && n % 2 == 0 => testRecursion2(x, n/2)* testRecursion2(x, n/2)
      case _ => 1
    }
  }

  def main(args: Array[String]) {

    println(signnum(3) + "-----" + signnum(-5) + "-----" + signnum(0))

    scalaFor()

    countDown(5)

    println(calUnicode("Hello"))

    print(testRecursion(2,0) + "  ")
    print(testRecursion(2,-1) + "  ")
    print(testRecursion(2,1) + "  ")
    println(testRecursion(2,2))

    print(testRecursion2(2,0) + "  ")
    print(testRecursion2(2,-1) + "  ")
    print(testRecursion2(2,1) + "  ")
    println(testRecursion2(2,2))

  }
}
