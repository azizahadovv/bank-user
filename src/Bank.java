import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private Payment payment;
    private final Comments comments = new Comments();

    private final Scanner scannerStr = new Scanner(System.in);
    private final Scanner scannerInt = new Scanner(System.in);


    private String name;
    private int cash;
    private int card;
    private int bank;

    private int totalBalance;

    private int balanceCashId = 1;
    private int balanceCardId = 1;
    private int balanceBankId = 1;
    private int userId = 1;

    private int userBalanceId = 1;


    private final ArrayList<Balance> balances = new ArrayList<>();
    private final ArrayList<Users> users = new ArrayList<>();


    public void withdrawnAmount() {
        boolean isExit = false;
        while (!isExit) {
            comments.paymentType();
            switch (scannerInt.nextInt()) {
                case 1: // cash
                    withdrawnCash();
                    break;
                case 2: // card
                    break;
                case 3: // bank
                    break;
                case 4: // exit
                    isExit = true;
                    break;
                default:
                    System.out.println("Notog'ri raqam kiritildi !!");
            }
        }
    }

    private void withdrawnCash() {
        allUsers();
        System.out.print("Foydalanuvchilardan birini tanlang: ");
        System.out.println("0 CHIQISH");
        addUserAmountCash(scannerInt.nextInt());
    }

    private void addUserAmountCash(int id) {
        Balance balance = new Balance();
        balance.setId(userBalanceId++);
        System.out.print("Qarz bermoqchi bo'lgan summangizni kiriting: ");
        balance.setAmount(scannerInt.nextInt());
        balance.setType(Payment.CASH.name());
        users.get(id).setBalances(balance);
    }

    public void bankAccountTotal() {
        cash = 0;
        card = 0;
        bank = 0;
        totalBalance = 0;

        for (int i = 0; i < balances.size(); i++) {
            System.out.println(balances.get(i).getAmount());
            if (balances.get(i).getType().equals("CASH")) cash += balances.get(i).getAmount();
            if (balances.get(i).getType().equals("CARD")) card += balances.get(i).getAmount();
            if (balances.get(i).getType().equals("BANK")) bank += balances.get(i).getAmount();
        }

        totalBalance = card + cash + bank;

        System.out.println(Payment.CASH.name() + ": " + cash);
        System.out.println(Payment.CARD.name() + ": " + card);
        System.out.println(Payment.BANK.name() + ": " + bank);
        System.out.println("TOTAL BALANCE: " + totalBalance);

    }

    public void amountToDeposit() {
        boolean isExit = false;
        while (!isExit) {
            comments.paymentType();
            switch (scannerInt.nextInt()) {
                case 1: // CASH
                    cashDeposite();
                    break;
                case 2: // CARD
                    cardDeposite();
                    break;
                case 3: // BAKN
                    bankDeposite();
                    break;
                case 4: // EXIT
                    isExit = true;
                    break;
                default:
                    System.out.println("Iltimos to'g'ri kommanda kiriting !!");

            }

            bankAccountTotal();


        }


    }

    private void bankDeposite() {
        Balance balance = new Balance();
        balance.setId(balanceBankId++);
        System.out.print("Pul Miqdorini kiriting: ");
        balance.setAmount(scannerInt.nextInt());
        balance.setType(Payment.BANK.name());
        balances.add(balance);
    }

    private void cardDeposite() {
        Balance balance = new Balance();
        balance.setId(balanceCardId++);
        System.out.print("Pul Miqdorini kiriting: ");
        balance.setAmount(scannerInt.nextInt());
        balance.setType(Payment.CARD.name());
        balances.add(balance);
    }

    private void cashDeposite() {
        Balance balance = new Balance();
        balance.setId(balanceCashId++);
        System.out.print("Pul Miqdorini kiriting: ");
        balance.setAmount(scannerInt.nextInt());
        balance.setType(Payment.CASH.name());
        balances.add(balance);

    }


    public void addUserInBank() {
        boolean isExit = false;
        while (!isExit) {
            allUsers();
            comments.addUserInfo();
            switch (scannerInt.nextInt()) {
                case 1:
                    Users user = new Users();
                    user.setId(userId++);
                    System.out.print("Isim Familiyangizni kiriting: ");
                    user.setName(scannerStr.nextLine());
                    System.out.print("Yoshingizni kiriting: ");
                    user.setAge(scannerInt.nextInt());
                    users.add(user);
                    break;
                case 2:
                    isExit = true;
                    break;
            }
        }

    }

    public void allUsers() {
        System.out.println("-------------------");
        for (int i = 0; i < users.size(); i++)
            System.out.println(users.get(i).getId() + "." + users.get(i).getName() + "." + users.get(i).getBalances());
        System.out.println("-------------------");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Balance> getBalances() {
        return balances;
    }

}
