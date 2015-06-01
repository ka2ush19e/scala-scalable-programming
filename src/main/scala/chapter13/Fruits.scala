package chapter13

abstract class Fruit(val name: String, val color: String)

object Fruits {
  object Apple extends Fruit("apple", "red")
  object Orange extends Fruit("orange", "orange")
  object Pear extends Fruit("pear", "yellowish")
  val menu = List(Apple, Orange, Pear)

  def showFruit(fruit: Fruit) {
    import fruit._
    println(s"$name are $color")
  }

  def main(args: Array[String]) {
    showFruit(Apple)
  }

  import java.util.regex
  class AStartB {
    val pat = regex.Pattern.compile("")
  }
}

object Fruits2 {
  def main(args: Array[String]) {
    import Fruits.{Apple => Mac, Orange}
    println(Mac.name)

    import Fruits.{Apple => Mac, _}
    println(Orange.name)
  }
}
