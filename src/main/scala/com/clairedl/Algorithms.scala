package com.clairedl.scala.algorithms

import scala.collection.mutable.ListBuffer

// These algorithms are taken from: https://github.com/geektimus/scala-challenges

/** Reduces a given string to its shortest length, removing matching adjacent lowercase characters */
class StringReducer(s: String) {

  private var result = new ListBuffer[String]

  private var previous = ""

  def reduce(): String = {
    for (c <- s) {
      val char = c.toString()
      if (c.isLower) {
        if (char != previous)
          {
            previous = char
            result += char
          }
      }
      else (result += char)
    }
    result.mkString
  }
}

/** Finds smallest positive integer that is not in the given array */
class MissingInteger(array: Array[Int]) {
  def find(): Option[Int] = {
    val sorted = array.sorted

    var previous = sorted(0)

    var matches = new ListBuffer[Int]()

    for (number <- sorted) {
      if ((number - previous) > 1) (matches += (previous + 1))
      previous = number
    }

    if (matches.length == 0) None
    else Some(matches.min)
  }
}

/** We have a collection of rocks and we represent its minerals in a string with letters from [a-z] and we need to
 * write a function to find the gemstones in the collection of rocks. A gemstone is a mineral that occurs at least once
 * in each of the rocks.
 * for ["abc","abaaa","bcd"] b is a gemstone since it appears in the three rocks
 * for ["ab","cd","ef"] there's no gemstone
 */
class GemstoneFinder(treasure: List[String]) {
  def find(): Option[List[Char]] = {
    // Finds the gemstones in rocks
    val inventory = treasure
      .map(x => composition(x))
      .flatten
      .groupBy(x => x)
      .map { case (k, v) => (k, v.length)}

    var gems = new ListBuffer[Char]()

    for (mineral <- inventory) {
      if (mineral._2 == treasure.length) gems += mineral._1
    }

    gems.length match {
      case 0 => None
      case _ => Some(gems.toList)
    }
  }

  // Gets the mineral composition of a rock
  private def composition(rock: String): List[Char] = {
    val result = rock
      .groupBy(x => x)
      .map(x => x._1)
    result.toList
  }
}

/** We need to find the minimum number of jumps a small frog can make from a starting position X to a ending position Y
 * given a jump distance D
 */
class FrogJumps {
  def calculate(jumpSize: Int, startPos: Int, endPos: Int): Int = {
    val distance = math.abs(endPos - startPos)
    val remainder = distance % jumpSize
    remainder match {
      case 0 => distance / jumpSize
      case _ => ((distance - remainder) / jumpSize) + 1
    }
  }
}

/** Tape equilibrium
 * Given a non empty array of Int, returns the minimum difference between sum of values before the pivot index
 * and the values from the pivot
 */
class TapeEquilibrium(array: Array[Int]) {
  def minDifference: Int = {
    var result = new ListBuffer[Int]()

    for (pivot <- 0 to array.length) {
      var leftSum = 0
      var rightSum = 0

      for (leftVal <- 0 to pivot - 1) leftSum += array(leftVal)
      for (rightVal <- pivot to array.length - 1) rightSum += array(rightVal)
      result += leftSum - rightSum
    }

    result.toList.min
  }
}
