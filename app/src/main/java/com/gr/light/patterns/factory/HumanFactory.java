package com.gr.light.patterns.factory;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-15
 **/
public class HumanFactory extends AbstractHumanFactory {
    @Override
    public <T extends Human> T createHuman(Class<T> c) {
        Human human = null;
        try{
            human = (T)Class.forName(c.getName()).newInstance();
        }catch (Exception e){
            System.out.println("人种生成错误");
        }
        return (T)human;
    }
}
