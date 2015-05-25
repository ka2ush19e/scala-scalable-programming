package chapter09

object ByNameParameter {
  var assertionEnabled = true

  def myAssert(predicate: => Boolean) {
    if (assertionEnabled && !predicate) {
      throw new AssertionError
    }
  }

  def main(args: Array[String]) {
    myAssert(5 > 3)
  }
}
