package com.example.tesst

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.tesst.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding_205: ActivityMainBinding
    private var khoanChiHienTai_205: KhoanChi_205? = null

    private val boPhucVuKetQua_205 = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val data_205 = result.data
            khoanChiHienTai_205 = data_205?.getSerializableExtra("khoan_chi_moi") as? KhoanChi_205
            Toast.makeText(this, "Cập nhật dữ liệu thành công!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding_205 = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding_205.root)

        supportActionBar?.title = "Quản lý chi phí cá nhân"

        xuLySuKienClick_205()
    }

    private fun xuLySuKienClick_205() {
        binding_205.btnThemKhoanChi205.setOnClickListener {
            val ten_205 = binding_205.edtTenKhoanChi205.text.toString().trim()
            val soTienStr_205 = binding_205.edtSoTien205.text.toString().trim()
            val ghiChu_205 = binding_205.edtGhiChu205.text.toString().trim()
            val trangThai_205 = binding_205.chkDaThanhToan205.isChecked

            if (ten_205.isNotEmpty() && soTienStr_205.isNotEmpty()) {
                val soTien_205 = soTienStr_205.toDouble()
                khoanChiHienTai_205 = KhoanChi_205(ten_205, soTien_205, ghiChu_205, trangThai_205)
                Toast.makeText(this, "Đã thêm khoản chi thành công!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Vui lòng nhập đầy đủ tên và số tiền!", Toast.LENGTH_SHORT).show()
            }
        }

        binding_205.btnXemChiTiet205.setOnClickListener {
            if (khoanChiHienTai_205 != null) {
                val intentChiTiet_205 = Intent(this, ChiTietChiTieuActivity::class.java)
                intentChiTiet_205.putExtra("obj_khoan_chi", khoanChiHienTai_205)
                boPhucVuKetQua_205.launch(intentChiTiet_205)
            } else {
                Toast.makeText(this, "Chưa có khoản chi nào được tạo!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}