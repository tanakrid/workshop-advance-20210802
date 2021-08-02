package unittest;

public class Hello {

    public UserDB userDB;

    public String hi(String name) {
        return "Hello, " + name;
    }

    public String workWithDb(int id) {
        return userDB.getNameByID(id);
    }
}

class UserDB {
    public String getNameByID(int id) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("DB Fail");
    }
}
