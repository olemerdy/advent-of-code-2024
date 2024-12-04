package org.lafeuille.adventofcode.y2024.d03

import scala.io.Source

object Day03 {
  private def myInput: Source =
    Source.fromURL(getClass.getResource("input03.txt"))

  def myLines: List[String] =
    myInput.getLines().toList

  def myOneLine: String =
    myLines.mkString
}

object Day03Part1 extends App {
  private val regex = "mul\\((\\d{1,3}),(\\d{1,3})\\)".r

  def result(line: String): Int =
    regex.findAllIn(line).map { case s"mul(${a},${b})" => a.toInt * b.toInt }.sum
}