package com.example.wuruixuan.androidstudy.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.wuruixuan.androidstudy.R;
import com.example.wuruixuan.androidstudy.activity.classes.Cat;
import com.example.wuruixuan.androidstudy.activity.classes.Dog;

/**
 * Activity的三个状态和七大生命周期
 */

public class ActivityA extends AppCompatActivity {

    private EditText et_info;

    /**
     * Activity创建时第一个调用的方法，通常我们在该方法中加载布局文件，初始化UI组件，事件注册等等
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        System.out.println("Activity-onCreate");

        et_info = findViewById(R.id.editText_info);
    }

    /**
     * 在onCreate方法之后调用，用于显示界面，但用户还不能进行交互
     */
    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("Activity-onStart");
    }

    /**
     * 当一个stopped状态的Activity被返回时调用，之后再调用onResume方法进入运行状态
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("Activity-onRestart");
    }

    /**
     * 在onStart方法后调用，该方法执行完成后，用户可以进行交互，当前Activity进入resumed状态
     * 当一个paused状态的Activity被重新返回时，会再次调用该方法，让Activity进入运行状态
     */
    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("Activity-onResume");
    }

    /**
     * 当其他Activity（透明或窗口模式）进入时，该方法会被调用，让当前Activity进入paused状态（暂停状态）
     * 当前Activity还可见，但不可交互，如果其他更高优先级的App需要内存时，当前Activity可能会被销毁（kill）
     * 当前Activity被返回时，会调用onResume方法
     */
    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("Activity-onPause");
    }

    /**
     * 当其他Activity完全覆盖该Activity时，会被调用，当前Activity会进入stopped状态（停止状态）
     * 不可见，如果其他更高优先级的App需要内存时，当前Activity可能会被销毁（kill）
     * 当前Activity被返回时，会调用onRestart方法
     */
    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("Activity-onStop");
    }

    /**
     * 当前Activity被销毁时调用，通常在该方法中用来释放资源，当前Activity killed
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("Activity-onDestroy");
    }

    /**
     * 启动ActivityB，并传递数据
     */
    public void sendClick1(View view) {
        Intent intent = new Intent(this, ActivityB.class);
        String info = et_info.getText().toString();
        // 封装要传递的数据
        Bundle data = new Bundle();
        data.putString("info", info);
        intent.putExtra("data", data);
        startActivity(intent);
    }

    public void sendClick2(View view) {
        Intent intent = new Intent(this, ActivityB.class);
        String info = et_info.getText().toString();
        // 不封装直接传递
        intent.putExtra("info", info);
        intent.putExtra("age", 20);
        startActivity(intent);
    }

    public void sendObjClick1(View view) {
        Cat cat = new Cat();
        cat.name = "皮卡丘";
        cat.age = 2;
        cat.type = "英短";
        // 实现Serializable接口
        Intent intent = new Intent(this, ActivityB.class);
        intent.putExtra("cat", cat);
        startActivity(intent);
    }

    public void sendObjClick2(View view) {
        Dog dog = new Dog();
        dog.name = "旺旺";
        dog.age = 1;
        dog.type = "萨摩耶";
        // 实现Parcelable接口，性能更好
        Intent intent = new Intent(this, ActivityB.class);
        intent.putExtra("dog", dog);
        startActivity(intent);
    }
}
