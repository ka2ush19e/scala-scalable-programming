package chapter20

object Demo {
  lazy val x = {println("initializing x"); "done"}

  def main(args: Array[String]) {
    println("-----------")
    Demo
    println("-----------")
    println(x)
    println(x)
    println("-----------")
  }
}
