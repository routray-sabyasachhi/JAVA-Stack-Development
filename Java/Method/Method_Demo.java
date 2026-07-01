package Java.Method;

class Computer {
    public void musicControl(boolean mode){
        if(mode == true)
            System.out.println("Playing music...");
        if(mode == false)
            System.out.println("Music paused");
    }

    public int calulator(int n1, int n2) {
        return n1+n2;
    }
}

public class Method_Demo {
    public static void main(String[] args) {
        Computer obj = new Computer();
        obj.musicControl(true);
        int result = obj.calulator(17, 17);
        System.out.println(result);
    }
}
