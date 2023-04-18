package com.mygdx.game.org.example;

import com.mygdx.game.org.example.units.BaseHero;

//import org.example.units.BaseHero;
import java.util.Collections;

public class View {
    private static int step = 1;
    private static final int[] l = {0};
    // 10-15 строки - рисование поля
    private static final String top10 = formatDiv("a") + "-" + String.join("",
            Collections.nCopies(9, formatDiv("-b")+"-")) + formatDiv("-c");
    private static final String midl10 = formatDiv("d") + "-" + String.join("",
            Collections.nCopies(9, formatDiv("-e")+"-")) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + "-" + String.join("",
            Collections.nCopies(9, formatDiv("-h")+"-")) + formatDiv("-i");
    private static void tabSetter(int cnt, int max){  // сколько раз надо поставить табы для выравнивания
        int dif = max - cnt + 2;
        if (dif>0) System.out.printf("%" + dif + "s", ":\t"); else System.out.print(":\t");
    }
    private static String formatDiv(String str) {  // обращение к юникоду, чтобы нарисовать сетку поля (т.к. нужных симыолов нет на клавиатуре)
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }

    private static String getChar(int x, int y){  // берет первую букву из персонажа
        String out = "|  ";
        for (BaseHero human: Main.allTeam) {
            if (human.getSelfPosition()[0] == x && human.getSelfPosition()[1] == y){
                if (human.getHp() == 0) {
                    out = "|" + (AnsiColors.ANSI_RED + human.getInfo().charAt(0) +
                            human.getInfo().charAt(1) + AnsiColors.ANSI_RESET);
                    break;
                }
                if (Main.TeamOne.contains(human)) out = "|" + (AnsiColors.ANSI_GREEN +
                        human.getInfo().charAt(0) + human.getInfo().charAt(1) + AnsiColors.ANSI_RESET);
                if (Main.TeamTwo.contains(human)) out = "|" + (AnsiColors.ANSI_BLUE +
                        human.getInfo().charAt(0) + human.getInfo().charAt(1) + AnsiColors.ANSI_RESET);
                break;
            }
        }
        return out;
    }
    public static void view() {
        if (step == 1 ){
            System.out.print(AnsiColors.ANSI_RED + "First step" + AnsiColors.ANSI_RESET);
        } else {
            System.out.print(AnsiColors.ANSI_RED + "Step:" + step + AnsiColors.ANSI_RESET);
        }
        step++;
        for (BaseHero hero: Main.allTeam) {
            l[0] = Math.max(l[0], hero.getInfo().length());
        }
        //Main.allTeam.forEach((v) -> l[0] = Math.max(l[0], v.getInfo().length())); // нужно, чтобы tabsetter затем выровнял информацию о командах
        System.out.print("_".repeat(l[0]*2));
        System.out.println("");
        System.out.print(top10 + "    ");
        System.out.print("Team One");
        //for (int i = 0; i < l[0]-9; i++)
        System.out.print(" ".repeat(l[0]-8));
        System.out.println(":\tTeam Two");
        for (int i = 0; i < 10; i++) {
            System.out.print(getChar(0, i));
        }
        System.out.print("|    ");
        System.out.print(Main.TeamOne.get(0).getInfo());
        tabSetter(Main.TeamOne.get(0).getInfo().length(), l[0]);
        System.out.println(Main.TeamTwo.get(0).getInfo());
        System.out.println(midl10);

        for (int i = 1; i < 9; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(getChar(i, j));
            }
            System.out.print("|    ");
            System.out.print(Main.TeamOne.get(i).getInfo());
            tabSetter(Main.TeamOne.get(i).getInfo().length(), l[0]);
            System.out.println(Main.TeamTwo.get(i).getInfo());
            System.out.println(midl10);
        }
        for (int j = 0; j < 10; j++) {
            System.out.print(getChar(9, j));
        }
        System.out.print("|    ");
        System.out.print(Main.TeamOne.get(9).getInfo());
        tabSetter(Main.TeamOne.get(9).getInfo().length(), l[0]);
        System.out.println(Main.TeamTwo.get(9).getInfo());
        System.out.println(bottom10);
    }
}
