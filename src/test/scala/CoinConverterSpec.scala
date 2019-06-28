import org.scalatest.{WordSpec, Matchers}

class CoinConverterSpec extends WordSpec with Matchers {

  "Denomination Iteration" should {
    "return a tuple once the remaining amount is less than the divisor" in {
      val result_200 = CoinConverter.denominationIteration(420, 0, 200)
      result_200 shouldBe(20, 2)

      val result_100 = CoinConverter.denominationIteration(153, 0, 100)
      result_100 shouldBe(53, 1)
    }
  }

  "Coin Converter" should {
    "return the correct amount" in {
      val actual = CoinConverter.convertPenniesToCoins(123)
      actual shouldBe "1 x £1, 1 x 20p, 1 x 2p, 1 x 1p"
    }
  }
}
