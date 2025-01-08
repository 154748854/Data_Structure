public class Test {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.createNode();

        mySingleList.display();
        System.out.println(mySingleList.size());
        System.out.println(mySingleList.contains(1156));
    }
}
