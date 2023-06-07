using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using WpfApp1.Models;
namespace WpfApp1
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            
        }
        QLBanHangContext db = new QLBanHangContext();
        //load du lieu len datagrid
        private void hienThiDuLieu()
        {
            var query = from sp in db.SanPhams
                        select new
                        {
                            sp.MaSp,
                            sp.TenSp,
                            sp.MaLoai,
                            sp.SoLuong,
                            sp.DonGia,
                            ThanhTien = sp.SoLuong * sp.DonGia
                        };
            dgvSanPham.ItemsSource = query.ToList();

        }
        private void hienThiCB()
        {
            var query = from lsp in db.LoaiSanPhams
                        select lsp;
            cboLoai.ItemsSource = query.ToList();
            cboLoai.DisplayMemberPath = "TenLoai";
            cboLoai.SelectedIndex = 0;
            cboLoai.SelectedValuePath = "MaLoai";

        }

        

        private void dgvSanPham_Loaded(object sender, RoutedEventArgs e)
        {
            hienThiDuLieu();
            hienThiCB();
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            //kiểm tra xem trùng mã sp
            var query= db.SanPhams.SingleOrDefault(t=> t.MaSp.Equals(txtMa.Text));
            if(query == null)
            {
                SanPham sp= new SanPham(); 
                sp.MaSp = txtMa.Text;
                sp.TenSp = txtTen.Text;
                sp.DonGia=double.Parse(txtgia.Text);
                sp.SoLuong=int.Parse(txtSL.Text);
                LoaiSanPham dachon = (LoaiSanPham)cboLoai.SelectedItem;
                sp.MaLoai=dachon.MaLoai;
                db.SanPhams.Add(sp);
                db.SaveChanges();
                MessageBox.Show("Them thanh cong", "thong bao");
                hienThiDuLieu();
            }
            else
            {
                MessageBox.Show("SP đã tồn tại", "Thông báo");
            }
        }
        private void btnSua_Click(object sender, RoutedEventArgs e)
        {
            var query = from spSua in db.SanPhams where spSua.MaSp ==(txtMa.Text) select spSua;
            SanPham SPsua = query.FirstOrDefault();
            if (SPsua == null)
            {
                MessageBox.Show("Benh nhan khonng ton tai", "ERROR", MessageBoxButton.OK, MessageBoxImage.Error);

            }
            else
            {
                SPsua.MaSp = txtMa.Text;
                SPsua.TenSp = txtTen.Text;
                LoaiSanPham k = (LoaiSanPham)cboLoai.SelectedItem;
                SPsua.MaLoai = k.MaLoai;
                SPsua.SoLuong = int.Parse(txtSL.Text);
                SPsua.DonGia =double.Parse( txtgia.Text);

                db.SaveChanges();
                hienThiDuLieu();
            }
        }
        

        private void dgvSanPham_SelectedCellsChanged(object sender, SelectedCellsChangedEventArgs e)
        {
            object obj = dgvSanPham.SelectedItem;
            if (obj != null)
            {
                try
                {
                    Type t = dgvSanPham.SelectedItem.GetType();
                    PropertyInfo[] p = t.GetProperties();
                    txtMa.Text = p[0].GetValue(dgvSanPham.SelectedValue).ToString();
                    txtTen.Text = p[1].GetValue(dgvSanPham.SelectedValue).ToString();
                    cboLoai.SelectedValue = p[2].GetValue(dgvSanPham.SelectedValue).ToString();
                    txtgia.Text = p[4].GetValue(dgvSanPham.SelectedValue).ToString();
                    txtSL.Text = p[3].GetValue(dgvSanPham.SelectedValue).ToString();
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Loi" + ex.Message);
                }
            }
        }

        private void Button_Click_Xoa(object sender, RoutedEventArgs e)
        {
            var query = from spXoa in db.SanPhams where spXoa.MaSp == txtMa.Text select spXoa;
            SanPham spx = query.FirstOrDefault();
            if (spx == null)
            {
                MessageBox.Show("benh nhan khong ton tai");
            }
            else
            {
                MessageBoxResult tb = MessageBox.Show("Ban co chac muon xoa", "Thong Bao", MessageBoxButton.YesNo, MessageBoxImage.Question);
                if (tb == MessageBoxResult.Yes)
                {
                    db.SanPhams.Remove(spx);
                    db.SaveChanges();
                    hienThiDuLieu();
                }



            }
        }

        private void Button_Click_Tim(object sender, RoutedEventArgs e)
        {
            
                Window1 myw = new Window1();
                myw.ShowDialog();
            
        }
    }
}
