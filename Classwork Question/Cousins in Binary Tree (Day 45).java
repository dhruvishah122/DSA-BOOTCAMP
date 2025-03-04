import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }
  
    public static boolean isCousins(Node root, int x, int y){
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        
        while(q.size() != 0){
            int sz = q.size();
            boolean isXExist = false;
            boolean isYExist = false;
            
            for(int i=0;i<sz;i++){
                Node temp = q.remove();
                
                // Same Level
                if(temp.data == x) isXExist = true;
                if(temp.data == y) isYExist = true;
                
                // Same parent or not
                if(temp.left != null && temp.right!= null){
                    if(temp.left.data == x && temp.right.data == y){
                        return false;
                    }
                    
                    if(temp.left.data == y && temp.right.data == x){
                        return false;
                    }
                }
                
                if(temp.left != null){
                    q.add(temp.left);
                }
                
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
            
            if(isXExist == true && isYExist == true){
                return true;
            }
        }
        return false;

    }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }
      int x = Integer.parseInt(br.readLine());
      int y = Integer.parseInt(br.readLine());

      Node root = construct(arr);
      System.out.println(isCousins(root,x,y));
  }

}
