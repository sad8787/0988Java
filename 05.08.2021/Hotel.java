public class Hotel {
    Room[] rooms;

    public Hotel(Room[] rooms) {
        this.rooms = rooms;
    }

    public void getFreeRooms(){
        String result = "Свободные комнаты:";
        for (int i = 0; i < this.rooms.length; i++) {
            if(!this.rooms[i].isReserved()){
                result += (this.rooms[i].getRoomNumber()+" ");
            }
        }
        System.out.println(result);
    }
    // рассмотрим пример для параметраметров getFreeRooms(true, 0, false, true, 2)
    public void getFreeRooms(boolean wc, int sleepinPlace, boolean conditioner, boolean wifi, int serviceCount){
        String result = "По данному запросу найдены комнаты: ";
        for (int i = 0; i < rooms.length; i++) {
            if(this.rooms[i].valueMark( wc, sleepinPlace,conditioner, wifi)==serviceCount && !this.rooms[i].isReserved()){
                result+=this.rooms[i].getRoomNumber()+" ";
            }
        }
        System.out.println(result); // Печатаем на экран
    }
    public void reserve(int roomNumber){
        String result = "Ошибка: номер не существует";
        for (int i = 0; i < this.rooms.length; i++) {
            if(this.rooms[i].getRoomNumber() == roomNumber && !this.rooms[i].isReserved()){
                result = ("Номер "+roomNumber+" успешно забронирован");
                rooms[i].setReserved(true);
                break;
            }else if (this.rooms[i].getRoomNumber() == roomNumber && this.rooms[i].isReserved()){
                result = ("Номер "+roomNumber+" занят");
                break;
            }
        }
        System.out.println(result);
    }
    public void getReservedRooms(){
        String result = "Зарезервированные комнаты:";
        for (int i = 0; i < this.rooms.length; i++) {
            if(this.rooms[i].isReserved()){
                result += (this.rooms[i].getRoomNumber()+" ");
            }
        }
        System.out.println(result);
    }
    public void evacuateRoom(int number){
        for (int i=0;i<this.rooms.length;i++){
            if (rooms[i].getRoomNumber()==number){rooms[i].setReserved(false);
                break;
            }
        }
    }
}
