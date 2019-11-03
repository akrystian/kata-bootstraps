import pro.adamski.tdd.money.Dollar
import pro.adamski.tdd.money.Franc
import pro.adamski.tdd.money.Money
import spock.lang.Specification

class TddSpec extends Specification {


  def 'testMultiplication'() {
    when:
    Money five = new Dollar(5)

    then:
    new Dollar(10) == five.times(2)
    new Dollar(15) == five.times(3)
  }

  def 'testFrancMultiplication'() {
    when:
    Money five = new Franc(5)

    then:
    new Franc(10) == five.times(2)
  }

  def 'testEquality'() {
    when:
    def equalsDollar = new Dollar(5).equals(new Dollar(5))
    def notEqualsDollar = new Dollar(5).equals(new Dollar(6))
    def equalsFranc = new Franc(5).equals(new Franc(5))
    def notEqualsFranc = new Franc(5).equals(new Franc(6))


    then:
    equalsDollar
    !notEqualsDollar
    equalsFranc
    !notEqualsFranc
  }
}
