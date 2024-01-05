-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th7 13, 2023 lúc 05:18 AM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qldatban`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `banan`
--

CREATE TABLE `banan` (
  `soban` int(3) NOT NULL,
  `trangthai` text NOT NULL DEFAULT 'Empty'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `banan`
--

INSERT INTO `banan` (`soban`, `trangthai`) VALUES
(1, 'Empty'),
(2, 'busy'),
(3, 'Empty'),
(4, 'busy'),
(5, 'busy'),
(6, 'Empty'),
(7, 'busy'),
(8, 'busy'),
(9, 'Empty');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ban_order`
--

CREATE TABLE `ban_order` (
  `banso` int(11) NOT NULL,
  `monan_id` int(11) NOT NULL,
  `tenMonAn` text NOT NULL,
  `soluong` int(11) NOT NULL,
  `dongia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `ban_order`
--

INSERT INTO `ban_order` (`banso`, `monan_id`, `tenMonAn`, `soluong`, `dongia`) VALUES
(0, 1, 'Lẩu Thái', 2, 259000),
(4, 2, 'Thịt Luộc', 1, 50000),
(4, 1, 'Lẩu Thái', 1, 259000),
(5, 1, 'Lẩu Thái', 1, 259000),
(8, 1, 'Lẩu Thái', 1, 259000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `datban`
--

CREATE TABLE `datban` (
  `banso` int(11) NOT NULL,
  `tenKhachHang` text NOT NULL,
  `sdtKhachHang` text NOT NULL,
  `thoigian` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `datban`
--

INSERT INTO `datban` (`banso`, `tenKhachHang`, `sdtKhachHang`, `thoigian`) VALUES
(3, 'Minh', '123456', '2023-07-17 17:44:05'),
(1, 'Minh', '123465', '2023-07-15 19:00:00'),
(9, 'Sơn', '123456789', '2023-07-14 15:00:00'),
(4, 'Đức', '456789123', '2023-07-13 00:00:00');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `hoadon_id` int(11) NOT NULL,
  `banso` int(11) NOT NULL,
  `tongtien` int(11) NOT NULL,
  `thoigian` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`hoadon_id`, `banso`, `tongtien`, `thoigian`) VALUES
(1, 1, 50000, '2023-07-11 13:42:26'),
(2, 1, 2590000, '2023-07-11 14:28:35'),
(4, 3, 309000, '2023-07-11 14:30:24'),
(5, 7, 238000, '2023-07-12 21:35:24'),
(6, 2, 781000, '2023-07-12 22:55:11');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `nv_id` int(11) NOT NULL,
  `tenNhanVien` text NOT NULL,
  `username` text NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`nv_id`, `tenNhanVien`, `username`, `password`) VALUES
(1, 'Nguyễn Anh Minh', 'minhnguyen123', '123456a');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thucdon`
--

CREATE TABLE `thucdon` (
  `monan_id` int(11) NOT NULL,
  `tenMonAn` text NOT NULL,
  `giaMonAn` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `thucdon`
--

INSERT INTO `thucdon` (`monan_id`, `tenMonAn`, `giaMonAn`) VALUES
(1, 'Lẩu Thái', 259000),
(2, 'Thịt Luộc', 50000),
(3, 'Salad cà chua', 79000),
(5, 'Gà rán', 149000),
(6, 'Gà hầm thuốc bắc', 189000),
(7, 'Gà luộc', 119000),
(8, 'Gà nướng ', 159000),
(9, 'Chân gà rút xương', 139000),
(10, 'Gà xào xả ớt', 149000),
(11, 'Gà chiên mắm tỏi', 145000);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `banan`
--
ALTER TABLE `banan`
  ADD PRIMARY KEY (`soban`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`hoadon_id`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`nv_id`);

--
-- Chỉ mục cho bảng `thucdon`
--
ALTER TABLE `thucdon`
  ADD PRIMARY KEY (`monan_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `banan`
--
ALTER TABLE `banan`
  MODIFY `soban` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `hoadon_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `nv_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `thucdon`
--
ALTER TABLE `thucdon`
  MODIFY `monan_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
