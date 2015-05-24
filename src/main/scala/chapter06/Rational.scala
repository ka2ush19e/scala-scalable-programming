package chapter06

class Rational(n: Int, d: Int) {
  require(d != 0)

  private val g = gcd(n.abs, d.abs)

  val number = n / g
  val denom = d / g

  def this(n: Int) = this(n, 1)

  override def toString: String = s"$number/$denom"

  def +(that: Rational): Rational = {
    new Rational(number * that.denom + that.number * denom, denom * that.denom)
  }

  def +(i: Int): Rational = {
    new Rational(number + i * denom, denom)
  }

  def *(that: Rational): Rational = {
    new Rational(number * that.number, denom * that.denom)
  }

  def *(i: Int): Rational = {
    new Rational(number * i, denom)
  }

  def lessThan(that: Rational): Boolean = {
    number * that.denom < that.number * denom
  }

  def max(that: Rational): Rational = {
    if (lessThan(that)) that else this
  }

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}

object Rational {
  implicit def intToRational(x: Int): Rational = new Rational(x)

  def main(args: Array[String]) {
    println("Create rational")
    println(new Rational(1, 2))
    try {
      println(new Rational(1, 0))
    } catch {
      case _: IllegalArgumentException => println("Cannnot create zero denominator")
    }
    println(new Rational(5))
    println(new Rational(2, 4))
    println()

    val oneHalf = new Rational(1, 2)
    val twoThirds = new Rational(2, 3)
    println(oneHalf + twoThirds)
    println(oneHalf * twoThirds)
    println(oneHalf lessThan twoThirds)
    println(oneHalf max twoThirds)
    println(twoThirds * 4)
    println(4 * twoThirds)
  }
}


