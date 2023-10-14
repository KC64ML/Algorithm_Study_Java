package 싸움땅;

public class Solution2 {

    private static class Node{
        public final int x;
        public final int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }


        public Node update(int x, int y){
            return new Node(x, y);
        }

        public String printlnNode(){
            return this.x + " " + this.y;
        }
    }
    public static void main(String[] args) {
        Node[] nodes = new Node[4];
        for(int i = 0; i < 4; i++){
            nodes[i] = new Node(0, 1);
        }

        for(int i = 0; i < 4; i++){
            nodes[i] = nodes[i].update(2, 3);
        }

        for(Node n : nodes){
            System.out.println(n.x + " " + n.y);
        }
    }
}
