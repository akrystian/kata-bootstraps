package pro.adamski.tdd.money;

public class Franc extends Money {

    public Franc(int amount, String currency) {
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
        return "Franc{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
