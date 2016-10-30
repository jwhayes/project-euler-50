package euler

class Result(val chain: Seq[Int], val sum: Int) {}

object Problem50 {
	
	def isPrime(candidate: Int): Boolean = {
		
		var isFactorOfCandidate = (value: Int) => (candidate % value) == 0

		var factorCount = (2 until candidate).count(isFactorOfCandidate)

		return factorCount == 0
	}

	def getPrimesUntil(upper: Int, lower: Int = 2): Seq[Int] = (lower until upper).filter(isPrime)
	
	def findSumChains(target: Int): Seq[Seq[Int]] = {

		val chainHeads = getPrimesUntil(target)

		val chains = chainHeads.flatMap(head => {
			val tails = getPrimesUntil(target, head)
			tails.map(tail => getPrimesUntil(tail, head))
		})

		val sum = (chain: Seq[Int]) => chain.reduceLeft((res, x) => res + x)	

		chains.filter(chain => (chain.length > 0) && (sum(chain) == target))
	}

	def findLongestSumChain(target: Int): Option[Seq[Int]] = findSumChains(target).sortBy(_.length).lastOption

	def solve(upper: Int): Option[Result] = {
	
		val sum = (chain: Seq[Int]) => chain.reduceLeft((res, x) => res + x)

		getPrimesUntil(upper)
			.map(prime => findLongestSumChain(prime))
			.flatten
			.sortBy(_.length)
			.map(chain => new Result(chain, sum(chain)))
			.lastOption
	}

	def main(args: Array[String]): Unit = {
		
		val result = solve(100).get.chain

		println(result)	
	}
}