
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ListGD {
    private ArrayList<GiaoDich> lst;
    private static int tongGDv, tongGDtt;
    public ListGD(){
        this.lst = new ArrayList<GiaoDich>();
        tongGDtt = 0;
        tongGDv = 0;
    }
    public GiaoDich themGD(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin GD ");
        System.out.println("Ma GD (Nhap So): ");
        int maGD = sc.nextInt();
        GiaoDich gd = new GiaoDich(maGD);
        if(lst.contains(gd))return null;
        else{
            String ngayGD = "";
            while(true){
                System.out.println("Ngay giao dich (dd-mm-yyyy): ");
                ngayGD = sc.next();
                if(ngayGD.matches("\\d{2}-\\d{2}-\\d{4}$"))break;
            }
            gd.setNgayGD(ngayGD);
            System.out.println("Don Gia: ");
            double dongia = sc.nextDouble();
            gd.setDonGia(dongia);
            System.out.println("So Luong: ");
            int soluong = sc.nextInt();
            gd.setSoLuong(soluong);
            return gd;
        }
    }
    public boolean themGDVang(){
        Scanner sc = new Scanner(System.in);
        GiaoDich gd = themGD();
        if(gd == null)return false;
        else{
            System.out.println("Loai Vang: ");
            String loaivang = sc.next();
            GiaoDichVang gdv = new GiaoDichVang(gd.getMaGD(), gd.getSoLuong(), gd.getNgayGD(), gd.getDonGia(), loaivang);
            gdv.setThanhtien();
            tongGDv += gdv.getSoLuong();
            return lst.add(gdv);
        }
    }
    public boolean themGDTT(){
        Scanner sc = new Scanner(System.in);
        GiaoDich gd = themGD();
        if(gd == null)return false;
        else{
            System.out.println("Loai Tien Te (nhap 1: VND, 2: ngoai te): ");
            int loaitiente = sc.nextInt();
            double tigia;
            if(loaitiente == 1)tigia = 1.0;
            else{
                System.out.println("Ti Gia: ");
                tigia = sc.nextDouble();
            }
            GiaoDichTienTe gdtt = new GiaoDichTienTe(gd.getMaGD(), gd.getSoLuong(), gd.getNgayGD(), gd.getDonGia(), tigia, loaitiente);
            gdtt.setThanhtien();
            tongGDtt += gdtt.getSoLuong();
            return lst.add(gdtt);
        }
    }
    public void hienthiDS(){
        System.out.println("====================================== DANH SACH GIAO DICH ======================================");
        //System.out.println("MaGD \t\t So Luong \t\t Ngay GD \t\t Don Gia \t\t Loai vang/Ty Gia \t\t TTien");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", "MaGD", "So Luong", "Ngay GD", "Don Gia", "Loai vang/Ty Gia", "TTien");
        double tt = 0;
        for(GiaoDich gd : lst){
            System.out.println(gd.toString());
            tt += gd.getThanhtien();
        }
        System.out.println("=================================================================================================");
        System.out.println("Tong tien: " + Double.toString(tt));
    }
    public void getByDate(String ngaygd){
        System.out.println("====================================== DANH SACH GIAO DICH NGAY " + ngaygd + " ======================================");
        //System.out.println("MaGD \t\t So Luong \t\t Ngay GD \t\t Don Gia \t\t Loai vang/Ty Gia \t\t TTien");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", "MaGD", "So Luong", "Ngay GD", "Don Gia", "Loai vang/Ty Gia", "TTien");
        for(GiaoDich gd : lst)if(gd.getNgayGD().equals(ngaygd))System.out.println(gd.toString());
        System.out.println("===================================================================================================================");
    }
    public void getContainDate(String ngaygd){
        System.out.println("====================================== DANH SACH GIAO DICH NGAY " + ngaygd + " ======================================");
        //System.out.println("MaGD \t\t So Luong \t\t Ngay GD \t\t Don Gia \t\t Loai vang/Ty Gia \t\t TTien");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", "MaGD", "So Luong", "Ngay GD", "Don Gia", "Loai vang/Ty Gia", "TTien");
        for(GiaoDich gd : lst)if((gd.getNgayGD().substring(0,2)).equals(ngaygd))System.out.println(gd.toString());
        System.out.println("===================================================================================================================");
    }
    public int tongGDVang(){
        return tongGDv;
    }
    public int tongGDtt(){
        return tongGDtt;
    }
    public void getBySoLuong(int from, int to){
        System.out.println("====================================== DANH SACH GIAO DICH Ngay ======================================");
        //System.out.println("MaGD \t\t So Luong \t\t Ngay GD \t\t Don Gia \t\t Loai vang/Ty Gia \t\t TTien");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", "MaGD", "So Luong", "Ngay GD", "Don Gia", "Loai vang/Ty Gia", "TTien");
        for(GiaoDich gd : lst)if(gd.getSoLuong() >= from && gd.getSoLuong() <= to)System.out.println(gd.toString());
        System.out.println("======================================================================================================");
    }
    public void getByYear(int from, int to){
        System.out.printf("====================================== DANH SACH GIAO DICH tu nam %d den nam %d ======================================\n", from, to);
        //System.out.println("MaGD \t\t So Luong \t\t Ngay GD \t\t Don Gia \t\t Loai vang/Ty Gia \t\t TTien");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", "MaGD", "So Luong", "Ngay GD", "Don Gia", "Loai vang/Ty Gia", "TTien");
        for(GiaoDich gd : lst)
            if(Integer.parseInt(gd.getNgayGD().substring(6)) >= from 
                    && Integer.parseInt(gd.getNgayGD().substring(6)) <= to)
                System.out.println(gd.toString());
        System.out.println("======================================================================================================");        
    }
    public void sapXepByNgay(){
        Collections.sort(lst, (GiaoDich gd1, GiaoDich gd2) -> {
            String d1 = gd1.getNgayGD();
            String d2 = gd2.getNgayGD();
            return (d1.substring(6) + d1.substring(3,5) + d1.substring(0,2)).compareTo(d2.substring(6) + d2.substring(3,5) + d2.substring(0,2));
        });
    }
    public int getSoLuongGD(){
        return lst.size();
    }
}
