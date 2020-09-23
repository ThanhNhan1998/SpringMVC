package com.laptrinhjavaweb.dto;

public class AbstractDTO {
	private Long id;
	private String createdDate;
	private String modifiedDate;
	private String createdBy;
	private String modifiedBy;
	private Long[] ids;
	
	private Integer page;
	private Integer limit;
	

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}
}
