public class Generic {
    public static void main(String[] args){
        PostBox<String> postBox = new PostBox<>();
        postBox.setItem("소포");
        PostBox<Integer> postBox2 = new PostBox<>();
        postBox2.setItem(100);
        System.out.println(postBox.getItem());
        System.out.println(postBox2.getItem());
    }
}
