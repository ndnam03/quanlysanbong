package view.panel.viewApp;

import entity.User;
import utils.UserSession;
import view.panel.BaoCao;
import view.panel.DangKyTaiKhoan;
import view.panel.DanhSachGioLam;

import view.panel.DatSanView;
import view.panel.DoiMatKhau;
import view.panel.ThanhToanHoaDon;

import view.panel.HoaDonChiTiet;
import view.panel.QuanLySan;
import view.panel.ThongKe;
import view.panel.ThongKeTongTien;

/**
 *
 * @author ACER
 */
public class App extends javax.swing.JFrame {

    /**
     * Creates new form App
     */
    public App() {

        initComponents();
        User user = UserSession.getCurrentUser();

        if (user.getRole().equalsIgnoreCase("admin")) {
            QuanLySan quanLySan = new QuanLySan();
            tab.add("Quản Lý Sân", quanLySan);
            ThongKe thongKe = new ThongKe();
            tab.add("Thống Kê", thongKe);
            HoaDonChiTiet thanhToanHoaDon = new HoaDonChiTiet();
            tab.add("Hóa Đơn", thanhToanHoaDon);
            ThanhToanHoaDon hoaDonChiTiet = new ThanhToanHoaDon();
            tab.add("Hóa Đơn Chi Tiết", hoaDonChiTiet);
            DangKyTaiKhoan dangKyTaiKhoan = new DangKyTaiKhoan();
            tab.add("Đăng Ký Tài Khoản", dangKyTaiKhoan);
            DoiMatKhau doiMatKhau = new DoiMatKhau();
            tab.add("Đổi Mật Khẩu", doiMatKhau);
            DanhSachGioLam danhSachGioLam = new DanhSachGioLam();
            tab.add("Giờ Làm", danhSachGioLam);

        } else {
            DatSanView datSan = new DatSanView();
            tab.add("Dat San", datSan);
            ThanhToanHoaDon thanhToanHoaDon = new ThanhToanHoaDon();
            tab.add("Hóa Đơn ", thanhToanHoaDon);
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            tab.add("Hóa Đơn Chi Tiết", hoaDonChiTiet);

            BaoCao baoCao = new BaoCao();
            tab.add("Báo Cáo", baoCao);
            DoiMatKhau doiMatKhau = new DoiMatKhau();
            tab.add("Đổi Mật Khẩu", doiMatKhau);
        }

        this.setLocationRelativeTo(this);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tab = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tab.setBackground(new java.awt.Color(0, 255, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(tab, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new App().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane tab;
    // End of variables declaration//GEN-END:variables
}
