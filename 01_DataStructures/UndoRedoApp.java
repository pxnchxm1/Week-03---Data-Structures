class TextNode {
    String text;
    TextNode next;
    TextNode prev;

    public TextNode(String text) {
        this.text = text;
        this.next = null;
        this.prev = null;
    }
}

class TextEditor {
    TextNode head;
    TextNode current;
    int size = 0;
    int limit = 10;

    public void addState(String text) {
        TextNode newNode = new TextNode(text);
        if (head == null) {
            head = newNode;
            current = head;
            size = 1;
        } else {
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
            size++;

            TextNode temp = current;
            int count = 1;
            while (temp.prev != null) {
                temp = temp.prev;
                count++;
                if (count > limit) {
                    head = head.next;
                    head.prev = null;
                    size--;
                }
            }
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("Nothing to undo");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("Nothing to redo");
        }
    }

    public void showCurrent() {
        if (current != null) {
            System.out.println("Current Text: " + current.text);
        } else {
            System.out.println("No text available");
        }
    }
}

public class UndoRedoApp {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");

        editor.showCurrent();

        editor.undo();
        editor.showCurrent();

        editor.undo();
        editor.showCurrent();

        editor.redo();
        editor.showCurrent();

        editor.addState("New Line Added");
        editor.showCurrent();

        editor.redo();  
    }
}
