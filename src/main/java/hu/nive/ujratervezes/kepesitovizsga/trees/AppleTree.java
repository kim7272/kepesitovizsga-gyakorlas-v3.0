package hu.nive.ujratervezes.kepesitovizsga.trees;

public class AppleTree extends Tree {
    public AppleTree(int i) {
        super(i);
    }

    @Override
    public Fruit getFruit() {
        return Fruit.APPLE;
    }

    @Override
    public int growLeaves(int numberOfSunnyDays) {
        leaves = leaves + 10 * numberOfSunnyDays;
        return leaves;
    }

    @Override
    public void ripenFruit(int numberOfSunnyDays) {
        weightOfFruit = growLeaves(numberOfSunnyDays) / 50;
    }

    @Override
    public int hostBirdNest() {
        return leaves / 200;
    }

    public static void main(String[] args) {
        Tree tree = new AppleTree(100);
        System.out.println((tree.growLeaves(80)));
        tree.ripenFruit(80);
        System.out.println(tree.weightOfFruit);

    }
}
