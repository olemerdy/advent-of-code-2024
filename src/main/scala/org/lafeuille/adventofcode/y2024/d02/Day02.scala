package org.lafeuille.adventofcode.y2024.d02

import org.lafeuille.adventofcode.y2024.d01.Day01.{getClass, myLists}

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

  def myReports: List[Report] =
    myList.map(Report(_))
}

case class Report(levels: List[Int])

object Day02Part1 extends App {

  @tailrec
  private def increasingRule(isAscending: Boolean, level: Int, levels: List[Int]): Boolean = levels match {
    case Nil => true
    case head :: tail if isAscending && level < head => increasingRule(isAscending, head, tail)
    case head :: tail if !isAscending && level > head => increasingRule(isAscending, head, tail)
    case _ => false
  }

  def increasingRule(levels: List[Int]): Boolean = levels match {
    case a :: b :: tail => increasingRule(a < b, b, tail)
    case _ => true
  }

  @tailrec
  private def consecutiveRule(level: Int, levels: List[Int]): Boolean = levels match {
    case Nil => true
    case head :: tail => math.abs(level - head) > 0 && math.abs(level - head) < 4 && consecutiveRule(head, tail)
  }

  def consecutiveRule(levels: List[Int]): Boolean = levels match {
    case Nil => true
    case head :: tail => consecutiveRule(head, tail)
  }

  def isSafe(levels: List[Int]): Boolean =
    increasingRule(levels) && consecutiveRule(levels)

  def result(reports: List[List[Int]]): Int =
    reports.count(isSafe)

  println(result(Day02.myList))
}

object Day02Part2 extends App {

}
