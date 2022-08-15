package edu.umsl;

class Animal extends creature implements Reproduction {
    @Override
    public String eatFood() {
        return "ingestion";
    }

    @Override
    public String modeOfReproduction() {
        return "Sexual Reproduction";
    }
}
