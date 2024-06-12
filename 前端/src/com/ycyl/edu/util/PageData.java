package com.ycyl.edu.util;

import java.util.Collection;

public class PageData<E> {

	private int total;
	
	private int totalPage;
	
	private Collection<E> rows;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public Collection<E> getRows() {
		return rows;
	}

	public void setRows(Collection<E> rows) {
		this.rows = rows;
	}
}
