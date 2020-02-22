case class FlightEvent(cap:Int,ts:Int) extends Ordered[FlightEvent] {
  override def compare(that: FlightEvent): Int = ts-that.ts
}

object Airport extends App {
  val tt:List[FlightEvent]=List(FlightEvent(-1,1),FlightEvent(1,10),FlightEvent(1,5),
    FlightEvent(-1,4),FlightEvent(1,8),FlightEvent(-1,7)
  )

  println( tt.sortBy(evt=>evt.ts))

  tt.sorted.foldLeft(2){
    case (res,ev)=>
      if(res+ev.cap==0) println(s"No space for $ev")
      res+ev.cap
  }

}
