package chapter12

import scala.collection.mutable.ArrayBuffer

abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  override def get(): Int = buf.remove(0)
  override def put(x: Int) { buf += x }
}

trait Doubling extends IntQueue {
  abstract override def put(x: Int) { super.put(x * 2) }
}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) { super.put(x + 1) }
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int) { if (x >= 0) super.put(x) }
}

class MyQueue extends BasicIntQueue with Doubling {

}

object Queue {
  def main(args: Array[String]) {
    val queue1 = new MyQueue()
    queue1.put(10)
    queue1.put(20)
    println(queue1.get())
    println(queue1.get())
    println()

    val queue2 = new BasicIntQueue with Doubling
    queue2.put(10)
    println(queue2.get())
    println()

    val queue3 = new BasicIntQueue with Incrementing with Filtering
    queue3.put(-1)
    queue3.put(0)
    queue3.put(1)
    println(queue3.get())
    println(queue3.get())
    println()

    val queue4 = new BasicIntQueue with Filtering with Incrementing
    queue4.put(-1)
    queue4.put(0)
    queue4.put(1)
    println(queue4.get())
    println(queue4.get())
    println(queue4.get())
  }
}
