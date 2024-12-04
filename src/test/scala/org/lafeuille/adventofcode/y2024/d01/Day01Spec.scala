package org.lafeuille.adventofcode.y2024.d01

import org.scalatest.matchers.should
import org.scalatest.wordspec.AnyWordSpec

class Day01Spec extends AnyWordSpec with should.Matchers {
  "My input in Part1" should {
    val result = 2264607
    s"have result $result" in {
      Day01Part1.result(Day01.myLists) shouldBe result
    }
  }

  "My input in Part2" should {
    val result = 19457120
    s"have result $result" in {
      Day01Part2.result(Day01.myLists) shouldBe result
    }
  }
}
