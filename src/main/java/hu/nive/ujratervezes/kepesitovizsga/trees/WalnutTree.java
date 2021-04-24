package hu.nive.ujratervezes.kepesitovizsga.trees;

public class WalnutTree extends Tree {

    public WalnutTree(int leaves) {
        super(leaves);
    }

    @Override
    public Fruit getFruit() {
        return Fruit.WALNUT;
    }

    @Override
    public int growLeaves(int numberOfSunnyDays) {
        leaves = leaves + 30 * numberOfSunnyDays;
        return leaves;
    }

    @Override
    public void ripenFruit(int numberOfSunnyDays) {
       weightOfFruit = growLeaves(numberOfSunnyDays) / 10;
    }

    @Override
    public int hostBirdNest() {
        return leaves/200;
    }
}
