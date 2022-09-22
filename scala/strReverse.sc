import scala.io.StdIn._

object strReverse {
	
	def main(args: Array[String])
	{
		// val input = readLine()
		val input = "Hi How are you"
		val output1 = input.reverse
		println(output1)
		
		
		val output2 = input.split(" ").map(x => x.reverse)
		println(output2.mkString(" "))
		
		val output3 = input.split(" ").reverse
		println(output3.mkString(" "))
	}                                         //> main: (args: Array[String])Unit
}