package com.autobots.bankApplication; // BankBase

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class BankBase implements Bank { // Это абстрактный класс, реализующий интерфейс Bank

    private String BankName;
    private long accountNumber; // Тип long означает, что эти поля — целые числа большого диапазона
    private long routingNumber; // Потому что long — это число, и в нём не хранятся ведущие нули.
    // long n = 000012345678L; // сохранится как 12345678


//  Используем Set потому что он не хранит дубликатов..  HashSet использует equals() и hashCode() чтобы определить дубликаты.
    public static Set<BankBase> allBankRecords = new HashSet<>(); // То есть в этом Set будет вся база уникальных банковских записей, проверяющих по счёту и маршруту (routing).
    public static Set<BankBase> bankBaseOfOneBank = new HashSet<>(); // То есть в этом Set будет вся база уникальных банковских записей, проверяющих по счёту и маршруту (routing).

    public BankBase(long accountNumber, long routingNumber) {
        if (Long.toString(accountNumber).length() != 12){ // чтобы проверить, сколько символов у числа. То есть:/ преобразуем число в строку (Long.toString)
            throw new IllegalArgumentException("Account number must be 12 digits");
        }else if (Long.toString(routingNumber).length() != 9) {
            throw new IllegalArgumentException("Routing number must be 9 digits");
        }else {
            this.accountNumber = accountNumber;
            this.routingNumber = routingNumber;
        }
    }

    // Этот метод:
    //принимает новый банк
    //проходит по уже сохранённым банкам в базе
    //если уже есть такой accountNumber или routingNumber, выбрасывает ошибку
    //Если всё в порядке — добавляет банк в Set.

    public static void addToAllBankRecords(BankBase bank) throws Exception {
        for (BankBase bankBase : allBankRecords) {
            if(bankBase.getAccountNumber() == bank.getAccountNumber()) {
                throw new Exception(bank.getAccountNumber() + " :Account number already exist");
            }
            if (bankBase.getRoutingNumber() == bank.getRoutingNumber()) {
                throw new Exception(bank.getRoutingNumber() + " :Routing number already exist");
            }
        }
        allBankRecords.add(bank); //Если всё в порядке — добавляет банк в Set. .add метод Set
    }


    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(long routingNumber) {
        this.routingNumber = routingNumber;
    }


    // Методы equals() и hashCode()
    // Сравнивает два банка по accountNumber и routingNumber.
    //То есть два банка считаются одинаковыми, если у них:
    //одинаковый счёт и
    //одинаковый routing number
    //Генерирует уникальный код для хранилища в HashSet. Это важно для того, чтобы Set знал, как сравнивать и не добавлять дубликаты.

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BankBase bankBase = (BankBase) o;
        return accountNumber == bankBase.accountNumber && routingNumber == bankBase.routingNumber;
    }

    @Override
    public int hashCode() { // У объектов hashCode всегда разный поэтому мне не можем сравнивать.. Сравниваем через equals
        return Objects.hash(accountNumber, routingNumber);
    }

    @Override
    public String toString() {
        return "BankBase{" +
                "accountNumber=" + accountNumber +
                ", routingNumber=" + routingNumber +
                '}';
    }
}
