package pro.adamski.tdd.money;

public class Money {
    protected final int amount;
    protected final String currency;

    protected Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Dollar dollar(int amount){
        return new Dollar(amount, "USD");
    }

    public static Franc franc(int amount){
        return new Franc(amount, "CHF");
    }

    public boolean equals(Object obj){
        Money money = (Money) obj;
        return amount == money.amount && currency.equals(money.currency);
    }

    public Money times(int amount){
        return null;
    }

}
