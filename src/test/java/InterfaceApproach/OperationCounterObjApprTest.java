package InterfaceApproach;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class OperationCounterObjApprTest {

    @Test
    void getSumV1() {

        OperationCounterObjAppr operationCounterObjAppr = new OperationCounterObjAppr();

        List<AccountOperation> oppList = List.of(
                new AccountOperationImpl(100),
                new AccountOperationImpl(200),
                new AccountOperationImpl(-50)
        );
        int sum = operationCounterObjAppr.getSumV1(oppList);
        assertEquals(250, sum);
    }

    @Test
    void getSumV2() {

        OperationCounterObjAppr operationCounterObjAppr = new OperationCounterObjAppr();

        List<AccountOperation> oppList = List.of(
                new AccountOperationImpl(100),
                new AccountOperationImpl(200),
                new AccountOperationImpl(-50)
        );
        int sum = operationCounterObjAppr.getSumV2(oppList);
        assertEquals(250, sum);
    }


    @Test
    void getSumV3() {

        OperationCounterObjAppr operationCounterObjAppr = new OperationCounterObjAppr();

        List<AccountOperation> oppList = List.of(
                new AccountOperationImpl(100),
                new AccountOperationImpl(200),
                new AccountOperationImpl(-50)
        );
        int sum = operationCounterObjAppr.getSumV3(oppList);
        assertEquals(250, sum);
    }

    @Test
    void getSumV4() {
        OperationCounterObjAppr operationCounterObjAppr = new OperationCounterObjAppr();

        List<AccountOperation> oppList = List.of(
                new AccountOperationImpl(100),
                new AccountOperationImpl(200),
                new AccountOperationImpl(-50)
        );
        int sum = operationCounterObjAppr.getSumV4(oppList);
        assertEquals(250, sum);
    }

    @Test
    void getSumV4FunctionalApproach() {
        OperationCounterObjAppr operationCounterObjAppr = new OperationCounterObjAppr();
        Function<Integer, AccountOperation> creator = AccountOperationImpl::new;
        int sum = operationCounterObjAppr.getSumV4(List.of(creator.apply(100), creator.apply(-50)));
        assertEquals(50, sum);
    }

    @Test
    void getSumV4FunctionalApproachConcise() {
        OperationCounterObjAppr operationCounterObjAppr = new OperationCounterObjAppr();
        //this variant allows us to use any implementation
        Function<Integer, AccountOperation> creator = expAmt -> () -> expAmt;
        int sum = operationCounterObjAppr.getSumV4(List.of(creator.apply(100), creator.apply(-50)));
        assertEquals(50, sum);
    }
}