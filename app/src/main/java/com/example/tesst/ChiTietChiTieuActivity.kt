package com.example.tesst

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat
import com.example.tesst.databinding.ActivityChiTietChiTieuBinding

class ChiTietChiTieuActivity : AppCompatActivity() {

    private lateinit var binding_205: ActivityChiTietChiTieuBinding
    private var khoanChi_205: KhoanChi_205? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding_205 = ActivityChiTietChiTieuBinding.inflate(layoutInflater)
        setContentView(binding_205.root)

        supportActionBar?.title = "Chi tiết khoản chi"

        khoanChi_205 = IntentCompat.getSerializableExtra(
            intent,
            "obj_khoan_chi",
            KhoanChi_205::class.java
        )

        if (khoanChi_205 != null) {
            hienThiThongTin_205()
        } else {
            Toast.makeText(this, "Không nhận được dữ liệu hợp lệ!", Toast.LENGTH_SHORT).show()
        }

        btnSuaKhoanChiClick_205()
        btnQuayLaiClick_205()
    }

    private fun btnSuaKhoanChiClick_205() {
        binding_205.btnSuaKhoanChi205.setOnClickListener {
            Toast.makeText(this, "Đang cập nhật chi tiết khoản chi", Toast.LENGTH_SHORT).show()
        }
    }

    private fun btnQuayLaiClick_205() {
        binding_205.btnQuayLai205.setOnClickListener {
            val intentTraVe_205 = Intent()
            intentTraVe_205.putExtra("khoan_chi_moi", khoanChi_205)
            setResult(RESULT_OK, intentTraVe_205)
            finish()
        }
    }

    private fun hienThiThongTin_205() {
        binding_205.txtThongTinChiTiet205.text = khoanChi_205?.layThongTin_205()
    }
}