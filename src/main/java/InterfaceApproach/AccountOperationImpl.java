package InterfaceApproach;

public class AccountOperationImpl implements AccountOperation {

    private final int amount;

    public AccountOperationImpl(int amount) {
        this.amount = amount;
    }

    @Override
    public int getTotalAmount() {
        return amount;
    }
}
