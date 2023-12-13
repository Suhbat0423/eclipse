import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import dataStructures.ArrayLinearList;


public class Registration {
    public ArrayLinearList studentList;
    public ArrayLinearList subjectList;
    public ArrayLinearList majorList;

    public Registration() {
        studentList = new ArrayLinearList();
        subjectList = new ArrayLinearList();
        majorList = new ArrayLinearList();
    }

    public void readSubjectList() {
        try (Scanner sc = new Scanner(new File("C:\\Users\\svhba\\Desktop\\subjects.txt"))) {
            int k = 0;
            while (sc.hasNext()) {
                Subject sj = new Subject(sc.nextLine());
                subjectList.add(k++, sj);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readStudentList() {
        try (Scanner sc = new Scanner(new File("C:\\Users\\svhba\\Desktop\\exams.txt"))) {
            int k = 0;
            while (sc.hasNext()) {
                String ss = sc.nextLine();
                String[] strArr = ss.split("/");

                student currentStudent;
                
                if (checkStudent(strArr[1]) == -1) {
                    currentStudent = new student(strArr[1], getMajor(strArr[0]));
                    if (getSubject(strArr[2]) != -1) {
                        currentStudent.addLesson((Subject) subjectList.get(getSubject(strArr[2])), Integer.parseInt(strArr[3]));
                    }
                    studentList.add(k++, currentStudent);
                } else {
                    currentStudent = (student) studentList.get(checkStudent(strArr[1]));
                    if (getSubject(strArr[2]) != -1) {
                        currentStudent.addLesson((Subject) subjectList.get(getSubject(strArr[2])), Integer.parseInt(strArr[3]));
                    }
                }

                
                currentStudent.hasFailed();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void readMajorList() {
        try (Scanner sc = new Scanner(new File("C:\\Users\\svhba\\Desktop\\majors.txt"))) {
            int k = 0;
            while (sc.hasNext()) {
                Major major = new Major(sc.nextLine());
                majorList.add(k++, major);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printSubject() {
        Subject.displayHead();
        for (int i = 0; i < subjectList.size(); i++)
            ((Subject) subjectList.get(i)).display();
    }

    public void printMajor() {
        Major.displayHead();
        for (int i = 0; i < majorList.size(); i++)
            ((Major) majorList.get(i)).display();
    }

    public int checkStudent(String studentCode) {
        for (int i = 0; i < this.studentList.size(); i++) {
            student currentStudent = (student) this.studentList.get(i);
            if (currentStudent.getCode().equals(studentCode)) {
                return i; 
            }
        }
        return -1; 
    }

    public Major getMajor(String majorCode) {
        Major mj = null; 
        for (int i = 0; i < majorList.size(); i++) {
            Major mj1 = (Major) majorList.get(i);
            if (mj1.getCode().equals(majorCode)) {
                mj = mj1;
                break; 
            }
        }
        return mj;
    }

    
    
    public int getSubject(String subjectCode) {
        int ind = -1;
        for (int i = 0; i < subjectList.size(); i++) {
            if (((Subject) subjectList.get(i)).getSubjectCode().equals(subjectCode)) {
                ind = i;
                break;
            }
        }
        return ind; 
    }

    public void displayStudentsGPA() {
    	
        student.displayHeader();
        
        for (int i = 0; i < studentList.size(); i++) {
            student currentStudent = (student) studentList.get(i);
            currentStudent.displayGpa();
            currentStudent.hasFailed(); 
        }
    }
    
    
    public static void main(String[] args) {
        Registration rr = new Registration();
        rr.readSubjectList();
        rr.printSubject();
        rr.readMajorList();
        rr.printMajor();
        rr.readStudentList(); 
        rr.displayStudentsGPA();
    }
    
}
