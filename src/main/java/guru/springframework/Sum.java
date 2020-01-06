package guru.springframework;

public class Sum implements Expression{
    Money augmend;
    Money addmend;

    public Sum(Money augmend, Money addmend) {
        this.augmend = augmend;
        this.addmend = addmend;
    }

    public Money reduce(String toCurrency){
        int amount=addmend.amount+augmend.amount;
        return new Money(amount,toCurrency);
    }
}
