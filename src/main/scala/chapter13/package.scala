package object chapter13 {
  def showFruit(fruit: Fruit) {
    import fruit._
    println(fruit.name)
  }
}
