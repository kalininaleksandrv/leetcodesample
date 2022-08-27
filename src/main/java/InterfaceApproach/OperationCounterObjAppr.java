package InterfaceApproach;

import java.util.List;
import java.util.stream.Collectors;

public class OperationCounterObjAppr {

    public int getSumV1(List<AccountOperation> accountOperations) {
        return accountOperations
                .stream()
                .mapToInt(AccountOperation::getTotalAmount)
                .sum();
    }

    public int getSumV2(List<AccountOperation> accountOperations) {
        return accountOperations
                .stream()
                .reduce(new AccountOperationImpl(0), (curr, next) -> new AccountOperationImpl(curr.getTotalAmount() + next.getTotalAmount()))
                .getTotalAmount();
    }

    public int getSumV3(List<AccountOperation> accountOperations) {
        return accountOperations
                .stream()
                .map(AccountOperation::getTotalAmount)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public int getSumV4(List<AccountOperation> accountOperations) {
        return accountOperations
                .stream()
                .collect(Collectors.summingInt(AccountOperation::getTotalAmount));
    }
}
