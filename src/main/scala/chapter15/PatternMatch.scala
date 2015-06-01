package chapter15

import math.{ Pi, E }

object PatternMatch {
  def main(args: Array[String]) {

    def describe(x: Any) = x match {
      case 5 => "five"
      case true => "truth"
      case Nil => "empty list"
      case _ => "other"
    }

    println(describe(5))
    println(describe(true))
    println(describe(List()))
    println(describe("x"))

    val pi = Pi
    E match {
      case Pi => println("strange")
      case _ => println("OK")
    }
    E match {
      case pi => println("strange")
      case _ => println("OK")
    }
    E match {
      case `pi` => println("strange")
      case _ => println("OK")
    }

    List(0, 1, 2) match {
      case List(0, _, _) => println("list")
      case _ =>
    }
    List(0, 1, 2) match {
      case List(0, _*) => println("list")
      case _ =>
    }

    (0, 1) match {
      case (0, _) => println("tuple")
      case _ =>
    }

    def generalSize(x: Any): Int = x match {
      case s: String => s.length
      case m: Map[_, _] => m.size
      case _ => -1
    }
    println(generalSize("aaa"))
    println(generalSize(Map(1 -> "a", 2 -> "b")))
    val s = null
    println(generalSize(s))

    UnOp("abs", Number(1)) match {
      case UnOp("abs", e @ Number(_)) => println(e)
      case _ =>
    }

    val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
    println(capitals.get("France"))
    println(capitals.get("America"))

    val withDefault: Option[Int] => Int = {
      case Some(x) => x
      case None => 0
    }
    println(withDefault(Some(10)))
    println(withDefault(None))

    val second: PartialFunction[List[Int], Int] = {
      case x :: y :: _ => y
    }
    println(second.isDefinedAt(List(1, 2, 3)))
    println(second.isDefinedAt(List()))

    for ((country, city) <- capitals) {
      println(s"$country $city")
    }
  }
}
