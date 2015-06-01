package chapter14

import org.scalatest.FunSpec

class ElementFunSpec extends FunSpec {
  describe("elem") {
    it("should have passed width") {
      val e = Element.elem('x', 2, 3)
      assertResult(2) {
        e.width
      }
    }
    it("should throw exception") {
      intercept[IllegalArgumentException] {
        Element.elem('x', -2, 3)
      }
    }
  }
}
