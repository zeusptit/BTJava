public class GiaoDichTienTe extends GiaoDich{
    private double tiGia;
    private int loaiTienTe;
    //constructor
    public GiaoDichTienTe(){
        super();
        this.tiGia = 0;
        this.loaiTienTe = 0;
    }
    public GiaoDichTienTe(int ma, int sl, String ngay, double dongia, double tgia, int loai){
        super(ma, sl, ngay, dongia);
        this.tiGia = tgia;
        this.loaiTienTe = loai;
    }
    //getter and setter
    public double getTiGia(){
        return this.tiGia;
    }
    public void setTiGia(double tgia){
        this.tiGia = tgia;
    }
    public int getLoaiTienTe(){
        return this.loaiTienTe;
    }
    public void setLoaiTienTe(int ltiente){
        this.loaiTienTe = ltiente;
    }
    @Override
    public void setThanhtien(){
        if(this.loaiTienTe == 1)this.setThanhtien(this.getDonGia() * this.getSoLuong());
        else this.setThanhtien(this.getDonGia() * this.getSoLuong()* this.getTiGia());
    }
    @Override
    public String toString(){
        String tmp;
        if(this.loaiTienTe == 1)tmp = " VND";
        else if(this.loaiTienTe == 2)tmp = " USD";
        else tmp = " EURO";
        //return super.toString() + " \t\t " + tiGia + tmp + " \t\t " + getThanhtien();
        return super.toString() + ' ' + String.format("%.1f %-16s %-20.1f", tiGia, tmp, getThanhtien());
    }
}
