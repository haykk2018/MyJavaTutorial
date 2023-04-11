package tamplates.factory_method;

public class Main {

    public static void main(String[] args) {
        factoryMethodPattern obj;
        obj = createObject("cl1");
        System.out.println(obj.writeAnything());
        obj = createObject("cl2");
        System.out.println(obj.writeAnything());
        obj = createObject("cl3");
        System.out.println(obj.writeAnything());

    }

    static factoryMethodPattern createObject(String className) {

        return switch (className) {
            case "cl1" -> new cl1();
            case "cl2" -> new cl2();
            case "cl3" -> new cl3();
            default -> null;
        };


    }
}
