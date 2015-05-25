package chapter09

import java.io.{PrintWriter, File}

object LoanPattern {
  def withPrintWriter(file: File)(op: PrintWriter => Unit) = {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  def main(args: Array[String]) {
    withPrintWriter(new File("data.txt")) { writer =>
      writer.println("test")
    }
  }
}
