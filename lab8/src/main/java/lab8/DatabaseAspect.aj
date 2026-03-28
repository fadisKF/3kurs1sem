package lab8;

public aspect DatabaseAspect {

    pointcut notInAspect(): !within(lab8.DatabaseAspect);

    pointcut getConnection():
        call(java.sql.Connection java.sql.DriverManager.getConnection(..)) && notInAspect();

    before(): getConnection() {
        System.out.println("[DB Aspect] Попытка подключения к БД...");
    }

    after() returning(java.sql.Connection conn): getConnection() {
        System.out.println("[DB Aspect] Подключение успешно! Connection получен.");
    }

    after() throwing(Throwable e): getConnection() {
        System.out.println("[DB Aspect] ОШИБКА подключения к БД: " + e.getMessage());
    }

    pointcut createStatement():
        call(java.sql.Statement java.sql.Connection.createStatement(..)) && notInAspect();

    before(): createStatement() {
        System.out.println("[DB Aspect] Создаётся Statement...");
    }

    after() returning(java.sql.Statement stmt): createStatement() {
        System.out.println("[DB Aspect] Statement создан успешно.");
    }

    pointcut executeQuery():
        call(java.sql.ResultSet java.sql.Statement.executeQuery(..)) && notInAspect();

    before(): executeQuery() {
        System.out.println("[DB Aspect] Выполняется SQL-запрос...");
    }

    after() returning(java.sql.ResultSet rs): executeQuery() {
        System.out.println("[DB Aspect] Запрос выполнен успешно. ResultSet получен.");
    }

    after() throwing(Throwable e): executeQuery() {
        System.out.println("[DB Aspect] ОШИБКА при выполнении запроса: " + e.getMessage());
    }

    pointcut closeResource():
        (call(* java.sql.Connection.close(..)) ||
         call(* java.sql.Statement.close(..)) ||
         call(* java.sql.ResultSet.close(..))) && notInAspect();

    before(): closeResource() {
        System.out.println("[DB Aspect] Закрывается ресурс: " + thisJoinPoint.getSignature().getName());
    }

    pointcut mainMethod(): execution(* lab8.Main.main(..));

    after() throwing(Throwable ex): mainMethod() {
        System.out.println("[DB Aspect] Критическая ошибка в работе с БД!");
        System.out.println("   Тип ошибки: " + ex.getClass().getName());
        System.out.println("   Сообщение: " + ex.getMessage());
    }

    Object around(): mainMethod() {
        long start = System.currentTimeMillis();
        try {
            return proceed();
        } finally {
            long duration = System.currentTimeMillis() - start;
            System.out.println("[DB Aspect] Метод main завершён за " + duration + " мс");
        }
    }
}