package pro.adamski.tdd.money;

import java.util.Objects;

public class Franc {
    private int amount;

    public Franc(int amount) {
        this.amount = amount;
    }

    public Franc times(int multiplier) {
        return new Franc(amount * multiplier);
    }

    public boolean equals(Object o) {
        Franc franc = (Franc) o;
        return amount == franc.amount;
    }
}
