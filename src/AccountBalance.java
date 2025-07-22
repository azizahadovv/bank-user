public class AccountBalance {
    private String type;
    private int amount;


    public AccountBalance(String type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    AccountBalance() {
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
