package com.giangvt2008110143.KiemTraCuoiKi;

import java.util.Scanner;
import java.util.ArrayList; // import the ArrayList class
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

public class ChuongTrinhQuanLyHangHoa {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		ArrayList<HangHoa> list_hang_hoa = new ArrayList<HangHoa>(); // Create an ArrayList object
		AddRecord(list_hang_hoa);
		int choice;
		while (true) {
			Menu();
			choice = IntInput("lựa chọn");
			if (choice == 1) {
			//NHẬP LOẠI HÀNG
				System.out.println("Nhập loại hàng");
				String type;
				while (true) {
					System.out.println("1: thực phẩm");
					System.out.println("2: sành sứ");
					System.out.println("3: điện máy");
					int type_choice = IntInput("loại lựa chọn");
					if (type_choice == 1) {
						type = "thực phẩm";
						break;
					} else if (type_choice == 2) {
						type = "sành sứ";
						break;
					} else if (type_choice == 3) {
						type = "điện máy";
						break;
					} else {
						System.out.println("Nhập sai lựa chọn");
						continue;
					}
				}
				
			String name = StringInput("tên hàng hóa");
			int price = IntInput("giá tiền");
			int so_luong = IntInput("số lượng");
			String Date = DateInput("ngày nhập");
			HangHoa new_1 = new HangHoa(type,name,price,so_luong,Date);
			list_hang_hoa.add(new_1);
			System.out.println("Thêm hàng hóa thành công!!");
			}
			
			else if(choice == 2) {
				System.out.println("------------------Sửa------------------");
				int id = IntInput("id hàng hóa");
				for (HangHoa i : list_hang_hoa) {
					if (i.hang_hoa_ID == id) {
						XuatThongTinHang(i);
//						NHẬP LOẠI HÀNG
						System.out.println("Nhập loại hàng mới");
						String new_type;
						while (true) {
							System.out.println("1: thực phẩm");
							System.out.println("2: sành sứ");
							System.out.println("3: điện máy");
							int type_choice = IntInput("loại lựa chọn");
							if (type_choice == 1) {
								new_type = "thực phẩm";
								break;
							} else if (type_choice == 2) {
								new_type = "sành sứ";
								break;
							} else if (type_choice == 3) {
								new_type = "điện máy";
								break;
							} else {
								System.out.println("Nhập sai lựa chọn");
								continue;
							}
						}
						String new_name = StringInput("Nhập tên hàng mới: ");
						int new_price = IntInput("giá tiền mới");
						int new_so_luong = IntInput("số lượng mới");
						String new_date = DateInput("ngày nhập mới");
						i.setName(new_name);
						i.setType(new_type);
						i.setSo_luong(new_so_luong);
						i.setPrice(new_price);
						i.setDate(new_date);
						System.out.println("Sửa hàng hóa thành công");
						break;
					} else if(list_hang_hoa.indexOf(i) < list_hang_hoa.size()) {
						continue;
					} else {
						System.out.println("Không tìm thấy hàng hóa");
					}
				}
			}
			else if(choice == 3) {
				System.out.println("------------------Xóa------------------");
				int id = IntInput("id hàng hóa");
				int index;
				for (HangHoa i : list_hang_hoa) {
					if (i.hang_hoa_ID == id) {
						index = list_hang_hoa.indexOf(i);
						list_hang_hoa.remove(index);
						System.out.println("Xóa thành công");
						break;
					}
				}			
			}
			else if(choice == 4) {
				while (true) {
					System.out.println("------------------Tìm kiếm------------------");
					System.out.println("1.Tìm kiếm theo loại hàng");
					System.out.println("2.Tìm kiếm theo khoảng giá");
					System.out.println("3.Tìm kiếm theo ngày");
					System.out.println("4.Quay về Menu");
					int search_choice = IntInput("lựa chọn");
					
					if (search_choice == 1) {
						System.out.println("Nhập loại hàng cần tìm");
						String search_type;
						while (true) {
							System.out.println("1: thực phẩm");
							System.out.println("2: sành sứ");
							System.out.println("3: điện máy");
							int type_choice = IntInput("loại lựa chọn");
							if (type_choice == 1) {
								search_type = "thực phẩm";
								break;
							} else if (type_choice == 2) {
								search_type = "sành sứ";
								break;
							} else if (type_choice == 3) {
								search_type = "điện máy";
								break;
							} else {
								System.out.println("Nhập sai lựa chọn");
								continue;
							}
						}
						for (HangHoa i : list_hang_hoa) {
							if (i.type == search_type) {
								XuatThongTinHang(i);
							}
						}
					} else if(search_choice == 2) {
						int min_price = IntInput("giá thấp nhất");
						int max_price = IntInput("giá cao nhất");
						for (HangHoa i : list_hang_hoa) {
							if (min_price <= i.price && i.price <= max_price ) {
								XuatThongTinHang(i);
							}
						}
					} else if(search_choice == 3) {
						String start_date = DateInput("ngày bắt đầu");
						String end_date = DateInput("ngày kết thúc");
						Date date1 = sdf.parse(start_date);
						Date date2 = sdf.parse(end_date);
						for (HangHoa i : list_hang_hoa) {
							Date date = sdf.parse(i.date);
							if (date1.before(date)==true && date2.after(date)==true){
								XuatThongTinHang(i);
							} else if(date1.equals(date)==true || date2.equals(date)) {
								XuatThongTinHang(i);
							}
						}
					} else if(search_choice == 4) {
						break;
					} else {
						continue;
					}
				}

				
			}
			else if(choice == 5) {
				System.out.println("------------------Sắp xếp hàng hóa------------------");
				ArrayList<HangHoa> thuc_pham_list = new ArrayList<HangHoa>();
				ArrayList<HangHoa> sanh_su_list = new ArrayList<HangHoa>();
				ArrayList<HangHoa> dien_may_list = new ArrayList<HangHoa>();
				
				for (HangHoa i : list_hang_hoa) {
					if (i.type == "thực phẩm") {
						thuc_pham_list.add(i);
					} else if(i.type == "sành sứ") {
						sanh_su_list.add(i);
					} else {
						dien_may_list.add(i);
					}
				}
				
				HangHoa [] thuc_pham_list_2 = thuc_pham_list.toArray(new HangHoa[thuc_pham_list.size()]);
				HangHoa [] sanh_su_list_2 = sanh_su_list.toArray(new HangHoa[sanh_su_list.size()]);
				HangHoa [] dien_may_list_2 = dien_may_list.toArray(new HangHoa[dien_may_list.size()]);
				
				while (true) {
					System.out.println("1. Sắp xếp theo giá tăng");
					System.out.println("2. Sắp xếp theo giá giảm");
					System.out.println("3. Sắp xếp theo ngày tăng");
					System.out.println("4. Sắp xếp theo ngày giảm");
					System.out.println("5. Quay về Menu");
					int sort_choice = IntInput("loại sắp xếp");
					if (sort_choice == 1) {
						SapXepGiaTang(thuc_pham_list);
						SapXepGiaTang(sanh_su_list);
						SapXepGiaTang(dien_may_list);
						System.out.println("-------------------Thực Phẩm-------------------");
						for (HangHoa i : thuc_pham_list) {
							XuatThongTinHang(i);
						}
						System.out.println("-------------------Sành Sứ-------------------");
						for (HangHoa i : sanh_su_list) {
							XuatThongTinHang(i);
						}
						System.out.println("-------------------Điện Máy-------------------");
						for (HangHoa i : dien_may_list) {
							XuatThongTinHang(i);
						}
					} else if(sort_choice == 2) {
						SapXepGiaGiam(thuc_pham_list);
						SapXepGiaGiam(sanh_su_list);
						SapXepGiaGiam(dien_may_list);
						System.out.println("-------------------Thực Phẩm-------------------");
						for (HangHoa i : thuc_pham_list) {
							XuatThongTinHang(i);
						}
						System.out.println("-------------------Sành Sứ-------------------");
						for (HangHoa i : sanh_su_list) {
							XuatThongTinHang(i);
						}
						System.out.println("-------------------Điện Máy-------------------");
						for (HangHoa i : dien_may_list) {
							XuatThongTinHang(i);
						}
					} else if (sort_choice==3) {
						SapXepNgayTang(thuc_pham_list_2);
						SapXepNgayTang(sanh_su_list_2);
						SapXepNgayTang(dien_may_list_2);
						System.out.println("-------------------Thực Phẩm-------------------");
						for (int i = 0; i < thuc_pham_list_2.length; i++) {
							XuatThongTinHang(thuc_pham_list_2[i]);
						}
						System.out.println("-------------------Sành Sứ-------------------");
						for (int i = 0; i < sanh_su_list_2.length; i++) {
							XuatThongTinHang(sanh_su_list_2[i]);
						}
						System.out.println("-------------------Điện Máy-------------------");
						for (int i = 0; i < dien_may_list_2.length; i++) {
							XuatThongTinHang(dien_may_list_2[i]);
						}
					} else if (sort_choice==4) {
						SapXepNgayGiam(thuc_pham_list_2);
						SapXepNgayGiam(sanh_su_list_2);
						SapXepNgayGiam(dien_may_list_2);
						System.out.println("-------------------Thực Phẩm-------------------");
						for (int i = 0; i < thuc_pham_list_2.length; i++) {
							XuatThongTinHang(thuc_pham_list_2[i]);
						}
						System.out.println("-------------------Sành Sứ-------------------");
						for (int i = 0; i < sanh_su_list_2.length; i++) {
							XuatThongTinHang(sanh_su_list_2[i]);
						}
						System.out.println("-------------------Điện Máy-------------------");
						for (int i = 0; i < dien_may_list_2.length; i++) {
							XuatThongTinHang(dien_may_list_2[i]);
						}
					} else if(sort_choice == 5) {
						break;
					} else {
						continue;
					}
				}
			}
			else if(choice == 6) {
				System.out.println("------------------Xem thống kê------------------");
				int TongSoLuongHangHoa = 0;
				int TongGiaTriNhapHang = 0;
				int SoLuongHangThucPham = 0;
				int SoLuongHangSanhSu = 0;
				int SoLuongHangDienMay = 0;
				for (HangHoa i : list_hang_hoa) {
					TongSoLuongHangHoa = TongSoLuongHangHoa + i.so_luong;
					int gia_tri = i.so_luong*i.price;
					TongGiaTriNhapHang = TongGiaTriNhapHang + gia_tri;
					if (i.type == "thực phẩm") {
						SoLuongHangThucPham = SoLuongHangThucPham+i.so_luong;
					} else if (i.type == "sành sứ") {
						SoLuongHangSanhSu = SoLuongHangSanhSu+i.so_luong;
					} else {
						SoLuongHangDienMay = SoLuongHangDienMay+i.so_luong;
					}
				}
				System.out.println("Tổng số lượng hàng hóa: "+Integer.toString(TongSoLuongHangHoa));
				System.out.println("Tổng giá trị nhập kho: "+Integer.toString(TongGiaTriNhapHang));
				System.out.println("Số lượng hàng thực phẩm: "+Integer.toString(SoLuongHangThucPham));
				System.out.println("Số lượng hàng sành sứ: "+Integer.toString(SoLuongHangSanhSu));
				System.out.println("Số lượng hàng điện máy: "+Integer.toString(SoLuongHangDienMay));
				System.out.println("---------------------------------------------------");
			}
			else if(choice == 7) {
				System.out.println("------------------Thoát------------------");
			}
			else{
				System.out.println("Nhập sai");
			}
			
		}

	}
	
	static void Menu() {
		System.out.println("-------------------------Chương Trình Quản Lý Hàng Hóa-------------------------");
		System.out.println("Nhập 1 để: Thêm hàng hóa");
		System.out.println("Nhập 2 để: Sửa hàng hóa");
		System.out.println("Nhập 3 để: Xóa hàng hóa");
		System.out.println("Nhập 4 để: Tìm kiếm hàng hóa");
		System.out.println("Nhập 5 để: Sắp xếp hàng hóa");
		System.out.println("Nhập 6 để: Xem thống kê");
		System.out.println("Nhập 7 để: Thoát");
		System.out.println();
	}
	
	static void XuatThongTinHang(HangHoa a) {
		System.out.println("--------------------------------------");
		System.out.println("Mã hàng: "+a.hang_hoa_ID);
		System.out.println("Tên hàng: "+a.getName());
		System.out.println("Loại hàng: "+a.getType());
		System.out.println("Giá: "+a.getPrice()+"đ");
		System.out.println("Số lượng: "+a.getSo_luong());
		System.out.println("Ngày nhập: "+a.getDate());
		System.out.println("--------------------------------------");
		System.out.println();
	}
	
	static int IntInput(String title) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Vui lòng nhập "+title+" : ");
		while(!sc.hasNextInt()) {
			System.out.print("Nhập sai vui lòng nhập lại "+title+": ");
			sc.next();
		}
		int value = sc.nextInt();
		return value;
	}
	
	static String StringInput(String title) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Vui lòng nhập "+title+" : ");
		while(!sc.hasNextLine()) {
			System.out.print("Nhập sai vui lòng nhập lại "+title+": ");
			sc.next();
		}
		String value = sc.nextLine();
		return value;
	}
	
	static String DateInput(String title) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Vui lòng nhập "+title+" : ");
		String dd,mm,yyyy;
		while (true) {
				dd = Integer.toString(IntInput("ngày"));
				if (dd.length()==2) {
					break;
				} else {
					System.out.println("Nhập sai vui lòng nhập lại!");
					continue;
				}
			}
		
		while (true) {
				mm = Integer.toString(IntInput("tháng"));
				if (mm.length()==2) {
					break;
				} else {
					System.out.println("Nhập sai vui lòng nhập lại!");
					continue;
				}
			}
		
		while (true) {
				yyyy = Integer.toString(IntInput("năm"));
				if (yyyy.length()==4) {
					break;
				} else {
					System.out.println("Nhập sai vui lòng nhập lại!");
					continue;
				}
			}
		String result = dd+"-"+mm+"-"+yyyy;
		return result;
	}
	
	static void AddRecord(ArrayList<HangHoa> list) {
		HangHoa new_1 = new HangHoa("thực phẩm","Snack Khoai Tay",6000,100,"15-10-2021");
		list.add(new_1);
		HangHoa new_2 = new HangHoa("thực phẩm","Bò Đóng Hộp",35000,150,"18-10-2021");
		list.add(new_2);
		HangHoa new_3 = new HangHoa("thực phẩm","Pizza Đóng Hộp",50000,80,"18-10-2021");
		list.add(new_3);
		HangHoa new_4 = new HangHoa("thực phẩm","Cơm Cuộn",25000,200,"19-10-2021");
		list.add(new_4);
		HangHoa new_5 = new HangHoa("thực phẩm","Bánh Mì Kebap",30000,150,"20-10-2021");
		list.add(new_5);
		HangHoa new_6 = new HangHoa("thực phẩm","Nho Đóng Hộp",70000,150,"22-10-2021");
		list.add(new_6);
		HangHoa new_7 = new HangHoa("thực phẩm","Xúc Xích CP",18000,200,"25-10-2021");
		list.add(new_7);
		HangHoa new_8 = new HangHoa("sành sứ","Bộ Chén 6",200000,160,"26-10-2021");
		list.add(new_8);
		HangHoa new_9 = new HangHoa("sành sứ","Bộ Ly Trà",175000,200,"26-10-2021");
		list.add(new_9);
		HangHoa new_10 = new HangHoa("sành sứ","Bình Hoa",275000,100,"27-10-2021");
		list.add(new_10);
		HangHoa new_11 = new HangHoa("sành sứ","Bộ Dĩa",150000,100,"28-10-2021");
		list.add(new_11);
		HangHoa new_12 = new HangHoa("sành sứ","Chảo Sứ",189000,266,"30-10-2021");
		list.add(new_12);
		HangHoa new_13 = new HangHoa("sành sứ","Nồi Sứ",175000,150,"01-11-2021");
		list.add(new_13);
		HangHoa new_14 = new HangHoa("sành sứ","Bộ Vật Trang Trí",350000,100,"02-11-2021");
		list.add(new_14);
		HangHoa new_15 = new HangHoa("điện máy","TV LG",6000000,100,"03-11-2021");
		list.add(new_15);
		HangHoa new_16 = new HangHoa("điện máy","TV Sony",7500000,100,"03-11-2021");
		list.add(new_16);
		HangHoa new_17 = new HangHoa("điện máy","Máy Lạnh LG",7200000,150,"04-11-2021");
		list.add(new_17);
		HangHoa new_18 = new HangHoa("điện máy","Tủ Lạnh LG",10150000,100,"05-11-2021");
		list.add(new_18);
		HangHoa new_19 = new HangHoa("điện máy","Nồi Chiên",2300000,200,"06-11-2021");
		list.add(new_19);
		HangHoa new_20 = new HangHoa("điện máy","Bếp Điện",4000000,120,"07-11-2021");
		list.add(new_20);
	}
	
	static void SapXepGiaTang(ArrayList<HangHoa> list) {
		Collections.sort(list, new Comparator<HangHoa>(){

			@Override
			public int compare(HangHoa o1, HangHoa o2) {
				// TODO Auto-generated method stub
				return o1.price - o2.price;
			}

		});
	}
	
	static void SapXepGiaGiam(ArrayList<HangHoa> list) {
		Collections.sort(list, new Comparator<HangHoa>(){

			@Override
			public int compare(HangHoa o1, HangHoa o2) {
				// TODO Auto-generated method stub
				return o2.price - o1.price;
			}

		});
	}
	
	static void SapXepNgayTang(HangHoa [] list) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		HangHoa temp = list[0];
		for (int i = 0; i < list.length -1; i++) {
			for (int j = i + 1; j < list.length; j++) {
				Date date1 = sdf.parse(list[i].date);
				Date date2 = sdf.parse(list[j].date);
				if (date1.after(date2)==true) {
					temp = list[j];
					list[j] = list[i];
					list[i] = temp;
					
				}
			}
		}
	}
	
	static void SapXepNgayGiam(HangHoa [] list) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		HangHoa temp = list[0];
		for (int i = 0; i < list.length -1; i++) {
			for (int j = i + 1; j < list.length; j++) {
				Date date1 = sdf.parse(list[i].date);
				Date date2 = sdf.parse(list[j].date);
				if (date1.before(date2)==true) {
					temp = list[j];
					list[j] = list[i];
					list[i] = temp;
					
				}
			}
		}
    }
}

