package org.longzhe.chapter06

import scala.beans.BeanProperty

/**
 * Created by dragon on 14-7-3.
 */
object ChapterPractise {

  class Count {
    //私有变量, 表示初开this(即自身对象)可以使用，其他对象都不能访问
    private[this] val value : Int = Int.MaxValue

    def increment() : Int = {
      if (value < Int.MaxValue) value + 1 else value
    }

    def current = value
  }

  //默认参数为0, balance成员是可变的
  class BankAccount(var balance : Int = 0) {
    balance = if(balance < 0) 0 else balance

    //没有参数的构造函数
    def this() {
      this(10)
    }

    def deposit() {}
    def withdraw() {}
  }

  class Timer(val hour : Int, val minute : Int) {

    def before(other : Timer):Boolean = {
      hour < other.hour || (hour == other.hour && minute < other.minute)
    }

    //重载
    override def toString() : String = {
      (hour * 60+ minute) toString
    }
  }

  class Student {
    //可以通过这个注解自动产生get set方法
    @BeanProperty var name : String = _  //表示默认值
    @BeanProperty var id : Long = _

    override def toString() : String = {
      id + " : " + name
    }
  }


  def main(args: Array[String]) {
    val count = new Count()
    println(count.increment())

    val bankAccount = new BankAccount(-1)
    println(bankAccount.balance)

    val time = new Timer(12, 30)
    println(time.before(new Timer(13, 30)))
    println(time.toString())

    val student = new Student()
    student.setName("longzhe")
    student.setId(123);
    println(student.toString)
  }
}
