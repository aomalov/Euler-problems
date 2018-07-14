package demo

package object eulerproject {

  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)


}
