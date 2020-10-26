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
 * for ["ab","cd","ef"] there's no gemstone */
class GemstoneFinder(treasure: List[String]) {
  def find(): Option[List[Char]] = {
    // Gets how many times each unique mineral appears in a rock of the treasure
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
