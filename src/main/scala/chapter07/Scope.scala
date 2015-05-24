package chapter07

object Scope {
  def main(args: Array[String]) {
    val a = 1;
    {
      val a = 2
      println(a)
    }
    println(a)
  }
}
