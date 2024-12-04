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

}
