import pro.adamski.tdd.money.Dollar
import pro.adamski.tdd.money.Franc
import spock.lang.Specification

class TddSpec extends Specification {


  def 'testMultiplication'() {
    when:
    Dollar five = new Dollar(5)

    then:
    new Dollar(10) == five.times(2)
    new Dollar(15) == five.times(3)
  }

  def 'testFrancMultiplication'() {
    when:
    Franc five = new Franc(5)

    then:
    new Franc(10) == five.times(2)
  }

  def 'testEquality'() {
    when:
    def equals = new Dollar(5).equals(new Dollar(5))
    def notEquals = new Dollar(5).equals(new Dollar(6))

    then:
    equals
    !notEquals
  }
}
