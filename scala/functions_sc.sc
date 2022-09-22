object functions_sc {

// First class function

	def doubler(i:Int): Int = {
		i * 2
	}                                         //> doubler: (i: Int)Int
	
	var a = doubler(_)                        //> a  : Int => Int = functions_sc$$$Lambda$8/3447021@6b2fad11
	a(3)                                      //> res0: Int = 6

	def tripler(i : Int): Int = {
		i * 3
	}                                         //> tripler: (i: Int)Int
	
	def func(i: Int, f: Int => Int) = {
		f(i)
	}                                         //> func: (i: Int, f: Int => Int)Int
	
	func(3,tripler)                           //> res1: Int = 9

	def f1 = {
		x: Int => x * x
		}                                 //> f1: => Int => Int
f1(4)                                             //> res2: Int = 16


// Higher order function

var b = 1 to 10                                   //> b  : scala.collection.immutable.Range.Inclusive = Range 1 to 10

//def doublerNew(i: Int): Int = { i *2}

//b.map(doublerNew)

//b.map(x => x *2)

//var c = 5
//val s = if(c == 2) 2 else 7

//val z = if(c==5) 1 else 2.0
//val x = if(c==5) 1 else println("Hi")
//val aa = if(c==5) 1 else 'c'
 
//var cc = 1 to 10
//cc.map (_ * 2)
//cc.reduce (_ + _)

// Partially applied function
def genericSum(x: Int, y: Int, f: Int=> Int)={
		f(x) + f(y)
	}                                         //> genericSum: (x: Int, y: Int, f: Int => Int)Int
	
genericSum(2,3,x=>x)                              //> res3: Int = 5

val sumOfSquare = genericSum(_: Int, _: Int, x=> x*x)
                                                  //> sumOfSquare  : (Int, Int) => Int = functions_sc$$$Lambda$13/66233253@4cb2c10
                                                  //| 0
sumOfSquare(5,5)                                  //> res4: Int = 50

// function curring

def genericSumCurring(f: Int => Int)(x: Int, y: Int){
	f(x) + f(y)
}                                                 //> genericSumCurring: (f: Int => Int)(x: Int, y: Int)Unit

genericSumCurring(x=>x*x)( 2,3)

val sumOfSqrs = genericSumCurring(x=> x* x)_      //> sumOfSqrs  : (Int, Int) => Unit = functions_sc$$$Lambda$17/846492085@4157f54
                                                  //| e
 sumOfSqrs(4,3)
}