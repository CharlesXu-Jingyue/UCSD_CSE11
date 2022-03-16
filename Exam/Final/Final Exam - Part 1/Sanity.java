import tester.*;

class Test_Sanity {
  
    void testSimpleInterest(Tester t) {
        Interest i = new Interest();
        double si1 = i.simpleInterest(10000.00, 3.875, 5);
        t.checkExpect(si1, 1937.5);
    }
  
    void testCompoundInterest(Tester t) {
        Interest i = new Interest();
        double ci1 = i.compoundInterest(10000.00, 3.875, 5, 12);
        t.checkExpect(ci1, 2134.14);
  
    }

    void testDeposit(Tester t){
        Customer c = new Customer(1,"Greg","55555555");
        Account a = new Account(100.0,c);

        t.checkExpect(a.deposit(100.0), "Deposit successful");
        t.checkExpect(a.balance, 200.0);
        
    
    }
    
     void testWithdraw(Tester t){
        Customer c = new Customer(1,"Sanmi","99955555");
        Account a = new Account(1000.0,c);

        t.checkExpect(a.withdraw(3000.0), "Insufficient balance");
        t.checkExpect(a.balance, 1000.0);
        
    }
    
}