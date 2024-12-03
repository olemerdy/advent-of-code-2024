package org.lafeuille.adventofcode.y2024.d01

import scala.io.Source

object Day01 {
  private def myInput: Source =
    Source.fromURL(getClass.getResource("input01.txt"))

  private def myPairs: List[(Int, Int)] =
    myInput.getLines()
      .map(_.split("\\s+"))
      .map(array => (array(0).toInt, array(1).toInt))
      .toList

  def myLists(): (List[Int], List[Int]) = {
    (
      myPairs.map((a, _) => a).sorted,
      myPairs.map((_, b) => b).sorted
    )
  }
}

object Day01Part1 extends App {

  def result(lists: (List[Int], List[Int])): Int =
    lists._1.zip(lists._2).map((a, b) => math.abs(a - b)).sum

  println(result(Day01.myLists()))
}

object Day01Part2 extends App {

  def result(lists: (List[Int], List[Int])): Int =
    lists._1.map(a => a * lists._2.count(b => a == b)).sum

  println(result(Day01.myLists()))
}
