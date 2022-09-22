object scala_1 {
  println("hi")                                   //> hi
  
  val a: Int = 10                                 //> a  : Int = 10
  var b: Int = 11                                 //> b  : Int = 11
  b=15
  println(b)                                      //> 15
  val c=true                                      //> c  : Boolean = true
  val d = 'a'                                     //> d  : Char = a
  val e = "aa"                                    //> e  : String = aa
  val pi = 3.14                                   //> pi  : Double = 3.14
  val piSinglePrecision :Float = 3.12345f         //> piSinglePrecision  : Float = 3.12345
  val lll =112343245l                             //> lll  : Long = 112343245
  val smallNumber : Byte = 127                    //> smallNumber  : Byte = 127
  println("Combining all: "+a + b+ c)             //> Combining all: 1015true
  
}