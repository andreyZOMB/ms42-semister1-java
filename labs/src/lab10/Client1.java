package lab10;

public class Client1 {
    public static String ipAddr = "localhost";
    public static int port = 8080;

    /**
     * ???????? ??????-?????????? ? ?????????? ??????? ? ??????? ?????
     *
     * @param args
     */

    public static void main(String[] args) {
        new ClientSomthing(ipAddr, port);

    }
}
