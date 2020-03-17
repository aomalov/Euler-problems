import scala.util.Random

object WeightedGenerator extends App {

  val inputSorted=List(("a",1),("b",2),("c",3))

  val universumCnt=inputSorted.foldLeft(0) {
    case (res,(_,weight)) => res+weight
  }

  val probabilityRanges:List[Tuple2[Int,String]]=inputSorted.foldLeft(List.empty[Tuple2[Int,String]]) {
    case(Nil,(letter,weight)) => List((weight,letter))
    case(res,(letter,weight)) => res++List((weight+res.last._1,letter))
  }

  //This one is optimized - O(n)
  val probabilityRanges2:Array[String]=inputSorted.foldLeft(Array.empty[Tuple2[Int,String]]) {
    case(res,(letter,weight)) if res.isEmpty=> Array((weight,letter))
    case(res,(letter,weight)) =>
      res++(res.last._1+1 to weight+res.last._1).map((_,letter))
  }.map(_._2)

  //Might be further optimized to o(log(n))
  def getRangedLetter(prob:Int):String = {
    val (left,right)=probabilityRanges.partition {
      case((maxRange,_)) => prob>maxRange
    }
    right.head._2
  }

  println(probabilityRanges2.toList)
  for(i<-1 to 10) {
    val random = Random.nextInt(universumCnt)+1
    println(s"$random-${getRangedLetter(random)} [${probabilityRanges2(random-1)}]")
  }
}
