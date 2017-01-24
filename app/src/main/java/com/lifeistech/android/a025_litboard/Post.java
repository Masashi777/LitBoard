package com.lifeistech.android.a025_litboard;

/**
 * Created by Masashi Hamaguchi on 2017/01/22.
 */

public class Post {

    String message;
    String userName;

    //firebaseのための空のコンストラクタ
    public Post() {

    }

    //コンストラクタ
    public Post(String userName, String message) {
        this.userName = userName;
        this.message = message;
    }

    //アクセサリメソッド
    public String getMessage() {return message;}

    public void setMessage(String message) {this.message = message;}

    public String getUserName() {return userName;}

    public void  setUserName(String userName) {this.userName = userName;}
}
