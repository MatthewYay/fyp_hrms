package com.developer.model;
import java.util.Date;

public class LeaveRequest {
	private int application_id;
	private int staff_id;
	private int leavetypeid;
	private String leavetype;
	private Date leavestart;
	private Date leaveend;
	private String staff_name;
	
	public int getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public int getapplication_id() {
		return application_id;
	}
	
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public String getstaff_name() {
		return staff_name;
	}

	public void setApplication_id(int application_id) {
		this.application_id = application_id;
	}

	public int getLeavetypeid() {
		return leavetypeid;
	}

	public void setLeavetypeid(int leavetypeid) {
		this.leavetypeid = leavetypeid;
		switch(leavetypeid) {
		case 1:
			this.leavetype="Sick Leave";
			break;
		case 2:
			this.leavetype="Casual leave";
			break;
			default:
			this.leavetype="Annual Leave";
			
		}
	}

	public String getLeavetype() {
		return leavetype;
	}

	

	public Date getLeavestart() {
		return leavestart;
	}

	public void setLeavestart(Date leavestart) {
		this.leavestart = leavestart;
	}

	public Date getLeaveend() {
		return leaveend;
	}

	public void setLeaveend(Date leaveend) {
		this.leaveend = leaveend;
	}

	public int getLeavestatus() {
		return leavestatus;
	}
	public String getLeavestatusmsg() {
		return leavestatusmsg;
	}

	public void setLeavestatus(int leavestatus) {
		this.leavestatus=leavestatus;
			switch(leavestatus) {
		case 0:
			this.leavestatusmsg="Pending";
			break;
		case 1:
			this.leavestatusmsg="Approved";
			break;
			default:
			this.leavestatusmsg="Rejected";
			}
	}

	private int leavestatus;	
	private String leavestatusmsg;	
		
	public LeaveRequest() {
	}
	
}
