object classes {
 	//class Person(name: String, age: Int)
 	//val p = new Person("ABC", 24)
 	//p.name  //value name is not a member of classes.Person
 	
 	class Person(val name: String, val age: Int)
 	val p = new Person("ABC", 27)             //> p  : classes.Person = classes$Person@3d71d552
 	p.name                                    //> res0: String = ABC
 	p.age                                     //> res1: Int = 27
 	
 	
 	object People{
 		val N_eyes = 2
 		def canFly: Boolean = false
 	}
 	
 	println(People.N_eyes)                    //> 2
 	println(People.canFly)                    //> false
 	
 	val mar = People                          //> mar  : classes.People.type = classes$People$2$@79698539
 	val Jan = People                          //> Jan  : classes.People.type = classes$People$2$@79698539
 	println(mar == Jan)                       //> true
 	
 	class People{
 		val x = 20
 		def salaryDoubler(salary: Int) = salary * 2
 	}
 	
 	val people = new People                   //> people  : classes.People = classes$People$3@73f792cf
 	println(people.salaryDoubler(20000))      //> 40000
 	
 	
 	class Animal{
 		def eat = println("They eat food")
 	}
 	
 	class Cat extends Animal{
 		def meal = println("Milk")
 	}
 	
 	val cat = new Cat                         //> cat  : classes.Cat = classes$Cat$1@2ed94a8b
 	cat.meal                                  //> Milk
 	cat.eat                                   //> They eat food
 	
 	
 	abstract class AnimalN{
 		def sleep = println("Animal sleeps")
 		def eat
 		val creatureType: String
 	}
 	
 	class Dog extends AnimalN{
 		val creatureType = "caine"
 		def eat: Unit = println("I eat lot")
 	}
 	
 	val dog = new Dog                         //> dog  : classes.Dog = classes$Dog$1@38082d64
 	dog.creatureType                          //> res2: String = caine
 	dog.eat                                   //> I eat lot
 	
 	
 	
 	trait Carnivore{
 		def prefferedMeal
 	}
 	
 	trait ColdBlooded
 	
 	class Crocodile extends AnimalN with Carnivore with ColdBlooded{
 		val creatureType: String = "caine"
 		def eat: Unit = println("Love eating")
 		def prefferedMeal = println("Fish")
 	}
 	
 	val croc = new Crocodile                  //> croc  : classes.Crocodile = classes$Crocodile$1@dfd3711
 	croc.eat                                  //> Love eating
 	croc.prefferedMeal                        //> Fish
}