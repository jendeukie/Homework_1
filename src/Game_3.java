import java.util.Scanner;
import java.util.Random;

public class Game_3 {
    static int px,py,bx,by,ex,ey,vx,vy;
    static int [][] map;
    static Random rd = new Random();
    static Scanner sc = new Scanner(System.in);
    static String move = "";


    public static void main(String[] args) {
        generate();
        while(true){
            draw();
            System.out.println("Your move? ");
            move = sc.next();
            action(move);
            if(bx==ex && by==ey){
                System.out.println("You win!");
                break;
            }
        }

    }

    private static void draw(){
        for (int i = 0; i < 10; i++) {
            System.out.println("");
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = 0;
            }
        }
        map[ex][ey] = 1;
        map[bx][by] = 2;
        map[px][py] = 3;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                switch(map[i][j]){
                    case 0:System.out.print(" - ");break;
                    case 1:System.out.print(" E ");break;
                    case 2:System.out.print(" B ");break;
                    case 3:System.out.print(" P ");break;
                    default:break;
                }
            }
            System.out.println("");
        }
    }

    private static void generate() {
        map = new int[10][10];
        px = 1;
        py = 1;
        ex = rd.nextInt(10);
        ey = rd.nextInt(10);
        bx = rd.nextInt(10);
        by = rd.nextInt(10);
    }

    private static void action(String move) {
        switch(move){
            case "W": vx = -1; vy = 0; break;
            case "A": vx = 0; vy = -1; break;
            case "S": vx = 1; vy = 0; break;
            case "D": vx = 0; vy = 1; break;
            default: vx = 0; vy = 0; break;
        }
        if(px+vx>map.length-1 || px+vx<0) return;
        if(py+vy>map.length-1 || py+vy<0) return;
        if(px+vx == bx && py+vy == by){
            if(bx+vx>map.length-1 || bx+vx<0) return;
            if(by+vy>map.length-1 || by+vy<0) return;
            bx+=vx;
            by+=vy;
            px+=vx;
            py+=vy;
            return;
        }
        px+=vx;
        py+=vy;

    }




}