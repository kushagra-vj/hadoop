object stringreverse {
  var s = "hello how are you"                     //> s  : String = hello how are you
  var rev = ""                                    //> rev  : String = ""
  for(i <- 1 to s.length())
  {
  	rev = rev+s(s.length() - i)
  }
  println(rev)                                    //> uoy era woh olleh
  
  s.split(' ')                                    //> res0: Array[String] = Array(hello, how, are, you)
  var wordRev = ""                                //> wordRev  : String = ""
  for(i <- s.split(' '))
  {
  	for (j <- 1 to i.length())
  	{
  		wordRev = wordRev + i(i.length()-j)
  	}
  	wordRev = wordRev +" "
  }
  println(wordRev)                                //> olleh woh era uoy 
  
  var sentRev = ""                                //> sentRev  : String = ""
  var list = s.split(' ')                         //> list  : Array[String] = Array(hello, how, are, you)
 	for(i <- 1 to list.size)
 	{
 		sentRev = sentRev+list(list.size - i)+" "
 	}
 	println(sentRev)                          //> you are how hello 
  
}