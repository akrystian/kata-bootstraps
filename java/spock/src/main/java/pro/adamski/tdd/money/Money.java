package pro.adamski.tdd.money;

public abstract class Money {
    protected int amount;

    public static Dollar dollar(int amount){
        return new Dollar(amount);
    }

    public static Franc franc(int amount){
        return new Franc(amount);
    }

    public boolean equals(Object oboject){
        Money dollar = (Money) oboject;
        return amount == dollar.amount && getClass().equals(oboject.getClass());
    }

    public abstract Money times(int amount);
}
