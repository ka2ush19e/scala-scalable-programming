package chapter20

trait Abstract {
  type T
  def transform(x: T): T
  val initial: T
  var current: T
}

class Concrete extends Abstract {
  type T = String
  def transform(x: String): String = x + x
  val initial: String = "hi"
  var current: String = initial
}
