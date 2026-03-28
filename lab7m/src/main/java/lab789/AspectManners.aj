package lab789;

public aspect AspectManners {

    pointcut notInAspect(): !within(lab789.AspectManners);

    pointcut gettersAndSetters():
        (execution(* lab789.HelloWorld.get*()) || execution(* lab789.HelloWorld.set*(..)))
        && notInAspect();

    before(): gettersAndSetters() {
        System.out.println("Something was getted/setted. " + thisJoinPoint
                + " Timestamp:" + System.currentTimeMillis());
    }

    pointcut sayMethods(): execution(* lab789.HelloWorld.say*(..));

    before(): sayMethods() {
        System.out.println("Good day!");
    }

    after(): sayMethods() {
        System.out.println("Nice to meet you!");
    }

    pointcut callsWithoutSay():
        call(* lab789.HelloWorld.*(..))
        && !call(* lab789.HelloWorld.say*(..))
        && notInAspect();

    after(): callsWithoutSay() {
        System.out.println("Without say method is called");
    }

    pointcut callSayToPerson(String message, String person):
        call(void lab789.HelloWorld.sayToPerson(String, String))
        && args(message, person)
        && notInAspect();

    void around(String message, String person): callSayToPerson(message, person) {
        HelloWorld hw = (HelloWorld) thisJoinPoint.getTarget();

        String family = (hw.getFamilyName() != null && !hw.getFamilyName().isEmpty())
                        ? " " + hw.getFamilyName() : "";

        String fullName = person + family;

        System.out.println("Aspect: full name = " + fullName);

        proceed(message, fullName);
    }
}