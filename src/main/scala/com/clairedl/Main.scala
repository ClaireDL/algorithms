package com.clairedl.scala

import com.clairedl.scala.algorithms._
import scala.collection.mutable.ListBuffer
import com.colofabrix.scala.figlet4s.unsafe._
import com.colofabrix.scala.figlet4s.options._
import scala.util.Random

object Main extends App {
  println(new StringReducer("Challenges").reduce())
  println(new StringReducer("ChaLlenges").reduce())

  val missingInt = new MissingInteger(Array(1, 3, 6, 4, 1, 2)).find()
  println(missingInt)

  val missingInt2 = new MissingInteger(Array(4, 1, 5, 6, 2)).find()
  println(missingInt2)

  val missingInt3 = new MissingInteger(Array(1, 3, 5, 4, 1, 2)).find()
  println(missingInt3)

  val gemstone = new GemstoneFinder(List("abca","abaaa","bcd")).find()
  println(gemstone)

  val gemstone2 = new GemstoneFinder(List("ab","cd","ef")).find()
  println(gemstone2)

  def split(input: List[Int], lowerCutoff: Int, higherCutoff: Int): (List[Int], List[Int], List[Int]) = {
    var lowerList = new ListBuffer[Int]()

    var middleList = new ListBuffer[Int]()

    var higherList = new ListBuffer[Int]()

    input
      .foreach(x => {
        x match {
          case x if x < lowerCutoff => lowerList += x
          case _                    => x match {
            case x if x <= higherCutoff => middleList += x
            case _                      => higherList += x
          }
        }
      }
    )

    (lowerList.toList, middleList.toList, higherList.toList)
  }

  val splitResult = split(List(2, 12, 25, 86, 1, 75, 63, 18, 4, 43, 7), 5, 10)
  println(splitResult)

  val jumps = new FrogJumps
  println(jumps.calculate(2, 0, 15))

  // Figlet4s
  //   .builder("Hello, World!")      // Create the options builder with a text to render
  //   .withMaxWidth(30)              // Max width of the text
  //   .withInternalFont("standard")  // Set the font
  //   // .defaultMaxWidth()             // Go back to the default max  width
  //   .withHorizontalLayout(
  //     HorizontalLayout.FullWidth   // Choose a layout
  //   )
  //   .text("Hello, is that exceeding the max width?")
  //   .render()                      // Render the text to a FIGure
  //   .print()

  // println(Figlet4s.internalFonts)

  // Tape equilibrium
  // Given a non empty array of Int, returns the minimum difference between sum of values before the pivot index
  // and the values from the pivot

  println("Tape equilibrium")
  val array = Array.fill(10)(Random.nextInt())

  val equilibrium = new TapeEquilibrium(array).minDifference
  println(equilibrium)

}
