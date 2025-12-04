import java.util.HashSet;
import java.util.Objects;
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
        return id == nv.id;  // So sánh theo id
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // Hash theo id
    }

    @Override
    public String toString() {
        return "NV{id=" + id + ", ten='" + ten + "', tuoi=" + tuoi + "}";
    }
}

class Main {
    public static void main(String[] args) {

        Set<NhanVien> ds = new HashSet<>();

        ds.add(new NhanVien(1, "An", 25));
        ds.add(new NhanVien(2, "Bình", 30));
        ds.add(new NhanVien(1, "An", 40)); // Trùng ID → không thêm
        ds.add(new NhanVien(2, "An", 40));
        System.out.println("Danh sách nhân viên:");
        for (NhanVien nv : ds) {
            System.out.println(nv);
        }
    }
}
