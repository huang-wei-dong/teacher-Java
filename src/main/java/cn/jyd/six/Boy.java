package cn.jyd.six;

public class Boy {
    private GirlFriend girlFriend;
    public void showFriend(){
        girlFriend.speak();
        girlFriend.cooking();
    }
    public void setGirlFriend(GirlFriend girlFriend){
        this.girlFriend = girlFriend;
    }
}
