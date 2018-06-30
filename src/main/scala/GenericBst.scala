trait GenericBST[+A] {
  def add[B >: A](x: B)(implicit ord: Ordering[B]): GenericBST[B] = {
    import ord.mkOrderingOps
    this match {
      case Empty =>
        Branch(x, Empty, Empty)
      case Branch(e, l, r) =>
        if (e > x) Branch(e, l.add(x), r)
        else if (e < x) Branch(e, l, r.add(x))
        else this
    }
  }

  def printTree:String = {
    this match {
      case Empty =>
        ""
      case Branch(e,l,r) =>
        s"$e->(${l.printTree},${r.printTree})"
    }
  }
}

case class Branch[+A](x: A, left: GenericBST[A], right: GenericBST[A]) extends GenericBST[A]
case object Empty extends GenericBST[Nothing]