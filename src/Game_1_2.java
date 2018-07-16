import java.util.Scanner;
import java.util.Random;

public class Game_1_2 {
    static int px,py,e1x,e1y,e2x,e2y,gx, gy,vx,vy;
    static int[][] map;
    static Scanner sc = new Scanner(System.in);
    static Random rd = new Random();
    static String move = "";

    public static void main(String[] args) {
        generate();
        while(true){
            draw();
            System.out.println("Your move: ");
            move = sc.next();
            action(move);
            if(px==gx && py==gy){
                System.out.println("You win!");
                break;
            }
            if(px==e1x && py==e1y){
                System.out.println("You lose!");
                break;
            }
            if(px==e2x && py==e2y){
                System.out.println("You lose!!");
                break;
            }
        }
    }

    private static void draw(){
        for (int i = 0; i < 8; i++) {
            System.out.println("");
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = 0;
            }
        }
        map[px][py] = 1;
        map[e1x][e1y] = 2;
        map[e2x][e2y] = 3;
        map[gx][gy] = 4;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                switch(map[i][j]){
                    case 0:System.out.print(" - ");break;
                    case 1:System.out.print(" P ");break;
                    case 2:System.out.print(" E ");break;
                    case 3:System.out.print(" e ");break;
                    case 4:System.out.print(" G ");break;
                    default:break;
                }
            }
            System.out.println("");
        }
    }

    private static void generate() {
        System.out.println("Input n: ");
        int n;
        n = sc.nextInt();
        map = new int[n][n];

        gx = rd.nextInt(map.length);
        gy = rd.nextInt(map.length);
        e1x = rd.nextInt(map.length);
        e1y = 0;
        e2x = 0;
        e2y = rd.nextInt(map.length);
        px = rd.nextInt(map.length);
        py = rd.nextInt(map.length);
        if((px == e1x  && py == e1y) || (px == e2x && py == e2y)){
            px = rd.nextInt(map.length);
            py = rd.nextInt(map.length);
        }

    }

    private static void action(String move) {
        switch(move){
            case "W": vx = -1; vy = 0; break;
            case "A": vx = 0; vy = -1; break;
            case "S": vx = 1; vy = 0; break;
            case "D": vx = 0; vy = 1; break;
            default: vx = 0; vy = 0;  break;
        }
        if(px+vx == map.length) vx = -(map.length-1);
        if(px+vx == -1) vx = +(map.length-1);
        if(py+vy == map.length) vy = -(map.length-1);
        if(py+vy == -1) vy = +(map.length-1);
        px+=vx;
        py+=vy;

        e1x = rd.nextInt(map.length);
        e1y = 0;
        e2x = 0;
        e2y = rd.nextInt(map.length);


    }

}
