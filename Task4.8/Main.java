import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Room[] rooms = {
                new Room((byte) 1,false,false,true,(byte) 11),
                new Room((byte) 2,true,true,false,(byte) 12),
                new Room((byte) 1,false,true,true,(byte) 13),
                new Room((byte) 3,true,false,false,(byte) 21),
                new Room((byte) 2,false,false,false,(byte) 22),
                new Room((byte) 1,true,true,true,(byte) 23),
                new Room((byte) 3,false,true,false,(byte) 31),
                new Room((byte) 3,true,true,false,(byte) 32),
                new Room((byte) 1,false,false,true,(byte) 33),
        };
        Hotel hotel = new Hotel(rooms);
        System.out.println("Незанятые комнаты ->  getFreeRooms");
        System.out.println("бронировать комнаты ->  reserveRoom");
        System.out.println("Показать комнаты с WiFi -> WiFi");
        System.out.println("Показать комнаты с EAT -> EAT");
        System.out.println("Показать комнаты с WC -> WC");
        System.out.println("Показать комнаты по кол-ву спальных мест -> спальных мест");
        System.out.println(" Вывести свойства комнаты-> свойства");

        System.out.println("Exit ->  exit");


        Scanner scanner = new Scanner(System.in);
        String command;
        while (true){
            System.out.println("Введите команду");
            command = scanner.nextLine();
            if(command.equals("getFreeRooms")){
                hotel.getFreeRooms();
            }
            else if(command.equals("WiFi")){
                hotel.cWiFi();
            }
            else if(command.equals("EAT")){
                hotel.cEAT();
            }
            else if(command.equals("WC")){
                hotel.cWC();
            }
            else if(command.equals("спальных мест")){
                System.out.print("спальных мест: ");
                byte местNumber = (byte) scanner.nextInt();
                hotel.roomsBynumberOfBeds(местNumber);
            }
            else if(command.equals("свойства")){
                System.out.print("Введите номер комнаты : ");
                byte местNumber = (byte) scanner.nextInt();
                hotel.displayRoomByNomer(местNumber);
            }
            else if(command.equals("reserveRoom")){
                System.out.print("Введите номер комнаты для бронирования: ");
                byte roomNumber = (byte) scanner.nextInt();
                hotel.reserveRoom(roomNumber);
            }else if (command.equals("exit")){
                break;
            }
        }

    }
}
