package org.lafeuille.adventofcode.y2024.d04

import scala.io.Source

object Day04 {
  private def myInput: Source =
    Source.fromURL(getClass.getResource("input04.txt"))

  def myGrid: Array[Array[Char]] =
    myInput.getLines().map(_.toArray).toArray
}

object Day04Part1 {
  private def countXMAS(cells: (Char, Char, Char, Char)): Int = cells match {
    case ('X', 'M', 'A', 'S') => 1
    case ('S', 'A', 'M', 'X') => 1
    case _ => 0
  }

  def result(grid: Array[Array[Char]]): Int = {
    val horizontal = (for i <- grid.indices
                          j <- 0 until (grid(i).length - 3)
                          cells = (grid(i)(j), grid(i)(j + 1), grid(i)(j + 2), grid(i)(j + 3))
    yield countXMAS(cells)).sum
    val vertical = (for i <- 0 until (grid.length - 3)
                        j <- grid(i).indices
                        cells = (grid(i)(j), grid(i + 1)(j), grid(i + 2)(j), grid(i + 3)(j))
    yield countXMAS(cells)).sum
    val diagonal = (for i <- 0 until (grid.length - 3)
                        j <- 0 until (grid(i).length - 3)
                        cells = (grid(i)(j), grid(i + 1)(j + 1), grid(i + 2)(j + 2), grid(i + 3)(j + 3))
    yield countXMAS(cells)).sum
    val reverseDiagonal = (for i <- 3 until grid.length
                               j <- 0 until (grid(i).length - 3)
                               cells = (grid(i - 3)(j + 3), grid(i - 2)(j + 2), grid(i - 1)(j + 1), grid(i)(j))
    yield countXMAS(cells)).sum
    horizontal + vertical + diagonal + reverseDiagonal
  }
}

object Day04Part2 extends App {
  def result(grid: Array[Array[Char]]): Int = {
    (for i <- 1 until grid.length - 1
         j <- 1 until grid(i).length - 1
         cells = (grid(i)(j), List(grid(i - 1)(j - 1), grid(i - 1)(j + 1), grid(i + 1)(j - 1), grid(i + 1)(j + 1)).sorted)
    yield cells match {
      case ('A', List('M', 'M', 'S', 'S')) => {
        println(s"Found a match: $cells")
        1
      }
      case _ => {
        println("Here")
        0
      }
    }
      ).sum
  }
}