package chapter05

object Literals {
  def main(args: Array[String]) {
    println(0x35)
    println(035)
    println(35)
    println(35L)
    println('\101')
    println('\u0041')
    println("""Hello World
               Hello Scala""")
    println("""|Hello World
               |Hello Scala""".stripMargin)
    println('test)
    println('test.name)
  }
}
