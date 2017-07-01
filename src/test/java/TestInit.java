import java.util.Date;

/**
 * Created by ryder on 2017/6/30.
 */
class TestInitClass{
    public void init(){
        System.out.println("init()函数");
    }
    public TestInitClass(){
        System.out.println("构造函数");
    }
}
public class TestInit {
    public static void main(String[] args){
        new TestInitClass();
    }
}
