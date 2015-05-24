package chapter03

import scala.collection.immutable.HashSet

object Collections {
  def main(args: Array[String]) {
    var jets1 = Set("Boeing", "Airbus")
    jets1 += "Lear"
    println(jets1.contains("Cesna"))

    val jets2 = scala.collection.mutable.Set("Boeing", "Airbus")
    jets2 += "Lear"
    println(jets2.contains("Cesna"))

    var jets3 = HashSet("Boeing", "Airbus")
    jets3 += "Lear"
    println(jets3.contains("Cesna"))

    val jets4 = scala.collection.mutable.Map[Int, String]()
    jets4 += (1 -> "Boeing")
    jets4 += (2 -> "Airbus")
    jets4 += (3 -> "Lear")
    jets4 += (4 -> "Cesna")
    println(jets4)

    val jets5 = Map(1 -> "Boeing", 2 -> "Airbus", 3 -> "Lear", 4 -> "Cesna")
    println(jets5)
  }
}
