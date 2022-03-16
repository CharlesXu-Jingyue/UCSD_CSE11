// Task 2: Customer class
// Your code here
class Customer {

  // Task 2: Fields in Customer class
  // Your code here
  int id;
  String name;
  String phone;

  // Task 2: Constructor for Customer class
  // Your code here
  Customer(int id, String name, String phone) {
    this.id = id;
    this.name = name;
    this.phone = phone;
  }
}

class Account {
  double balance;
  // Task 2: Add Customer field
  // Your code here
  Customer customer;

  // Task 2: Modify the constructor 
  // to account for Customer field
  Account(double balance, Customer customer) {
    this.balance = balance;
    // Your code here
    this.customer = customer;
  }

  // Task 2: deposit method
  // Your code here
  String deposit(double deposit) {
    this.balance += deposit;
    return "Deposit successful";
  }

  // Task 2: withdraw method
  // Your code here
  String withdraw(double withdraw) {
    if(withdraw <= this.balance) {
      this.balance -= withdraw;
      return "Withdrawal successful";
    } else {
      return "Insufficient balance";
    }
  }
}

class Bank {
  // Task 2: At least 1 Customer object
  Customer c1 = new Customer(1, "Charles", "13579");

  // Task 2: At least 1 Account object
  Account a1 = new Account(62.8, c1);

  // Task 2: At least 1 call of deposit method
  String d1 = a1.deposit(48);

  // Task 2: At least 2 calls of withdraw method
  String w1 = a1.withdraw(14.5);
  String w2 = a1.withdraw(187);
}