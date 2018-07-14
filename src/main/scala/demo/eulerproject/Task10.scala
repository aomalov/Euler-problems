package demo.eulerproject

object Task10 extends App {

  def foldOrFail[A, B](it: Iterable[A])(zero: B)(fail: A => Boolean)(f: (B, A) => B): Option[B] = {
    val ii = it.iterator
    var b = zero
    while (ii.hasNext) {
      val x = ii.next
      if (fail(x)) return None
      b = f(b, x)
    }
    Some(b)
  }

  def bruteForce(): Unit = {
    var primeNumbers: List[Long] = List(2, 3, 5, 7, 11)
    val primeCandidateInit: Long = 13
    for (i <- primeCandidateInit to 2000000L) {
      val c = Math.ceil(Math.sqrt(i))
      val isNotPrime = foldOrFail(primeNumbers.filter(_ <= c))(false)(i%_==0)((maybePrime, elem) => maybePrime || (i % elem == 0))
        .getOrElse(true)
      if (!isNotPrime) primeNumbers ++= List(i)
      if(i%100000==0) println(i,primeNumbers.size)
    }
    print(primeNumbers.sum)//142913828922
  }

  def markNonPrimesStrategy(): Unit = {
    val MAX_CAPACITY = 2000000
    val initPrime=2
    var primesList = Array.fill(MAX_CAPACITY-initPrime)(true)

    for (elem <- primesList.indices) {
      if(primesList(elem)) {
        val prime=elem+initPrime //actual number - all the powers of it - are NON PRIME

        for(i<-2 * prime until MAX_CAPACITY by prime) {
          primesList.update(i-initPrime,false)
        }
      }
    }

    val s=primesList.zipWithIndex.map {
      case (true,idx)=> idx+initPrime
      case (false,_)=> 0
    }.foldLeft(0L)(_+_)

    print(s)

  }


  override def main(args: Array[String]): Unit = {
    markNonPrimesStrategy()
  }
}
