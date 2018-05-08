####1.@Configuration&@Bean给容器中注册组件
@Configuration
####2.组件注册-@ComponentScan-自动扫描组件&指定扫描规则
@ComponentScan
   basePackageClasses：对basepackages()指定扫描注释组件包类型安全的替代。
   
   excludeFilters：指定不适合组件扫描的类型。
   
   includeFilters：指定哪些类型有资格用于组件扫描。
   ```
   @Configuration //配置Spring容器  
   @ComponentScan(basePackages={"spitter"},  
       excludeFilters={@Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)}) 
   ```
   lazyInit：指定是否应注册扫描的beans为lazy初始化。
   nameGenerator：用于在Spring容器中的检测到的组件命名。
   resourcePattern：控制可用于组件检测的类文件。
   scopedProxy：指出代理是否应该对检测元件产生，在使用过程中会在代理风格时尚的范围是必要的。
   scopeResolver：用于解决检测到的组件的范围。
   useDefaultFilters：指示是否自动检测类的注释 
####3.Spring中自定义FilterType指定组件过滤规则
   在TypeFilter中有一个需要实现的接口方法：
   boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)throws IOException;
   这个接口有两个参数：
   MetadataReader表示读取到的当前正在扫描的类的信息。
   MetadataReaderFactory 表示可以获得到其他任何类的信息。
   
   
####4.@Scope-设置组件作用域
默认注册是单例的，如果要改变其规则，利用@Scope
Scope:取值:
1.singleton单例模式,
　　全局有且仅有一个实例
2.prototype原型模式，
　　每次获取Bean的时候会有一个新的实例
3.request
    request表示该针对每一次HTTP请求都会产生一个新的bean，同时该bean仅在当前HTTP request内有效
4.session
    session作用域表示该针对每一次HTTP请求都会产生一个新的bean，同时该bean仅在当前HTTP session内有效
5.global session
    global session作用域类似于标准的HTTP Session作用域，
    不过它仅仅在基于portlet的web应用中才有意义。
    Portlet规范定义了全局Session的概念，它被所有构成某个 portlet web应用的各种不同的portlet所共享。
    在global session作用域中定义的bean被限定于全局portlet Session的生命周期范围内。
    如果你在web中使用global session作用域来标识bean，那么web会自动当成session类型来使用。

####5.@Lazy-bean懒加载
```
   @Lazy(true)  
   @Component  
   public class Chinese implements Person{  
      //codes here  
   } 
  ```
  lazy-init（懒加载），表示该bean在容器初始化的时候不进行初始化。第一次使用的时候创建bean，并进行一些初始化
  
####6.@Conditional-按照条件注册bean
spring4.X新加入的,能够按照一定的条件进行注册bean。
自定义Condition,继承这个接口
 ```
    public interface Condition {
        boolean matches(ConditionContext var1, AnnotatedTypeMetadata var2);
    }
  ```
  
  
  https://blog.csdn.net/tianyaleixiaowu/article/details/78201587
  