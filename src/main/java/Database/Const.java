package Database;

public class Const {
    public static final String USERS_TABLE = "users";
    public static final String TASKS_TABLE = "tasks";
    public static final String ADMINS_TABLE = "admins";

    // USERS Table Column Names
    public static final String USERS_ID = "userid";  //usersid???
    public static final String USERS_LASTNAME = "lastname";
    public static final String USERS_PASSWORD = "password";
    public static final String USERS_EMAIL = "email";
    public static final String USERS_PHONENUMBER = "phonenumber";
    public static final String USERS_USERNAME = "username";
    public static final String USERS_FIRSTNAME = "firstname";

    //Columns Names of Admin Table
    public static final String ADMINS_NAME = "Name";
    public static final String ADMINS_LASTNAME = "LastName";
    public static final String ADMINS_ID= "id";
    public static final String ADMINS_PASSWORD = "Password";
    public static final String ADMINS_USERNAME = "Username";

    // TASKS Table Column Names
    public static final String TASKS_ID = "taskid";
    public static final String TASKS_DATE = "datecreated";
    public static final String TASKS_DESCRIPTION = "description";
}
