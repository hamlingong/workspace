package com.kunhong.design.TemplateMethod;

/**
 * 具体模板角色类
 * @author lyq
 *
 */
public class MoneyMarketAccount extends Account {

    @Override
    protected String doCalculateAccountType() {
        
        return "Money Market";
    }

    @Override
    protected double doCalculateInterestRate() {
        
        return 0.045;
    }

}
