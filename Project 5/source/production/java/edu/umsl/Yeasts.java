package edu.umsl;

class Yeasts extends Fungi {
    @Override
    public String toString() {
        //Call two methods and put them together
        String data = "Eat food: " + eatFood() + ", and reproduction: " + modeOfReproduction();
        return data;
    }
}
