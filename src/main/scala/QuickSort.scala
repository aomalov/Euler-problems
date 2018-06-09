object QuickSort extends App {

  val list=List(0,10,6,1,7,8,2,4,5,11)
  val list2=List('d','f','r','q','a')

  print(qSort(list))

  def qSort[A](arr:Seq[A])(implicit ord:Ordering[A]):Seq[A] = arr match {
    case Nil =>
      Nil
    case head::Nil =>
      List(head)
    case head::restList =>
      val (left, right) = restList.partition(ord.lt(_,head))
      qSort(left) ++ List(head) ++ qSort(right)
  }
}
