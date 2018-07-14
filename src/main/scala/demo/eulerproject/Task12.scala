package demo.eulerproject

object Task12 extends App {

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

  def generateSimple():Int = {
    var triangNum=0
    for(n<-1 to 15000) {
      triangNum+=n
      val sqrtTriangle=Math.round(Math.sqrt(triangNum)).toInt
      val divisors=for(p<-1 to sqrtTriangle if triangNum%p==0) yield p
      if(divisors.size*2>500)
        return triangNum
    }
    0
  }

  println(generateSimple())

//  generateTriangularNum(14400,1,2,500,8)

}
