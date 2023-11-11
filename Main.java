import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.Math;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome!");
        int num;
        do {
            showMenu();
            System.out.println("Enter a number>>>");
            num = scanInt();
            switch(num) {
                case 1: {
                    List list = new List();
                    scanAllClubs(list, 32, 1);
                    Club[][] clubs = new Club[8][4];
                    draw(list, 1, clubs);
                    System.out.println("UCL Group Stage Draw:");
                    printAllClubs(clubs, 1);
                    System.out.println();
                    break;
                }
                case 2: {
                    List list = new List();
                    scanAllClubs(list, 16, 2);
                    Club[][] clubs = new Club[2][8];
                    draw(list, 2, clubs);
                    System.out.println("UCL Round of 16 Draw:");
                    printAllClubs(clubs, 2);
                    System.out.println();
                    break;
                }
                case 3: {
                    List list = new List();
                    scanAllClubs(list, 8, 3);
                    Club[][] clubs = new Club[2][4];
                    draw(list, 3, clubs);
                    System.out.println("UCL Quarter-Finals Draw:");
                    printAllClubs(clubs, 3);
                    System.out.println();
                    break;
                }
                case 4: {
                    List list = new List();
                    scanAllClubs(list, 4, 4);
                    Club[][] clubs = new Club[2][2];
                    draw(list, 4, clubs);
                    System.out.println("UCL Semi-Finals Draw:");
                    printAllClubs(clubs, 4);
                    System.out.println();
                    break;
                }
                case 5: {
                    System.out.println("Goodbye!");
                    break;
                }
                default: {
                    System.out.println("Number is invalid.");
                }
            }
        } while(num != 5);
    }
    public static void showMenu() {
        System.out.println("Menu:");
        System.out.println("1. UCL Group Stage Draw");
        System.out.println("2. UCL Round of 16 Draw");
        System.out.println("3. UCL Quarter-Finals Draw");
        System.out.println("4. UCL Semi-Finals Draw");
        System.out.println("5. Exit");
    }
    public static int scanInt() {
        Scanner in = new Scanner(System.in);
        while(true) {
            try {
                return in.nextInt();
            } catch(InputMismatchException exception) {
                System.out.println("Input is invalid.");
                in.next();
            }
        }
    }
    public static Club scanClub(int stage) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name of club>>>");
        String name = in.nextLine();
        System.out.println("Enter country of club>>>");
        String country = in.next();
        if(stage == 1) {
            System.out.println("Enter pot of club>>>");
            char pot = in.next().charAt(0);
            return new Club(name, country, pot);
        } else if(stage == 2) {
            System.out.println("Enter pot of club>>>");
            char pot = in.next().charAt(0);
            System.out.println("Enter group of club>>>");
            int group = scanInt();
            return new Club(name, country, pot, group);
        } else {
            return new Club(name, country);
        }
    }
    public static void scanAllClubs(List list, int number, int stage) {
        for(int i = 0; i < number; i++) {
            list.insert(scanClub(stage));
        }
    }
    public static void draw(List list, int stage, Club[][] clubs) {
        if(stage == 1) {
            for(int i = 0; i < clubs.length; i++) {
                char pot = 'A';
                for(int j = 0; j < clubs[i].length;) {
                    int num = (int) (Math.random()*list.getLength());
                    Club sample = list.find(num);
                    boolean flag = true;
                    for(int k = 0; k < j; k++) {
                        if(sample.similar(clubs[i][k], 1)) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag && sample.getPot() == pot) {
                        clubs[i][j] = list.remove(num);
                        j++;
                        pot++;
                    }
                }
            }
        } else if(stage == 2) {
            for(int i = 0; i < clubs.length; i++) {
                for(int j = 0; j < clubs[i].length;) {
                    int num = (int) (Math.random()*list.getLength());
                    if(i == 1) {
                        Club sample = list.find(num);
                        if(!sample.similar(clubs[i-1][j], 2)) {
                            clubs[i][j] = list.remove(num);
                            j++;
                        }
                    } else {
                        clubs[i][j] = list.remove(num);
                        j++;
                    }
                }
            }
        } else {
            for(int i = 0; i < clubs.length; i++) {
                for(int j = 0; j < clubs[i].length; j++) {
                    int num = (int) (Math.random()*list.getLength());
                    clubs[i][j] = list.remove(num);
                }
            }
        }
    }
    public static void printAllClubs(Club[][] clubs, int stage) {
        if(stage == 1) {
            for(int i = 0; i < clubs.length; i++) {
                System.out.print("Group " + (i+1) + ": ");
                for(int j = 0; j < clubs[i].length; j++) {
                    System.out.print(clubs[i][j] + ", ");
                }
                System.out.println();
            }
        } else {
            for(int i = 0; i < clubs[0].length; i++) {
                System.out.println(clubs[0][i] + " VS " + clubs[1][i]);
            }
        }
    }
}