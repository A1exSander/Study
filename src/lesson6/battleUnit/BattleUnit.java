package lesson6.battleUnit;

import lesson6.ISpeakerUnit;

abstract public class BattleUnit
         implements ISpeakerUnit //- В абстрактных классах не обязательно реализовывать методы из интерфейсов
{
    // В абстрактном классе могут быть методы без реализации
    //    private int health;
//    private int attackScore;
    protected int health;
    protected int attackScore;

    public BattleUnit(int health, int attackScore) { // 100 20
        this.health = health;
        this.attackScore = attackScore;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 1) {
            return;
        }
        this.health = health;
    }

    public int getAttackScore() {
        return attackScore;
    }

    public void setAttackScore(int attackScore) {
        this.attackScore = attackScore;
    }

    public boolean isAlive(){
        return health > 0;
    }

    abstract public void attack(BattleUnit enemy);
}
