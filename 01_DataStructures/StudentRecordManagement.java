class StudentNode{
    String name;
    int roll;
    int age;
    char grade;
    StudentNode next;

    public StudentNode(String name, int roll,int age,char grade){
        this.name = name ;
        this.roll = roll ;
        this.age = age ;
        this.grade = grade ;    
    }
}

class StudentRecord {
    StudentNode head;

    public void addStudentBegginning(String name,int roll,int age,char grade){
        StudentNode newStudent = new StudentNode(name, roll, age, grade);
        System.out.println("Inserting " + name +"'s record at beggining of the record :");
        if (head == null) {
            head = newStudent;
            newStudent.next = null;
        } else {
            newStudent.next = head;
            head = newStudent;
        }
        System.out.println("Record inserted successfully");
        
    }
    public void addStudentEnd(String name, int roll, int age, char grade){
        StudentNode newStudent = new StudentNode(name, roll, age, grade);
        if(head == null){
            head = newStudent;
            newStudent.next = null;
        }else{
            while(head.next != null){
                head = head.next;
            }
            head.next = newStudent;
            newStudent.next = null;
        }
    }
    public void addStudentAtI(int index, String name, int roll, int age, char grade){
        StudentNode newStudent = new StudentNode(name, roll, age, grade);
        System.out.println("Inserting " + name +"'s record at index "+ index +":");
        if(index < 0){
            System.out.println("Invalid index");
            return;
        }
        if(index == 0){
            addStudentBegginning(name, roll, age, grade);
        }else{
            StudentNode current = head;
            int idx=0;
            while(current.next!=null || idx <index){
                current = current.next;
                idx++;
            }
            newStudent.next = current.next;
            current.next = newStudent;
        }
        System.out.println("Record inserted successfully");
    }
    public void delStudent(int roll){
        StudentNode current = head;
        StudentNode prev = null;
        System.out.println("Deleting student with roll number " + roll);
        while(current != null && current.roll != roll){
            prev = current;
            current = current.next;
        }
        if(current == null){
            System.out.println("Student not found");
            return;
        }if(prev==null){
            head = current.next;
        }else{
            prev.next = current.next;
        }
        System.out.println("Student deleted successfully");

    }
    public void searchStudent(int roll){
        System.out.println("Searching student with roll number " + roll);
        StudentNode curr = head;

        while(curr !=null){
            if(curr.roll == roll){
                System.out.print("Student found and details below : ");
                System.out.print(" Name : " + curr.name);
                System.out.print(" Roll : " + curr.roll);
                System.out.print(" Age : " + curr.age);
                System.out.print(" Grade : " + curr.grade+"\n");
                System.out.println("---------------------->");
                return;
            }curr = curr.next;
        }
        System.out.println("Student not found");
    }
    public void displayRecords(){
        System.out.println("Displaying all records");
        StudentNode curr = head;
        while(curr != null){
            System.out.print("Name : " + curr.name);
            System.out.print(" Roll : " + curr.roll);
            System.out.print(" Age : " + curr.age);
            System.out.print(" Grade : " + curr.grade +"\n");
            curr = curr.next;
        }

    }
    public void updateGrade(int roll,char grade){
        System.out.println("\nUpdating grade of student with roll number " + roll);
        StudentNode curr = head;
        while(curr != null){
            if(curr.roll == roll){
                curr.grade = grade;
                System.out.println("Grade updated to "+ grade);
                System.out.println("Updated record : ");
                return;
            }
            curr = curr.next;
        }
        System.out.println(" Student not found ");
    }
    
}
public class StudentRecordManagement{
    public static void main(String[] args){
        StudentRecord sr = new StudentRecord();
        sr.addStudentBegginning("John", 1, 20, 'A');
        sr.addStudentEnd("Ravi", 3, 22, 'C');
        sr.addStudentAtI(1, "Amit", 4, 23, 'D');
        sr.displayRecords();
        sr.delStudent(2);
        sr.displayRecords();
        sr.searchStudent(3);
        sr.updateGrade(3, 'A');
        sr.displayRecords();


    }

}