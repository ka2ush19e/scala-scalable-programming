package chapter18

object Reassignable {
  def main(args: Array[String]) {
    val time = new Time
    time.hour = 12
    time.minute = 15
    println(time)

    val thermo = new Thermometer
    thermo.fahrenheit = 25
    println(thermo)
  }
}

class Time {
  private[this] var h = 12
  private[this] var m = 0
  def hour: Int = h
  def hour_=(x: Int) {
    require(0 <= x && x < 24)
    h = x
  }
  def minute: Int = m
  def minute_=(x: Int) {
    require(0 <= x && x < 60)
    m = x
  }
  override def toString: String = f"$hour%02d:$minute%02d"
}

class Thermometer {
  var celsius: Float = _
  def fahrenheit = celsius * 9 / 5 + 32
  def fahrenheit_=(f: Float) {
    celsius = (f -32) * 5 / 9
  }
  override def toString: String = s"${fahrenheit}F/${celsius}C"
}
