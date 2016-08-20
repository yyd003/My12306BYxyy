package com.neuedu.my12306.usermgr.domain;

public class Order {
	private int id;
	private String order_date;
	private String name;
	private User userid;
	public int tickets;
	public double totalmoney;
	public int status;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}

	public int getTickets() {
		return tickets;
	}

	public void setTickets(int tickets) {
		this.tickets = tickets;
	}

	public double getTotalmoney() {
		return totalmoney;
	}

	public void setTotalmoney(double totalmoney) {
		this.totalmoney = totalmoney;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

//	@Override
//	public String toString() {
//		return "Order:	ID = " + id + "	" + "name = " + name + "	" + "order_date = " + order_date + "	" + "fromplace = " + fromplace + "	" + "toplace = " + toplace + "	" + "begin = " + begin;
//	}
}
