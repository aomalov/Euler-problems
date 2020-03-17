//package demo
//
//class ListNode[T] {
//  elem: T
//  prev: Option[ListNode[T]]
//}
//
//class MyQueue[T] {
//  var head:Option[ListNode[T]]=None
//  var linkedListTail:Option[ListNode[T]]=None
//
//  def put(elem:T):Unit = {
//    linkedListTail=linkedListTail match {
//      case None  =>
//        val firstElem=ListNode(elem)
//        head=Some(firstElem)
//        Some(firstElem)
//      case Some(tail) =>
//        Some(tail.add(elem))
//    }
//  }
//
//  def get:Option[T] = {
//    head match {
//      case None => None
//      case Some(node) =>
//        head=node.prev
//        Some(node.elem)
//    }
//  }
//
//  def getElems(head:Option[ListNode[T]],accumulatorList:List[T]=Nil):List[T] = {
//    head match {
//      case None => accumulatorList
//      case Some(ListNode(elem,prev)) => accumulatorList++List(elem)++getElems(prev)
//    }
//  }
//
//  override def toString: String = {
//    getElems(head).mkString(",")
//  }
//
//}
//
//
//object MyQueueTest extends App {
//  val myQueue=new MyQueue[Int]()
//
//  myQueue.put(1)
//  myQueue.put(5)
//  myQueue.put(13)
//  println(myQueue)
//  println(myQueue.get)
//  println(myQueue)
//}
