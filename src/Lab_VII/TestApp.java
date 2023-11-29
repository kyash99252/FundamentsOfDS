package Lab_VII;

import java.util.ArrayList;

/**
 * This is a class for testing the LinkedTree class.
 */
class TestApplication {
    public static void main(String[] args) {
        ArrayList<Integer> num = new ArrayList<Integer>();
        LinkedTree<String> T1 = new LinkedTree<>();

        Node<String> node0 = T1.createNode("Electronics R' Us", null);
        T1.addRoot(node0);

        Node<String> node1 = T1.createNode("R&D", node0);
        T1.addChild(node0, node1);

        Node<String> node2 = T1.createNode("Sales", node0);
        T1.addChild(node0, node2);

        Node<String> node21 = T1.createNode("Domestic", node2);
        T1.addChild(node2, node21);

        Node<String> node22 = T1.createNode("International", node2);
        T1.addChild(node2, node22);

        Node<String> node221 = T1.createNode("Canada", node22);
        T1.addChild(node22, node221);

        Node<String> node222 = T1.createNode("S.America", node22);
        T1.addChild(node22, node222);
        Node<String> node223 = T1.createNode("Overseas", node22);
        T1.addChild(node22, node223);

        Node<String> node2231 = T1.createNode("Africa", node223);
        T1.addChild(node223, node2231);

        Node<String> node2232 = T1.createNode("Europe", node223);
        T1.addChild(node223, node2232);

        Node<String> node2233 = T1.createNode("Asia", node223);
        T1.addChild(node223, node2233);

        Node<String> node2234 = T1.createNode("Australia", node223);
        T1.addChild(node223, node2234);

        Node<String> node3 = T1.createNode("Purchasing", node0);
        T1.addChild(node0, node3);

        Node<String> node4 = T1.createNode("Manufacturing", node0);
        T1.addChild(node0, node4);

        Node<String> node41 = T1.createNode("TV", node4);
        T1.addChild(node4, node41);

        Node<String> node42 = T1.createNode("CD", node4);
        T1.addChild(node4, node42);

        Node<String> node43 = T1.createNode("Tuner", node4);
        T1.addChild(node4, node43);

        //T1.printPreorderIndent(T1, node0, 0); //without label or serial number
        T1.printPreorderLabeled(T1, node0, num);
    }
}
