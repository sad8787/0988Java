import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel(new Room[]{
                new Room(true, 2, true, true, 11),
                new Room(true, 3, true, true, 12),
                new Room(true, 2, false,false, 13),
                new Room(false, 1, false, false, 14),
                new Room(true, 4, true, true, 21),
                new Room(true, 3, false, false, 22),
                new Room(false,3, false, false, 23),
                new Room(true, 4, true, false, 24),
                new Room(true, 4, true, true, 31),
                new Room(true, 1, false, false, 32),
                new Room(false,1, false, false, 33),
                new Room(true, 4, true, false, 34),

        });
        String commands = "*----*\n" +
                "getFreeRooms (wc:[true|false]) (sleepingPlace:[кол-во мес]) (conditioner:[true|false]) (wifi:[true|false]))- показать все свободные комнтаы\n" +
                "reserve [номер комнаты] забронировать номер\n" +
                "getReservedRooms - показать зарезервированные номера\n" +
                "evacuate [номер комнаты]  освободить номер\n" +
                "*----*";
        System.out.println(commands);
        System.out.println("Введите команду:");

        //String command = scanner.nextLine();

        String[] command = scanner.nextLine().split(" ");
        while (!command[0].equals("exit")) {
            if(command[0].equals("getReservedRooms")){
                hotel.getReservedRooms();
            }
            else if(command[0].equals("getFreeRooms")){
                if(command.length==1){hotel.getFreeRooms();}
                else if (command.length==6){
                    try{
                        hotel.getFreeRooms((command[1]=="true"), Integer.parseInt(command[2]), (command[3]=="true"),(command[4]=="true"), Integer.parseInt(command[5]));
                    }catch (Exception e){
                        System.out.println(e.toString());
                    }
                }
            }
            else if(command[0].equals("reserve")){
                if(command.length==1){
                    hotel.getFreeRooms();
                    System.out.println("введите reserve, пробел и номер комнаты или любую другую команду");
                }
                else if (command.length==2){hotel.reserve(Integer.parseInt(command[1]));}
            }
            else if (command[0].equals("evacuate")){
                if (command.length==2){
                    hotel.evacuateRoom(Integer.parseInt(command[1]));
                }
                else{
                    hotel.getReservedRooms();
                    System.out.println("введите evacuate, пробел и номер комнаты или любую другую команду");
                }
            }
            else{
                System.out.println("Ошибка: неизавестаная команда.\nСписок доступных команд:\n"+commands);
            }
            command = scanner.nextLine().split(" ");
        }
    }
}
