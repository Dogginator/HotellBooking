
package bookinghotell;



public class RoomType {
   private String roomType;
   private String price;
   private String ac;
   private String breakfast;
   private String bedType;
   private String conntinue;
   
   
   public RoomType(String bedType, String breakfast, String ac, String price, String conntinue){
       this.bedType = bedType;
       this.breakfast = breakfast;
       this.ac = ac;
       this.price = price;
       this.conntinue = conntinue;
   }


    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAc() {
        return ac;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public String getConntinue() {
        return conntinue;
    }

    public void setConntinue(String conntinue) {
        this.conntinue = conntinue;
    }
   
   
   
   
   
}
