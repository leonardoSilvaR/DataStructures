public class BinaryTree {
    int value;
    BinaryTree leftNode;
    BinaryTree rightNode;

    public BinaryTree(int value) {
        this.value = value;
    }

    public void insertNode(BinaryTree binary, int value) {
        if (binary != null) {
            if (value > binary.value) {
                if (binary.rightNode != null) {
                    insertNode(binary.rightNode, value);
                } else {
                    binary.rightNode = new BinaryTree(value);
                    binary.rightNode.value = value;
                }
            } else if (value < binary.value) {
                if (binary.leftNode != null) {
                    insertNode(binary.leftNode, value);
                } else {
                    binary.leftNode = new BinaryTree(value);
                    binary.leftNode.value = value;
                }
            }
        }
    }

    public BinaryTree findByValueAndSum(int value, BinaryTree bt) {
        if (bt != null) {
            if (value < bt.value) {
                findByValueAndSum(value, bt.leftNode);
            } else if (value > bt.value) {
                findByValueAndSum(value, bt.rightNode);
            } else {
                System.out.println("Somátoria " + (sum(bt) - bt.value));
            }
        }
        return bt;
    }

    public int sum(BinaryTree bt) {
        while (bt != null) {
            return sum(bt.rightNode) + sum(bt.leftNode) + bt.value;
        }
        return 0;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(8);
        bt.insertNode(bt, 10);
        bt.insertNode(bt, 20);
        bt.insertNode(bt, 1);
        bt.insertNode(bt, 5);
        bt.insertNode(bt, 6);
        bt.findByValueAndSum(5, bt);
    }
}
