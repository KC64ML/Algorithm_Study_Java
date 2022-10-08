package another;

public class Digit1 {
    public static void main(String[] args) {
        int count = 0;

        for(int i=0;i<5;i++) {
            for(int j=0;j<5;j++) {
                if(j <i) {
                    System.out.printf("%3s", " ");
                }else {
                    System.out.printf("%3d",++count);
                }
            }
            System.out.println();
        }

    }
}
