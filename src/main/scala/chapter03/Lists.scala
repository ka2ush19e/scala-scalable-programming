package chapter03

object Lists {
  def main(args: Array[String]) {
    val oneTwo = List(1, 2)
    val threeFour = List(3, 4)
    val oneTwoThreeFour = oneTwo ::: threeFour
    println(oneTwoThreeFour)

    val twoThree = List(2, 3)
    println(1 :: twoThree)

    println(1 :: 2 :: 3 :: 4 :: Nil)
  }
}
