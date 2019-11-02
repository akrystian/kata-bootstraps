import pro.adamski.tdd.money.Dollar
import spock.lang.Specification

class TddSpec extends Specification {


  def 'testMultiplication'() {
    given:
    Dollar five = new Dollar(5)

    when:
    def result = five.times(2)

    then:
    result.amount == 10

    when:
    result = five.times(3)

    then:
    result.amount == 15
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
