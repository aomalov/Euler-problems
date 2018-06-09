package bintree;


import java.io.Serializable;

class Node implements Serializable {

    private static final long serialVersionUID = -4504830243551304607L;
    transient Node left;
    transient Node right;

    final Integer value;

    Node(Integer value) {
        this.left = null;
        this.right = null;
        this.value = value;
    }
}
