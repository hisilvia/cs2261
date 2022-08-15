package edu.umsl;

//Plant inherits creature class, and implements Reproduction interface
class Plant extends creature implements Reproduction{
    @Override
    public String eatFood() {
        return "sunlight (aka photosynthesis)";
    }

    @Override
    public String modeOfReproduction() {
        return "Seeds";
    }
}
