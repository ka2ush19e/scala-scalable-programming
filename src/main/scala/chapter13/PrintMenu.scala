package chapter13

object PrintMenu {
  def main(args: Array[String]) {
    import chapter13.Fruits
    import chapter13.showFruit

    for (f <- Fruits.menu) {
      println(f.name)
    }
  }
}
