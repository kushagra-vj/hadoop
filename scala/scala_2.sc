object scala_2 {
  val name: String = "Kushagra"                   //> name  : String = Kushagra
  println(s"Hi $name")                            //> Hi Kushagra
  val a = 1<2                                     //> a  : Boolean = true
  
  val x: String="Abc"                             //> x  : String = Abc
  val y: String="Abc"                             //> y  : String = Abc
  
  val z= x==y                                     //> z  : Boolean = true
  
  if(1>3){
  	println("Hi")
  }
  else{
  	println("There")
  	}                                         //> There
  	
  	val num = 3                               //> num  : Int = 3
  	num match{
  		case 1 => println("one")
  		case 2 => println("two")
  		case _ => println("None")
  	}                                         //> None
  	
  for(x <- 1 to 2){
  	val square= x*x
  	println(square)
  }                                               //> 1
                                                  //| 4
    var i = 0                                     //> i  : Int = 0
    while(i<3){
    	println(i)
    	i = i+1
    }                                             //> 0
                                                  //| 1
                                                  //| 2
    var j = 0                                     //> j  : Int = 0
    do{
    	println(j)
    	j = j + 1
    }while(j < 2)                                 //> 0
                                                  //| 1
                                                  
    
    {
			var s = 0
			s + 20
			7
    }                                             //> res0: Int = 7
    var ds = {
			var s = 0
			s + 20
    }                                             //> ds  : Int = 20
    
    println(ds)                                   //> 20
}