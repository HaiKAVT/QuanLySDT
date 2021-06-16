import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class PhoneBook extends Phone{
    ArrayList<String> PhoneList = new ArrayList();
    @Override
    void insertPhone(String name, String phone) {
        boolean foundPhone = false;
        for (String s: PhoneList) {
            if(s.contains(name)){
                foundPhone = true;
                if(!s.contains(phone)){
                    s += " : " + phone;
                }
                else {
                    System.out.println("Danh bạ này đã có sẵn!");
            }

            }
        }
        if(!foundPhone){
            PhoneList.add(name + ", " +  phone);
        }

    }

    @Override
    void removePhone(String name) {
      boolean seached = false;
        for (String s: PhoneList) {
            if(name.equals(s.substring(0, s.indexOf(","))));{
                seached = true;
                PhoneList.remove(s);
                System.out.println("Removed");
                break;
            }
        }
        if(!seached){
            System.out.println("not found person with name : " + name);
        }
    }

    @Override
    void updatePhone(String name, String newPhone) {
        String s = name;
        s = s.substring(0, s.indexOf(",")); //bỏ sdt cũ, giữ lại tên
        PhoneList.set(PhoneList.indexOf(s), s + ", "+ newPhone );
        System.out.println("updated");

    }

    @Override
    void searchPhone(String name) {
        boolean seached = false;
        for (String s: PhoneList) {
            if(s.contains(name)){
                seached = true;
                System.out.println(s.toString());
            }
        }
            if(!seached){
                System.out.println("not found person !!");
            }
    }

    @Override
    void sort() {
        if(PhoneList.size() == 0) System.out.println("PhoneList is empty");
        else {
            Collections.sort(PhoneList, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            System.out.println("sort ascending by name: ");
            for (String s:PhoneList) {
                System.out.println(s);
            }
        }

    }
}
