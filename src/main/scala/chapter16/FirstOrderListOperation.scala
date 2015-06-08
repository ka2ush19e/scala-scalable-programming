package chapter16

object FirstOrderListOperation {
  def main(args: Array[String]) {

    println("### first-order methods ###")
    def append[T](xs: List[T], ys: List[T]): List[T] = xs match {
      case List() => ys
      case x :: xs1 => x :: append(xs1, ys)
    }
    println(s"append(List(1, 2, 3), List(5, 6, 7)): ${append(List(1, 2, 3), List(5, 6, 7))}")

    val abcde = List("a", "b", "c", "d", "e")
    println(s"abcde.length: ${abcde.length}")
    println(s"abcde.last: ${abcde.last}")
    println(s"abcde.init: ${abcde.init}")
    println(s"abcde.reverse: ${abcde.reverse}")
    println(s"abcde.take(2): ${abcde.take(2)}")
    println(s"abcde.drop(2): ${abcde.drop(2)}")
    println(s"abcde.splitAt(2): ${abcde.splitAt(2)}")
    println(s"abcde(3): ${abcde(3)}")
    println(s"abcde.indices: ${abcde.indices}")
    println(s"List(abcde, abcde).flatten: ${List(abcde, abcde).flatten}")
    println(s"abcde.indices zip abcde: ${abcde.indices zip abcde}")
    println(s"abcde.zipWithIndex: ${abcde.zipWithIndex}")
    println(s"""List((0, "a"), (1, " b")).unzip: ${List((0, "a"), (1, "b")).unzip}""")
    println(s"""abcde.mkString(","): ${abcde.mkString(",")}""")
    println(s"""abcde.mkString("[", ",", "]"): ${abcde.mkString("[", ",", "]")}""")
    println(s"abcde.toArray: ${abcde.toArray}")
    println(s"Array(1, 2, 3).toList: ${Array(1, 2, 3).toList}")
    println()

    println("### merge sort ###")
    def msort[T](less: (T, T) => Boolean)(xs: List[T]): List[T]  = {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (x:: xs1, y:: ys1) => if (less(x, y)) x :: merge(xs1, ys) else y :: merge(xs, ys1)
      }
      val n = xs.length / 2
      if (n == 0) {
        xs
      } else {
        val (ys, zs) = xs.splitAt(n)
        merge(msort(less)(ys), msort(less)(zs))
      }
    }
    val intAscSort = msort((_: Int) < (_: Int)) _
    val intDescSort = msort((_: Int) > (_: Int)) _
    println(intAscSort(List(5, 3, 7, 2, 1)))
    println(intDescSort(List(5, 3, 7, 2, 1)))
    println()

    msort[String](_ > _)(abcde)
    abcde.sortWith(_ > _)
  }
}
