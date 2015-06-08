package chapter16

object BasicListOperation {
  def main(args: Array[String]) {

    println("### insertion sort ###")
    def isort(xs: List[Int]): List[Int] = {
      if (xs.isEmpty) Nil else insert(xs.head, isort(xs.tail))
    }
    def insert(x: Int, xs: List[Int]): List[Int] = {
      if (xs.isEmpty || x <= xs.head) x :: xs else xs.head :: insert(x, xs.tail)
    }
    println(isort(List(5, 3, 6, 8, 7, 9, 4, 1)))
    println()

    println("### list pattern ###")
    def isort2(xs: List[Int]): List[Int] = xs match {
      case List() => List()
      case _ => insert2(xs.head, isort2(xs.tail))
    }
    def insert2(x: Int, xs: List[Int]): List[Int] = xs match {
      case List() => List(x)
      case y :: ys => if (x <= y) x :: xs else y :: insert2(x, ys)
    }
    println(isort2(List(5, 3, 6, 8, 7, 9, 4, 1)))
    println()


  }
}
