package fi.candysoft.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "title", nullable = false)
    @Length(min = 3, message = "*Title should have at least 3 symbols")
    @NotEmpty(message = "*Please provide title")
    private String title;

    @Column(name = "body", columnDefinition = "TEXT")
    private String body;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false, updatable = false)
    @CreationTimestamp
    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date date) {
        this.createDate = date;
    }

}

