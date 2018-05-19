import scala.annotation.tailrec

object MergeLists extends App {

  @tailrec
  def doMerge(listHead:List[Int],listA: List[Int], listB: List[Int]): List[Int] = (listA,listB) match {
    case (Nil,Nil) => listHead
    case (first, Nil) => listHead++first
    case (Nil, second) => listHead++second
    case (a_head::a_tail,b_head::_) if a_head<b_head =>
      doMerge(listHead++List(a_head),a_tail,listB)
    case (_,b_head::b_tail) =>
      doMerge(listHead++List(b_head),listA,b_tail)
  }

  val l1=List(1,3,5,6,7,12)
  val l2=List(2,3,4,19)

  print(doMerge(Nil,l1,l2))
}
