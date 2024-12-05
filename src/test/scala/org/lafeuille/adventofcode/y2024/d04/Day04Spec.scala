package org.lafeuille.adventofcode.y2024.d04

import org.scalatest.matchers.should
import org.scalatest.wordspec.AnyWordSpec

class Day04Spec extends AnyWordSpec with should.Matchers {

  "My input in Part1" should {
    val result = 2543
    s"have result $result" in {
      Day04Part1.result(Day04.myGrid) shouldBe result
    }
  }

  "My input in Part2" should {
    val result = 1988
    s"have result $result" in {
      Day04Part2.result(Day04.myGrid) shouldBe result
    }
  }

}
