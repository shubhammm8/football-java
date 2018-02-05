package in.mindtree.DAO;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	int var=-1;
	while(var!=8){
		System.out.println("1 - Insert Player \n2 - Display\n3 - Display Teams\n4 - delete Player");

	Scanner s=new Scanner(System.in);
	var=s.nextInt();
	switch(var){
	case 2:{
		new DaoImpl().display();
		break;
	}
	case 1:{
		new DaoImpl().Insert();
		break;
	}
	case 3:{
		new DaoImpl().showteams();
		break;
	}
	case 4:{
		new DaoImpl().deletePlayer();
		break;
	}
	case 5:{
		
	}
	}}
	}

}
