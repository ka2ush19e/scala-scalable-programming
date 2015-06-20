package chpater20

trait RationalTrait {
  val numerArg: Int
  val denomArg: Int

  private lazy val g = gcd(numerArg, denomArg)
  lazy val number = numerArg / g
  lazy val denom = denomArg / g

  private def gcd(a: Int, b: Int): Int = {
    require(denomArg != 0)
    if (b == 0) a else gcd(b, a % b)
  }
  override def toString: String = s"$numerArg/$denomArg"
}

class Rational {

}

object Rational {
  def main(args: Array[String]) {
    val x = 2
    new {
      val numerArg: Int = 1 * x
      val denomArg: Int = 2 * x
    } with RationalTrait

    object twoThirds extends {
      val numerArg: Int = 2
      val denomArg: Int = 3
    } with RationalTrait

    class RationalClass(n: Int, d: Int) extends {
      val numerArg: Int = 2
      val denomArg: Int = 3
    } with RationalTrait

    new RationalTrait {
      val denomArg: Int = 1 * x
      val numerArg: Int = 2 * x
    }
  }
}

