import java.util.Scanner;

public class ManagerPhoneBook {
    static  Scanner scanner = new Scanner(System.in);
    static PhoneBook phoneBook = new PhoneBook();
    static  String name, phone;
    public static void main(String[] args) {
        menu();
        while (true){
            System.out.println("Please choose an option : ");
            int choose  = scanner.nextInt();
            switch (choose){
                case 1: insertPhone();break;
                case 2: removePhone();break;
                case 3: updatePhone(); break;
                case 4: searchPhone(); break;
                case 5: sort(); break;
                case 6: System.exit(0);
                break;
            }
        }

    }
    static  void menu() {
        System.out.println("PHONEBOOK MANAGEMENT SYSTEM");
        System.out.println("1. Insert Phone");
        System.out.println("2. Remove Phone");
        System.out.println("3. Update Phone");
        System.out.println("4. Search Phone");
        System.out.println("5. sort");
        System.out.println("6. Exit");
    }
    private  static  void  removePhone(){
        scanner.nextLine();
        System.out.println("Input name of person you want to remove: ");
        name = scanner.nextLine();
        phoneBook.removePhone(name);
    }
    private  static  void  searchPhone(){
        scanner.nextLine();
        System.out.println("Input name of person you want to search phone:  ");
        name = scanner.nextLine();
        phoneBook.searchPhone(name);
    }
    private  static  void insertPhone(){
        scanner.nextLine();
        System.out.println("Input name ");
        name = scanner.nextLine();
        System.out.println("Input phone");
        phone = scanner.nextLine();
        phoneBook.insertPhone(name, phone);
    }
    private  static  void  sort(){
        phoneBook.sort();
    }
    private  static  void  updatePhone(){
        boolean searched = false;
        scanner.nextLine();
        System.out.println("Input name of person you want to update phone?");
        name = scanner.nextLine();
        for (String s: phoneBook.PhoneList) {
            if(name.equals(s.substring(0, s.indexOf(",")))){
                searched = true;
                System.out.println("Input phone number of person you want to update ");
                phone = scanner.nextLine();
                phoneBook.updatePhone(name,phone);
                break;
            }
        }
        if(!searched) {
            System.out.println("not found person with name is : " + name);
        }
    }
}
