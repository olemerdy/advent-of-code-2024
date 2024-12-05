package org.lafeuille.adventofcode.y2024.d05

import org.lafeuille.adventofcode.y2024.d01.Day01.getClass

import scala.io.Source

object Day05 {
  private def myInputA: Source =
    Source.fromURL(getClass.getResource("input05a.txt"))

  private def myInputB: Source =
    Source.fromURL(getClass.getResource("input05b.txt"))

  def myPageOrderingRules: List[(Int, Int)] =
    myInputA.getLines().map(_.split("\\|").map(_.toInt)).map(a => (a(0), a(1))).toList

  def myUpdates: List[List[Int]] =
    myInputB.getLines().map(_.split(",").map(_.toInt).toList).toList

  private def uniquePairs[A](list: List[A]) = for {
    (x, idxX) <- list.zipWithIndex
    (y, idxY) <- list.zipWithIndex
    if idxX < idxY
  } yield (x, y)

  def isOrdered(pageOrderingRules: List[(Int, Int)], update: List[Int]): Boolean =
    uniquePairs(update).forall((a, b) => !pageOrderingRules.contains((b, a)))

  def getMiddleNumber(update: List[Int]): Int =
    update(update.size / 2)
}

object Day05Part1 {

  def result(pageOrderingRules: List[(Int, Int)], updates: List[List[Int]]): Int =
    updates
      .filter(Day05.isOrdered(pageOrderingRules, _))
      .map(Day05.getMiddleNumber)
      .sum
}

object Day05Part2 {

  private def reorder(pageOrderingRules: List[(Int, Int)], update: List[Int]): List[Int] = ???

  def result(pageOrderingRules: List[(Int, Int)], updates: List[List[Int]]): Int =
    updates
      .filter(!Day05.isOrdered(pageOrderingRules, _))
      .map(reorder(pageOrderingRules, _))
      .map(Day05.getMiddleNumber)
      .sum
}
