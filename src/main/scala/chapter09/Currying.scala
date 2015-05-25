package chapter09

object Currying {
  def plainOldSum(x: Int, y: Int): Int = x + y

  def curriedSum(x: Int)(y: Int): Int = x + y

  def main(args: Array[String]) {
    println(plainOldSum(2, 3))
    println(curriedSum(2)(3))
    val onePlus = curriedSum(1)_
    println(onePlus(2))
  }
}
