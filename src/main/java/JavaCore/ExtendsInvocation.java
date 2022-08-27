package JavaCore;

import java.util.List;

public class ExtendsInvocation {


    public void executeExample(){
        Account a1 = new ManagedAccount(List.of("account1", "account2", "account3"));
        a1.printAccountNames(List.of("account1", "account2", "account3"));

        /*
    every method firstly invoke in subclass then in superclass
    invoked printAccounts() from ManagedAccount
    invoked printAccounts() from Account --> ok, it's because of "super"
    invoked getAccount() from ManagedAccount --> that's surprise
    invoked getAccount() from Account
         */
    }
}

class Account {

    List<String> accounts;

    public Account(List<String> accounts) {
        this.accounts = accounts;
    }

    public String getAccount(String name) {
        System.out.println("invoked getAccount from Account class");
        return accounts
                .stream()
                .filter(i -> i.equalsIgnoreCase(name))
                .findAny()
                .orElse("nothing found");
    }

    public void printAccountNames(List<String> accounts) {
        System.out.println("invoked printAccountNames from Account class");
        accounts.forEach(acc -> System.out.println(getAccount(acc)));
    }
}

class ManagedAccount extends Account{

    public ManagedAccount(List<String> accounts) {
        super(accounts);
    }

    @Override
    public String getAccount(String name) {
        System.out.println("invoked getAccount from ManagedAccount class");
        return super.getAccount(name);
    }

    public void printAccountNames (List<String> accounts) {
        System.out.println("invoked printAccountNames from ManagedAccount class");
        super.printAccountNames(accounts);
    }
}
