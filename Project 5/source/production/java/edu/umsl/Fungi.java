package edu.umsl;

class Fungi extends creature implements Reproduction {
    @Override
    public String eatFood() {
        return "external digestion with hyphae";
    }

    @Override
    public String modeOfReproduction() {
        return "Spores";
    }
}
