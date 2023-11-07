public class GiaoDichVang extends GiaoDich{
    private String loaiVang;
    //constructor
    public GiaoDichVang(){
        super();
        this.loaiVang = "";
    }
    public GiaoDichVang(int ma, int sl, String ngay, double dongia, String lvang){
        super(ma, sl, ngay, dongia);
        this.loaiVang = lvang;
    }
    //getter and setter
    public String getLoaiVang(){
        return this.loaiVang;
    }
    public void setLoaiVang(String loaivang){
        this.loaiVang = loaivang;
    }
    @Override
    public String toString(){
        //return super.toString() + " \t\t " + loaiVang + " \t\t " + getThanhtien();
        return super.toString() + ' ' + String.format("%-20s %-20.1f", loaiVang, getThanhtien());
    }
}
