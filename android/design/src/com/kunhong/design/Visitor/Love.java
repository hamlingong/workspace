package com.kunhong.design.Visitor;

/**
 * 恋爱时Man与Woman的不同表现  
 * @author lyq
 *
 */
public class Love implements Visitor{  

  public void visit(Man man) {  
      System.out.println("当男人恋爱时，凡事不懂也装懂");  
  }  


  public void visit(Woman girl) {  
      System.out.println("当女人恋爱时，遇事懂也装不懂");  
  }  
}  