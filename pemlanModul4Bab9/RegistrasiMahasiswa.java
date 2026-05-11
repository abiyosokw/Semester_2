package pemlanModul4Bab9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrasiMahasiswa extends JFrame {
    private JTextField txtNama, txtTglLahir, txtNoDaftar, txtNoTelp, txtEmail;
    private JTextArea txtAlamat;
    private JButton btnSubmit;

    public RegistrasiMahasiswa() {
        setTitle("Form Daftar Ulang Mahasiswa Baru");
        setSize(450, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(new Color(230, 235, 255));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtNama = new JTextField(20);
        txtTglLahir = new JTextField(20);
        txtNoDaftar = new JTextField(20);
        txtNoTelp = new JTextField(20);
        txtAlamat = new JTextArea(4, 20);
        txtAlamat.setLineWrap(true);
        txtEmail = new JTextField(20);
        btnSubmit = new JButton("Submit");

        addComponent(0, "Nama Lengkap:", txtNama, gbc);
        addComponent(1, "Tanggal Lahir:", txtTglLahir, gbc);
        addComponent(2, "Nomor Pendaftaran:", txtNoDaftar, gbc);
        addComponent(3, "No. Telp:", txtNoTelp, gbc);
        
        gbc.gridy = 4; gbc.gridx = 0;
        add(new JLabel("Alamat:"), gbc);
        gbc.gridx = 1;
        add(new JScrollPane(txtAlamat), gbc);

        addComponent(5, "E-mail:", txtEmail, gbc);

        gbc.gridy = 6; gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(btnSubmit, gbc);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prosesSubmit();
            }
        });
    }

    private void addComponent(int y, String label, Component comp, GridBagConstraints gbc) {
        gbc.gridy = y;
        gbc.gridx = 0;
        add(new JLabel(label), gbc);
        gbc.gridx = 1;
        add(comp, gbc);
    }

    private void prosesSubmit() {
        if (txtNama.getText().isEmpty() || txtTglLahir.getText().isEmpty() || 
            txtNoDaftar.getText().isEmpty() || txtNoTelp.getText().isEmpty() || 
            txtAlamat.getText().isEmpty() || txtEmail.getText().isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "Semua kolom harus terisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int response = JOptionPane.showConfirmDialog(this, 
            "Apakah anda yakin data yang Anda isi sudah benar?", 
            "Konfirmasi", JOptionPane.OK_CANCEL_OPTION);

        if (response == JOptionPane.OK_OPTION) {
            tampilkanData();
        }
    }

    private void tampilkanData() {
        JFrame frameData = new JFrame("Data Mahasiswa");
        frameData.setSize(400, 350);
        frameData.setLocationRelativeTo(this);
        
        JTextArea areaData = new JTextArea();
        areaData.setEditable(false);
        areaData.setFont(new Font("Monospaced", Font.PLAIN, 13));
        areaData.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String hasil = String.format(
            "Nama            : %s\n" +
            "Tanggal Lahir   : %s\n" +
            "No. Pendaftaran : %s\n" +
            "No. Telp        : %s\n" +
            "Alamat          : %s\n" +
            "E-mail          : %s",
            txtNama.getText(), txtTglLahir.getText(), txtNoDaftar.getText(),
            txtNoTelp.getText(), txtAlamat.getText(), txtEmail.getText()
        );

        areaData.setText(hasil);
        frameData.add(new JScrollPane(areaData));
        frameData.setVisible(true);
        this.dispose(); 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegistrasiMahasiswa().setVisible(true));
    }
}