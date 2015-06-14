package chapter19

class Queue[+T] private(private[this] var leading: List[T], private[this] var trailing: List[T]) {
  private def mirror() = {
    if (leading.isEmpty) {
      while (trailing.nonEmpty) {
        leading = trailing.head :: leading
        trailing = trailing.tail
      }
    }
  }

  def head: T = {
    mirror()
    leading.head
  }

  def tail: Queue[T] = {
    mirror()
    new Queue(leading.tail, trailing)
  }

  def enqueue[U >: T](x: U): Queue[U] = {
    new Queue[U](leading, x :: trailing)
  }
  override def toString: String = (leading ::: trailing.reverse).toString()
}

object Queue {
  def apply[T](xs: T*) = new Queue[T](xs.toList, Nil)
}

object QueueApp {
  def main(args: Array[String]) {
    val q = Queue(1, 2, 3)
    println(q)
  }
}
