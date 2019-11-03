import pro.adamski.tdd.money.Franc
import pro.adamski.tdd.money.Money
import spock.lang.Specification

class TddSpec extends Specification {


  def 'testMultiplication'() {
    when:
    Money five = Money.dollar(5)

    then:
    Money.dollar(10) == five.times(2)
    Money.dollar(15) == five.times(3)
  }

  def 'testFrancMultiplication'() {
    when:
    Money five = Money.franc(5)

    then:
    Money.franc(10) == five.times(2)
  }

  def 'testEquality'() {
    when:
    def equalsDollar = Money.dollar(5).equals(Money.dollar(5))
    def notEqualsDollar = Money.dollar(5).equals(Money.dollar(6))
    def equalsFranc = Money.franc(5).equals(Money.franc(5))
    def notEqualsFranc = Money.franc(5).equals(Money.franc(6))
    def notEqualsFrancDollar = Money.franc(5).equals(Money.dollar(5))


    then:
    equalsDollar
    !notEqualsDollar
    equalsFranc
    !notEqualsFranc
    !notEqualsFrancDollar
  }

  def 'testCurrency'() {
    when:
    def francCurrency = Money.franc(1).currency()
    def dollarCurrency = Money.dollar(1).currency()

    then:
    francCurrency == 'CHF'
    dollarCurrency == 'USD'
  }
}
