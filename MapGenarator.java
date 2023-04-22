package Game;

import Core.Terminal;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Main {
    static int[][] map;
    public static void main(String[] args) {
        Terminal panel = new Terminal(600, 600);
        panel.setEditable(false);
        panel.run();

        panel.print("test", 255, 0, 255);

        map = createMap();
        printMap(panel);

        panel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_R){
                    map = createMap();
                    panel.clear();
                    printMap(panel);
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }

    public static int[][] createMap(){
        Random ran = new Random();
        int[][] matrix = new int[ran.nextInt(10)+5][ran.nextInt(10)+5];
        generateTerrain(matrix, 1);
        generateTerrain(matrix, 2);
        addPlayer(matrix);
        addEnemy(matrix);
        return matrix;
    }

    public static void generateTerrain(int[][] terrain, int type){
        Random ran = new Random();
        int startX = ran.nextInt(terrain.length);
        int startY = ran.nextInt(terrain[0].length);
        terrain[startX][startY] = type;
        int i = 0;
        while(true){
            if((startX+1>terrain.length-1) || (startX==0)){
                startX = ran.nextInt((terrain.length/2)+1);
                continue;
            }
            if((startY+1>terrain[0].length-1) || (startY==0)){
                startY = ran.nextInt((terrain[0].length/2)+1);
                continue;
            }

            if (terrain[startX + 1][startY] == 0 && ran.nextInt(100) >= 30) {
                terrain[startX + 1][startY] = type;
                startX++;
            } else if (terrain[startX - 1][startY] == 0 && ran.nextInt(100) >= 30) {
                terrain[startX - 1][startY] = type;
                startX--;
            } else if (terrain[startX][startY + 1] == 0 && ran.nextInt(100) >= 30) {
                terrain[startX][startY + 1] = type;
                startY++;
            } else if (terrain[startX][startY - 1] == 0 && ran.nextInt(100) >= 30) {
                terrain[startX][startY - 1] = type;
                startY--;
            }else {
                i++;
                startX = ran.nextInt(terrain.length);
                startY = ran.nextInt(terrain[0].length);
            }
            if(i==3) break;
        }
    }

    public static void addPlayer(int[][] map){
        Random ran = new Random();
        int startX = ran.nextInt(map.length);
        int startY = ran.nextInt(map[0].length);
        if(map[startX][startY]!=0 && map[startX][startY]!=4) map[startX][startY] = 3;
        else addPlayer(map);
    }

    public static void addEnemy(int[][] map){
        Random ran = new Random();
        int n = 0, k = 0;
        if(map.length > 9 && map[0].length > 9) n = 1;
        if(map.length > 12 && map[0].length > 12) n = 2;
        if(map.length > 16 && map[0].length > 16) n = 3;
        while (k!=n){
            int startX = ran.nextInt(map.length);
            int startY = ran.nextInt(map[0].length);
            if(map[startX][startY]!=0 && map[startX][startY]!=3){
                map[startX][startY] = 4;
                k++;
            }
        }
    }

    public static void printMap(Terminal panel){
        for (int[] ints : map) {
            for (int column = 0; map[0].length > column; column++) {
                switch (ints[column]){
                    case 0 -> panel.print("\uD83D\uDCA7");
                    case 1 -> panel.print("🌲");
                    case 2 -> panel.print("\uD83C\uDFD4️");
                    case 3 -> panel.print("\uD83D\uDE42");
                    case 4 -> panel.print("\uD83D\uDE08");
                }
                panel.print(" ");
            }
            panel.println();
        }
        for (int[] ints : map) {
            for (int column = 0; map[0].length > column; column++) {
                switch (ints[column]){
                    case 0 -> System.out.print("\uD83D\uDCA7");
                    case 1 -> System.out.print("🌲");
                    case 2 -> System.out.print("\uD83C\uDFD4️");
                    case 3 -> System.out.print("\uD83D\uDE42");
                    case 4 -> System.out.print("\uD83D\uDE08");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}