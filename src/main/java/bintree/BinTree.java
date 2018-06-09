package bintree;


import java.io.*;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class BinTree implements Serializable {
    private static final long serialVersionUID = 8974960230418547295L;

    private Node root;

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    private void add(int value) {
        root = addRecursive(root, value);
    }

    private void traverseInOrder(Node node, Consumer<Node> visitor) {
        if (node != null) {
            visitor.accept(node);
            traverseInOrder(node.left,visitor);
            traverseInOrder(node.right,visitor);
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        final AtomicInteger cnt=new AtomicInteger(0);
        traverseInOrder(root,node->cnt.incrementAndGet());

        out.write(cnt.get());
        traverseInOrder(root,node -> {
            try {
                out.write(node.value);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        int count=in.read();
        root=null;

        for(int i=0;i<count;i++) {
          add(in.read());
        }
    }


    public static void main(String[] args) {
        BinTree tree=new BinTree();
        int[] arr={1,3,5,2,3,7,9,6};
        Arrays.stream(arr).forEach(tree::add);
        tree.traverseInOrder(tree.root,node -> {
            System.out.print(" " + node.value);
        });


        String filename = "time.ser";
        // save the object to file
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(tree);
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // read the object from file
        // save the object to file
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            BinTree tree1 = (BinTree) in.readObject();
            tree1.traverseInOrder(tree1.root,node-> System.out.print(" " + node.value));
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
