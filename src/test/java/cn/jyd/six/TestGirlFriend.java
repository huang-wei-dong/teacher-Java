package cn.jyd.six;

import org.junit.jupiter.api.Test;

public class TestGirlFriend {
    @Test
    public void testGirlFriend()
    {
        Boy boy = new Boy();
        GirlFriend girlFriend = new ChinaGirlFriend();
        boy.setGirlFriend(girlFriend);
        boy.showFriend();
        System.out.println("----换洋女朋友后----");
        girlFriend= new AmericanGirlFriend();
        boy.setGirlFriend(girlFriend);
        boy.showFriend();
    }

    /**
     * 测试匿名类
     */
    @Test
    public void testAnonymousClass()
    {
        Boy boy = new Boy();
        GirlFriend girlFriend = new GirlFriend() {
            @Override
            public void speak() {
                System.out.println("匿名朋友");
            }
            @Override
            public void cooking() {
                System.out.println("匿名朋友正在做菜");
            }
        };
        boy.setGirlFriend(girlFriend);
        boy.showFriend();
    }

}
