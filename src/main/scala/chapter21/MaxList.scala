package chapter21

import scala.collection.immutable.Range.Inclusive

object MaxList {
  def main(args: Array[String]) {

    def maxList1[T](elements: List[T])(implicit orderer: T => Ordered[T]): T = {
      elements match {
        case List() => throw new IllegalArgumentException("empty list")
        case List(x) => x
        case x :: rest =>
          val max = maxList1(rest)
          if (x > max) x else max
      }
    }

    def maxList2[T <% Ordered[T]](elements: List[T]): T = {
      elements match {
        case List() => throw new IllegalArgumentException("empty list")
        case List(x) => x
        case x :: rest =>
          val max = maxList2(rest)
          if (x > max) x else max
      }
    }

    println(maxList1(List(1, 4, 3, 5, 6, 9, 12)))
    println(maxList2(List(1, 4, 3, 5, 6, 9, 12)))
  }
}
