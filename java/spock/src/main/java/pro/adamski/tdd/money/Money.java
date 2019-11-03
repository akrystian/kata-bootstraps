package pro.adamski.tdd.money;

public class Money {
    protected int amount;

    public boolean equals(Object oboject){
        Money dollar = (Money) oboject;
        return amount == dollar.amount && getClass().equals(oboject.getClass());
    }
}
