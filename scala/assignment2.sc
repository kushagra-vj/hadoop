object assignment2 {
	var N = 5; var k = 40                     //> N  : Int = 5
                                                  //| k  : Int = 40
	var numList = List(10,20,30,40,50)        //> numList  : List[Int] = List(10, 20, 30, 40, 50)
	var cnt = 0                               //> cnt  : Int = 0
	for(i <- numList)
	{
		if(i<k)
		{
			cnt = cnt + 1
		}
	}
	println(cnt)                              //> 3
}