package model;/*
 * Author @Yucel Can Dogan
 * Project: Let Me Clean
 */

public class Mitarbeiter {
    private String Name;
    private String LastName;
    private String Username;
    private int Level;
    private String Password;
    private int Id;
    private String Work;

    public Mitarbeiter(String name, String lastName, String username, int level, String password, String work) {
        Name = name;
        LastName = lastName;
        Username = username;
        Level = level;
        Password = password;
        Work = work;
    }

    public Mitarbeiter() {
    }

    public Mitarbeiter(String userName){
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getWork() {
        return Work;
    }

    public void setWork(String work) {
        this.Work = work;
    }



}
