package chapter27

import scala.annotation.Annotation


object Annotations {
  def main(args: Array[String]) {

    sealed abstract class Number
    case class One() extends Number
    case class Two() extends Number
    case class Three() extends Number

    def numberToInt(n: Number) = (n: @unchecked) match {
      case One() => 1
      case Two() => 2
    }

    println(numberToInt(One()))
    println(numberToInt(Two()))
    println()

    @hello("world") def aaa() {
      println("aaa")
    }

    @deprecated def bbb() {
      println("aaa")
    }

    aaa()
  }

  class hello(name : String) extends Annotation {
    println(s"Hello, $name")
  }
}
