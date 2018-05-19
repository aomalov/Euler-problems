import scala.io.Source

object Task67 extends App {

  val tree = Source.fromResource("p067_triangle.txt").getLines()
    .map(_.split(" ").map(_.toInt).toList).toList

  print(findOptimalGround(tree,Nil,tree.size-2).head)


  def findOptimalGround(tree:List[List[Int]],ground:List[Int],level:Int):List[Int] = level match {
      //first ground
    case -1 =>
      ground
    //other ground
    case lvl =>
      val grnd = tree(level).indices.map { idx =>
        val prevLevel = if (lvl == tree.size - 2) tree(level + 1) else ground
        val step = if (prevLevel(idx) > prevLevel(idx + 1)) 0 else 1
        prevLevel(idx + step)+tree(level)(idx)
      }.toList
      findOptimalGround(tree,grnd,level-1)
  }


}
