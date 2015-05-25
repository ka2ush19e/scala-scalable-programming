package chapter09

import java.io.File

object FileMatcher {
  private def filesHere(path: String): Array[File] = {
    val files = new File(path).listFiles
    files.filter(_.isFile) ++ files.filter(_.isDirectory).flatMap(f => filesHere(f.getAbsolutePath))
  }

  def filesMatching(path: String, matcher: String => Boolean): Array[File] = {
    for (file <- filesHere(path) if matcher(file.getName)) yield file
  }

  def filesEnding(path: String, query: String): Array[File] = {
    filesMatching(path, _.endsWith(query))
  }

  def filesContaining(path: String, query: String): Array[File] = {
    filesMatching(path, _.contains(query))
  }

  def filesRegex(path: String, query: String): Array[File] = {
    filesMatching(path, _.matches(query))
  }

  def main(args: Array[String]) {
    filesEnding(".", "sbt").foreach(f => println(f.getAbsolutePath))
    println()

    filesContaining(".", "File").foreach(f => println(f.getAbsolutePath))
    println()

    filesRegex(".", ".*Sum.*").foreach(f => println(f.getAbsolutePath))
    println()
  }
}
