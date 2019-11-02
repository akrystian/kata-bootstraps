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
}
