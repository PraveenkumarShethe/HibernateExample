package com.bullraider.crud;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.bullraider.crud.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
	public static void main(String[] args) {
		Main m=new Main();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the choice between 1 to 4 ");
		System.out.println("Enter 1 to save employee");
		System.out.println("Enter 2 to update employee");
		System.out.println("Enter 3 to delete employee");
		System.out.println("Enter 4 to retrieve employee");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			m.saveEmployee();
			break;
		case 2:
			m.updateEmployee();
			break;
		case 3:
			m.deleteEmployee();
			break;
		case 4:
			m.retriveEmployee();
			break;
		default:System.exit(0);
			break;
		}
		
		
		sc.close();
		
	}
	public void saveEmployee()
	{
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
		Scanner sc4 = new Scanner(System.in);
		System.out.println("Enter the details");
		System.out.println("Enter the name varchar");
		String ename = sc.nextLine();
		System.out.println("Entetr the job varchar");
		String job = sc1.nextLine();
		System.out.println("Enter the salary int ");
		int sal = sc2.nextInt();
		System.out.println("Enter the department no int");
		int deptno =sc3.nextInt();
		
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			Employee emp=new Employee();
			emp.setEname(ename);
			emp.setJob(job);
			emp.setSal(sal);
			emp.setDeptno(deptno);
			session.save(emp);
			transaction.commit();
			System.out.println("Records inserted sucessessfully");
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

	public void retriveEmployee() 

	{ 

		Session session = HibernateUtil.getSessionFactory().openSession(); 
		Transaction transaction = null; 
		try { 
			transaction = session.beginTransaction(); 
						List employee = session.createQuery("from Employee").list(); 
			
			for (Iterator iterator = employee.iterator(); iterator.hasNext();) 
			{ 
				Employee employee1 = (Employee) iterator.next(); 
				System.out.println(employee1.getEmpno()+"  "+employee1.getEname()+"  "+ employee1.getJob()+"   "+employee1.getSal()+"   "+employee1.getDeptno()); 
			}           
			transaction.commit(); 

		} catch (HibernateException e) { 

			transaction.rollback(); 

			e.printStackTrace(); 

		} finally { 

			session.close(); 

		} 
	}
	public  void  deleteEmployee() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the employee ID to delete");
		int empno = sc.nextInt();

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try { 
			transaction = session.beginTransaction();
			String queryString = "from Employee where empno = :empno";
			Query query = session.createQuery(queryString);
			query.setInteger("empno", empno);
			Employee employee=(Employee) query.uniqueResult();
			session.delete(employee);
			System.out.println("One employee is deleted!");
			
		} catch (HibernateException e) { 

			transaction .rollback(); 

			e.printStackTrace(); 

		} finally { 

			session.close(); 

		} 
	}
	public  void  updateEmployee() 
	{
		Scanner sc1 = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the employee ID you want to upodate");
		int salOld = sc.nextInt();
		System.out.println("Enter the employee salary updated value ");
		int updatedSal = sc1.nextInt();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try { 
			transaction = session.beginTransaction();
			String queryString = "from Employee where sal = :sal";
			Query query = session.createQuery(queryString);
			query.setInteger("sal", salOld);
			Employee employee=(Employee) query.uniqueResult();
			employee.setSal(updatedSal);
			session.update(employee);
			System.out.println("One employee is updated!");
		} catch (HibernateException e) { 

			transaction .rollback(); 

			e.printStackTrace(); 

		} finally { 

			session.close(); 

		} 
	}
} 

