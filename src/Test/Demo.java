package Test;

import Model.Users;
import Service.AmonicServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Demo {
    static AmonicServiceImpl service = new AmonicServiceImpl();
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {


        int n = 0;
        int timeout = 10;
        do{
            System.out.println("Welcome to Amonic AirLines System");
            System.out.println("Please input Log Name:" +"\n"+"Please input Password:");
            String name = s.next();
            String pwd = s.next();
            if(service.Login(name,pwd)){
                showMenu();
                break;
            }else {
                n++;
                System.out.println("LogName format is wrong,Please retry...");
                if(n==3){
                    try {
                        while (timeout>0){
                            Thread.sleep(1000);
                            System.out.println("请等待"+timeout+"秒后重新登录");
                            timeout--;
                            n = 0;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }while (true);
    }

    public static void showMenu(){
        System.out.println("------------------Menu------------------");
        System.out.println("1、Show All"+"\n"+"2、Query"+"\n"+"3、Exit");
        System.out.println("Please enter your choice:");
        int n = s.nextInt();
        if(n==1){
            System.out.println("firstName\tlastName\tactive\trole\temail\tofficeID");
            List<Users> list = service.getAll();
            for (Users u:list) {
                System.out.println(u.getFirstName()+"\t"+u.getLastName()+"\t"+u.getAge()+"\t"+u.getRole()+"\t"+u.getEmail()+"\t"+u.getOffice());
            }
        }else if(n==2){
            System.out.println("Please input Email:");
            String info = s.next();
            List<Users> list = service.getByEmail(info);
            for (Users u:list) {
                System.out.println(u.getFirstName()+"\t"+u.getLastName()+"\t"+u.getAge()+"\t"+u.getRole()+"\t"+u.getEmail()+"\t"+u.getOffice());
            }
        }else if(n==3){
           service.Exit();
            System.out.println("-------------------Exit-------------------");
        }
    }
}
