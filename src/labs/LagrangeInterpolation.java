package labs;

import labs.models.IFuncX;
import labs.modules.LagrangianIntegrationMath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LagrangeInterpolation implements Runnable {
    Scanner scanner = new Scanner(System.in);
    @Override
    public void run() {
        System.out.println("Интерполирование многочленом Лагранжа:");
        Map<String, IFuncX> funcs = new HashMap<>();
        // 1
        funcs.put("sin(x)", Math::sin);
        // 2
        funcs.put("cos(x)", Math::cos);
        /*
        Вывод и обработка ввода. Не трогать.
        */
        int i = 1;
        ArrayList<String> keys = new ArrayList<>();
        for (Map.Entry<String, IFuncX> entry : funcs.entrySet()) {
            System.out.println((i++) + ". " + entry.getKey());
            keys.add(entry.getKey());
        }
        System.out.println((funcs.size()+1)+". Ввести своё уравнение");
        String str = scanner.nextLine();
        IFuncX func1 = funcs.get(keys.get(Integer.parseInt(str) - 1));
        LagrangianIntegrationMath.solve(func1);
    }
}
