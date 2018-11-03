package com.company;

class Imagen {
    private int i1;
    private int i2;
    private int j1;
    private int j2;

    Imagen(int i1, int i2, int j1, int j2) {
        this.i1 = i1;
        this.i2 = i2;
        this.j1 = j1;
        this.j2 = j2;
    }

    int getI1() {
        return i1;
    }

    int getI2() {
        return i2;
    }

    int getJ1() {
        return j1;
    }

    int getJ2() {
        return j2;
    }

    @Override
    public String toString() {
        return "(" + i1 + ", " + i2 + ") " + " (" + j1 + ", " + j2 + ")";
    }
}
