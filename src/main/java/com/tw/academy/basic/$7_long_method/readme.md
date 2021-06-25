重构的主要内容：
对printReceipt方法进行重构
- 将方法划分为几个部分
    - 打印头部信息（printHeaders
    - 打印顾客信息（printCustomerInfo
    - 打印商品信息（printItemList
    - 计算州税 （getTotalSalesTx
    - 计算价格 （getTotalAmount
    - 打印州税信息 （printsTotalStateTax)
    - 打印总价格信息 （printTotalAmount)

其中，州税价格和总价格信息这两个内容我将其从一个for循环中抽取出来，
在现代计算机语言中，进行简单业务的for循环并不会更加耗时，独立出来单独的for循环可以有更好的可阅读性。
