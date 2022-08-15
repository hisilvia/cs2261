//*******************************************************************************************************
//Course     : CMP-2261-001
//Author     : Silvia Matthews
//Professor  : Steve Riegerix
//Project 5  : Implement an interface, inherit from an abstract class,
//           :           and create either a SET OR lIST of my elements.
//Date       : 04/2/2022
//*******************************************************************************************************

package edu.umsl;
import java.util.List;
import java.util.ArrayList;

public class MainProj5 {
    public static void main(String[] args) {

        //Create List for Animal
        List<Animal> animals = new ArrayList<Animal>();
        animals.add(new Cat());
        animals.add(new Wolf());

        //Create List for Fungi
        List<Fungi> fungi = new ArrayList<Fungi>();
        fungi.add(new Mushroom());
        fungi.add(new Yeasts());

        //Create List for Plants
        List<Plant> plants = new ArrayList<Plant>();
        plants.add(new Eggplant());
        plants.add(new Tomato());

        //Print Animal
        for (Animal i: animals) {
            System.out.println(i);
        }

        //Print Fungi
        for (Fungi i: fungi) {
            System.out.println(i);
        }

        //Print Plant
        for (Plant i: plants) {
            System.out.println(i);
        }
    }
}
