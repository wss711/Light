package com.gr.light.patterns;

import android.os.Bundle;
import android.view.View;

import com.gr.light.R;
import com.gr.light.activity.BaseActivity;
import com.gr.light.patterns.builder.Director;
import com.gr.light.patterns.factory.AbstractHumanFactory;
import com.gr.light.patterns.factory.BlackHuman;
import com.gr.light.patterns.factory.Human;
import com.gr.light.patterns.factory.HumanFactory;
import com.gr.light.patterns.factory.WhiteHuman;
import com.gr.light.patterns.factory.YellowHuman;
import com.gr.light.patterns.prototype.PrototypePatternsClient;
import com.gr.light.patterns.simplefactory.ComputerFactory;
import com.gr.light.patterns.singleton.HungrySingleton;

import butterknife.OnClick;

public class CreatePatternsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_builder_patterns;
    }

    @OnClick({R.id.singleton_patterns_btn, R.id.simple_factory_patterns_btn, R.id.static_factory_patterns_btn,
            R.id.factory_patterns_btn, R.id.builder_patterns_btn,R.id.prototype_patterns_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.singleton_patterns_btn:
                HungrySingleton.getInstance().print("HungrySingleton");
                break;
            case R.id.simple_factory_patterns_btn:
                ComputerFactory.createComputer("戴尔").start();
                break;
            case R.id.static_factory_patterns_btn:
                break;
            case R.id.factory_patterns_btn:
                factoryPatternsClient();
                break;
            case R.id.builder_patterns_btn:
                builderPatternsClient();
                break;
            case R.id.prototype_patterns_btn:
                PrototypePatternsClient.execute();
                break;

        }
    }

    private void factoryPatternsClient(){
        // 声明创造人的八卦炉
        AbstractHumanFactory bagualu = new HumanFactory();
        // 火候不够，白种人产生了
        System.out.println("--造出的第一批人是白色人种");
        Human whiteHuman = bagualu.createHuman(WhiteHuman.class);
        whiteHuman.getColor();
        whiteHuman.talk();
        // 火候过了，黑种人产生了
        System.out.println("--造出的第二批人是黑色人种");
        Human blackHuman = bagualu.createHuman(BlackHuman.class);
        blackHuman.getColor();
        blackHuman.talk();
        // 火候刚刚好，黄种人产生了
        System.out.println("--造出的第一批人是白色人种");
        Human yellowHuman = bagualu.createHuman(YellowHuman.class);
        yellowHuman.getColor();
        yellowHuman.talk();
        // 一时兴起，棕种人产生了
        Human brownHuman = bagualu.createHuman(BlackHuman.class);
        brownHuman.getColor();
        brownHuman.talk();
    }
    private void builderPatternsClient(){

        Director director = new Director();

        System.out.println("================= 10量宝马X1");
        for (int i = 0; i<10;i++){
            System.out.println("宝马X1-------" + i);
            director.getBmwX1().run();
        }

        System.out.println("================= 5台宝马X3");
        for (int i = 0; i<5;i++){
            System.out.println("宝马X3-------" + i);
            director.getBmwX3().run();
        }

        System.out.println("================= 3量宝马X5");
        for (int i = 0; i<3;i++){
            System.out.println("宝马X5-------" + i);
            director.getBmwX5().run();
        }

        System.out.println("================= 5辆奔驰GLC--------");
        for (int i = 0; i<5;i++){
            System.out.println("奔驰GLC-------" + i);
            director.getBenzGlc().run();
        }
       System.out.println("================= 3辆奔驰GLE--------");
        for (int i = 0; i<3;i++){
            System.out.println("奔驰GLE-------" + i);
            director.getBenzGle().run();
        }
       System.out.println("================= 2辆奔驰GLS--------");
        for (int i = 0; i<2;i++){
            System.out.println("奔驰GLC-------" + i);
            director.getBenzGls().run();
        }
    }



}
