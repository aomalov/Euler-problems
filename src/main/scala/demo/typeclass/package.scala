package demo

package object typeclass {

  trait Show[A] {
    def show(a: A): String
  }

  object Show {
    def apply[A](implicit sh: Show[A]): Show[A] = {
      sh
    }

    implicit class ShowOps[A: Show](a: A) {
      def show = {
        Show[A].show(a)
      }
    }

    //Needed only to run show(30)
    def show[A: Show](a: A) = {
      Show[A].show(a)
    }

    implicit val intCanShow: Show[Int] =
      new Show[Int] {
        def show(int: Int): String = s"int $int"
      }
  }



}
