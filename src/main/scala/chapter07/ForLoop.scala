package chapter07

import java.io.File

import scala.io.Source
import scala.util.control.Breaks._

object ForLoop {
  def main(args: Array[String]) {

    for (i <- 1 to 5) {
      println(i)
    }
    println()

    for (i <- 1 until 5) {
      println(i)
    }
    println()

    val files = new File(".").listFiles()
    for (file <- files) {
      println(file)
    }
    println()

    for (file <- files if file.getName.startsWith(".")) {
      println(file)
    }
    println()

    def fileLines(file: File): List[String] = {
      Source.fromFile(file).getLines().toList
    }

    val lines =
      for {
        file <- files
        if file.isFile
        line <- fileLines(file)
        trimmed = line.trim
        if trimmed.contains("scala")
      } yield trimmed
    println(lines.toList.mkString("\n"))
    println()

    def searchFrom(i: Int): Int = {
      if (i >= files.length) -1
      else if (files(i).getName.contains("scala")) i
      else searchFrom(i + 1)
    }
    println(searchFrom(0))
    println(files(searchFrom(0)).getName)
    println()

    breakable {
      for (file <- files) {
        if (file.getName.contains("scala")) {
          println(file.getName)
          break()
        }
      }
    }
  }
}
