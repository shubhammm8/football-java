package in.mindtree.DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;

import in.mindtree.Nation;
import in.mindtree.Player;
import in.mindtree.Team;
import in.mindtree.hibernateUtil;

public class DaoImpl implements DAOClass{
	

	@Override
	public void Insert() {
		Scanner scanner=new Scanner(System.in);

		System.out.println("hi Welcome to Football Portal");
		System.out.println("Please Enter the nation ");
		String nationname=scanner.next();

		System.out.println("Please Enter the team ");
		String teamname=scanner.next();

		System.out.println("Please enter the player name");
		
		String playername=scanner.next();
		
		System.out.println("Please enter the studs");
		String studs=scanner.next();
		
		System.out.println("Please enter the playing position");
		String pos=scanner.next();
		Session s=hibernateUtil.buildSessionFactory().openSession();
		s.beginTransaction();
		
		Query q1=s.createQuery("from Nation where Name=:name");
		q1.setParameter("name", nationname);
		Nation nat1;
		if(q1.list().isEmpty()){
			nat1=new Nation();
			nat1.setName(nationname);
		
			
		}else{
			nat1=(Nation) q1.list().get(0);
	
		}
		Query q2=s.createQuery("from Team where teamName=:name");
		q2.setParameter("name",teamname);
		
		Team tea;
		if(q2.list().isEmpty()){
			tea=new Team();
			tea.setTeamName(teamname);
			
		}else{
			tea=(Team) q2.list().get(0);
			
		}
		
		tea.setNation(nat1);
		
		Player p=new Player();
		p.setFootballStuds(studs);
		p.setPlayerName(playername);
		p.setPosition(pos);
		
		p.setTeam(tea);
		
		s.save(p);
		s.getTransaction().commit();
		s.close();
		
	}

	
	public void display() {
			Session s=hibernateUtil.buildSessionFactory().openSession();
			s.beginTransaction();
			Query q=s.createQuery("from Nation");
			List list=q.list();
			Iterator i=list.iterator();
			while(i.hasNext()){
				Nation n=(Nation)i.next();
				System.out.println(" team id -"+n.getNid()+"  team mane - "+n.getName());
				
				
			}
			
			s.getTransaction().commit();
			s.close();
			
	}


	@Override
	public void showteams() {
		Session s=hibernateUtil.buildSessionFactory().openSession();
		s.beginTransaction();
		Query q=s.createQuery("from Team");
		List list=q.list();
		Iterator i=list.iterator();
		
		while(i.hasNext()){
			Team t=(Team) i.next();
			System.out.println(" Team Id - "+t.getTid()+"   Team Name - "+t.getTeamName()+"   team belongs to - "+t.getNation().getName());
		}
	s.getTransaction().commit();
	s.close();
	}
	
	
	public void deletePlayer(){
		try{
		System.out.println("Please enter the player id to be deleted");
		Scanner sc=new Scanner(System.in);
		int val=sc.nextInt();
		sc.close();
	Session s=hibernateUtil.buildSessionFactory().openSession();
	s.beginTransaction();
	
	Query q=s.createQuery("delete from Player where pid=:p");
	q.setParameter("p",val);
	
	q.executeUpdate();
	System.out.println("successfully done  -  ");
		s.getTransaction().commit();
		s.close();
		}catch(Exception e){}
	}
	
	
	
	
}
