package lk.ijse.dep.web.pos;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {

    private static AnnotationConfigApplicationContext ctx = buildContext();

    private static AnnotationConfigApplicationContext buildContext() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        return ctx;
    }

    public static AnnotationConfigApplicationContext getContext(){
        return ctx;
    }
}
