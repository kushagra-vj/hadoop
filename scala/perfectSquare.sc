import scala.io.StdIn._

object perfectSquare {
	
	def main(args: Array[String])
	{
		val numCustomer: Int = readInt()
		
		val billAmt: String = readLine()
		val billAmount: Array[Int] = billAmt.split(" ").map(x =>x.toInt)
		
		var count = 0
		for(i <- billAmount)
		{
			val sqrt = Math.sqrt(i)
			if(sqrt.ceil - sqrt == 0)
			{
				count = count + 1
			}
		}
		println(count)
	}                                         //> main: (args: Array[String])Unit
}