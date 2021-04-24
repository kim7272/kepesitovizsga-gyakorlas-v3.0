package hu.nive.ujratervezes.kepesitovizsga.trees;

public abstract class Tree {

    public int leaves;
    public int weightOfFruit;
    private int numberOfSunnyDays;
    private Fruit fruit;

    public Tree(int leaves) {
        this.leaves = leaves;
    }

    public abstract Fruit getFruit();

    public abstract int growLeaves(int numberOfSunnyDays);

    public abstract void ripenFruit(int numberOfSunnyDays);

    public abstract int hostBirdNest();

}
