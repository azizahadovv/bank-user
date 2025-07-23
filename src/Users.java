import java.util.ArrayList;

public class Users {
    private int id;
    private int age;
    private String name;
    private final ArrayList<Balance> balances = new ArrayList<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public void setBalances(Balance balance) {
        balances.add(balance);
    }

}
