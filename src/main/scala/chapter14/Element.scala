package chapter14

import chapter14.Element.elem

abstract class Element {
  def contents: Array[String]
  def width: Int = contents(0).length
  def height: Int = contents.length

  def above(that: Element): Element = {
    val this_ = this widen that.width
    val that_ = that widen this.width
    assert(this_.width == that_.width)
    elem(this_.contents ++ that_.contents)
  }

  def beside(that: Element): Element = {
    val this_ = this heighten that.height
    val that_ = that heighten this.height
    elem(for ((line1, line2) <- this_.contents.zip(that_.contents)) yield line1 + line2)
  }

  def widen(w: Int): Element = {
    if (w <= width) {
      this
    } else {
      val left = elem(' ', (w - width) / 2, height)
      val right = elem(' ', w - width - left.width, height)
      left beside this beside right
    } ensuring(w <= _.width)
  }

  def heighten(h: Int): Element = {
    if (h <= height) {
      this
    } else {
      val top = elem(' ', width, (h - height) / 2)
      val bot = elem(' ', width, h - height - top.height)
      top above this above bot
    }
  }

  override def toString: String = contents.mkString("\n")
}

object Element {
  private class ArrayElement(val contents: Array[String]) extends Element

  private class LineElement(s: String) extends Element {
    val contents = Array(s)
    override def height: Int = 1
    override def width: Int = s.length
  }

  private class UniformElement(
      ch: Char,
      override val width: Int,
      override val height: Int) extends Element {

    require(width >= 0)
    private val line = ch.toString * width
    override def contents: Array[String] = Array.fill(height)(line)
  }

  def elem(contents: Array[String]): Element = new ArrayElement(contents)
  def elem(ch: Char, width: Int, height: Int): Element = new UniformElement(ch, width, height)
  def elem(line: String): Element = new LineElement(line)

  def main(args: Array[String]) {
    val a = elem("a")
    val b = elem('b', 5, 2)
    val c = elem(Array("c", "c"))
    val d = elem(Array("d", "d"))
    val e = elem("e")

    println(c.above(b).beside(d).beside(a).above(e))
  }
}
