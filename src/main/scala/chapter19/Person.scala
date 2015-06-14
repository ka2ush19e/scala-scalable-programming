package chapter19

class Person(val name: String) extends Ordered[Person] {
  override def compare(that: Person): Int = name.compareToIgnoreCase(that.name)
  override def toString: String = name
}

object Person {
  def main(args: Array[String]) {
    val p1 = new Person("Alice")
    val p2 = new Person("Bob")
    println(p1 < p2)
    println()

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
    val people1 = List(new Person("Bob"), new Person("Charles"), new Person("Dyran"))
    println(msort((x:Person, y:Person) => x < y)(people1))
    println()

    def msort2[T <: Ordered[T]](less: (T, T) => Boolean)(xs: List[T]): List[T]  = {
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
        merge(msort2(less)(ys), msort2(less)(zs))
      }
    }
    val people2 = List(new Person("Bob"), new Person("Charles"), new Person("Dyran"))
    println(msort2((x:Person, y:Person) => x < y)(people2))
    println()
  }
}
