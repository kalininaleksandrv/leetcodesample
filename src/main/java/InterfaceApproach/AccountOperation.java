package InterfaceApproach;

/**
 * represents account operation item e.g. payment or income
 */
public interface AccountOperation {

    /**
     * @return total amount of operations in this account
     */
    int getTotalAmount();

}
