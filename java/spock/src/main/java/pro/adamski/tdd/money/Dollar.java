package pro.adamski.tdd.money;

public class Dollar {
    public int amount;

    Dollar(int amount) {
        this.amount = amount;
    }

    Dollar times(int multiplier) {
        return new Dollar(amount * multiplier);
    }

    public boolean equals(Object oboject){
        Dollar dollar = (Dollar) oboject;
        return amount == dollar.amount;
    }
}
