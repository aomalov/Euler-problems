import scala.collection.immutable.Queue

object TreeBFS extends App {

  val t = Branch(
    Branch(
      Leaf(12),
      Branch(
        Leaf(3),
        Leaf(4))),
    Leaf(8))

  val q = Queue()

  def bsfTraversal(t:Tree[Int]) = {


  }
}

sealed trait Tree[+A]

case class Leaf[A](value: A) extends Tree[A]

case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]