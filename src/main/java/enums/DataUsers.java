package enums;

public enum DataUsers {

    PITER_CHAILOVSKII("epam", "1234", "PITER CHAILOVSKII");

    public String login;
    public String password;
    public String userName;

    DataUsers(String login, String password, String userName) {
        this.login = login;
        this.password = password;
        this.userName = userName;
    }
}
