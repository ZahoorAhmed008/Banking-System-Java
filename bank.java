package javaapplication6;
import java.awt.*;
import java.util.Scanner;

public class bank extends Thread{
    Scanner input = new Scanner(System.in);
    public int balance;
    public int id2;
    public String name;
    public String pass = "admin";
    public int loanamount;
    int kk;
    manager manobj = new manager();
    bank(){

        System.out.println("_________________________________________________________________");
        System.out.println("**********Welcome to Bank Management System**********");
        System.out.println("_________________________________________________________________");
        System.out.println();
//        manobj.bankselection();
    }

    @Override
    public void run() {
        manager manobj = new manager();
        manobj.bankselection();
    }

    void showoptions() {
        int a;
        System.out.println("**************************");
        System.out.println("");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Amount");
        System.out.println("3. Deposit Amount");
        System.out.println("4. Account Details");
        System.out.println("5. Go to Manager");
        System.out.println("6. Ask for Loan");
        System.out.println("7. Exit");
        System.out.println("**************************");
        System.out.print("Enter: ");
        a = input.nextInt();
        switch (a) {
            case 1:
                checkbalance();
                break;
            case 2:
                withdraw();
                break;
            case 3:
                deposit();
                break;
            case 4:
                showdetails();
                break;
            case 5:
                manobj.manager();
                break;
            case 6:
                loan();
                break;
            case 7:
                System.out.println("Thankyou for using!");
                break;
            default:
                System.out.println("Wrong choice, Try again!");
                showoptions();
        }
    }
    void checkbalance(){
        int a;
        System.out.println("Your current balance is: " +balance);
        System.out.println("Press 0 To Go Back");
        System.out.println("Press 1 To Exit");
        a = input.nextInt();
        if (a==0){
            showoptions();
        }
        else if (a==1){
            System.out.println("Thankyou for using!");
        }
        else{
            System.out.println("Wrong input, try again!");
            checkbalance();
        }
    }
    void deposit(){
        int a;
        int deposit;
        System.out.println("Enter amount: ");
        deposit = input.nextInt();
        balance = deposit + balance;
        System.out.println("Sucessfully deposited!");
        System.out.println("Press 0 To Go Back");
        System.out.println("Press 1 To Exit");
        a = input.nextInt();
        if (a==0){
            showoptions();
        }
        else if (a==1){
            System.out.println("Thankyou for using!");
        }
        else{
            System.out.println("Wrong input, try again!");
            deposit();
        }
    }
    void withdraw(){
        int a;
        int withdraw;
        System.out.println("Enter amount: ");
        withdraw = input.nextInt();
        if (withdraw > balance){
            System.out.println("You dont have enough balance!");
            System.out.println("Try again!");
            withdraw();
        }
        else if (withdraw <= balance){
            balance = balance - withdraw;
            System.out.println("Sucessfully withdrawn!");
        }
        System.out.println("Press 0 To Go Back");
        System.out.println("Press 1 To Exit");
        a = input.nextInt();
        if (a==0){
            showoptions();
        }
        else if (a==1){
            System.out.println("Thankyou for using!");
        }
        else{
            System.out.println("Wrong input, try again!");
            withdraw();
        }
    }
    void showdetails(){
        int a;
        System.out.println("Your name: " +name);
        System.out.println("Your id: " +id2);
        System.out.println("Press 0 To Go Back");
        System.out.println("Press 1 To Exit");
        a = input.nextInt();
        if (a==0){
            showoptions();
        }
        else if (a==1){
            System.out.println("Thankyou for using!");

        }
        else{
            System.out.println("Wrong input, try again!");
            showdetails();
        }
    }
    void loan(){
        int id;
        System.out.println("Amount: ");
        loanamount = input.nextInt();
        System.out.println("ID: ");
        id = input.nextInt();

        if (id==id2){
            System.out.println("Request submitted");
            kk=1;
        }
        else{
            System.out.println("ID not registered, try again");
            loan();
        }
        showoptions();
    }
    void loan2(){
        if (kk==1){
            int a=0;
            System.out.print(name);
            System.out.println(" Requested for " +loanamount);
            System.out.println("Press 1 to approve");
            System.out.println("Press 2 to delete");
            a = input.nextInt();
            if (a==1){
                System.out.println("Approved");
                balance=balance+loanamount;
                manobj.manager2();
            }
            else if (a==2){
                System.out.println("Deleted");
                kk=0;
                manobj.manager2();
            }
        }
        else{
            System.out.println("No pending requests");
            manobj.manager2();
        }

    }

    public class manager{
        void manager(){
            String pass2;
            input.nextLine();
            System.out.println("Enter password: ");
            pass2 = input.nextLine();
            if(pass2.equals(pass)){
                System.out.println("Logined!");
                manager2();
            }
            else{
                int a;
                System.out.println("Wrong password");
                System.out.println("Press 0 to Exit");
                System.out.println("Press 1 to Try again");
                a = input.nextInt();
                if (a==0){
                    System.out.println("Thankyou for using!");
                }
                else if (a==1){
                    manager();
                }
            }
        }
        void manager2(){
            int a;
            System.out.println("");
            System.out.println("**************************");
            System.out.println("1. Delete Account");
            System.out.println("2. Update Balance");
            System.out.println("3. View Account Details");
            System.out.println("4. Go to User");
            System.out.println("5. Check Loan Requests");
            System.out.println("6. Exit");
            System.out.println("***************************");
            System.out.print("Enter number:");
            a = input.nextInt();
            switch(a){
                case 1:
                    int idd;
                    System.out.println("Enter account id: ");
                    idd = input.nextInt();
                    if (id2 == idd){
                        System.out.println("Account Deleted!");
                        id2=0;
                        name="";
                        manager2();
                    }
                    else{
                        System.out.println("ID not registered");
                        manager2();
                    }
                    break;
                case 2:
                    if (id2==0){
                        System.out.println("Account not registered");
                        manager2();
                    }
                    else{
                        System.out.println("Enter amount:");
                        balance = input.nextInt();
                        System.out.println("Balance updated!");
                        manager2();
                    }
                    break;
                case 3:
                    if (id2==0){
                        System.out.println("Account not registered!");
                        manager2();
                    }
                    else{
                        System.out.println("Account name: " +name);
                        System.out.println("Account id: " +id2);
                        System.out.println("Account balance: " +balance);
                        manager2();
                    }
                    break;
                case 4:
                    user();
                    break;
                case 5:
                    loan2();
                    break;
                case 6:
                    System.out.println("Thankyou for using!");
                    break;
                default:
                    System.out.println("Wrong choice, try again!");
                    manager2();
                    break;
            }
        }
        void bankselection(){
            System.out.println("**************************");
            System.out.println("1. Manager");
            System.out.println();
            System.out.println("2. User");
            System.out.println();
            System.out.println("3. Exit");
            System.out.println("**************************");
            System.out.println("Enter: ");
            int a;
            a = input.nextInt();
            if(a==1){
                manager();
            }
            else if (a==2){
                user();
            }
            else if (a==3){
                System.out.println("Thankyou for using!");
            }
            else{
                System.out.println("Wrong choice, Try again!");
                bankselection();
            }
        }
        void user(){
            if (id2!=0){
                System.out.println("Your id is already registered, Welcome "+name);
                showoptions();
            }
            else{
                int id;
                System.out.println("");
                System.out.println("Enter your ID: ");
                id = input.nextInt();
                input.nextLine();
                id2=id;
                System.out.println("Enter your name: ");
                name = input.nextLine();
                showoptions();
            }
        }

    }

    public static void main(String[] args) {
        bank bankobj = new bank();
        bankobj.start();
    }
}