import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        System.out.println("Welcome to Library Management System");
        System.out.println("How may i help ^^");
        Scanner sc = new Scanner(System.in);

        int i = 0;
        // startingIndex instead of i, naming naming naming
        boolean continueLoop = true;

        /*
        I wouldn't recommend while loop here for 2 reasons:
            1-) risky, could cause a memory leak
            2-) unreadable, recommendation will be mentioned above

        Recommendations instead:
            1-) Instead of while loop, use a helper method.
                That will promote 2 principles of the OOP, encapsulation & abstraction.
                Highly recommend you to learn these 2 principles, especially must for interviews.
         */
        while (continueLoop) { 
            System.out.printf("1-)For Login enter 1\n2-)For Sign Up enter 2\n3-)To exit press 3");

            i = sc.nextInt();
            sc.nextLine();
            // indentations must be enforced to improve code readability
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
        // encapsulation - getUserName
        System.out.printf("Pls enter your password : ");
        String password = sc.nextLine();
        // encapsulation - getUserPassword
        User temp = UserOPS.logInUser(name, password);
        if(temp == null) {
            // isNull() method from Object Class
            System.out.println("Wrong user name or password");
        } else {
            System.out.printf("Welcome %s ^^\n", temp.name);
        }
    }

    private static void singup (Scanner sc){
        // signUp
        String name;
        while (true){
            System.out.printf("Enter your user name : ");
            name = sc.nextLine();
            if(!UserOPS.checkName(name)){
                // I'll get into UserOPS class and its implementations at the meeting
                break;
            }
            System.out.println("This name is not available :(");
        }
        // DRY: Do not repear
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


