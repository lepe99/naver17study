package memo.data;

import java.sql.Timestamp;

public class MemoDto {
    private int idx;
    private String nickname;
    private String avatar;
    private String message;
    private Timestamp writeDate;
    
    public int getIdx() {
        return idx;
    }
    
    public void setIdx(int idx) {
        this.idx = idx;
    }
    
    public String getNickname() {
        return nickname;
    }
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    public String getAvatar() {
        return avatar;
    }
    
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public Timestamp getWriteDate() {
        return writeDate;
    }
    
    public void setWriteDate(Timestamp writeDate) {
        this.writeDate = writeDate;
    }
}


