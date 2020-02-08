package br.com.babypet.utils.models;

import java.util.List;

import org.springframework.data.domain.Page;

public class PageModel<T, M> {

	private Long totalElements;
	private Integer totalPages;
	private Integer size;
	private Integer number;
	private List<M> content;

	public Long getTotalElements() {
		return totalElements;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public Integer getSize() {
		return size;
	}

	public Integer getNumber() {
		return number;
	}
	
	public List<M> getContent() {
		return content;
	}

	public void setContent(Page<T> page) {
		
		this.totalElements = page.getTotalElements();
		this.totalPages = page.getTotalPages();
		this.size = page.getSize();
		this.number = page.getNumber();
		
	}
	
	public void setContentList(List<M> content) {
		
		this.content = content;
		
	}
	
}
