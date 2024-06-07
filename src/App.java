import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        System.out.println("Welcome to Library Management System");
        System.out.println("How may i help ^^");
        Scanner sc = new Scanner(System.in);

        int i = 0;
        boolean continueLoop = true;
        while (continueLoop) { 
            System.out.printf("1-)For Login enter 1\n2-)For Sign Up enter 2\n3-)To exit press 3");

            i = sc.nextInt();
            sc.nextLine();
            switch (i) {
                case 1:
                login(sc);
                break;

                case 2:
                singup(sc);
                break;

                case 3 : 
                    System.out.println("Have a nice day ^^");
                    continueLoop = false;
                break;

                default:
                System.out.println("Wrong Option :(");
                break;
            }
        }
        sc.close();
    }

    private static void login (Scanner sc){
        System.out.printf("Pls enter your name : ");
        String name = sc.nextLine();
        System.out.printf("Pls enter your password : ");
        String password = sc.nextLine();
        User temp = UserOPS.logInUser(name, password);
        if(temp == null) {
            System.out.println("Wrong user name or password");
        } else {
            System.out.printf("Welcome %s ^^\n", temp.name);
        }
    }

    private static void singup (Scanner sc){
        String name;
        while (true){
            System.out.printf("Enter your user name : ");
            name = sc.nextLine();
            if(!UserOPS.checkName(name)){
                break;
            }
            System.out.println("This name is not available :(");
        }
        System.out.printf("Pls enter your password : ");
        String password = sc.nextLine();
        System.out.printf("Pls enter your e-mail : ");
        String eMail = sc.nextLine();
        int j = UserOPS.signUpUser(name, new User(name, password, eMail));
        if (j==1) {
            System.out.println("you have successfully registered ^^");
        } else {
            System.out.println("something went wrong while you were signing up :(");
        }
    }

}


