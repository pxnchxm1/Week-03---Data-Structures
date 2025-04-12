class ItemNode{
    String itemName;
    int itemId;
    int itemQuantity;
    double itemPrice;
    ItemNode next;
    public ItemNode(String itemName, int itemId, int itemQuantity, double itemPrice) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        this.next = null;
    }  
}

class ItemList{
    ItemNode head;
    public void addItemAtBeginning(ItemNode newItem){
        if(head == null){
            head = newItem;
            newItem.next =  null;
        }else{
            newItem.next = head ;
            head = newItem;
        }
    }
    public void addItemAtEnd(ItemNode newItem){
        if(head == null){
           addItemAtBeginning(newItem);
        }else{
            ItemNode curr = head;
            while(curr.next!=null){
                curr = curr.next;
            }
            curr.next = newItem;
            newItem.next = null;
        }
    }
    public void addItemAtPosition(ItemNode newItem, int pos){
        if(pos==1){
            addItemAtBeginning(newItem);
        }else{
            ItemNode curr = head;
            int idx =1;
            while(curr!=null && idx<pos-1){
                curr = curr.next;
                idx++;
            }
            if(curr != null){
                newItem.next = curr.next;
                curr.next = newItem;
            }else{
                System.out.println("Position out of bounds");
            }
        }
    }
    public void removeItemById(int id){
        if(head == null){
            System.out.println("List is empty");
        } 
        else{
            ItemNode curr = head;
            while(curr.next!=null && curr.next.next!=null){
                if(curr.next.itemId == id){
                    curr.next = curr.next.next;
                    System.out.println("Item removed");
                    return;
                }
                curr = curr.next;
            }
            
        }
    }
    public void updateQuantityById(int id,int q){
        if(head == null){
            System.out.println("List is empty");
        }else{
            ItemNode curr = head;
            while(curr!=null){
                if(curr.itemId==id){
                    curr.itemQuantity =q;
                    System.out.println("Item updated");
                    return;
                }
                curr = curr.next;
            }
            System.out.println("Item not found");
        }
    }
    public void searchItemById(int id){
        if(head == null){
            System.out.println("Empty list");
        }else{
            ItemNode curr = head ;
            while(curr!=null){
                if(curr.itemId == id){
                    System.out.println("Item found: " + curr.itemName + " " + curr.itemId + " " + curr.itemQuantity + " " + curr.itemPrice);
                    return;
                }
                curr = curr.next;
            }
            System.out.println("Item not found");
        }
    }
    public double calculateTotalValue(){
        if(head==null){
            System.out.println("List is empty");
            return 0;
        }
        else{
            double s = 0.0;
            ItemNode curr = head ;
            while(curr!=null){
                s+= (curr.itemPrice * curr.itemQuantity);
                curr = curr.next;
            }
            return s;
        }
    }

    //merge sort 
    public  ItemNode getMiddle(ItemNode head){
        if(head == null){
            return head;
        }
        ItemNode slow = head;
        ItemNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ItemNode mergeSort(ItemNode head){
        if(head == null || head.next == null){
            return head;
        }
        ItemNode mid = getMiddle(head);
        ItemNode lhead = head;
        ItemNode rhead = mid.next;
        mid.next = null;
        return merge(mergeSort(lhead),mergeSort(rhead));
    }
    public ItemNode merge(ItemNode left,ItemNode right){
        ItemNode temp = new ItemNode("",0,0,0);
        ItemNode curr = temp;
        while(left!=null && right!=null){
            if(left.itemId <= right.itemId){
                curr.next = left;
                left = left.next;
            }else{
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        if(left!=null){
            curr.next = left;
        }else if(right!=null){
            curr.next = right;
        }
        return temp.next;
    }
    public void displayList(){
        if(head == null){
            System.out.println("List is empty");
        }else{
            ItemNode curr = head;
            while(curr != null){
                System.out.print( curr.itemId +"---->" );
                curr = curr.next;
            }
            System.out.println("null");
        }
    }
}
public class InventoryManagementSystem {

    public static void main(String[] args) {
        ItemNode item1 = new ItemNode("Item1", 101, 10, 20.5);
        ItemNode item2 = new ItemNode("Item2", 102, 5, 15.0);
        ItemNode item3 = new ItemNode("Item3", 103, 8, 30.0);
        ItemNode item4 = new ItemNode("Item4", 104, 12, 25.0);
        ItemNode item5 = new ItemNode("Item5", 105, 20, 10.0);
        ItemNode item6 = new ItemNode("Item6", 106, 15, 50.0);
        ItemList itemList = new ItemList();
        System.out.println("adding item 1,2,3 at beggining");
        itemList.addItemAtBeginning(item1);
        itemList.addItemAtBeginning(item2);
        itemList.addItemAtBeginning(item3);
        itemList.displayList();
        System.out.println("adding item 4 at beggining");
        itemList.addItemAtBeginning(item4);
        itemList.displayList();
        System.out.println("adding item 5 at end");
        itemList.addItemAtEnd(item5);
        itemList.displayList();
        System.out.println("adding item 6 at position 2");
        itemList.addItemAtPosition(item6, 2);
        itemList.displayList();
        System.out.println("Removing item with id 2");
        itemList.removeItemById(102);
        System.out.println("updating item id 104 quantity to 100");
        itemList.updateQuantityById(104, 100);
        itemList.displayList();
        System.out.println("searching item with id 101");
        itemList.searchItemById(101);
        System.out.println("calculating total value");
        double totalValue = itemList.calculateTotalValue();
        System.out.println("Total value of inventory: " + totalValue);
        System.out.println("Sorting the list");
        itemList.head = itemList.mergeSort(itemList.head);
        itemList.displayList();
    }
}
