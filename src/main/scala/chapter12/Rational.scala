package chapter12

class Rational(n: Int, d: Int) extends Ordered[Rational] {
  require(d != 0)

  private val g = gcd(n.abs, d.abs)
  val numer = n / g
  val denom = d / g

  def this(n: Int) = this(n, 1)

  override def toString: String = s"$numer/$denom"

  def +(that: Rational): Rational = {
    new Rational(numer * that.denom + that.numer * denom, denom * that.denom)
  }

  def +(i: Int): Rational = {
    new Rational(numer + i * denom, denom)
  }

  def *(that: Rational): Rational = {
    new Rational(numer * that.numer, denom * that.denom)
  }

  def *(i: Int): Rational = {
    new Rational(numer * i, denom)
  }

  override def compare(that: Rational): Int = (numer * that.denom) - (that.numer * denom)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}

object Rational {
  implicit def intToRational(x: Int): Rational = new Rational(x)

  def main(args: Array[String]) {
    val half = new Rational(1, 2)
    val third = new Rational(1, 3)
    println(half < third)
    println(half > third)
  }
}


