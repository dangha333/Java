import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

class NhanVien {
    private int id;
    private String ten;
    private int tuoi;

    public NhanVien(int id, String ten, int tuoi) {
        this.id = id;
        this.ten = ten;
        this.tuoi = tuoi;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NhanVien)) return false;
        NhanVien nv = (NhanVien) o;
        return id == nv.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "NV{id=" + id + ", ten='" + ten + "', tuoi=" + tuoi + "}";
    }
}

class Main {

    public static boolean kiemTraTonTai(Set<NhanVien> ds, int id) {
        return ds.contains(new NhanVien(id, "", 0));
    }

    public static void main(String[] args) {

        Set<NhanVien> ds = new HashSet<>();

        ds.add(new NhanVien(1, "An", 25));
        ds.add(new NhanVien(2, "Bình", 30));
        ds.add(new NhanVien(1, "An", 40));
        ds.add(new NhanVien(2, "An", 40));

        System.out.println("Danh sách nhân viên:");
        for (NhanVien nv : ds) {
            System.out.println(nv);
        }

        // ⭐ Nhập ID từ bàn phím
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ID cần kiểm tra: ");
        int idCanTim = sc.nextInt();

        // ⭐ Kiểm tra tồn tại
        if (kiemTraTonTai(ds, idCanTim)) {
            System.out.println("Nhân viên có ID " + idCanTim + " tồn tại trong danh sách.");
        } else {
            System.out.println("Không tìm thấy nhân viên có ID " + idCanTim);
        }
    }
}
