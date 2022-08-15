package Homework_15;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class GeneratorFactory implements Generator<Number>{

    private static final Class<?>[] numberTypes = {Integer.class, Double.class, Float.class, Long.class};
    private static final Random rand = new Random();

    public GeneratorFactory() {

    }

    @Override
    public Number getNextRand() {
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        GeneratorFactory numberGenerator = new GeneratorFactory();
        try {
            Number gen = (Number)numberTypes[rand.nextInt(numberTypes.length)].getDeclaredConstructor().newInstance();
            gen.getNextRand();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
}

abstract class Number{

    public void getNextRand(){

   };

}

class Integer extends Number{

    public void getNextRand(){
        Random r = new Random();
        int x = r.nextInt();
        System.out.println(x);
    };

}

class Double extends Number{

    public void getNextRand(){
        Random r = new Random();
        double d = r.nextDouble();
        System.out.println(d);
    };

}

class Float extends Number{

    public void getNextRand(){
        Random r = new Random();
        float f = r.nextFloat();
        System.out.println(f);
    };

}

class Long extends Number{

    public void getNextRand(){
        Random r = new Random();
        long l = r.nextLong();
        System.out.println(l);
    };

}