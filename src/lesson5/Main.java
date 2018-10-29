package lesson5;

import lesson5.battleUnit.BattleUnit;
import lesson5.battleUnit.Knight;
import lesson5.battleUnit.Spearman;

public class Main {
    public static void main(String[] args) {
        Knight knight = new Knight(100, 20);
        Spearman spearman = new Spearman(60, 70);
        BattleUnit knight2 = new Knight( 20, 30);
        //Основной - дочерний
        knight.attack(spearman);
    }
}