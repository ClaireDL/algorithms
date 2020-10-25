package com.clairedl.scala

import com.clairedl.scala.algorithms._

object Main extends App {
  println(new StringReducer("Challenges").reduce())
  println(new StringReducer("ChaLlenges").reduce())

  val missingInt = new MissingInteger(Array(1, 3, 6, 4, 1, 2)).find()
  println(missingInt)

  val missingInt2 = new MissingInteger(Array(4, 1, 5, 6, 2)).find()
  println(missingInt2)

  val missingInt3 = new MissingInteger(Array(1, 3, 5, 4, 1, 2)).find()
  println(missingInt3)
}
