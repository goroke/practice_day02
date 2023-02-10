import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import pokemon.*;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int menu = 0, pokemon = 0, attack_menu = 0;
        String n = "", s = "";
        Pokemon p;

        while(true){
            System.out.printf("총 %d마리의 포켓몬이 생성되었습니다\n", Pokemon.getCount());

            System.out.print("1) 포켓몬 생성  2) 프로그램 종료 : ");
            try{menu = sc.nextInt();}
            catch(InputMismatchException e){
                System.out.println("메뉴에서 골라 주세요");
                sc.nextLine();
                continue;
            }
            sc.nextLine();

            if(menu == 2) {
                System.out.println("프로그램을 종료합니다");
                break;
            }
            else if(menu == 1){
                System.out.print("1) 피카츄  2) 꼬부기  3) 파이리 : ");
                pokemon = sc.nextInt(); sc.nextLine();

                System.out.print("플레이어 이름 입력 : ");
                n = sc.nextLine();

                System.out.print("사용 가능한 기술 입력 : ");
                s = sc.nextLine();

                while (true) {
                    try {
                        p = switch (pokemon) {
                            case 1 -> new Pikachu(n, s);
                            case 2 -> new Ggoboogi(n, s);
                            case 3 -> new Pairi(n, s);
                            default -> throw new IllegalStateException("메뉴에서 골라 주세요");
                        };
                    } catch (IllegalStateException e) {
                        sc.nextLine();
                        System.out.println(e.getMessage());
                        continue;
                    }
                    break;
                }

                p.info();
                System.out.print("공격 번호 선택 : ");
                attack_menu = sc.nextInt();
                p.attack(attack_menu - 1);
            }
            else{
                System.out.println("메뉴에서 골라 주세요");
            }
        }
    }
}
