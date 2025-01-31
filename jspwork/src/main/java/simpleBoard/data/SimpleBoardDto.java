package simpleBoard.data;

import java.sql.Timestamp;

public class SimpleBoardDto {
    private int boardId;
    private String writer;
    private String subject;
    private String content;
    private String readCount;
    private Timestamp writeDate;
    
    
    public SimpleBoardDto() {
    }
    
    public SimpleBoardDto(String writer, String subject, String content) {
        this.writer = writer;
        this.subject = subject;
        this.content = content;
    }
    
    public int getBoardId() {
        return boardId;
    }
    
    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }
    
    public String getWriter() {
        return writer;
    }
    
    public void setWriter(String writer) {
        this.writer = writer;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public String getReadCount() {
        return readCount;
    }
    
    public void setReadCount(String readCount) {
        this.readCount = readCount;
    }
    
    public Timestamp getWriteDate() {
        return writeDate;
    }
    
    public void setWriteDate(Timestamp writeDate) {
        this.writeDate = writeDate;
    }
}
