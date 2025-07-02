package bankApplication; //BankDemo

public class BankDemo {
    public static void main(String[] args) throws Exception {

        Mbank aliaMbank = new Mbank(123456789123L,123456789);
        System.out.println(aliaMbank.getBalance());
        aliaMbank.deposit(100000);
        System.out.println("-------");
        System.out.println(aliaMbank.getBalance());

        Optima ulugbekOptima = new Optima(987654321987L, 987654321);
        System.out.println(ulugbekOptima.getBalance());

        Bank.transferFunds(aliaMbank, ulugbekOptima, 500);
        System.out.println(aliaMbank.getBalance());
        System.out.println(ulugbekOptima.getBalance());

        Demir zinaidaDemir = new Demir(543216789543L, 999999999);

        Bank.transferFunds(zinaidaDemir, ulugbekOptima, 1000);

        System.out.println(zinaidaDemir.getBalance());

        zinaidaDemir.withDraw(500000);

        BankBase.allBankRecords.stream().filter(n -> n.getBalance() > 100).forEach(System.out::println);

        double allSumOfBanks = BankBase.allBankRecords.stream().mapToDouble(Bank :: getBalance).sum();
        System.out.println(allSumOfBanks);

    }
}
