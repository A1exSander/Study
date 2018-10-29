package lesson6.battleUnit;

public class Spearman extends BattleUnit {

    public Spearman(int health, int attackScore) {
        super(health, attackScore);
    }

    @Override
    public void attack(BattleUnit enemy) {
        enemy.health -= this.attackScore;
    }

    @Override
    public void say(String text) {
        System.out.println("Реплика пикинера " + text );
    }

    @Override
    public void sing(String song) {
        System.out.println("Песня пикинера " + song);

    }
}