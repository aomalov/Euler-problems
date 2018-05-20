object QuickSelect extends App {

  val l=List(1,5,6,22,7,4,8,9,2,12)

  def doSelect(list:List[Int],k: Int,start_k:Int): Int = list match {
    case Nil =>
      throw new Exception("error - bad input data")
    case head::Nil =>
      head
    case head::tail =>
      val (left,right)=tail.partition(_<head)
      start_k+left.size+1-k match {
        case 0=>
          head
        case x if x>0 =>
          doSelect(left,k,start_k)
        case other =>
          doSelect(right,k,start_k+left.size+1)
      }
  }

  for(k<-1 to l.size)
    println(doSelect(l,k,0))

}
