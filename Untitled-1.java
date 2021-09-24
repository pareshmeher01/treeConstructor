import java.util.*;
import java.io.*;
class Main{
    public static String TreeConstructor(String[] strArr){
        return strArr[0]''
    }

    class public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print(new Main().treeConstructor(s.nextLine()));
    }
    private String treeConstructor(String[] a) {
        Point[] p = createPoints(a);
        for(int i =0; i < p.length; i++) {
            Point pi = p[i];
            int v = pi.x;
            int parent = pi.y;
            boolean add = Node.getNode(parent).add(v);

            if(!add){
                return "false";
            }
        }
        Node root = null;
        for(int i=0;i<p.length;i++){
            Point pi = p[i];
            int v = pi.x;
            Node node = Node.getNode(v);
            Node r = node.getRoot();
            if(root == null){
                root = r;
            }
            if(r != root)
                return "false";
        }
        return "true";
    }

    private Point[] createPoints(String[] a){
        Point[] p = new Point[a.length];
        for(int i =0;i<p.length;i++){
            String s = a[i].substring(1, a[i].length() - 1);
            String[] split = s.split(",");
            p[i] = new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1]));

        }
        return p;
    }

}

class Node{
    Node left, right, parent;
	int value;
	private static Map<Integer, Node> map = new HashMap<>();

	static Node getNode(int v) {
		Node n = map.get(v);
		if (n == null) {
			map.put(v, n = new Node(v));
		}
		return n;
	}

	Node getRoot() {
		if (parent == null)
			return this;
		Node n = parent;
		while (n != null && n.parent != null)
			n = n.parent;
		return n;
	}

	Node() {
		this(-1);
	}

	public Node(int v) {
		this.value = v;
	}

	@Override
	public String toString() {
		return "Node x " + value;
	}

	boolean add(int v) {
		boolean toLeft = v < value;
		if ((toLeft && left != null) || right != null)
			return false;
		Node node = getNode(v);
		if (toLeft) {
			left = node;
		} else
			right = node;
		node.parent = this;
		return true;
	}
}

class Point {
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	int x, y;

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Point))
			return false;
		Point p = (Point) obj;
		return p.x == x && p.y == y;
	}

	@Override
	public int hashCode() {
		return x;
	}
}
