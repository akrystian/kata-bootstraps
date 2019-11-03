package pro.adamski.tdd.money;

public abstract class Money {
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

    public boolean equals(Object oboject){
        Money dollar = (Money) oboject;
        return amount == dollar.amount && getClass().equals(oboject.getClass());
    }

    public abstract Money times(int amount);


}
