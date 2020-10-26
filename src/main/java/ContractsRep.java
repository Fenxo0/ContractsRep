import contacts.Contract;

import java.util.Arrays;

/**
 * @author Maxim Suhochev
 */
public class ContractsRep {
    /** dimension array*/
    private int n = 15;
    /** count add*/
    private int count = 0;
    /** array contracts*/
    private Contract[]con = new Contract[n];

    /**
     *Here is added a new contract
     * @param contract
     */
    public void addCon(Contract contract){
        if(checkId(contract.getId())) {
            if (con.length <= count - 1) {
                con = (Contract[]) arrayCopy(con);
                con[count] = contract;
            } else {
                con[count] = contract;
            }
            count++;
        }
        else{
            System.out.println("Sorry, this id already exists");
        }
    }

    /**
     * This method check id
     * @param id - personal id contract
     * @return true or false
     */
    private boolean checkId(int id){
        if(count == 0) return true;
        boolean flag = true;
        for (int i = 0; i < count; i++) {
            if(id == con[i].getId()){
                flag = false;
                return flag;
            }
        }
        return flag;
    }

    /**
     * Here is the search a contract
     * @param id contract
     * @return contract info or error
     */
    public Object getCon(int id){
        for (int i = 0; i < count; i++) {
            if (id == con[i].getId()) {
                return con[i];
            }
        }
        return "This id not found!";
    }

    /**
     * The contract is delete here
     * @param id contact
     */
    public void deleteCom(int id){
        int i;
        for (i = 0; i < con.length; i++) {
            if(id == con[i].getId()){
                break;
            }
        }
        for(int j = i; j < con.length-1; j++){
            con[j] = con[j+1];
        }
        count--;
    }

    /**
     * This method copy old array in new array
     * @param con - array contact
     * @return new array
     */
    private Object[] arrayCopy(Contract[] con){
        return Arrays.copyOf(con, con.length + 10);
    }
}
