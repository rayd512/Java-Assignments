import java.util.HashMap;
/**
 * Lab 6: Anonymous Inner Classes and Reflection <br />
 * The {@code Animal} interface
 */
interface Animal {
    /**
     * An animal speaks
     */
    public void speak ();
}

/**
 * Lab 6: Anonymous Inner Classes and Reflection <br />
 * The {@code Lion} class
 */
class Lion implements Animal {
    /**
     * The lion speaks
     */
    public void speak() {
        System.out.println("ROAR");
    }
}

/**
 * Lab 6: Anonymous Inner Classes and Reflection <br />
 * The {@code Mouse} class
 */
class Mouse implements Animal {
    /**
     * The mouse speaks
     */
    public void speak() {
        System.out.println("SQUEAK");
    }
}

/**
 * Lab 6: Anonymous Inner Classes and Reflection <br />
 * The {@code Dog} class
 */
class Dog implements Animal {
    /**
     * The dog speaks
     */
    public void speak() {
        System.out.println("WOOF");
    }
}

/**
 * Lab 6: Anonymous Inner Classes and Reflection <br />
 * The {@code Bison} class
 */
class Bison implements Animal {
    /**
     * The bison speaks
     */
    public void speak() {
        System.out.println("BELLOW");
    }
}

/**
 * Lab 6: Anonymous Inner Classes and Reflection <br />
 * The {@code AnimalType} class
 */
class AnimalType {
    /**
     * Create and return an animal
     * @param criteria      {@code String} how is the animal like
     * @return              {@code Animal} the animal
     */
    public static HashMap<String, Class<? extends Animal>> sizes =  new HashMap<String,Class<? extends Animal>>(){
        {
            put("small", Mouse.class);
            put("big", Bison.class);
            put("lazy", Lion.class);
            put("loyal", Dog.class);
        }
    };
    public static Animal getAnimal(String criteria) throws InstantiationException, IllegalAccessException {
        // TODO: Lab 6 Part 2-1 -- Refactor this method
        return AnimalType.sizes.get(criteria).newInstance();
    }
}

/**
 * Lab 6: Anonymous Inner Classes and Reflection <br />
 * The {@code JavaDPExample} class
 */
public class JavaDPExample {
    /**
     * Main entry
     * @param args          {@code String[]} Command line arguments
     */
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        AnimalType.getAnimal("small").speak();
        AnimalType.getAnimal("big").speak();
        AnimalType.getAnimal("lazy").speak();

        // TODO: Lab 6 Part 2-2 -- add an animal "Dog" here: criteria="loyal"; speak="woof"
        
        AnimalType.getAnimal("loyal").speak();

        // TODO: Lab 6 Part 2-3 -- remove the "small" animal here: Mouse
        AnimalType.sizes.remove("small");
        try {
            AnimalType.getAnimal("small").speak();
        } catch (Exception e) {
            System.out.println("Unkwon animal...");
        }
    }
}
