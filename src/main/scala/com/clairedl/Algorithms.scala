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
