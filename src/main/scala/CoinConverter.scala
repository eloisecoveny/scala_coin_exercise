import scala.annotation.tailrec

object CoinConverter {

  val coins = Map(
    "£2" -> 200,
    "£1" -> 100,
    "50p" -> 50,
    "20p" -> 20,
    "10p" -> 10,
    "5p" -> 5,
    "2p" -> 2,
    "1p" -> 1
  )

  def convertPenniesToCoins(amount: Int): String = {
    var remaining: Int = amount
    var coinDenominations: String = ""

    // For each coin type (starting £2)
    coins.keys.foreach(coinType => {

      // Calculate its divisibility by `amount` in pennies + number of iterations
      var coinIteration: (Int, Int) = {
        denominationIteration(remaining, 0, coins(coinType))
      }

      // Reset `remaining` value and concat the coin type and no. iterations to `coinDenominations`
      if (coinIteration._2 > 0) {
        remaining = coinIteration._1
        if (coinDenominations != "") coinDenominations.concat(s", ${coinIteration._2} x $coinType")
        else coinDenominations.concat(s"${coinIteration._2} x $coinType")
      } else {
        Nil
      }
    })
    // Return the concatenated string
    coinDenominations
  }

  // If the coinType divisor is greater than the remaining amount, return `remaining` and `accumulator` values
  @tailrec
  def denominationIteration(remaining: Int, accumulator: Int, divisor: Int): (Int, Int) = {
    if (divisor > remaining) (remaining, accumulator)
      // Or else pass in the decreased `remaining` and increased `accumulator` values recursively
    else denominationIteration((remaining - divisor), (accumulator + 1), divisor)
  }
}
