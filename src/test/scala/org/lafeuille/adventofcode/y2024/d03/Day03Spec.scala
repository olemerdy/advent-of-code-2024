package org.lafeuille.adventofcode.y2024.d03

import org.scalatest.matchers.should
import org.scalatest.wordspec.AnyWordSpec

class Day03Spec extends AnyWordSpec with should.Matchers {

  "My input in Part1" should {
    val result = 173731097
    s"have result $result" in {
      Day03Part1.result(Day03.myOneLine) shouldBe result
    }
  }

}
