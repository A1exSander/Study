package lesson4Homework.task1;

public class Figures {
    public double space, perimeter, x1, y1, x2, y2, x3, y3, x4, y4;
    double len1, len2, len3, len4, p, rad;

    public Figures(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Figures(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public Figures(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.x4 = x4;
        this.y4 = y4;
    }

    public double getSpaceT() {
        len1=Math.abs(Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1)));
        len2=Math.abs(Math.sqrt((x2 - x3)*(x2 - x3) + (y2 - y3)*(y2 - y3)));
        len3=Math.abs(Math.sqrt((x3 - x1)*(x3 - x1) + (y3 - y1)*(y3 - y1)));
        p=(len1+len2+len3)/2;
        space = Math.sqrt(p * (p-len1) + (p-len2) + (p-len3));
        return space;
    }
    public double getSpaceR() {
            len1 = Math.abs(Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1)));
            len2 = Math.abs(Math.sqrt((x2 - x3)*(x2 - x3) + (y2 - y3)*(y2 - y3)));
            len3 = Math.abs(Math.sqrt((x3 - x4)*(x3 - x4) + (y3 - y4)*(y3 - y4)));
            len4 = Math.abs(Math.sqrt((x4 - x1)*(x4 - x1) + (y4 - y1)*(y4 - y1)));
            space = (len1 * len2);
            return space;
    }
    public double getSpaceC() {
        rad = Math.abs(Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1)));
        space=Math.PI*rad*rad/2;
        return space;
    }


    public double getPerimeterT() {
        len1=Math.abs(Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1)));
        len2=Math.abs(Math.sqrt((x2 - x3)*(x2 - x3) + (y2 - y3)*(y2 - y3)));
        len3=Math.abs(Math.sqrt((x3 - x1)*(x3 - x1) + (y3 - y1)*(y3 - y1)));
        perimeter=len1+len2+len3;
        return perimeter;
    }

    public double getPerimeterR() {

            len1 = Math.abs(Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1)));
            len2 = Math.abs(Math.sqrt((x2 - x3)*(x2 - x3) + (y2 - y3)*(y2 - y3)));
            len3 = Math.abs(Math.sqrt((x3 - x4)*(x3 - x4) + (y3 - y4)*(y3 - y4)));
            len4 = Math.abs(Math.sqrt((x4 - x1)*(x4 - x1) + (y4 - y1)*(y4 - y1)));
            perimeter = (len1 + len2) * 2;
            return perimeter;
    }
    public double getPerimeterC() {
        rad = Math.abs(Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1)));
        perimeter = 2 * Math.PI * rad;
        return perimeter;
    }
}
