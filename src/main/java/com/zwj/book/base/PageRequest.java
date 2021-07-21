package com.zwj.book.base;

public class PageRequest {
	private int p = 1; // 页码
	private int pz = 10; // 每页显示大小
	private String s = "";// 排序的字段
	private String o = "";// 排序的方式：升序，降序

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getPz() {
		return pz;
	}

	public void setPz(int pz) {
		this.pz = pz;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public void setSort(String s) {
		this.s = s;
	}

	public String getO() {
		return o;
	}

	public void setO(String o) {
		if ("DESC".equalsIgnoreCase(o))
			this.o = "DESC";
		else
			this.o = "ASC";
	}

	public void setOrder(String o) {
		this.o = o;
	}
}
