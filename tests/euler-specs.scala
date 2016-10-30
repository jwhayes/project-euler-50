
import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import org.scalatest.Matchers
import euler.Problem50

class EulerSpecs extends FunSpec with BeforeAndAfter with Matchers {

	describe("when testing for a prime number") {

		describe("when the number is prime") {
			it("should return true") {
				Problem50.isPrime(83) shouldBe true
			}
		}

		describe("when the number is not prime") {
			it("should return false") {
				Problem50.isPrime(10) shouldBe false
			}
		}
		
	}

	describe("when finding sum chains of primes") {

		describe("when the target is 41") {
			it("should find the chain: 2, 3, 5, 7, 11, 13") {
				Problem50.findSumChains(41) should contain (List(2, 3, 5, 7, 11, 13))
			}
			it("should find other chains as well") {
				Problem50.findSumChains(41).length should be > 1
			}
		}
	}

	describe("when finding longest sum chain of primes") {

		describe("when the target is 41") {
			it("should find the chain: 2, 3, 5, 7, 11, 13") {
				Problem50.findLongestSumChain(41).get shouldBe List(2, 3, 5, 7, 11, 13)
			}
		}
	}

	describe("when finding the longest sum of consecutive primes") {

		describe("below 100") {
			it("should find the chain: 2, 3, 5, 7, 11, 13") {
				Problem50.solve(100).get.chain shouldBe List(2, 3, 5, 7, 11, 13)
			}
			it("should report that the sum is 41") {
				Problem50.solve(100).get.sum shouldBe 41
			}
		}

		describe("below 1000") {
			it("should find a chain of 21 terms") {
				Problem50.solve(1000).get.chain.length shouldBe 21
			}
			it("should report that the sum is 953") {
				Problem50.solve(1000).get.sum shouldBe 953
			}
		}

	}
}



