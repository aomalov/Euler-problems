package demo.eulerproject

object Task12 extends App {

  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  val brutePrimes=Set(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97)

  def generateTriangularNum(count:Int,start:Int,inc:Int,minSize:Int,checkSeed:Int):Unit = {
    if(count>0) {
      if(inc%checkSeed==0) {
        println(s">>> $inc")
        val primeDivs=for(p<-brutePrimes if start%p==0) yield p
        if(primeDivs.size<9) {
          println(s"Checking for $start")
          val divs=for(p<-1 to start if start%p==0) yield p
          if(divs.size>minSize) {
            print(s"#$inc $start [${divs.size}] {${(divs.toSet intersect brutePrimes).size}} : ")
            divs.foreach(n=>print(s" $n"))
            println()
          }
        }
      }
      generateTriangularNum(count-1,start+inc,inc+1,minSize,checkSeed)
    }
  }


//  val candidates=List(2080,6480,7840,12160,12880,14080,14400)
//  for(i<-candidates.indices)
//    if(i>0) println(gcd(candidates(i-1),candidates(i)))

  generateTriangularNum(14400,1,2,500,8)

}
