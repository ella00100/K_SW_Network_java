package day26;

public class day26 {
    private String secret = "캡슐화된 변수";
    String s = "day26의 인스턴스 변수";

    class MemberClass {
        String s = "day26의 MemberClass의 인스턴스 변수";

        public void show1() {
            System.out.println("Inner Class");
            System.out.println(secret);
            System.out.println(s);
            System.out.println(day26.this.s);
            // static String s3 = "정적 멤버 필드";
            // static void show2() {}
        }
        static String s3 = "static memeber field";
        static void info(){
            System.out.println("static member method");
        }
    }
        public static void main(String[] args) {
            day26 m = new day26();
            day26.MemberClass m1 = m.new MemberClass();

            System.out.println(m1.s);
            m1.show1();
            System.out.println(day26.MemberClass.s3);
            day26.MemberClass.info();
    }
}

