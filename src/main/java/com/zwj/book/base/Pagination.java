package com.zwj.book.base;

import java.util.ArrayList;
import java.util.List;

// 分页组件
public class Pagination<T> {
	private int pageSize; // 每页大小
	private int totalPage; // 总页数
	private int total; // 总的记录条数
	private int currentPage; // 当前页数
	private int from; // 当前页的起始条目数
	private int to; // 当前页的结束条目数
	private List<T> items; // 显示的条目 size <= pageSize

	public Pagination() {

	}

	public Pagination(int pageSize, int total, int currentPage, List<T> items) {
		this.pageSize = pageSize;
		this.total = total;
		if (pageSize > 0)
			this.totalPage = total % pageSize > 0 ? total / pageSize + 1 : total / pageSize;
		this.currentPage = currentPage < totalPage ? currentPage : totalPage;
		if (this.currentPage < 1 && total > 0) {
			this.currentPage = 1;
		}
		if (this.currentPage < 1 && total == 0) {
			this.currentPage = 0;
		}
		this.from = this.currentPage == 0 ? 0 : pageSize * (currentPage - 1) + 1;
		this.to = this.currentPage == 0 ? 0 : pageSize * (currentPage - 1) + items.size();
		this.items = items;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getTotal() {
		return total;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getFrom() {
		return from;
	}

	public int getTo() {
		return to;
	}

	public List<T> getItems() {
		return items;
	}

	public static <T> Pagination<T> empty(PageRequest request) {
		return new Pagination<>(request.getPz(), 0, request.getP(), new ArrayList<T>());
	}

	@SuppressWarnings("unchecked")
	public static <T, S> Pagination<T> convert(Pagination<S> page) {
		if (!page.getItems().isEmpty())
			throw new IllegalArgumentException();
		return (Pagination<T>) page;
	}

}
