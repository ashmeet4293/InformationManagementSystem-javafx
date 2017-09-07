package pckgmain;

import pckgdatabase.DatabaseConnector;
import pckgdatabase.StudentDBUtils;
import pckgmodel.Student;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        StudentDBUtils studentDBUtils=new StudentDBUtils();

        Student student=new Student();
        Scanner scanner=new Scanner(System.in);
            System.out.println("Enter Your Choice ");
            System.out.println("1 : Insert \n2: Update \n3:fetch\n4:fetch By Id\n5: Delete ");
            int choice;
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    student.setName("RAm");
                    student.setAddress("Pokhara");
                    student.setRoll(24);
                    student.setSem(4);

                    if (studentDBUtils.createStudent(student)) {
                        System.out.println("Student Created");
                    }
                    break;
                case 2:
                    int id, roll, sem;
                    String name, address;

                    System.out.println("Enter ID to Update : ");
                    id = scanner.nextInt();

                    System.out.println("Enter Name : ");
                    name = scanner.next();
                    System.out.println("Enter Address : ");
                    address = scanner.next();
                    System.out.println("Enter Roll : ");
                    roll = scanner.nextInt();
                    System.out.println("Enter Semester : ");
                    sem = scanner.nextInt();

                    student.setId(id);
                    student.setName(name);
                    student.setAddress(address);
                    student.setRoll(roll);
                    student.setSem(sem);

                    if (studentDBUtils.updateData(student)) {
                        System.out.println("Student Data Updated Successfully");
                    }
                    break;
                case 3:
                    studentDBUtils.fetchData();
                    break;
                case 4:
                    System.out.println("Enter ID : ");
                    id = scanner.nextInt();
                    studentDBUtils.fetchById(id);
                    break;
                case 5:
                    System.out.println("Enter ID : ");
                    id = scanner.nextInt();
                    if(studentDBUtils.deleteById(id)){
                        System.out.println("Student Deleted Successfully ");
                    }
                default:
                    break;
            }



    }
}
