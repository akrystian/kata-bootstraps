package pro.adamski.tdd.money;

public class Dollar extends Money {

    Dollar(int amount, String currency) {
        super(amount, currency);
    }

    public Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public String currency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Dollar{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
