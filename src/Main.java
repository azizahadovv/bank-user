import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Comments comments = new Comments();
        Bank bank = new Bank();
        Scanner scannerStr = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);

        System.out.print("Bank nomini kiriting: ");
        bank.setName(scannerStr.nextLine());
        System.out.println("Bank muvaffaqiyatli yaratildi !!!");

        while (true) {
            comments.StartCommand();

            switch (scannerInt.nextInt()) {
                case 1: // Bank Hisobi
                    bank.bankAccountTotal();
                    break;
                case 2: // Pul Kiritish
                    bank.amountToDeposit();
                    break;
                case 3: // Pul Chiqarish
                    bank.withdrawnAmount();
                    break;
                case 4: // Foydalanuvchilar Ro'yxati
                    bank.addUserInBank();
                    break;
                default:
                    System.out.println("Noto'g'ri raqam kiritildi !! ");
            }


        }


    }
}