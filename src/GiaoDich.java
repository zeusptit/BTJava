public class GiaoDich {
    protected int maGD, SoLuong;
    protected String NgayGD;
    protected double DonGia, ThanhTien;
    
    //constructor
    protected GiaoDich(){
        this.maGD = 0;
        this.NgayGD = "";
        this.DonGia = 0;
        this.SoLuong = 0;
        this.ThanhTien = 0;
    }
    protected GiaoDich(int maGD){
        this.maGD = maGD;
        this.NgayGD = "";
        this.DonGia = 0;
        this.SoLuong = 0;
        this.ThanhTien = 0;
    }
    protected GiaoDich(int ma, int sl, String ngay, double gia){
        this.maGD = ma;
        this.NgayGD = ngay;
        this.DonGia = gia;
        this.SoLuong = sl;
        this.ThanhTien = 0;
    }
    //setter and getter
    public int getMaGD(){
        return this.maGD;
    }
    public void setThanhtien(double thanhtien){
        ThanhTien = thanhtien;
    }
    public void setThanhtien(){
        ThanhTien = DonGia * SoLuong;
    }
    public double getThanhtien(){
        return ThanhTien;
    }
    public double getDonGia(){
        return this.DonGia;
    }
    public void setDonGia(double dongia){
        this.DonGia = dongia;
    }
    public int getSoLuong(){
        return this.SoLuong;
    }
    public void setSoLuong(int soluong){
        this.SoLuong = soluong;
    }
    public String getNgayGD(){
        return this.NgayGD;
    }
    public void setNgayGD(String ngaygd){
        this.NgayGD = ngaygd;
    }
            
    @Override
    public String toString(){
       //return maGD + " \t\t " + SoLuong + " \t\t " + NgayGD + " \t\t " + DonGia;
       return String.format("%-20d %-20d %-20s %-20.1f", maGD, SoLuong, NgayGD, DonGia);
    }
    
    //call contains
    @Override
    public boolean equals(Object o){
        if(this == o)return true;
        if(o == null)return false;
        GiaoDich other = (GiaoDich) o;
        if(maGD != other.maGD)return false;
        return true;
    }
}
