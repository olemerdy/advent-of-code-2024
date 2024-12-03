package org.lafeuille.adventofcode.y2024.d02

import scala.annotation.tailrec
import scala.io.Source

object Day02 {
  private def myInput: Source =
    Source.fromURL(getClass.getResource("input02.txt"))

  def myList: List[List[Int]] =
    myInput.getLines()
      .map(_.split("\\s+")
        .map(_.toInt)
        .toList)
      .toList
}

object Day02Part1 extends App {

  def isSafe(levels: List[Int]): Boolean = {
    var isAscending = true
    for (i <- levels.indices) {

    }
    false
  }

  def result(reports: List[List[Int]]): Int =
    reports.count(isSafe)

  println(Day02.myList.indices)
  println(result(Day02.myList))
}

object Day02Part2 extends App {
}
