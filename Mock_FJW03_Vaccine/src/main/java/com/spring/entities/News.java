package com.spring.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "News")
public class News {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NewsId")
    private Integer newsId;
    
    @NotNull
    @Column(name = "Content")
    private String content;
    
    @NotNull
    @Column(name = "Preview")
    private String preview;
    
    @NotNull
    @Column(name = "Title")
    private String title;
    
    @NotNull
    @Column(name = "NewsTypeId")
    private String newsTypeId;
    
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "news")
    List<NewsType> newsTypes = new ArrayList<NewsType>();
	public Integer getNewsId() {
		return newsId;
	}
	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPreview() {
		return preview;
	}
	public void setPreview(String preview) {
		this.preview = preview;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNewsTypeId() {
		return newsTypeId;
	}
	public void setNewsTypeId(String newsTypeId) {
		this.newsTypeId = newsTypeId;
	}
	public List<NewsType> getNewsTypes() {
		return newsTypes;
	}
	public void setNewsTypes(List<NewsType> newsTypes) {
		this.newsTypes = newsTypes;
	}
	protected News(Integer newsId, @NotNull String content, @NotNull String preview, @NotNull String title,
			@NotNull String newsTypeId, List<NewsType> newsTypes) {
		super();
		this.newsId = newsId;
		this.content = content;
		this.preview = preview;
		this.title = title;
		this.newsTypeId = newsTypeId;
		this.newsTypes = newsTypes;
	}
	protected News() {
		super();
	}
    
    
 
}
