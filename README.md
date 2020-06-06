### 基础篇简介

#### 一、项目部署

{img}

##### 1.分布式基础概念

·微服务、注册中心\配置中心(nacos)、远程调用(Feign)、网关(spring-cloud-starter-gateway)

##### 2.基础开发

·SpringBoot2.0、SpringCloud、Mybatis-Plus、Vue组件化、阿里云对象化存储

##### 3.环境开发

·VM、Linux、Docker、MySQL、人人开源逆向工程

##### 4.开发规范

·数据校验JSR303、全局异常处理、全局统一返回、全局跨域处理

·枚举状态、业务状态码、VO与TO与PO划分、逻辑删除、

·Lombok：@Data(实体添加GET/SET方法)、@Slf4j(开启日志记录)

#### 二、环境搭配

~~~properties
//1-Redis进入Redis-cli:$docker exec -it redis /bin/bash
				 	   $redis-cli
//2-创建并配置mySQL容器:docker run -p 3306:3306 --name mysql \
-v /mydata/mysql/log:/var/log/mysql \
-v /mydata/mysql/data:/var/lib/mysql \
-v /mydata/mysql/conf:/etc/mysql \
-e MYSQL_ROOT_PASSWORD=root \
-d mysql:5.7

~~~



#### 三、数据库配置

~~~yml
spring:
  datasource:
    username: root
    password: root
    url: jdbc:mysql://192.168.252.128:3306/gulimall_pms?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC
    driver-class-name: com.mysql.cj.jdbc.Driver
~~~

#### 四、相关配置

##### 1.Nacos配置

~~~properties
/**
 * 1-如何使用Nacos作为配置中心统一管理配置
 *      1.依赖
 *          <dependency> cloud</grouId>
 *              <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
 *          </dependency>
 *      2.创建一个bootstrap.properties:
 *          spring.application.name=gulimall-coupon
 *          spring.cloud.nacos.config.server-addr=127.0.0.1:8848
 *      3.需要给配置中心默认添加一个（Data Id/数据集）gulimall-coupon.properties(应用名.properties)
 *      4.动态获取配置
 *              @RefreshScope:动态获取并刷新配置
 *              @Value("${配置项的名}")：获取到配置
 *              如果nacos配置中心和本地的配置文件中都配置了相同的项--优先使用nacos配置中心的配置
 * 2-细节
 *      1.命名空间：配置隔离：
 *          默认：public(保留空间):默认新增的所有配置都在public空间；
 *          1.开发、测试、生产:利用命名空间实现环境隔离
 *            注意：在bootstrap.properties配置上 需要在哪个命名空间下的配置
 *            spring.cloud.nacos.config.namespace=XXXXXXXXXXXXXXXXXXXXXXXXXXX(配置管理ID)
 *          2.每一个微服务之间互相隔离配置，每一个微服务都创建自己的命名空间，只加载自己命名空间下的所有配置
 *      2.配置集：所有的配置的集合
 *      3.配置集ID：
 *          Data ID--类似文件名
 *      4.配置分组：
 *          默认所有的配置集都属于：DEFAULT_GROUP;----1111,618,1212
 *          配置配置分组：spring.cloud.nacos.config.group=1111---配置分组
 *
 * 每个微服务创建自己的命名空间，使用配置分组区分环境-dev\test\prod
 * 3-同时加载多个配置集
 *  1.微服务任何配置信息，在任何配置文件都可以放在配置中心中
 *  2.只需要在bootstrap.properties说明加载配置中心中哪些配置文件即可
 *  3.@Value、@ConfigurationProperties
 *  以前SpringBoot任何方法从配置文件中获取值，都能使用
 *  配置中心有的优先使用配置中心的配置
 */
~~~

##### 2.API网关-springCloud Gateway

​	原理：请求-->路由规则匹配-->断言判定-->filter拦截

##### 3.配置mybatis-Plus

~~~properties
/**
 * 1.整合MyBatis-Plus
 *  1—导入依赖--mybatis-plus-boot-starter
 *  2—配置
 *      1.配置数据源：
 *          1.导入数据库的驱动
 *          2.在application.yml配置数据源相关信息
 *      2.配置MyBatis-Plus
 *          1.使用@mapperScan
 *          2.告诉mybatis-Plus、sql映射文件位置
 */
~~~

##### 4.添加数据校验功能

~~~properties
 * 3-数据校验-JSR303
 *      1--给Bran添加校验注解：javax.validation.constraints,并定义自己的message提示
 *      2--开启校验功能-在controller方法体的参数上添加@Valid注解
 *          效果：校验错误以后会有默认的响应
 *      3--给校验的bean后紧跟一个BindingResult，就可以获取到校验的结果
 *      4--分组校验（多场景的复杂校验）
 *          1---@NotBlank(message = "品牌名必须提交",groups = {AddGroup.class,UpdateGroup.class})
 *              给校验注解标注什么情况需要进行校验
 *          2---@Validated({AddGroup.class})
 *          3---默认没有指定分组的校验注解 例NotBlank,在分组校验情况@Validated({AddGroup.class})下不生效，只会在Validated生效；
 *      5--自定义校验
 *          1---编写一个自定义的校验注解
 *          2---编写一个自定义的校验器 ConstraintValidator
 *          3---关联自定义的校验器和自定义的校验注解
 * @Documented
 * @Constraint(
 *         validatedBy = {ListValueConstraintValidator.class【可以指定多个不同的校验器，适配不同类型的校验】}
 * )
 * @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
 * @Retention(RetentionPolicy.RUNTIME)
 */
~~~

##### 5.Mybatis分页插件

~~~java
//引入分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        paginationInterceptor.setOverflow(true);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
		paginationInterceptor.setLimit(1000);
		//开启 count 的 join 优化,只针对部分 left join
		paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return paginationInterceptor;
    }
~~~



#### 五、待理解知识点

##### 1.前端相关

###### 1-ES6新特性

~~~html
<script>
//1-发送get请求
this.$http({
url: this.$http.adornUrl(''),
method: 'get',
params: this.$http.adornParams({})
}).then(({ data }) => { })
//2-发送post请求 
this.$http({
url: this.$http.adornUrl(''),
method: 'post',
data: this.$http.adornData(data, false)
}).then(({ data }) => { }); 
//3-生命周期函数
</script>
~~~

~~~properties
1-created(){}:生命周期函数-创建完成(可以访问当前this实例)
2-mouted(){}:生命周期函数-挂载完成(可以访问DOM元素)
3-beforeCreate(){}:生命周期函数-创建之前
4-beforeMoute(){}:生命周期函数-挂载之前
5-beforeUpdate(){}:生命周期函数-更新之前
6-updated(){}:生命周期函数-更新之后
7-beforeDestory(){}:生命周期-销毁之前
8-destoryed(){}:生命周期-销毁完成
9-activated(){}:若页面存在keep-alive缓存功能，该函数会触发
~~~

##### 2.后端相关

###### 1-jdk8新特性

~~~properties
1-queryWrapper.eq("publish_status",status):eq表示publish_status==status
2-queryWrapper.ge("price",min):其中ge表示min小于等于price
3-queryWrapper.le("price",max):其中le表示max大于等于price
~~~

##### 3.第三方相关

###### 1-docker容器搭建

###### 2-MySql命令熟悉

~~~properties
1-虚拟机检查内存情况:free -m
2-docker logs XXX(id):查看idXXX的日志
~~~

##### 5.其他