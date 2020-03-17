package demo

package object rangetuple {
  trait RangeTuple[A] {
    def calcDistance(data:Tuple2[A,A]): Int
  }

  object RangeTuple {
    def apply[A](implicit ev: RangeTuple[A]): RangeTuple[A] = {
      ev
    }

    implicit class RangeTupleOps[A: RangeTuple](tupleData:Tuple2[A,A]) {
      def calcDistance: Int = {
        RangeTuple[A].calcDistance(tupleData)
      }
    }

  }
}
