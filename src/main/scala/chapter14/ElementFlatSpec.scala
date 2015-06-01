package chapter14

import org.scalatest.{ ShouldMatchers, FlatSpec }

class ElementFlatSpec extends FlatSpec with ShouldMatchers {
  "A UniformElement" should "have a width equal to the passed value" in {
    Element.elem('x', 2, 3).width should be (2)
  }
  it should "have a height equal to the passed value" in {
    Element.elem('x', 2, 3).height should be (3)
  }
}

object ElementFlatSpec {
  def main(args: Array[String]) {
    (new ElementFlatSpec).execute()
  }
}
