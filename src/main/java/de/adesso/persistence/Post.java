package de.adesso.persistence;

import de.adesso.util.MD5Hash;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * This class creates a post object with the given fields.
 */
@Entity
public class Post {

    /* unique ID of the post */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* The content of the post */
    @Column(columnDefinition = "TEXT")
    private String content;

    /* The teaserXml text of the post */
    @Column(columnDefinition = "TEXT")
    private String teaserXml;

    /* The searchXml text of the post */
    @Column(columnDefinition = "TEXT")
    private String searchXml;

    /* hash value of post content */
    @Column(columnDefinition = "VARCHAR2(64)")
    private String hashValue;

    /* List of the images included in this post */
    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
    private List<Image> images;

    // needed by JPA
    private Post() {
    }

    /**
     * constructor
     * Creates also an MD5Hash hashing type.
     */
    public Post(String content) {
        this.content = content;
    }

    /**
     * Generates a hash value from the given string.
     *
     * @param content
     */
    public void generateHashValue(String content) {
        this.hashValue = MD5Hash.generateHashValue(content);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTeaserXml() {
        return teaserXml;
    }

    public void setTeaserXml(String teaserXml) {
        this.teaserXml = teaserXml;
    }

    public String getSearchXml() {
        return searchXml;
    }

    public void setSearchXml(String searchXml) {
        this.searchXml = searchXml;
    }

    public String getHashValue() {
        return hashValue;
    }

    public void setHashValue(String hashValue) {
        this.hashValue = hashValue;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", teaserXml='" + teaserXml + '\'' +
                ", searchXml='" + searchXml + '\'' +
                '}';
    }
}