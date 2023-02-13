package day21;

public class Generic {
    public static void main(String[] args){
        PostBox<String> postBox = new PostBox<>();
        postBox.setItem("소포");
        PostBox<Integer> postBox2 = new PostBox<>();
        postBox2.setItem(100);
        System.out.println(postBox.getItem());
        System.out.println(postBox2.getItem());
    }

    public static class PostBox<T> { //generic class _ T type
        private T item;

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }
    }
}
