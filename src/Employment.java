import java.util.*;

class Employment implements Comparable<Employment> {
    public int id;
    public String ten;
    public int tuoi;
    public Employment(int id, String ten, int tuoi) {
        this.id = id;
        this.ten = ten;
        this.tuoi = tuoi;
    }
    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Employment o) {
        return Integer.compare(this.id, o.id);
    }


    @Override
    public String toString() {
        return "NV{id=" + id + ", ten='" + ten + "', tuoi=" + tuoi + "}";
    }
}

class Main2 {
    public static boolean kiemTraTonTai(Set<Employment> ds, int id) {
        return ds.contains(new Employment(id, "", 0));
    }
    public static void main(String[] args) {
        Set<Employment> ds = new TreeSet<>(Comparator.comparingInt(Employment::getId));

        ds.add(new Employment(1, "An", 25));
        ds.add(new Employment(2, "Bình", 30));
        ds.add(new Employment(1, "An", 40)); // trùng ID → bị loại
        ds.add(new Employment(2, "An", 40)); // trùng ID → bị loại
        ds.add(new Employment(3, "Cường", 22));


        System.out.println("Danh sách nhân viên (đã sắp xếp theo ID):");
        for (Employment nv : ds) {
            System.out.println(nv);
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ID cần kiểm tra: ");
        int idCanTim = sc.nextInt();

        if (kiemTraTonTai(ds, idCanTim)) {
            System.out.println("Nhân viên có ID " + idCanTim + " tồn tại.");
        } else {
            System.out.println("Không tìm thấy nhân viên có ID " + idCanTim);
        }
    }
}
