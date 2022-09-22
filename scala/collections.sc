object collections {

	// Array ======================
		val a = Array(1,2,3,4,5)          //> a  : Array[Int] = Array(1, 2, 3, 4, 5)
		println(a)                        //> [I@4157f54e
		println(a.mkString("|"))          //> 1|2|3|4|5
		
		for(i <- a) println(i)            //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
     // mutable
     
     a(2) = 2
     println(a.mkString("|"))                     //> 1|2|2|4|5
		
		
		// List =====================
		
		val b = List(1,2,3,4,5)           //> b  : List[Int] = List(1, 2, 3, 4, 5)
		b.head                            //> res0: Int = 1
		b.tail                            //> res1: List[Int] = List(2, 3, 4, 5)
		b.reverse                         //> res2: List[Int] = List(5, 4, 3, 2, 1)
		b.sum                             //> res3: Int = 15
		10 :: b                           //> res4: List[Int] = List(10, 1, 2, 3, 4, 5)
		
		// Tuple =================
		
		val c = ("ABC", 1000, true)       //> c  : (String, Int, Boolean) = (ABC,1000,true)
		c._1                              //> res5: String = ABC
		
		val d = (108, "ABC")              //> d  : (Int, String) = (108,ABC)
		val e = 108 ->  "ABC"             //> e  : (Int, String) = (108,ABC)
		println(e._2)                     //> ABC
		
		// Range
		
		val rng = 1 to 10                 //> rng  : scala.collection.immutable.Range.Inclusive = Range 1 to 10
		val rng_1 = 1 until  10           //> rng_1  : scala.collection.immutable.Range = Range 1 until 10
		
		for(i <- rng_1) println(i)        //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
                                                  //| 6
                                                  //| 7
                                                  //| 8
                                                  //| 9
     // Set =====================
     
     val f = Set(1,1,1,1,3,4,6,5,3,3,2,2,2,2)     //> f  : scala.collection.immutable.Set[Int] = Set(5, 1, 6, 2, 3, 4)
     f.min                                        //> res6: Int = 1
			f.max                     //> res7: Int = 6
			
			// Map ======================
			
			val g = Map(1 -> "ABC", "xyz" -> 10)
                                                  //> g  : scala.collection.immutable.Map[Any,Any] = Map(1 -> ABC, xyz -> 10)
			g                         //> res8: scala.collection.immutable.Map[Any,Any] = Map(1 -> ABC, xyz -> 10)
			
			g.get(1)                  //> res9: Option[Any] = Some(ABC)
			g.get("xyz")              //> res10: Option[Any] = Some(10)
}