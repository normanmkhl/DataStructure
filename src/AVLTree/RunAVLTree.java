package AVLTree;

public class RunAVLTree {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        System.out.println("Insert values from 1 to 10 : ");
        for (int i = 1; i <= 10; i++) {
            tree.insert(i);
            System.out.print(i + " ");
        }

        System.out.println("\n");

        System.out.print("Print the balance: ");
        tree.printBalance();

        System.out.println("\n");

        System.out.println("Traverse pre order : ");
        tree.PreOrder();

        System.out.println("\n");

        System.out.println("Traverse in order : ");
        tree.InOrder();

        System.out.println("\n");

        System.out.println("Traverse post order : ");
        tree.PostOrder();

        System.out.println("\n");

        System.out.println("Traverse in order after deletion of 5 : ");
        tree.delete(5);
        tree.InOrder();

        System.out.println("\n");

        System.out.println("Find node of : 9 and 14 ");

        if(null != tree.Search(9)){
            System.out.println("Key found for 9");
        }else{
            System.out.println("Not found for 9");
        }

        if(null != tree.Search(14)){
            System.out.println("Key found for 14");
        }else{
            System.out.println("Not found for 14");
        }

        System.out.println();

        System.out.println("Find the smallest node");
        tree.BTsmallest();

        System.out.println("Find the biggest node");
        tree.BTbiggest();


    }
}
