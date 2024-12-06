
public class User {
    private String name;
    private String surName;

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                '}';
    }
}
