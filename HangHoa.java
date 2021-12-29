package com.giangvt2008110143.KiemTraCuoiKi;

public class HangHoa {
    private static int count = 0;
        int hang_hoa_ID;
        String type;
        String name;
        int price;
        int so_luong;
        String date;
        
        public HangHoa(String type, String name, int price, int so_luong, String date) {
            super();
            this.type = type;
            this.name = name;
            this.price = price;
            this.so_luong = so_luong;
            this.date = date;
            this.hang_hoa_ID = ++count;
        }
    
        public String getType() {
            return type;
        }
    
        public void setType(String type) {
            this.type = type;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public int getPrice() {
            return price;
        }
    
        public void setPrice(int price) {
            this.price = price;
        }
    
        public int getSo_luong() {
            return so_luong;
        }
    
        public void setSo_luong(int so_luong) {
            this.so_luong = so_luong;
        }
    
        public String getDate() {
            return date;
        }
    
        public void setDate(String date) {
            this.date = date;
        }
        
    }
