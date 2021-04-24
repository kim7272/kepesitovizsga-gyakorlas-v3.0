package hu.nive.ujratervezes.kepesitovizsga.trees;

public class CherryTree extends Tree {

    public CherryTree(int i) {
        super(i);
    }

    @Override
    public Fruit getFruit() {
        return Fruit.CHERRY;
    }

    @Override
    public int growLeaves(int numberOfSunnyDays) {
        leaves = leaves + 20 * numberOfSunnyDays;
        return leaves;
    }

    @Override
    public void ripenFruit(int numberOfSunnyDays) {
        weightOfFruit = growLeaves(numberOfSunnyDays) / 30;
    }

    @Override
    public int hostBirdNest() {
        return leaves/200;
    }
}
