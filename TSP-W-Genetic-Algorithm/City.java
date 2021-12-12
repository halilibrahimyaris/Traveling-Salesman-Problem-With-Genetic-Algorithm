package GeneticAlgorithm;

/**
 * @author halil
 */
public class City {

    // Each city has these following variables:
    // name = Label of city
    // x_coord = Coordinate of x
    // y_coord = Coordinate of y

    private int number;
    private float x_coord;
    private float y_coord;

    public City(int number, float x_coord, float y_coord) {
        this.number = number;
        this.x_coord = x_coord;
        this.y_coord = y_coord;
    }

    // Return name of this city
    public int getNumber() {
        return number;
    }

    // Return X Coordiate of this city
    public float getX_coord() {
        return x_coord;
    }

    // Return Y Coordiate of this city
    public float getY_coord() {
        return y_coord;
    }


}
