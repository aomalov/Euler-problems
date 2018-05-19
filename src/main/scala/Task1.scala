object Task1 extends App {

  val fives = Range(0, 1000, 5).sum
  val threes = Range(0, 1000, 3).sum
  val fifteens = Range(0, 1000, 15).sum

  print(fives+threes-fifteens)

}
