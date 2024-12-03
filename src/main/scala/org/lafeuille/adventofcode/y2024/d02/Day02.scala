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
}

enum Direction:
  case Ascending, Descending, Undefined

object Day02Part1 extends App {

  def isSafe(levels: List[Int]): Boolean = {
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
      safe = diffInBounds && directionMatches
    }
    safe
  }

  def result(reports: List[List[Int]]): Int =
    reports.count(isSafe)
}

object Day02Part2 extends App {

  def isSafe(levels: List[Int]): Boolean = {
    var tolerateNextError = true
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
      safe = diffInBounds && directionMatches
    }
    safe
  }

  def result(reports: List[List[Int]]): Int =
    reports.count(isSafe)
}
