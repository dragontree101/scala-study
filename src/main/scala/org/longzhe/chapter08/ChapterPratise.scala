package org.longzhe.chapter08

/**
 * Created by dragon on 14-7-8.
 */
object ChapterPratise {

  class Person {
    private[this] var name : String = _

    private[this] var age : Int = _

    override def toString = name + " : " + age
  }

  class Employee extends Person {

    private[this] var salary : Double = _

    override def toString = super.toString + " : " + salary

  }


  def main(args: Array[String]) {
    var employee1 = new Employee

    println(employee1.toString)
  }
}
