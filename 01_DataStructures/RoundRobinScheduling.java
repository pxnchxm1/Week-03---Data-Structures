class ProcessNode {
    int pid;
    int burst;
    int rem;
    int prio;
    ProcessNode next;

    public ProcessNode(int pid, int burst, int prio) {
        this.pid = pid;
        this.burst = burst;
        this.rem = burst;
        this.prio = prio;
        this.next = null;
    }
}

class ProcessCircularList {
    ProcessNode head;

    public void addProcess(ProcessNode newNode) {
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            ProcessNode curr = head;
            while (curr.next != head) {
                curr = curr.next;
            }
            curr.next = newNode;
            newNode.next = head;
        }
    }

    public void removeProcess(int pid) {
        if (head == null) return;
        ProcessNode curr = head;
        ProcessNode prev = null;
        do {
            if (curr.pid == pid) {
                if (curr == head && curr.next == head) {
                    head = null;
                    return;
                }
                if (curr == head) {
                    ProcessNode last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                    return;
                }
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    public void displayProcesses() {
        if (head == null) return;
        ProcessNode curr = head;
        do {
            System.out.print("P" + curr.pid + "(" + curr.rem + ") -> ");
            curr = curr.next;
        } while (curr != head);
        System.out.println();
    }

    public void roundRobin(int tq) {
        if (head == null) return;
        ProcessNode curr = head;
        int time = 0;
        int totalWait = 0;
        int totalTAT = 0;
        int count = 0;

        while (head != null) {
            curr = head;
            do {
                if (curr.rem > 0) {
                    int exec = Math.min(tq, curr.rem);
                    curr.rem -= exec;
                    time += exec;
                    displayProcesses();
                    if (curr.rem == 0) {
                        int tat = time;
                        int wt = tat - curr.burst;
                        totalTAT += tat;
                        totalWait += wt;
                        count++;
                        int id = curr.pid;
                        curr = curr.next;
                        removeProcess(id);
                        if (head == null) break;
                        continue;
                    }
                }
                curr = curr.next;
            } while (curr != head && head != null);
        }

        if (count > 0) {
            System.out.println("Avg Waiting Time: " + (totalWait * 1.0 / count));
            System.out.println("Avg Turnaround Time: " + (totalTAT * 1.0 / count));
        }
    }
}

public class RoundRobinScheduling {
    public static void main(String[] args) {
        ProcessCircularList pc = new ProcessCircularList();
        ProcessNode p1 = new ProcessNode(1, 5, 2);
        ProcessNode p2 = new ProcessNode(2, 3, 1);
        ProcessNode p3 = new ProcessNode(3, 4, 3);
        ProcessNode p4 = new ProcessNode(4, 2, 2);

        pc.addProcess(p1);
        pc.addProcess(p2);
        pc.addProcess(p3);
        pc.addProcess(p4);

        System.out.println("Processes in the queue:");
        pc.roundRobin(2);
    }
}
