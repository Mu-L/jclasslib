import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main<@Test1 T extends @Test1 Object> extends @Test1 Object implements @Test1 TestInterface {

    private static TestInterface staticField =  ((p) -> System.err.println("static"));

    static {
        handleTest((p) -> System.err.println("clinit"));
        handleTest(staticField);
    }

    public static final int TEST_INT = 1;
    public static final String TEST_STRING = "123";

    private TestInterface nonStaticField =  ((p) -> System.err.println("static"));

    private List<@Test1 String> strings;

    private
    @Test1
    Object @Test2 [] data;

    public Main() {
        handleTest((p) -> System.err.println("init"));
        handleTest(nonStaticField);
    }

    public static void main() {
        handleTest((p) -> System.out.println("abc"));
    }

    public static void main(String[] args) throws @Test1 Exception {
        Nested.main();
        new Nested().xyz();
        main();
        new @Test1 Main();

        @Test1 int i = 0, j, k;
        Object o = "";
        @Test1 String s = (@Test1 String) o;
        @Test1 String s2 = (@Test1 String) o;
        @Test1 String s3 = (@Test1 String) o;

        String a = s + s2 + s3;

        try {
            TestInterface t = Arrays::<@Test1 int[]>sort;
            handleTest(t);
        } finally {
            elementValues();
        }


        try {
            handleTest(Main::testMethod);
        } catch (@Test1 Exception e) {
            e.printStackTrace();
        }

        try {
            handleTest((p) -> System.err.println("test"));
        } catch (@Test1 Exception e) {
            e.printStackTrace();
        }

        try {
            handleTest((p) -> handleTest(data1 -> System.err.println("level 2")));
        } catch (@Test1 Exception e) {
            e.printStackTrace();
        }

        class LocalClass {
            void testLocal() {
                class LoadClass2 {
                    void testLocal() {
                        System.err.println("local");
                    }
                }
                System.err.println("local");
                new LoadClass2().testLocal();
            }
        }

        class LocalClass2 {
            void testLocal() {
                System.err.println("local");
            }
        }

        new LocalClass().testLocal();
        new LocalClass2().testLocal();

    }

    @Test2(one = "1", two = true, three = TestEnum.THREE, four = String.class, other = @Test1("test"), otherArray = {@Test1("x"), @Test1("y")})
    private static void elementValues() {
        System.out.println();
    }

    private static void handleTest(@Test1 TestInterface t2) {
        class LocalClass {
            class InnerLocalClass {
                void testInnerLocal() {
                    System.err.println("local");
                }
            }

            void testLocal() {
                System.err.println("local");
                new InnerLocalClass().testInnerLocal();
            }
        }
        new LocalClass().testLocal();
        t2.run(new int[0]);
    }

    @Override
    public void run(int[] data) {

    }

    public static void testMethod(int[] data) {

    }
    private static class NestedBase {
        public NestedBase() {
            System.out.println("base");
        }
    }

    private static class Nested extends NestedBase {

        private int c;

        void xyz() {
            Object[][][] objects = new Object[0][2][3];
            handleTest(Main::testMethod);
            handleTest((p) -> {
                System.out.println("test 1 " + c++);
            });

            SerializablePredicate<String> predicate = s -> false;
            predicate.test("123");

            handleTest((p) -> {
                System.out.println("test 2 " + c++);
            });

        }

        void iinc() {
            int z = 0;
            z++;
        }

        void tableSwitch() {
            int z = 0;
            switch (z) {
                case 1:
                    z += 1;
                    break;
                case 2:
                    z += 2;
                    break;
                case 3:
                    z += 3;
                    break;
                case 4:
                    z += 4;
                    break;
                case 5:
                    z += 5;
                    break;
            }
        }

        void lookupSwitch() {
            int z = 0;
            switch (z) {
                case 1:
                    z += 1;
                    break;
                case 56:
                    z += 2;
                    break;
                case 111:
                    z += 3;
                    break;
                case 1056:
                    z += 4;
                    break;
                case 36666:
                    z += 5;
                    break;
            }
        }

        static void main() {
            handleTest(Main::testMethod);
            final long[] i = {0};
            handleTest((p) -> {
                i[0]++;
            });
            System.out.println(i[0]);
        }

    }


    @FunctionalInterface
    public interface SerializablePredicate<T> extends Predicate<T>, Serializable {

    }


}
