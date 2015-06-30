package chapter30

trait Tree[+T] {
  def elem: T
  def left: Tree[T]
  def right: Tree[T]
}

object EmptyTree extends Tree[Nothing] {
  override def elem: Nothing = throw new NoSuchElementException("elem")
  override def left: Tree[Nothing] = throw new NoSuchElementException("left")
  override def right: Tree[Nothing] = throw new NoSuchElementException("right")
}

class Branch[+T](
  val elem: T,
  val left: Tree[T],
  val right: Tree[T]) extends Tree[T] {
  override def equals(other: Any): Boolean = other match {
    case that: Branch[t] =>
      (that canEqual this) && elem == that.elem && left == that.left && right == that.right
    case _ => false
  }
  override def hashCode(): Int = {
    41 * (
      41 * (
        41 + elem.hashCode
        ) + left.hashCode
      ) + right.hashCode
  }
  def canEqual(other: Any): Boolean = other match {
    case that: Branch[_] => true
    case _ => false
  }
}

object Branch {
  def main(args: Array[String]) {
    val b1 = new Branch[List[String]](Nil, EmptyTree, EmptyTree)
    val b2 = new Branch[List[Int]](Nil, EmptyTree, EmptyTree)
    println(s"b1 == b2: ${b1 == b2}")

  }
}
