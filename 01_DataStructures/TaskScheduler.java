// 3. Circular Linked List: Task Scheduler
// Problem Statement: Create a task scheduler using a circular linked list. Each node in the list represents a task with Task ID, Task Name, Priority, and Due Date. Implement the following functionalities:
// Add a task at the beginning, end, or at a specific position in the circular list.
// Remove a task by Task ID.
// View the current task and move to the next task in the circular list.
// Display all tasks in the list starting from the head node.
// Search for a task by Priority.
// Hint:
// Use a circular linked list where the last node’s next pointer points back to the first node, creating a circular structure.
// Ensure that the list loops when traversed from the head node, so tasks can be revisited in a circular manner.
// When deleting or adding tasks, maintain the circular nature by updating the appropriate next pointers.

class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;
    public TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}
class TaskListCircular{
    TaskNode head;
    public void addTaskAtBeginning(TaskNode newTask) {
        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            TaskNode curr = head;
            while (curr.next != head) {
                curr = curr.next;
            }
            curr.next = newTask;
            newTask.next = head;
            head = newTask;
        }
    }
    public void addTaskAtEnd(TaskNode newTask) {
        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            TaskNode curr = head;
            while (curr.next != head) {
                curr = curr.next;
            }
            curr.next = newTask;
            newTask.next = head;
        }
    }
    public void insertTaskAtPosition(TaskNode newTask, int pos) {
        if (pos == 1) {
            addTaskAtBeginning(newTask);
        } else {
            TaskNode curr = head;
            int idx = 1;
            while (curr != null && idx < pos - 1) {
                curr = curr.next;
                idx++;
            }
            if (curr != null) {
                newTask.next = curr.next;
                curr.next = newTask;
            }
            else {
                System.out.println("Position out of bounds");
            }
        }
    }
    public void removeTaskById(int taskUd){
        if(head == null){
            System.out.println("List is empty");
        }else{
            TaskNode curr = head;
            while(curr.next != head && curr.next.taskId != taskUd){
                curr = curr.next;
            }
            if(curr.next == head){
                System.out.println("Task not found");
            }else{
                curr.next = curr.next.next;
                if(curr.next == head){
                    head = curr;
                }
            }
        }
    }
    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            TaskNode curr = head;
            if(curr.priority == priority) {
                System.out.println("Task found: " + curr.taskName);
                return;
            }
            while (curr != head) {
                if (curr.priority == priority) {
                    System.out.println("Task found: " + curr.taskName);
                    return;
                }
                curr = curr.next;
            }
            System.out.println("Task not found");
        }
    }
    public void displayTasks() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            TaskNode curr = head;
            do {
                System.out.print(" Task Name: " + curr.taskName + "-----> ");
                curr = curr.next;
            } while (curr != head);
        }
        System.out.println();
    }
}
public class TaskScheduler {
    public static void main(String[] args) {
        TaskNode task1 = new TaskNode(1, "Task 1", 2, "2023-10-01");
        TaskNode task2 = new TaskNode(2, "Task 2", 1, "2023-10-02");
        TaskNode task3 = new TaskNode(3, "Task 3", 3, "2023-10-03");
        TaskNode task4 = new TaskNode(4, "Task 4", 4, "2023-10-04");
        TaskNode task5 = new TaskNode(5, "Task 5", 5,"2025-9-8");
        TaskListCircular ts = new TaskListCircular();
        ts.addTaskAtBeginning(task1);
        ts.addTaskAtBeginning(task2);
        ts.displayTasks();
        System.out.println("\ninserting task  at end \n");
        ts.addTaskAtEnd(task3);
        ts.displayTasks();
        System.out.println("\ninserting task at position 2\n");
        ts.insertTaskAtPosition(task4, 2);
        ts.displayTasks();
        System.out.println("\ninserting task  at end \n");
        ts.addTaskAtEnd(task5);
        ts.displayTasks();
        System.out.println("\nRemoving task with ID 3\n");
        ts.removeTaskById(3);
        ts.displayTasks();
    }
}
