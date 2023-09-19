package Lf;
import java.util.*;

class Notebook {
    int ram;
    int hdd;
    String os;
    String color;

    public Notebook(int ram, int hdd, String os, String color) {
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }
}

public class Lf {
    public static void main(String[] args) {
        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(new Notebook(8, 512, "Windows", "Black"));
        notebooks.add(new Notebook(16, 1024, "MacOS", "Silver"));

        Scanner scanner = new Scanner(System.in);
        Map<String, Object> filters = new HashMap<>();
        
        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        
        int choice = scanner.nextInt();
        
        switch(choice) {
            case 1:
                System.out.println("Введите минимальное значение ОЗУ:");
                filters.put("ram", scanner.nextInt());
                break;
            case 2:
                System.out.println("Введите минимальное значение объема ЖД:");
                filters.put("hdd", scanner.nextInt());
                break;
            case 3:
                System.out.println("Введите операционную систему:");
                filters.put("os", scanner.next());
                break;
            case 4:
                System.out.println("Введите цвет:");
                filters.put("color", scanner.next());
                break;
            default:
                System.out.println("Неверный выбор");
                return;
        }

        Set<Notebook> filtered = filterNotebooks(notebooks, filters);
        
        for (Notebook notebook : filtered) {
            System.out.println(notebook.ram + " " + notebook.hdd + " " + notebook.os + " " + notebook.color);
        }
    }

    static Set<Notebook> filterNotebooks(Set<Notebook> notebooks, Map<String, Object> filters) {
        Set<Notebook> result = new HashSet<>();
        
        for (Notebook notebook : notebooks) {
            if (filters.containsKey("ram") && notebook.ram < (int) filters.get("ram")) continue;
            if (filters.containsKey("hdd") && notebook.hdd < (int) filters.get("hdd")) continue;
            if (filters.containsKey("os") && !notebook.os.equals(filters.get("os"))) continue;
            if (filters.containsKey("color") && !notebook.color.equals(filters.get("color"))) continue;
            
            result.add(notebook);
        }
        
        return result;
    }
}