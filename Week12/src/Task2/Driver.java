package Task2;
import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args){

        try {
            Scanner scan = new Scanner(System.in);
            Vector<Textbook> textbooks = new Vector<>();
            Vector<Instructor> instructors = new Vector<>();
            Vector<Course> courses = new Vector<>();
            Date date;

            menu : while(true){
                System.out.println("Welcome to the system!");
                System.out.println("\nPress A to log in as ADMIN or press U to log in as USER\nPress Q to quit Ы");

                String input = scan.next();

                switch(input){

                    case "a":
                        adminreg : while(true){
                            System.out.println("Please write down your admin name and password.\nIn order to return back write <back>.");
                            String username = scan.next();

                            switch(username){
                                case "back":
                                    continue menu;
                                default:
                                    BufferedReader br = new BufferedReader(new FileReader("admin.txt"));
                                    BufferedWriter bw = new BufferedWriter(new FileWriter("admin.txt", true));

                                    String password = scan.next();
                                    int hashedPassword = Objects.hash(password);

                                    String adminName = br.readLine();
                                    String adminPass = br.readLine();

                                    br.close();

                                    if(username.equals(adminName) && hashedPassword == Integer.parseInt(adminPass)){
                                        trueadmin : while(true){

                                            System.out.println("[1] Add course\n[2] Add instructor\n[3] Add textbook\n[4] Go back");
                                            int input_adm = scan.nextInt();

                                            String courseTitle = null;
                                            Course temp_course = null;
                                            Instructor temp_instructor = null;
                                            Textbook temp_textbook = null;
                                            date = new Date();
                                            bw.write(date + " admin logged in to a system");
                                            bw.newLine();

                                            switch(input_adm){
                                                case 1:
                                                    System.out.println("Please, fill course's title, instructor and textbook...");
                                                    System.out.print("Course title: ");
                                                    courseTitle = scan.next();

                                                    System.out.println("Now you need to add instructor.\n[1] Choose one from existing." +
                                                            "\n[2] Create a new instructor.\n[3] Back");

                                                    int choice = scan.nextInt();

                                                    switch(choice){
                                                        case 1:
                                                            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("instructors.out"));
                                                            Iterator it;
                                                            int eXchoice, index = 0;
                                                            Vector<Instructor> temp_instructors = (Vector<Instructor>) ois.readObject();

                                                            it = temp_instructors.iterator();

                                                            while(it.hasNext()){
                                                                System.out.println(++index + ") " + it.next());
                                                            }
                                                            ois.close();

                                                            System.out.print("Enter index of existing instructor: ");
                                                            eXchoice = scan.nextInt();

                                                            temp_instructor = new Instructor(temp_instructors.get(eXchoice - 1).getFirstName(),
                                                                    temp_instructors.get(eXchoice - 1).getLastName(),
                                                                    temp_instructors.get(eXchoice - 1).getDepartment(),
                                                                    temp_instructors.get(eXchoice - 1).getEmail());

                                                            date = new Date();
                                                            bw.write(date + " admin added new instructor " +  "'" + temp_instructor + "'");
                                                            bw.newLine();

                                                            temp_instructor.serialize(instructors);
                                                            System.out.println(temp_instructor + " instructor is chosen.");
                                                            break;

                                                        case 2:
                                                            System.out.println("Write down instructor's first name, last name, department and email: ");
                                                            String firstName = scan.next();
                                                            String lastName = scan.next();
                                                            String department = scan.next();
                                                            String email = scan.next();

                                                            temp_instructor = new Instructor(firstName, lastName, department, email);
                                                            instructors.add(temp_instructor);

                                                            date = new Date();
                                                            bw.write(date + " admin added new instructor " + "'" + temp_instructor + "'");
                                                            bw.newLine();

                                                            temp_instructor.serialize(instructors);
                                                            break;

                                                        case 3:
                                                            bw.close();
                                                            continue adminreg;

                                                        default:
                                                            System.out.println("Wrong input. You've returned back to trueadmin.");
                                                            continue trueadmin;
                                                    }

                                                    System.out.println("Now you need to add textbook.\n[1] Choose one from existing." +
                                                            "\n[2] Create a new textbook.");
                                                    choice = scan.nextInt();

                                                    switch(choice){
                                                        case 1:
                                                            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("textbooks.out"));
                                                            Iterator it;
                                                            int eXchoice, index = 0;
                                                            Vector<Textbook> temp_textbooks = (Vector<Textbook>) ois.readObject();

                                                            it = temp_textbooks.iterator();
                                                            while(it.hasNext()){
                                                                System.out.println(++index +  ") " + it.next());
                                                            }
                                                            ois.close();

                                                            System.out.print("Enter index of existing textbook: ");
                                                            eXchoice = scan.nextInt();

                                                            temp_textbook = new Textbook(temp_textbooks.get(eXchoice - 1).getTitle(),
                                                                    temp_textbooks.get(eXchoice - 1).getAuthor(),
                                                                    temp_textbooks.get(eXchoice - 1).getIsbn());

                                                            date = new Date();
                                                            bw.write(String.format(date + " admin added new textbook " + "'" + temp_textbook + "'"));
                                                            bw.newLine();

                                                            temp_textbook.serialize(textbooks);
                                                            System.out.println("'" + temp_textbook + "'" + " textbook is chosen.");
                                                            break;

                                                        case 2:
                                                            System.out.println("Write down textbook's isbn, author and title: ");
                                                            String ISBN = scan.next();
                                                            String author = scan.next();
                                                            String title = scan.next();

                                                            temp_textbook = new Textbook(ISBN, author, title);
                                                            textbooks.add(temp_textbook);

                                                            date = new Date();
                                                            bw.write(date + " admin added new textbook " + "'" + temp_textbook + "'");
                                                            bw.newLine();

                                                            temp_textbook.serialize(textbooks);
                                                            break;

                                                        default:
                                                            System.out.println("Wrong input. You've returned back to trueadmin.");
                                                            continue trueadmin;
                                                    }

                                                    temp_course = new Course(courseTitle, temp_textbook, temp_instructor);
                                                    courses.add(temp_course);

                                                    bw.write(date + " admin added new course " + "'" + temp_course + "'");
                                                    bw.newLine();

                                                    temp_course.serialize(courses);
                                                    break;

                                                case 2:
                                                    System.out.println("Write down instructor's first name, last name, department and email: ");
                                                    String firstName = scan.next();
                                                    String lastName = scan.next();
                                                    String department = scan.next();
                                                    String email = scan.next();

                                                    temp_instructor = new Instructor(firstName, lastName, department, email);
                                                    instructors.add(temp_instructor);

                                                    date = new Date();
                                                    bw.write(date + " admin added new instructor " + "'" + temp_instructor + "'");
                                                    bw.newLine();

                                                    temp_instructor.serialize(instructors);
                                                    break;

                                                case 3:
                                                    System.out.println("Write down textbook's isbn, author and title: ");
                                                    String isbn = scan.next();
                                                    String author = scan.next();
                                                    String title = scan.next();

                                                    temp_textbook = new Textbook(isbn, author, title);
                                                    textbooks.add(temp_textbook);

                                                    date = new Date();
                                                    bw.write(date + " admin added new textbook " + "'" + temp_textbook + "'");
                                                    bw.newLine();

                                                    temp_textbook.serialize(textbooks);
                                                    break;

                                                case 4:
                                                    bw.close();
                                                    continue adminreg;

                                                default:
                                                    System.out.println("Wrong input, try again!");
                                                    continue trueadmin;
                                            }
                                        }
                                    }
                                    else {
                                        System.out.println("Wrong username or password. Try again!");
                                        continue adminreg;
                                    }
                            }
                        }

                    case "u":
                        user : while(true){

                            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("courses.out"));;
                            Iterator it;
                            System.out.println("You have login as USER\nHere you can watch: \n[1] courses \n[2] instructors " +
                                    "\n[3] textbooks\nIn order to return back write <back>.");
                            String input_user = scan.next();

                            switch(input_user){

                                case "1":
                                    ois = new ObjectInputStream(new FileInputStream("courses.out"));
                                    Vector<Course> temp_courses = (Vector<Course>) ois.readObject();

                                    it = temp_courses.iterator();

                                    while(it.hasNext()){
                                        System.out.println(it.next());
                                    }
                                    break;

                                case "2":
                                    ois = new ObjectInputStream(new FileInputStream("instructors.out"));
                                    Vector<Course> temp_instructors = (Vector<Course>) ois.readObject();

                                    it = temp_instructors.iterator();
                                    while(it.hasNext()){
                                        System.out.println(it.next());
                                    }
                                    break;

                                case "3":
                                    ois = new ObjectInputStream(new FileInputStream("textbooks.out"));
                                    Vector<Textbook> temp_textbooks = (Vector<Textbook>) ois.readObject();

                                    it = temp_textbooks.iterator();
                                    while(it.hasNext()){
                                        System.out.println(it.next());
                                    }
                                    break;

                                case "back":
                                    ois.close();
                                    continue menu;
                            }
                        }

                    case "q":
                        System.exit(200);
                }
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnf){
            cnf.printStackTrace();
        } catch (NullPointerException npe){
            npe.printStackTrace();
        }
    }
}