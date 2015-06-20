package chapter21

class PreferredPrompt(val preference: String)

class PreferredDrink(val preference: String)

object MyPrefs {
  implicit val myPrompt = new PreferredPrompt("hello >")
  implicit val myDrink = new PreferredDrink("water")
}

object Greeter {

  def greet(name: String)(implicit prompt: PreferredPrompt, drink: PreferredDrink) {
    println(s"Welcome, $name. The system is ready. ")
    println(s"${drink.preference} ${prompt.preference}")
  }

  def main(args: Array[String]) {
    val prompt = new PreferredPrompt("$$$ > ")
    val drink = new PreferredDrink("coke")
    Greeter.greet("foobar")(prompt, drink)

    import MyPrefs._
    Greeter.greet("foobar")
  }
}
