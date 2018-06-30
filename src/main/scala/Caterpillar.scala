

object Caterpillar extends App {

  val l = List(1, 2, 3, 7)
  val l2 = List(4, 1, 7, 8, 7)

  //O(n^2) - caterpillar method
  def findSbm(lst: List[Int]): Boolean = {
    val n = lst.size
    for (x <- 0 until n-2) {
      for (y <- x + 1 until n-1) {
        var z = y+1
        while (z < n) {
          if (lst(x) < lst(z) && lst(z) < lst(y)) {
            println(lst(x), lst(y), lst(z))
            return true
          }
          z += 1
        }
      }
    }
    false
  }

  //  println(findSbm(l))
    println(findSbm(l2))

  val root: GenericBST[Int] = Empty
  val tree1 = root.add(5).add(7).add(2).add(4).add(11)

  println(tree1)

}