package chapter23

case class Person(name: String, isMale: Boolean, children: Person*)

object Person {
  def main(args: Array[String]) {
    val andy = new Person("andy", false)
    val bob = new Person("bob", true)
    val marie = new Person("marie", false, andy, bob)
    val person = List(andy, bob, marie)

    println("### High order function ###")
    person.filter(!_.isMale).flatMap(p => p.children.map(c => (p.name, c.name))).foreach(println)

    println("### For ###")
    (for (p <- person; if !p.isMale; c <- p.children) yield (p.name, c.name)).foreach(println)
  }
}
