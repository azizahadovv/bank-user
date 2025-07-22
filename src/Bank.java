import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private Payment payment;
    private Comments comments = new Comments();

    private final Scanner scannerStr = new Scanner(System.in);
    private final Scanner scannerInt = new Scanner(System.in);


    private String name;
    private int cash;
    private int card;
    private int bank;
    private int balanceId = 1;

    private final ArrayList<Balance> balances = new ArrayList<>();
    private final ArrayList<Users> users = new ArrayList<>();


    public void bankAccountTotal() {
        System.out.println(Payment.CASH + ":" + cash);
        System.out.println(Payment.CARD + ":" + card);
        System.out.println(Payment.BANK + ":" + bank);

        for (int i = 0; i < balances.size(); i++) {
            if (balances.get(i).getType().equals("CASH")) cash += balances.get(i).getAmount();
            if (balances.get(i).getType().equals("CARD")) card += balances.get(i).getAmount();
            if (balances.get(i).getType().equals("BANK")) bank += balances.get(i).getAmount();
        }

    }

    public void addUserInBank() {
        Users user = new Users();

        boolean isExit = false;
        while (!isExit) {

            allUsers();
            comments.addUserInfo();

            switch (scannerInt.nextInt()) {
                case 1:
                    user.setId(balanceId++);
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

        for (int i = 0; i < users.size(); i++) System.out.println(users.get(i).getId() + "." + users.get(i).getName());

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
