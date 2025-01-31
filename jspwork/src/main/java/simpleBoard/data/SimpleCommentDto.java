package simpleBoard.data;

import java.sql.Timestamp;

public class SimpleCommentDto {
    private int commentIdx;
    private int boardId;
    private String writer;
    private String content;
    private Timestamp writeDate;
    
    public Timestamp getWriteDate() {
        return writeDate;
    }
    
    public void setWriteDate(Timestamp writeDate) {
        this.writeDate = writeDate;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public String getWriter() {
        return writer;
    }
    
    public void setWriter(String writer) {
        this.writer = writer;
    }
    
    public int getBoardId() {
        return boardId;
    }
    
    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }
    
    public int getCommentIdx() {
        return commentIdx;
    }
    
    public void setCommentIdx(int commentIdx) {
        this.commentIdx = commentIdx;
    }
}
