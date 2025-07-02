package bankApplication;

import java.util.HashSet;
import java.util.Set;

public class DemirBase {

    private long accountNumber;
    private long routingNumber;

    public DemirBase(long accountNumber, long routingNumber){
        if (Long.toString(accountNumber).length() != 12){
            throw new IllegalArgumentException("Account number must be 12 digits");
        }else if (Long.toString(routingNumber).length() != 9) {
            throw new IllegalArgumentException("Routing number must be 9 digits");
        }else {
            this.accountNumber = accountNumber;
            this.routingNumber = routingNumber;
        }
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public long getRoutingNumber() {
        return routingNumber;
    }


}
