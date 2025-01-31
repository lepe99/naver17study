package employee.data;

import java.sql.Timestamp;

public class EmployeeDto {
    private int num;
    private String empName;
    private String empPhoto;
    private String empJoin;
    private int empBirth;
    private String empBlood;
    private Timestamp writeDate;
    
    public int getNum() {
        return num;
    }
    
    public void setNum(int num) {
        this.num = num;
    }
    
    public String getEmpName() {
        return empName;
    }
    
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    
    public String getEmpPhoto() {
        return empPhoto;
    }
    
    public void setEmpPhoto(String empPhoto) {
        this.empPhoto = empPhoto;
    }
    
    public String getEmpJoin() {
        return empJoin;
    }
    
    public void setEmpJoin(String empJoin) {
        this.empJoin = empJoin;
    }
    
    public int getEmpBirth() {
        return empBirth;
    }
    
    public void setEmpBirth(int empBirth) {
        this.empBirth = empBirth;
    }
    
    public String getEmpBlood() {
        return empBlood;
    }
    
    public void setEmpBlood(String empBlood) {
        this.empBlood = empBlood;
    }
    
    public Timestamp getWriteDate() {
        return writeDate;
    }
    
    public void setWriteDate(Timestamp writeDate) {
        this.writeDate = writeDate;
    }
}


