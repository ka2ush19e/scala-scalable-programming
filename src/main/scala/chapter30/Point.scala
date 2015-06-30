package chapter30

import scala.collection.mutable

object Point {

  def main(args: Array[String]) {
    bad1()
    bad2()
    bad3()
    bad4()
  }

  def bad1() = {
    class Point(val x: Int, val y: Int) {
      def equals(that: Point): Boolean = {
        x == that.x && y == that.y
      }
    }

    val p1, p2 = new Point(1, 2)
    val q = new Point(2, 3)

    println(s"p1 equals p2: ${p1 equals p2}")
    println(s"p1 equals q: ${p1 equals q}")

    val coll = mutable.HashSet(p1)
    println(s"coll contains p2: ${coll contains p2}")

    val p2a: Any = p2
    println(s"p1 equals p2a: ${p1 equals p2a}")
    println()
  }

  def bad2() = {
    class Point(val x: Int, val y: Int) {
      override def equals(that: Any): Boolean = that match {
        case that_ : Point => x == that_.x && y == that_.y
        case _ => false
      }
    }

    val p1, p2 = new Point(1, 2)
    val q = new Point(2, 3)

    println(s"p1 equals p2: ${p1 equals p2}")
    println(s"p1 equals q: ${p1 equals q}")

    val coll = mutable.HashSet(p1)
    println(s"coll contains p2: ${coll contains p2}")

    val p2a: Any = p2
    println(s"p1 equals p2a: ${p1 equals p2a}")
    println()
  }

  def bad3() {
    class Point(var x: Int, var y: Int) {
      override def hashCode(): Int = 41 * (41 + x) + y
      override def equals(that: Any): Boolean = that match {
        case that_ : Point => x == that_.x && y == that_.y
        case _ => false
      }
    }

    val p1, p2 = new Point(1, 2)
    val q = new Point(2, 3)

    println(s"p1 equals p2: ${p1 equals p2}")
    println(s"p1 equals q: ${p1 equals q}")

    val coll = mutable.HashSet(p1)
    println(s"coll contains p2: ${coll contains p2}")

    p1.x += 1
    println(s"coll contains p1: ${coll contains p1}")

    val p2a: Any = p2
    println(s"p1 equals p2a: ${p1 equals p2a}")
    println()
  }

  def bad4() {
    class Point1(val x: Int, val y: Int) {
      override def hashCode(): Int = 41 * (41 + x) + y
      override def equals(that: Any): Boolean = that match {
        case that_ : Point1 => x == that_.x && y == that_.y
        case _ => false
      }
    }

    class ColoredPoint1(x: Int, y: Int, val color: Color.Value) extends Point1(x, y) {
      override def equals(that: Any): Boolean = that match {
        case that_ : ColoredPoint1 => this.color == that_.color && super.equals(that_)
        case _ => false
      }
    }

    val p = new Point1(1, 2)
    val cp1 = new ColoredPoint1(1, 2, Color.Red)
    println(s"p equals cp1: ${p equals cp1}")
    println(s"cp1 equals p: ${cp1 equals p}")
    println()

    class ColoredPoint2(x: Int, y: Int, val color: Color.Value) extends Point1(x, y) {
      override def equals(that: Any): Boolean = that match {
        case that_ : ColoredPoint2 => this.color == that_.color && super.equals(that_)
        case that_ : Point1 => that_ equals this
        case _ => false
      }
    }

    val cp2 = new ColoredPoint2(1, 2, Color.Red)
    val cp2b = new ColoredPoint2(1, 2, Color.Orange)
    println(s"p equals cp2: ${p equals cp2}")
    println(s"cp2 equals p: ${cp2 equals p}")
    println(s"p equals cp2b: ${p equals cp2b}")
    println(s"cp2 equals cp2b: ${cp2 equals cp2b}")
    println()

    class Point2(val x: Int, val y: Int) {
      override def hashCode(): Int = 41 * (41 + x) + y
      override def equals(that: Any): Boolean = that match {
        case that_ : Point2 => x == that_.x && y == that_.y && this.getClass == that_.getClass
        case _ => false
      }
    }

    class ColoredPoint3(x: Int, y: Int, val color: Color.Value) extends Point2(x, y) {
      override def equals(that: Any): Boolean = that match {
        case that_ : ColoredPoint3 => this.color == that_.color && super.equals(that_)
        case _ => false
      }
    }

    val pAnon = new Point2(1, 1) {override val y = 2}
    println(s"p equals pAnon: ${p equals pAnon}")

    class Point3(val x: Int, val y: Int) {
      override def hashCode(): Int = 41 * (41 + x) + y
      override def equals(that: Any): Boolean = that match {
        case that_ : Point3 =>
          (that_ canEqual this) && x == that_.x && y == that_.y
        case _ => false
      }
      def canEqual(other: Any): Boolean = other.isInstanceOf[Point3]
    }

    class ColoredPoint4(x: Int, y: Int, val color: Color.Value) extends Point3(x, y) {
      override def hashCode(): Int = 41 * super.hashCode() + color.hashCode()
      override def equals(that: Any): Boolean = that match {
        case that_ : ColoredPoint4 =>
          (that_ canEqual this) && this.color == that_.color && super.equals(that_)
        case _ => false
      }
      override def canEqual(other: Any) = other.isInstanceOf[ColoredPoint4]
    }

  }
}

object Color extends Enumeration {
  val Red, Orange, Yellow = Value
}
