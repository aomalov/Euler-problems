object  BinSearch extends App {

  val partialSumsList=Array(20,31,40,48,55,61,65,68,70)

  /***
   * TAIL RECURSIVE O(log(n))
   * @param elem  element to be tested
   * @param partialsSums partial sums array
   * @param tmpRes internal recursion param - for
   * @return Get sequence number of the array partialSums member which is bigger then elem
   */
  def getMinSumCoverage(elem:Int,partialsSums:Array[Int],tmpRes:Int=1):Int ={
    if(elem>=partialsSums.last) -1
    else if(elem<partialsSums.head) tmpRes
    else {
      val pivot = partialsSums.length / 2-1
      if (elem > partialsSums(pivot) && elem < partialsSums(pivot + 1))
        tmpRes + pivot + 1
      else if (elem < partialsSums(pivot))
        getMinSumCoverage(elem, partialsSums.partition(_<partialsSums(pivot + 1))._1, tmpRes)
      else
        getMinSumCoverage(elem, partialsSums.partition(_<partialsSums(pivot + 1))._2, pivot + tmpRes+1)
    }
  }

  println(s"mincov 1000 = ${getMinSumCoverage(1000,partialSumsList)}")
  println(s"mincov 0 = ${getMinSumCoverage(0,partialSumsList)}")
  println(s"mincov 17 = ${getMinSumCoverage(17,partialSumsList)}")
  println(s"mincov 20 = ${getMinSumCoverage(20,partialSumsList)}")
  println(s"mincov 21 = ${getMinSumCoverage(21,partialSumsList)}")
  println(s"mincov 30 = ${getMinSumCoverage(30,partialSumsList)}")
  println(s"mincov 35 = ${getMinSumCoverage(35,partialSumsList)}")
  println(s"mincov 64 = ${getMinSumCoverage(64,partialSumsList)}")
  println(s"mincov 69 = ${getMinSumCoverage(69,partialSumsList)}")
  println(s"mincov 70 = ${getMinSumCoverage(70,partialSumsList)}")
}
