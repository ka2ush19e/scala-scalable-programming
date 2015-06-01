package chapter12

class Animal

trait HasLegs

class Frog extends Animal with Philosophical with HasLegs {
  override def toString: String = "green"
  override def philosophize() {
    println(s"It ain't easy being $toString!")
  }
}

object Frog {
  def main(args: Array[String]) {
    val frog = new Frog()
    frog.philosophize()

    val phil: Philosophical = frog
    phil.philosophize()

    val phrog: Philosophical = new Frog
    phrog.philosophize()
  }
}
