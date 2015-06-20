package chapter21

import java.awt.Button
import java.awt.event.{ActionEvent, ActionListener}

object Button {
  def main(args: Array[String]) {
    val btn = new Button("test")

    // java style
    btn.addActionListener(
      new ActionListener {
        def actionPerformed(e: ActionEvent) = {
          println("pressed")
        }
      }
    )

    // before implicit
    btn.addActionListener(
      function2ActionListener((_: ActionEvent) => println("pressed"))
    )

    // scala implicit
    btn.addActionListener((_: ActionEvent) => println("pressed"))

  }

  implicit def function2ActionListener(f: ActionEvent => Unit): ActionListener = {
    new ActionListener {
      override def actionPerformed(e: ActionEvent) = f(e)
    }
  }
}
