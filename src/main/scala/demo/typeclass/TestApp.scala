package demo.typeclass

import Show._

object TestApp extends App {

  implicit val stringCanShow: Show[String] =
    new Show[String]{
      def show(str: String): String = s"string $str"
    }

  println(show(30),show("element"))
  println(30.show,"element".show)

}
