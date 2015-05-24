package chapter07

object TryCatch {
  def main(args: Array[String]) {
    try {
      1 / 0
    } catch {
      case e: ArithmeticException => println("ArithmeticException")
      case e: RuntimeException => println("RuntimeException")
    } finally {
      println("Finalized")
    }
  }
  println()

  def f(): Int = try {1} finally {2}

  def g(): Int = try {return 1} finally {return 2}

  println(f())
  println(g())
  println()
}
