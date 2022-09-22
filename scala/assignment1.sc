object assignment1 {
	// var numOfCust = scala.io.StdIn.readInt()
	var numOfCust = 7                         //> numOfCust  : Int = 7
	var billAmt = Array(10,20,16,25,30,40,36) //> billAmt  : Array[Int] = Array(10, 20, 16, 25, 30, 40, 36)
	var cnt = 0                               //> cnt  : Int = 0
		for(i <- 1 to numOfCust)
		{
			var res = (i * i)
			if (billAmt contains res)
			{
				cnt = cnt + 1
			}
			
		}
		println(cnt)                      //> 3
		
		
		def getApplicableCust(numOfCust: Int, billAmt: Array[Int]):Int ={
			var cnt = 0
			for(i <- 1 to numOfCust)
			{
				if (billAmt contains (i*i))
				{
					cnt = cnt+1
				}
			}
			return cnt
		}                                 //> getApplicableCust: (numOfCust: Int, billAmt: Array[Int])Int
		var res = getApplicableCust(numOfCust,billAmt)
                                                  //> res  : Int = 3
		println(res)                      //> 3
	
}