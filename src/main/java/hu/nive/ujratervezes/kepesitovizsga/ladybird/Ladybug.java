package hu.nive.ujratervezes.kepesitovizsga.ladybird;

public class Ladybug {

    private String hungarian_name;
    private String latin_name;
    private String genus;
    private int number_of_points;

    public Ladybug(String hungarian_name, String latin_name, String genus, int number_of_points) {
        this.hungarian_name = hungarian_name;
        this.latin_name = latin_name;
        this.genus = genus;
        this.number_of_points = number_of_points;
    }
}
