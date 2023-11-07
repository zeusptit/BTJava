
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.println("MaGD \t\t So Luong \t\t Ngay GD \t\t Don Gia \t\t Loai vang/Ty Gia \t\t TTien");
        ListGD a = new ListGD();
        OUTER:
        while (true) {
            Scanner sc = new Scanner(System.in);
            int inp = sc.nextInt();
            String ngaygd;
            int from, to;
            switch (inp) {
                case 0 -> {
                    break OUTER;
                }
                case 1 -> {
                    a.themGDVang();
                }
                case 2 -> {
                    a.themGDTT();
                }
                case 3 -> a.hienthiDS();
                case 4 -> {
                    System.out.println("Tong so luong cac giao dich: ");
                    System.out.println(a.getSoLuongGD());
                }
                case 5 -> {
                    ngaygd = sc.next();
                    a.getByDate(ngaygd);
                }
                case 6 -> {
                    ngaygd = sc.next();
                    a.getContainDate(ngaygd);
                }
                case 7 -> {
                    from = sc.nextInt();
                    to = sc.nextInt();
                    a.getByYear(from, to);
                }
                    
                default -> {
                }
            }
        }
    }
    
}
