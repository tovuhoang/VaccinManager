package com.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "NewsType")
public class NewsType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NewsTypeId")
    private Integer newsTypeId;
    
    @NotNull
    @Column(name = "Description")
    private String description;
    
    @NotNull
    @Column(name = "NewsTypeName")
    private String newsTypeName;  
    
    @ManyToOne
    @JoinColumn(name = "NewsId")
    private News news;
    
	public Integer getNewsTypeId() {
		return newsTypeId;
	}
	public void setNewsTypeId(Integer newsTypeId) {
		this.newsTypeId = newsTypeId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNewsTypeName() {
		return newsTypeName;
	}
	public void setNewsTypeName(String newsTypeName) {
		this.newsTypeName = newsTypeName;
	}
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	protected NewsType(Integer newsTypeId, @NotNull String description, @NotNull String newsTypeName, News news) {
		super();
		this.newsTypeId = newsTypeId;
		this.description = description;
		this.newsTypeName = newsTypeName;
		this.news = news;
	}
	protected NewsType() {
		super();
	}
    
    
}
