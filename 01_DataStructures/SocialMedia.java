import java.util.ArrayList;
import java.util.List;

class UserNode {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    UserNode next;

    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

class UserList {
    UserNode head;

    public void addUser(UserNode user) {
        if (head == null) {
            head = user;
        } else {
            UserNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = user;
        }
    }

    public UserNode findUserById(int id) {
        UserNode curr = head;
        while (curr != null) {
            if (curr.userId == id) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    public void addFriend(int id1, int id2) {
        UserNode u1 = findUserById(id1);
        UserNode u2 = findUserById(id2);
        if (u1 != null && u2 != null && id1 != id2) {
            if (!u1.friendIds.contains(id2)) u1.friendIds.add(id2);
            if (!u2.friendIds.contains(id1)) u2.friendIds.add(id1);
        }
    }

    public void removeFriend(int id1, int id2) {
        UserNode u1 = findUserById(id1);
        UserNode u2 = findUserById(id2);
        if (u1 != null && u2 != null) {
            u1.friendIds.remove(Integer.valueOf(id2));
            u2.friendIds.remove(Integer.valueOf(id1));
        }
    }

    public void displayFriends(int id) {
        UserNode user = findUserById(id);
        if (user == null) return;
        System.out.print("Friends of " + user.name + ": ");
        for (int fid : user.friendIds) {
            UserNode f = findUserById(fid);
            if (f != null) System.out.print(f.name + " ");
        }
        System.out.println();
    }

    public void findMutualFriends(int id1, int id2) {
        UserNode u1 = findUserById(id1);
        UserNode u2 = findUserById(id2);
        if (u1 == null || u2 == null) return;

        System.out.print("Mutual friends: ");
        for (int fid1 : u1.friendIds) {
            if (u2.friendIds.contains(fid1)) {
                UserNode mutual = findUserById(fid1);
                if (mutual != null) System.out.print(mutual.name + " ");
            }
        }
        System.out.println();
    }

    public void searchByName(String name) {
        UserNode curr = head;
        while (curr != null) {
            if (curr.name.equals(name)) {
                System.out.println("User found: " + curr.name + ", ID: " + curr.userId);
                return;
            }
            curr = curr.next;
        }
        System.out.println("User not found");
    }

    public void countFriends() {
        UserNode curr = head;
        while (curr != null) {
            System.out.println(curr.name + " has " + curr.friendIds.size() + " friends");
            curr = curr.next;
        }
    }
}

public class SocialMedia {
    public static void main(String[] args) {
        UserList ul = new UserList();

        UserNode u1 = new UserNode(1, "Alice", 22);
        UserNode u2 = new UserNode(2, "Bob", 25);
        UserNode u3 = new UserNode(3, "Charlie", 21);
        UserNode u4 = new UserNode(4, "Diana", 23);

        ul.addUser(u1);
        ul.addUser(u2);
        ul.addUser(u3);
        ul.addUser(u4);

        ul.addFriend(1, 2);
        ul.addFriend(1, 3);
        ul.addFriend(2, 3);
        ul.addFriend(3, 4);

        ul.displayFriends(1);
        ul.displayFriends(3);

        ul.findMutualFriends(1, 2);
        ul.findMutualFriends(2, 4);

        ul.removeFriend(1, 3);
        ul.displayFriends(1);

        ul.searchByName("Charlie");
        ul.countFriends();
    }
}
