package org.lafeuille.adventofcode.y2024.d02

import org.scalatest.matchers.should
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.wordspec.AnyWordSpec

class Day02Spec extends AnyWordSpec with should.Matchers with TableDrivenPropertyChecks {

  "My input in Part1" should {
    val result = 516
    s"have result $result" in {
      Day02Part1.result(Day02.myList) shouldBe result
    }
  }

  "Part 2 isSafe method" should {
    val samples = Table(
      ("Sample", "Safe"),
      (List(7, 6, 4, 2, 1), true),
      (List(1, 2, 7, 8, 9), false),
      (List(9, 7, 6, 2, 1), false),
      (List(1, 3, 2, 4, 5), true),
      (List(8, 6, 4, 4, 1), true),
      (List(1, 3, 6, 7, 9), true)
    )

    forAll(samples) { (sample, safe) =>
      s"be $safe when called on $sample" in {
        Day02Part2.isSafe(sample) shouldBe safe
      }
    }
  }

  "My input in Part2" should {
    val result = 548
    s"have result $result" in {
      Day02Part2.result(Day02.myList) shouldBe result
    }
  }

}
