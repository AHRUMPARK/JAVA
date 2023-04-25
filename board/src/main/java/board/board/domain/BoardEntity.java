package board.board.domain;

import javax.persistence.*;

@Entity
@Table(name="board")
public class BoardEntity {

    @Id
    private String id;

    @Column(length =50, nullable = false)
    private String pw;

    @Column(length =50, nullable = false)
    private String title;

    @Column(length = 100, nullable = false)
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
