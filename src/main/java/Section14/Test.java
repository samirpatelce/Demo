package Section14;

import java.util.ArrayList;

public class Test {
    @org.testng.annotations.Test
    public void regular(){
        ArrayList<String> name = new ArrayList<String>();
        name.add("Abhi");
        name.add("Axay");
        name.add("sam");
        name.add("aplo");
        int count = 0;

        for (int i=0; i<name.size();i++){
            String startedName = name.get(i);
            if(startedName.startsWith("A")){
                count++;
            }
        }
        System.out.println(count);
    }

    @org.testng.annotations.Test
    public void steramFilter(){
        ArrayList<String> name = new ArrayList<String>();
        name.add("Abhi");
        name.add("Axay");
        name.add("sAam");
        name.add("Aaplo");

        Long c = name.stream().filter(s->s.startsWith("A")).count();
        System.out.println(c);


    }
}