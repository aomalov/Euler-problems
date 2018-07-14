package demo.eulerproject

object Task20 extends App {

  def factorial(x: Int): Double = x match {
    case 1 => 1L
    case fact => fact * factorial(fact - 1)
  }


  def sumDigits(x: Double): Int = x match {
    case v if v < 10 => v.toInt
    case bigger => (bigger % 10).toInt + sumDigits((bigger / 10).toLong)
  }

//  println(factorial(13))
  for(i<-1 to 30) println(sumDigits(i), sumDigits(factorial(i)))

}
