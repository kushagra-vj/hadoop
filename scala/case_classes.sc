object case_classes {
  	//1. class parameter is promoted to fields
  	case class Person(name: String, age: Int)
  	
  	
  	val p1 = new Person("ABC", 20)            //> p1  : case_classes.Person = Person(ABC,20)
  	println(p1.name)                          //> ABC

	//2. case classes have sensible toString
	println(p1.toString)                      //> Person(ABC,20)
	println(p1)                               //> Person(ABC,20)
	
	//3. equals and hashcode method implimented internally
	
	val p2 = new Person("ABC", 20)            //> p2  : case_classes.Person = Person(ABC,20)
	println(p1==p2)                           //> true
	
	//4. companion objects already created
	val p3 = Person("ABC", 20)                //> p3  : case_classes.Person = Person(ABC,20)
	println(p3)                               //> Person(ABC,20)

//5. case classes have copy method

val p4 = p2.copy()                                //> p4  : case_classes.Person = Person(ABC,20)
println(p4)                                       //> Person(ABC,20)

val p5 = p2.copy(age=25)                          //> p5  : case_classes.Person = Person(ABC,25)
println(p5)                                       //> Person(ABC,25)

//6. case classes are serilizable







}