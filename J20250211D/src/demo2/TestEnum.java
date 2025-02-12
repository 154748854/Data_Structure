package demo2;

import java.sql.SQLOutput;

public enum TestEnum {
    //枚举对象
    RED(1,"红色"),GREEN(2,"绿色"),BLACK(3,"黑色");
    public int num;
    public String factor;
    TestEnum(int num,String factor) {
        this.num = num;
        this.factor = factor;
    }

    public static void main(String[] args) {
        TestEnum[] testEnums = TestEnum.values();
        for (int i = 0; i < testEnums.length; i++) {
            System.out.println(testEnums[i].ordinal());
        }
    }

    public static void main1(String[] args) {
        TestEnum color = RED;
        switch(color) {
            case RED:
                System.out.println("RED");
                break;
            case BLACK:
                System.out.println("BLACK");
                break;
            case GREEN:
                System.out.println("GREEN");
                break;
            default:
                System.out.println("ERR");
                break;
        }
    }
}
