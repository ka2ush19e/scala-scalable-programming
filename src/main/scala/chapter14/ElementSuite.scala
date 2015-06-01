package chapter14

import org.scalatest.Suite

class ElementSuite extends Suite {
  def testUniformElement() {
    val e = Element.elem('x', 2, 3)
    assert(e.width == 2)
  }
}

object ElementSuite {
  def main(args: Array[String]) {
    (new ElementSuite).execute()
  }
}
