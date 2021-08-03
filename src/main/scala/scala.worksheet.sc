def add(x: Int)(using y: Int): Int = x + y

given instance: Int = 10

add(1)
add(1)(using 5)

//trait Show[A] {
// def show(x: A): String
//}
//
//def printListWithUsing[A](list: List[A])(using show: Show[A]): String = list.map(x => show.show(x)).mkString(";")
//def printListWithContextBound[A:Show](list: List[A]): String = list.map(x => summon[Show[A]].show(x)).mkString(";")
//
//given intShow: Show[Int] with {
//  def show(x: Int): String = x.toString 
//}
//
//printListWithUsing(List(1, 2, 3, 4))
//printListWithContextBound(List(1, 2, 3, 4))

trait Show[A] {
 extension (v: A) {
   def show(): String
 }
}

given intShow: Show[Int] with {
  extension (v: Int) {
    def show(): String = v.toString()
  }
}

given listShow[A: Show]: Show[List[A]] with {
  extension (v: List[A]) {
    def show(): String = v.map(_.show()).mkString(";")
  }
}

1.show()
List(1, 2, 3).show()

extension(v: Int) {
  def demo():String = v.toString
}

// equals to def show()(v: Int) = v.toString

1.demo()
demo(1)()
