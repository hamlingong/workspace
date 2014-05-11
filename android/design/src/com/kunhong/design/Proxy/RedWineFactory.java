package com.kunhong.design.Proxy;

/**
*真实主题角色,这里指红酒工厂角色,它实现了SellInterface接口
*/
public class RedWineFactory implements SellInterface{
     public Object sell(){
         System.out.println("真实主题角色RedWineFactory 被调用了");
         return new Object();
     }
}

