import scala.io.Source

object Task22 extends App {

  val names = Source.fromResource("p022_names.txt").getLines().next()
    .split(',').map(name=>name.substring(1,name.length-1))

  val sortedNames=names.sorted.toList

  val all:Long=sortedNames.zipWithIndex.map {
    case (aName,idx)=>
      aName.map(chr=>(chr.getNumericValue-'A'.getNumericValue+1)*(idx+1)).sum
  }.sum

  println(all)
}
