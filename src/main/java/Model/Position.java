package Model;

public class Position {
    private float x;
    private float y;

    public Position(float x, float y) {
        this.setX(x);
        this.setY(y);
    }

    public Position() {}

    public float getX() {
        return this.x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;

        Position position = (Position) o;

        return Float.compare(position.getX(), this.getX()) == 0 &&
                Float.compare(position.getY(), this.getY()) == 0;
    }

    @Override
    public int hashCode() {
        int result = (this.getX() != +0.0f ? Float.floatToIntBits(this.getX()) : 0);
        result = 31 * result + (this.getY() != +0.0f ? Float.floatToIntBits(this.getY()) : 0);
        return result;
    }
}
