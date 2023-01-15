package data;

public class CommonStrings {
    // All String values used for tests
    public static String LOGIN_PAGE_URL = "https://www.saucedemo.com/";
    public static String PRODUCTS_PAGE_URL = LOGIN_PAGE_URL + "inventory.html";
    public static String EXTERNAL_PAGE = "https://saucelabs.com/";
    public static String PASSWORD = "secret_sauce";
    public static String STANDARD_USER = "standard_user";
    public static String LOCKED_USER = "locked_out_user";
    public static String LOGIN_ERROR_MSG_WRONG_CREDS = "Epic sadface: Username and password do not match any user in this service";
    public static String LOGIN_ERROR_MSG_USERNAME = "Epic sadface: Username is required";
    public static String LOGIN_ERROR_MSG_PASSWORD = "Epic sadface: Password is required";
    public static String LOGIN_ERROR_MSG_LOCKED = "Epic sadface: Sorry, this user has been locked out.";
    public static String ADD_ITEM_BUTTON = "Add to cart".toUpperCase();
    public static String REMOVE_ITEM_BUTTON = "Remove".toUpperCase();
    public static String CHECKOUT_ERROR_MSG_FIRSTNAME = "Error: First Name is required";
    public static String CHECKOUT_ERROR_MSG_LASTNAME = "Error: Last Name is required";
    public static String CHECKOUT_ERROR_MSG_POSTALCODE = "Error: Postal Code is required";
    public static String CHECKOUT_COMPLETE_MESSAGE = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
    public static final double TAX = 12.4921875;
}
