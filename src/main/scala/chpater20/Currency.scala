package chpater20

abstract class CurrencyZone {
  type Currency <: AbstractCurrency
  def make(x: Long): Currency

  abstract class AbstractCurrency {
    type Currency <: AbstractCurrency
    val amount: Long
    def designation: String
    override def toString: String = s"$amount $designation"
    def +(that: Currency) = make(this.amount + that.amount)
    def *(x: Double) = make((this.amount * x).toLong)
    def from(other: CurrencyZone#AbstractCurrency): CurrencyZone.this.Currency = {
      make(math.round(
        other.amount.toDouble * Converter.exchangeRate(other.designation)(designation)
      ))
    }
  }

}

object US extends CurrencyZone {

  abstract class Dollar extends AbstractCurrency {
    def designation: String = "USD"
    override def toString: String = {
      val a = amount.toDouble / CurrencyUnit.amount.toDouble
      f"$a%.2f $designation"
    }
  }

  type Currency = Dollar
  def make(cents: Long): Dollar = new Dollar {val amount = cents}
  val Cent = make(1)
  val Dollar = make(100)
  val CurrencyUnit = Dollar
}

object Japan extends CurrencyZone {

  abstract class Yen extends AbstractCurrency {
    def designation: String = "JPY"
  }

  type Currency = Yen
  def make(yen: Long): Yen = new Yen {val amount = yen}
  val Yen = make(1)
  val CurrencyUnit = Yen
}

object Converter {
  var exchangeRate = Map(
    "USD" -> Map("USD" -> 1.0, "JPY" -> 1.25),
    "JPY" -> Map("USD" -> 0.8, "JPY" -> 1.0)
  )
}

object Currency {
  def main(args: Array[String]) {
    println(US.make(100))
    println(Japan.make(100))
    println(US.Dollar.from(Japan.make(250)))
  }
}

