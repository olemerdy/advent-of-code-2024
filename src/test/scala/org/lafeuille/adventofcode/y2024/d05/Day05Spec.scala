package org.lafeuille.adventofcode.y2024.d05

import org.scalatest.matchers.should
import org.scalatest.wordspec.AnyWordSpec

class Day05Spec extends AnyWordSpec with should.Matchers {

  "My input in Part1" should {
    val result = 4609
    s"have result $result" in {
      Day05Part1.result(Day05.myPageOrderingRules, Day05.myUpdates) shouldBe result
    }
  }

  "My input in Part2" should {
    val result = 1988
    s"have result $result" in {
      ///Day05Part2.result(Day05.myGrid) shouldBe result
    }
  }
}