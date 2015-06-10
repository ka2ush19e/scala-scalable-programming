package chapter17

import scala.collection.immutable.{TreeMap, TreeSet}
import scala.collection.mutable

object Collections {
  def main(args: Array[String]) {
    val text = "See Spot run. Run , Spot. Run!"
    val wordArray = text.split("[ !,.]+")

    val words = mutable.Set.empty[String]
    for (word <- wordArray) {
      words += word.toLowerCase
    }
    println(s"words: $words")
    println()

    val nums = Set(1, 2, 3)
    println(s"nums: $nums")
    println(s"nums + 5: ${nums + 5}")
    println(s"nums - 3: ${nums - 3}")
    println(s"nums ++ Set(3, 4): ${nums ++ Set(3, 4)}")
    println(s"nums -- Set(1, 2): ${nums -- Set(1, 2)}")
    println(s"nums & Set(1, 3, 5): ${nums & Set(1, 3, 5)}")
    println()

    val counts = mutable.Map.empty[String, Int]
    for (word <- wordArray) {
      val word_ = word.toLowerCase
      val oldCount = counts.getOrElse(word_, 0)
      counts += (word_ -> (oldCount + 1))
    }
    println(s"counts: $counts")
    println()

    val ts = TreeSet(9, 4, 5, 2, 3)
    println(s"ts: $ts")
    val tm = TreeMap(8 -> "eight", 4 -> "four", 1 -> "one")
    println(s"tm: $tm")
    val ts2 = mutable.Set.empty ++= ts
    println(s"ts2: $ts2")
    val tm2 = mutable.Map.empty ++= tm
    println(s"tm2: $tm2")



  }
}
