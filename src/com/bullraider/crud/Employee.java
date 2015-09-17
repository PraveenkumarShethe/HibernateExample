package com.bullraider.crud;
import java.io.Serializable;
public class Employee implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long empno;
	private String ename;
	private int sal;
	private String job;
	private int deptno ;
	
	public long getEmpno() {
		return empno;
	}
	
	public void setEmpno(long empno) {
		this.empno = empno;
	}
	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	

}
