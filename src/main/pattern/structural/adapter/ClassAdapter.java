package pattern.structural.adapter;

import java.util.Random;

/**
 * @author Sergey Kuptsov
 * @since 17/04/2016
 */
public class ClassAdapter {

    public static void main(String[] args) {

        SequenceGenerator sequenceGenerator = new SequenceGenerator(new GeneratorAdapter());
        System.out.println(sequenceGenerator.next());

    }

    interface Generator {
        int next();
    }

    private static class GeneratorAdapter extends Random implements Generator {

        @Override
        public int next() {
            return super.nextInt();
        }
    }

    private static class SequenceGenerator {

        private final Generator generator;

        public SequenceGenerator(Generator generator) {
            this.generator = generator;
        }

        public int next() {
            return generator.next();
        }
    }


}
