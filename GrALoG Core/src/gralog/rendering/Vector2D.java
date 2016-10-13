/*
 * This file is part of GrALoG FX, Copyright (c) 2016 LaS group, TU Berlin.
 * License: https://www.gnu.org/licenses/gpl.html GPL version 3 or later.
 */
package gralog.rendering;

/**
 * A 2-dimensional immutable vector.
 */
public class Vector2D {

    private final double x, y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Vector2D other = (Vector2D) obj;
        return Double.doubleToLongBits(this.x) == Double.doubleToLongBits(other.x) &&
               Double.doubleToLongBits(this.y) == Double.doubleToLongBits(other.y);
    }

    @Override
    public String toString() {
        return "Vector2D{" + x + "," + y + '}';
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double get(int dimension) {
        switch (dimension) {
            case 0:
                return x;
            case 1:
                return y;
            default:
                throw new RuntimeException("Invalid dimension for a 2-dimensional vector: " + dimension);
        }
    }

    public int dimensions() {
        return 2;
    }

    public Vector2D orthogonal() {
        return new Vector2D(-this.y, this.x);
    }

    public Vector2D plus(Vector2D other) {
        return new Vector2D(this.x + other.x, this.y + other.y);
    }

    public Vector2D minus(Vector2D other) {
        return new Vector2D(this.x - other.x, this.y - other.y);
    }

    public double multiply(Vector2D other) {
        return this.x * other.x + this.y * other.y;
    }

    public Vector2D normalized() {
        return this.multiply(1d / this.length());
    }

    public Vector2D multiply(double c) {
        return new Vector2D(this.x * c, this.y * c);
    }

    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    public double theta() {
        double alpha = Math.asin(this.normalized().y);
        alpha *= 180d / Math.PI; // radian to degrees

        if (x > 0) {
            if (y > 0)
                return alpha;
            else
                return 360d + alpha; // alpha is negative
        }
        else
            return 180d - alpha;
    }

    public static Vector2D closestPointOnLine(double px, double py, double l1x,
            double l1y, double l2x, double l2y) {
        Vector2D p = new Vector2D(px, py);
        Vector2D l1 = new Vector2D(l1x, l1y);
        Vector2D l2 = new Vector2D(l2x, l2y);
        Vector2D l = l2.minus(l1);

        // normal-vector
        Vector2D n = l.orthogonal();

        // lotfuß-punkt
        double k = Math.abs(l1.minus(p).multiply(n)) / n.multiply(n);
        Vector2D q = p.plus(n.multiply(k));

        return q;
    }

    public static double distancePointToLine(double px, double py, double l1x,
            double l1y, double l2x, double l2y) {
        Vector2D p = new Vector2D(px, py);
        Vector2D l1 = new Vector2D(l1x, l1y);
        Vector2D l2 = new Vector2D(l2x, l2y);
        Vector2D l = l2.minus(l1);

        if (l.getX() == 0 && l.getY() == 0) // (*)
            return l1.minus(p).length(); // l1==l2 so "the line" is actually just the point l1

        Vector2D perpendicular = closestPointOnLine(px, py, l1x, l1y, l2x, l2y);
        double lScaleToPerpendicular = 0.0;
        if (l.getX() != 0)
            lScaleToPerpendicular = (perpendicular.getX() - l1.getX()) / l.getX();
        else // if(l.getY() != 0) // true, because of (*)
            lScaleToPerpendicular = (perpendicular.getY() - l1.getY()) / l.getY();

        if (lScaleToPerpendicular < 0)
            return l1.minus(p).length();
        if (lScaleToPerpendicular > 1)
            return l2.minus(p).length();
        return perpendicular.minus(p).length();
    }

    private static double snap(double GridSize, double value) {
        double newCoord = value + GridSize / 2d;
        double temp = newCoord % GridSize;
        if (temp < 0)
            temp += GridSize;
        return newCoord - temp;
    }

    public Vector2D snapToGrid(double GridSize) {
        return new Vector2D(snap(GridSize, x), snap(GridSize, y));
    }
}
