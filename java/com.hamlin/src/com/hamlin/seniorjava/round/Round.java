package com.hamlin.seniorjava.round;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Round {
    public static void test() {
        /*
         * 目前java支持7中舍入法：
         * 1、 ROUND_UP：远离零方向舍入。向绝对值最大的方向舍入，只要舍弃位非0即进位。
         * 2、 ROUND_DOWN：趋向零方向舍入。向绝对值最小的方向输入，所有的位都要舍弃，不存在进位情况。
         * 3、 ROUND_CEILING：向正无穷方向舍入。向正最大方向靠拢。若是正数，舍入行为类似于ROUND_UP，若为负数，
         * 舍入行为类似于ROUND_DOWN。Math.round()方法就是使用的此模式。
         * 4、
         * ROUND_FLOOR：向负无穷方向舍入。向负无穷方向靠拢。若是正数，舍入行为类似于ROUND_DOWN；若为负数，舍入行为类似于ROUND_UP
         * 。
         * 5、 HALF_UP：最近数字舍入(5进)。这是我们最经典的四舍五入。
         * 6、 HALF_DOWN：最近数字舍入(5舍)。在这里5是要舍弃的。
         * 7、 HAIL_EVEN：银行家舍入法:
         * 舍去位的数值小于5时，直接舍去。
         * 舍去位的数值大于5时，进位后舍去。
         * 当舍去位的数值等于5时，若5后面还有其他非0数值，则进位后舍去，若5后面是0时，则根据5前一位数的奇偶性来判断，奇数进位，偶数舍去。
         * 对于上面的规则我们举例说明
         * 11.556 = 11.56 ------六入
         * 11.554 = 11.55 -----四舍
         * 11.5551 = 11.56 -----五后有数进位
         * 11.545 = 11.54 -----五后无数，若前位为偶数应舍去
         * 11.555 = 11.56 -----五后无数，若前位为奇数应进位
         */

        // 利用double作为参数的构造函数，无法精确构造一个BigDecimal对象
        // 利用String对象作为参数传入的构造函数能精确的构造出一个BigDecimal对象
        BigDecimal d = new BigDecimal("100000"); // 存款

        BigDecimal r = new BigDecimal(0.001875 * 3); // 利息
        BigDecimal i = d.multiply(r).setScale(2, RoundingMode.HALF_EVEN); // 使用银行家算法

        System.out.println("季利息是：" + i);

        /*
         * BigDecimal：
         */
        double f = 111231.5585;
        BigDecimal b = new BigDecimal(f);
        double f1 = b.setScale(2, RoundingMode.HALF_UP).doubleValue();
        System.out.println("double: " + f1);

        /*
         *DecimalFormat:
         *
         */
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
        System.out.println("DecimalFormat: " + df.format(123.345));

        /*
         *
         */
        double dmp = 3.1415926;
        String result = String.format("%.2f", dmp);
        System.out.println("String Double: " + result);
    }
}
