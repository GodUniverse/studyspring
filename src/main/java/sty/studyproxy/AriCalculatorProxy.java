package sty.studyproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class AriCalculatorProxy {

    private AriCalculator target;

    public AriCalculatorProxy(AriCalculator target) {
        this.target = target;
    }

    public Object getProxy(){
        Object proxy;

        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] intefaces = target.getClass().getInterfaces();
        proxy = Proxy.newProxyInstance(classLoader, intefaces, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String name = method.getName();

                System.out.println("begin... the method name:"+ name + ", args:" + Arrays.asList(args));
                Object result = method.invoke(target, args);
                System.out.println("end... result:" + result);

                return result;

            }
        });

        return proxy;
    }
}
