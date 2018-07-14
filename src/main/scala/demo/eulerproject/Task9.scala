package demo.eulerproject

object Task9 extends App {

  val MAX_VAL = 1000
  for (a <- 1 until MAX_VAL/2) {
    for (b <- a + 1 until MAX_VAL/2) {
      val c = MAX_VAL - (a + b)
      if (a * a + b * b == c * c) {
        println(a * b * c) //31875000
        println(a,b,c)
      }
    }
  }

}
