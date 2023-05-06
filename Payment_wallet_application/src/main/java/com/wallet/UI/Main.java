package com.wallet.UI;
import java.util.Scanner;

import com.wallet.service.BankAccountService;
import com.wallet.service.CustomerService;
import com.wallet.service.TransactionService;
import com.wallet.service.WalletService;
import com.wallet.serviceImpl.CustomerServiceImpl;
import com.wallet.serviceImpl.TransactionServiceImpl;
import com.wallet.serviceImpl.WalletServiceImpl;

public class Main {
    
    private static Scanner sc = new Scanner(System.in);
    private static CustomerService customerService = new CustomerServiceImpl();
    private static WalletService walletService = new WalletServiceImpl();
//    private static BankAccountService beneficiaryService = new BankAccountService();
//    private static AccountService accountService = new AccountServiceImpl();
    private static TransactionService transactionService = new TransactionServiceImpl();
//    private static BillPaymentService billPaymentService = new BillPaymentServiceImpl();
    
    public static void main(String[] args) {
        
        int choice;
        
        do {
            System.out.println("\n********** Payment Wallet Application **********");
            System.out.println("1. Register new customer");
            System.out.println("2. Login as customer");
            System.out.println("3. Add money to wallet");
            System.out.println("4. View wallet balance");
            System.out.println("5. Add beneficiary");
            System.out.println("6. View beneficiaries");
            System.out.println("7. Add bank account");
            System.out.println("8. Remove bank account");
            System.out.println("9. View bank accounts");
            System.out.println("10. Pay bill");
            System.out.println("11. View transaction history");
            System.out.println("12. Logout");
            System.out.println("Enter your choice:");
            choice = sc.nextInt();
            
            switch(choice) {
                case 1:
                    // Register new customer
                    break;
                case 2:
                    // Login as customer
                    break;
                case 3:
                    // Add money to wallet
                    break;
                case 4:
                    // View wallet balance
                    break;
                case 5:
                    // Add beneficiary
                    break;
                case 6:
                    // View beneficiaries
                    break;
                case 7:
                    // Add bank account
                    break;
                case 8:
                    // Remove bank account
                    break;
                case 9:
                    // View bank accounts
                    break;
                case 10:
                    // Pay bill
                    break;
                case 11:
                    // View transaction history
                    break;
                case 12:
                    System.out.println("Thank you for using Payment Wallet Application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid choice.");
            }
            
        } while(choice != 12);
        
        sc.close();
    }

}
