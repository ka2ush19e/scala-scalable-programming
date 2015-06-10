package chapter17

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object SequenceAppendPerformance {
  def main(args: Array[String]) {

    def time[T](func: => T): T = {
      val st = System.nanoTime
      val result = func
      println(f"Elapsed time: ${(System.nanoTime - st) / 1000}%,d [ms]")
      result
    }

    println("### List 1 ###")
    time {
      var nums: List[Int] = List()
      for (i <- 0 to 10000) {
        nums = nums :+ i
      }
    }
    println()

    println("### List 2 ###")
    time {
      var nums: List[Int] = List()
      for (i <- 0 to 10000) {
        nums = i :: nums
      }
      nums = nums.reverse
    }
    println()

    println("### ListBuffer ###")
    time {
      var buf = new ListBuffer[Int]
      for (i <- 0 to 10000) {
        buf += i
      }
      val nums = buf.toList
    }
    println()

    println("### ArrayBuffer ###")
    time {
      var buf = new ArrayBuffer[Int]
      for (i <- 0 to 10000) {
        buf += i
      }
      val nums = buf.toList
    }
    println()
  }
}
