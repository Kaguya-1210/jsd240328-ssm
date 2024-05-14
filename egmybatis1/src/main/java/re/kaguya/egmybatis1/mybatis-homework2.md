

[TOC]

# MyBatis-day01作业

## 作业1

在工程**_04mybatis**中，使用 <font color=red>**xml配置文件的方式**</font> 完成评论表的相关操作

## 作业2

### 商品管理系统练习

#### 1.1 数据要求

* **SQL脚本**：<font color=red>**02练习-商品管理系统.sql**</font>

* 库表说明

  *  库名：**mybatisdb** 
  * 表名： **product**

  * 表字段：商品编号id，商品标题title，商品价格price，商品库存stock

#### 1.2 要求

<font color=red>**工程名：egmybatis数字**</font>

* 第1题：添加一个商品信息 `insertProduct`；
* 第2题：通过`id`查询一个商品的标题和价格 `selectSingleProduct`；
* 第3题：通过`id` 删除一个商品信息 `deleteById`；
* 第4题：查询所有商品的 标题和库存 `selectManyProduct`

#### 1.3 思路梳理

* 第1步：创建工程，勾选依赖；
* 第2步：配置数据库连接信息和xml文件映射位置；
* 第3步：创建实体类；
* 第4步：创建接口和接口方法；
* 第5步：xml配置SQL，之后测试。













