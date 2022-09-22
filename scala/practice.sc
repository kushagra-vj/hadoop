object practice {
  var a = "ABC"; a="Bye"                          //> a  : String = Bye
  //var b = "ABC"; var b=5
  //val c = "ABC"; c="AA"
  
  val student = ("S",90,"B","sa")                 //> student  : (String, Int, String, String) = (S,90,B,sa)
  student._2                                      //> res0: Int = 90
  
  val z = println("HI")                           //> HI
                                                  //| z  : Unit = ()
  println(z)                                      //> ()


val x = 10; val y = if (x==5) println("hello") else(1,"hi")
                                                  //> x  : Int = 10
                                                  //| y  : Any = (1,hi)

val d = List.range(1,10)                          //> d  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
d.map(_*2)                                        //> res1: List[Int] = List(2, 4, 6, 8, 10, 12, 14, 16, 18)
d.map((i:Int) => {i*i;i*2})                       //> res2: List[Int] = List(2, 4, 6, 8, 10, 12, 14, 16, 18)
}