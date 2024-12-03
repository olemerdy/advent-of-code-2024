package org.lafeuille.adventofcode.y2024.d02

import org.lafeuille.adventofcode.y2024.d02.Direction.{Ascending, Descending, Undefined}

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

  def isSafe(levels: List[Int], canHaveOneError: Boolean): Boolean = {
    var tolerateNextError = canHaveOneError
    var safe = true
    var direction = Direction.Undefined
    var i = 0
    while
      i += 1
      safe && i < levels.size
    do {
      val diff = math.abs(levels(i - 1) - levels(i))
      val diffInBounds = diff >= 1 && diff <= 3
      val newDirection = if (levels(i - 1) < levels(i)) Ascending else Descending
      val directionMatches = direction == Undefined || direction == newDirection
      direction = newDirection
      val levelSafe = diffInBounds && directionMatches
      safe = tolerateNextError || levelSafe
      tolerateNextError = !levelSafe
    }
    safe
  }
}

enum Direction:
  case Ascending, Descending, Undefined

object Day02Part1 extends App {

  def isSafe(levels: List[Int]): Boolean =
    Day02.isSafe(levels = levels, canHaveOneError = false)

  def result(reports: List[List[Int]]): Int =
    reports.count(isSafe)

  println(result(Day02.myList))
}

object Day02Part2 extends App {

  def isSafe(levels: List[Int]): Boolean =
    Day02.isSafe(levels = levels, canHaveOneError = true)

  def result(reports: List[List[Int]]): Int =
    reports.count(isSafe)

  println(result(Day02.myList))
}
