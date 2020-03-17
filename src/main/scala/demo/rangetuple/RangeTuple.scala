package demo.rangetuple

import RangeTuple._

object Tester extends App {
  implicit val intRangeTuple: RangeTuple[Int] =
    new RangeTuple[Int] {
      override def calcDistance(tupleData:Tuple2[Int,Int]): Int = tupleData._1-tupleData._2
    }

  implicit val stringRangeTuple: RangeTuple[String] =
    new RangeTuple[String] {
      override def calcDistance(tupleData:Tuple2[String,String]): Int = {
          tupleData._1.length-tupleData._2.length
        }
    }

  println(s"${(90,80).calcDistance}")
  println(s"${("one","three").calcDistance}")
}
