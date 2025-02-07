// UserBalancesDto.java
package dto;

public class UserBalancesDto {
    private int userId;
    private int initBalance;
    private int currentBalance;
    
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public int getInitBalance() {
        return initBalance;
    }
    
    public void setInitBalance(int initBalance) {
        this.initBalance = initBalance;
    }
    
    public int getCurrentBalance() {
        return currentBalance;
    }
    
    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }
}
