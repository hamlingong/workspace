kzl-sModuleLibs
===============

模块化项目工具包


一直都有着自己搭建个框架写写lib demo的想法。

近期由于对以前的一个项目开发不同版本，再加上当时因为http工具包缺陷，想要换一个工具包，但是目前而言，修改更换这些东西都会有不少的代价。

于是就有了这么个想法，，最大限度的重用以前的代码。


根据高内聚低耦合的原则，凡是能隔离的都进行隔离。

目标是，，当项目在任何地方出现变化需要修改时，只是修改这个地方，而不需要东拉西扯的找一大堆东西。


对于工具包，，定义接口，，项目根据接口使用，就算更换别人的实现，也不用修改项目代码。

例如，把一个获取本地数据的activity进行隔离，xml,activity，uiHelper，dataHelper（biz），dao。。。。

使用lib将dao封装，使用接口规范biz


以上，就是本项目的起因。。


目前，本项目只有http 跟adapter两个不完整可使用的模块，以及本人常用的一些工具类模块。这些都会在接下来进行补全，优化。

预期

除了一些工具包的封装，我还会写上一些demo，这些demo都会根据以上的高内聚低耦合的原则编写，也是我以后写代码的一种框架规范。

本人实力有限，如有不对或者疏漏的地方，欢迎指正。

附上一些使用以及借鉴的开源网址
https://github.com/Trinea/android-common
https://github.com/litesuits/android-lite-http
https://github.com/davidleen/android-BaseAdapter-enhance
如有遗漏，还请指出，谢谢！


转载请注明出处https://github.com/zouzhenglu/kzl-sModuleLibs

<a href="kezhenlu@qq.com">kezhenlu@qq.com</a>

柯震陆






