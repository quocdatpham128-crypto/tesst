package com.example.tesst

import java.io.Serializable

data class KhoanChi_205(
    var tenKhoanChi_205: String,
    var soTien_205: Double,
    var ghiChu_205: String,
    var daThanhToan_205: Boolean
) : Serializable {
    fun layThongTin_205(): String {
        val trangThai = if (daThanhToan_205) "Đã thanh toán" else "Chưa thanh toán"
        return "Tên khoản chi: $tenKhoanChi_205\nSố tiền: $soTien_205 VNĐ\nGhi chú: $ghiChu_205\nTrạng thái: $trangThai"
    }
}