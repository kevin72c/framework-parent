# 后台Java开发规范
  （参见[framework.standard项目源码](https://www.xxx.com)）  
# 前言
本文在参考业界已有的编码风格的基础上，描述公司开发项目风格，力求一种统一的编程风格，并从整体编码风格、代码文件风格、函数编写风格、变量风格、注释风格等几个方面进行阐述。（这些规范并不是一定所有都的好的，如有更好的建议大家讨论后修改规范，如果没有则按本文规范开发，主要目的让程序有良好的可读性，易于将来扩展维护）

后台开发需要严格按照最新规范来执行，赛事项目开始代码按照此文档作为review标准，希望大家认真阅读，如有不到位的地方尽早提出建议，将公司的技术规范做的更好
## 整体编码风格
- 缩进
  - 每当开始一个新的块，缩进增加4个空格，当块未结束换行时，缩进8个空行；当块结束时，缩进返回先前的缩进级别。
  - ==IDEA设置： File - Settings - Editor - Code Style - Java - （use tab character把勾去掉，tab size、indent设置为4）==
- 每列代码长度限制 120个字符
  - ==IDEA设置边境线设置方法： File - Settings - Editor - Code Style - Right margin (columns) 设置为100==
- 大括号  
  - 大括号与if, else, for, do, while语句一起使用时，即使只有一条语句(或是空)，也应该把大括号写上。
对于非空块和块状结构，遵循以下风格
左大括号前不换行
  - 左大括号后换行
  - 右大括号前换行
  - 如果右大括号是一个语句、函数体或类的终止，则右大括号后换行; 否则不换行。例如，如果右大括号后面是else或逗号，则不换行。

示例：
```
if (condition {
    for (int i = 0; i < length; i++) {
        ...
    }
} else {
    while (true) {
        ...
    }
}
```

## 命名约定
1. 包名
   - 全部小写，尽量使用单个单词命名，组合单词只是简单连接起来，不使用下划线、横线等特殊符号
2. 类名
   - 都以UpperCamelCase驼峰风格编写
   - 类名通常是名词或名词短语，接口名称有时可能是形容词或形容词短语。现在还没有特定的规则或行之有效的约定来命名注解类型。
   - 测试类的命名以它要测试的类的名称开始，以Test结束。例如，HashTest或HashIntegrationTest。
3. 方法名
   - 方法名都以lowerCamelCase风格编写。
   - 方法名通常是动词或动词短语。
4. 变量名
   - 常量名命名模式为CONSTANT_CASE，全部字母大写，用下划线分隔单词。那，到底什么算是一个常量？

   - 每个常量都是一个静态final字段，但不是所有静态final字段都是常量。在决定一个字段是否是一个常量时， 考虑它是否真的感觉像是一个常量。例如，如果任何一个该实例的观测状态是可变的，则它几乎肯定不会是一个常量。 只是永远不打算改变对象一般是不够的，它要真的一直不变才能将它示为常量。
   ```
    // Constants
    static final int NUMBER = 5;
    static final ImmutableList<String> NAMES = ImmutableList.of("Ed", "Ann");
    static final Joiner COMMA_JOINER = Joiner.on(',');  // because Joiner is immutable
    static final SomeMutableType[] EMPTY_ARRAY = {};
    enum SomeEnum { ENUM_CONSTANT }
    
    // Not constants
    static String nonFinal = "non-final";
    final String nonStatic = "non-static";
    static final Set<String> mutableCollection = new HashSet<String>();
    static final ImmutableSet<SomeMutableType> mutableElements = ImmutableSet.of(mutable);
    static final Logger logger = Logger.getLogger(MyClass.getName());
    static final String[] nonEmptyArray = {"these", "can", "change"};
   ```
5. 非常量字段名
    - 非常量字段名以lowerCamelCase风格编写。
    - 这些名字通常是名词或名词短语。

6. 参数名
    - 参数名以lowerCamelCase风格编写。
    - 参数应该避免用单个字符命名。

7. 局部变量名
    - 局部变量名以lowerCamelCase风格编写，比起其它类型的名称，局部变量名可以有更为宽松的缩写。
    - 虽然缩写更宽松，但还是要避免用单字符进行命名，除了临时变量和循环变量。
    - 即使局部变量是final和不可改变的，也不应该把它示为常量，自然也不能用常量的规则去命名它。

8. 驼峰式命名法(CamelCase)
    - 驼峰式命名法 分大驼峰式命名法(UpperCamelCase)和小驼峰式命名法(lowerCamelCase)。 有时，我们有不只一种合理的方式将一个英语词组转换成驼峰形式，如缩略语或不寻常的结构(例如"IPv6"或"iOS")。Google指定了以下的转换方案。

    - 名字从散文形式(prose form)开始:
    1. 把短语转换为纯ASCII码，并且移除任何单引号。例如："Müller’s algorithm"将变成"Muellers algorithm"。
    2. 把这个结果切分成单词，在空格或其它标点符号(通常是连字符)处分割开。
        - 推荐：如果某个单词已经有了常用的驼峰表示形式，按它的组成将它分割开(如"AdWords"将分割成"ad words")。 需要注意的是"iOS"并不是一个真正的驼峰表示形式，因此该推荐对它并不适用。
    3. 现在将所有字母都小写(包括缩写)，然后将单词的第一个字母大写：
        - 每个单词的第一个字母都大写，来得到大驼峰式命名。
        - 除了第一个单词，每个单词的第一个字母都大写，来得到小驼峰式命名。
    4. 最后将所有的单词连接起来得到一个标识符。
示例：
```
Prose form                Correct               Incorrect
------------------------------------------------------------------
"XML HTTP request"        XmlHttpRequest        XMLHTTPRequest
"new customer ID"         newCustomerId         newCustomerID
"inner stopwatch"         innerStopwatch        innerStopWatch
"supports IPv6 on iOS?"   supportsIpv6OnIos     supportsIPv6OnIOS
"YouTube importer"        YouTubeImporter
```
## 注释
### 原则：
1. 注释形式统一
> 在整个应用程序中，使用具有一致样式来构造注释，按照这份规范写代码，不要试图在既成的规范系统中引入新的规范。

2、注释内容准确简洁
> 内容要简单、明了、含义准确，防止注释的多义性，错误的注释不但无益反而有害。比如一个“场馆”模块，那么就不要在方法里说明这个是场馆的a方法，那个是场馆的b方法
### 注释条件：
1. 基本注释（必须加）  
    1. 类（接口）的注释
    2. 构造函数的注释
    3. 方法的注释
    4. 全局变量的注释
    5. 字段/属性的注释
> 备注：简单的代码做简单注释，注释内容不大于10个字即可，另外，Model对象的getter、setter方法不需加注释。具体的注释格式请参考下面举例。
2. 特殊必加注释（必须加）
    1. ==典型算法必须有注释==。
    2. 在代码不明晰处必须有注释。
    3. 在代码修改处加上修改标识的注释。
    4. 在循环和逻辑分支组成的代码中加注释。
    5. ==为他人提供的接口必须加详细注释。==
3. 注释格式
    1. 单行(single-line)注释：“// ...”
    2. 块(block)注释：“/*……*/”
    3. 文档注释：“/**……*/”
    4. javadoc 注释标签语法
        - @author   对类的说明 标明开发该类模块的作者
        - @version   对类的说明 标明该类模块的版本
        - since 服务最早提供版本
        - @see     对类、属性、方法的说明 参考转向，也就是相关主题， ==填写路径例如： com.c.j.w.api.demo@method==
        - @param    对方法的说明 对方法中某参数的说明
        - @return   对方法的说明 对方法返回值的说明
        - @exception  对方法的说明 对方法可能抛出的异常进行说明

## 编程实践
- @Override：能用则用
- 捕获的异常：不能忽视
    - 所有的异常必须打印日志，如果他确实不需要在catch块做任何响应，需要做注释加以说明（如以下的例子）
    ```
    try {
      int i = Integer.parseInt(response);
      return handleNumericResponse(i);
    } catch (NumberFormatException ok) {
      // it's not numeric; that's fine, just continue
    }
    
    return handleTextResponse(response);
    ```
- 静态成员：使用类进行调用
    - 使用类名调用静态的类成员，而不是具体某个对象或表达式。
    ```
    Foo aFoo = ...;
    Foo.aStaticMethod(); // good
    aFoo.aStaticMethod(); // bad
    somethingThatYieldsAFoo().aStaticMethod(); // very bad
    ```
- 性能与安全
1. 不要使用String str=new String（”abc”）；这将产生2个对象，应当使用String str=”abc”
2. 处理可变String 时候尽量使用StringBuffer类。
3. 尽量避免使用Vector 和HashTable等旧的集合实现。由于时实现时同步的，故大量操作带来不必要的性能损失。应使用ArrayList和HashMap来代替。如果一定要使用同步集合类，当使用如下方式：Map map=Collections.synchronizedMap（new HashMap（））；。
4. 避免在循环中频繁的构建和释放对象。
5. 如无必要，不要序列化对象。
6. 垃圾收集和资源释放，可能有异常的操作时必须在try的finally块中释放资源，如数据库连接，I/O操作等
```
Connection connection = null;
try {
    ...
} catch(Exception e) {
   e.printStackTrace(); 
} finally {
    if (connection != null) {
        connection.close();
    }
}
```
## 逻辑比较
```
boolean b1 = arg == "str"; // bad 字符串比较使用equals方法而不是==
boolean b2 = "str".equals(arg); // good

if (orderType == 0) // bad 可读性差，项目避免出现类似判断
if (orderType == OrderTypeDict.Venue_Site_Order.code) // good 使用字典常量比较，可读性强， 方便维护

if (startTime > now()) // not good
boolean past = startTime > now();
if (past) // good 把变量当成注释来使用，代码清晰
```

# 项目开发
## Model层
---
> 数据模型创建在model项目，命名方式首字母大写驼峰模式
> 要求类与字段必须注解说明（ApiModel、ApiModelProperty）  
> 使用@Data注解生成getter、setter方法
> 使用@Builder注解生成建造者模式model，构建对象使用build方法
--- 
#### Pojo 数据库表映射对象  
> 主键使用Long型、20位、无符号、自增  
> 日期字段使用Long型  
> 存放目录 com.c.j.w.*.model.pojo
---

```
@Data
@ApiModel("Pojo实体")
public class Pojo {
    
    @ApiModelProperty("主键")
    private Long pojoID;
    @ApiModelProperty("开始日期")
    private Long startDate;
    
}
```
#### Vo 接口返回结果对象
> 存放目录 com.c.j.w.*.model.vo
#### Param 接口请求参数对象
> 存放目录 com.c.j.w.*.model.param
#### Dict 数据字典类
> 模块部分目录：com.c.j.w.*.model.dict  
> 公共部分目录：com.c.j.w.model.dict  
> 字典为枚举类，类名为字段名加Dict后缀，必须有code与name字段，规范如下
```
public enum StandardDict {

    Standard_Alpha(0, "规范规则Alpha"), // 字典名首字母大写，下划线分隔
    Standard_Beta(1, "规范规则Beta");
    
    public final int code;
    public final String name;

    StandardDict(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
```

## Controller 控制层
- 接口遵循Restful设计规范，使用模块名做命名空间、方法根据业务特点选择GET、POST、DELETE、PATCH、PUT  
- 所有接口均返回Resp对象
- 使用SessionUtil.getSessionUser获取用户信息
- 接口使用RestController注解类，使用Spring4.3新特性GetMapping、PostMapping等声明接口  
- 必须使用Api、ApiOperation注解接口作用
- 使用Check注解参数安全验证，使用required属性判断用户是否登录
- 控制层只做参数验证、控制跳转、无事务处理能力，所有业务处理要求放在service层
```
/**
 * 接口演示
 * @author chenjw
 * @date 2016年9月21日 下午8:19:10
 */
@RestController
@RequestMapping("demo")
@Api(value = "demo", description = "接口标准规范")
public class StandardController {

    @Autowired
    private StandardService standardService;


    @ApiOperation("创建Demo")
    @PostMapping
    @Check(value = "[demoID@d, demoName]")
    public Resp post(@ModelAttribute StandardDetailVo standardDetailVo) {
        return standardService.post(standardDetailVo);
    }

    @ApiOperation("详情查询")
    @GetMapping(value = "{demoID}")
    public Resp<StandardDetailVo> detail(@PathVariable String demoID) {
        return standardService.detail(demoID);
    }

    @ApiOperation("列表查询")
    @GetMapping
    public Resp<List<StandardDetailVo>> list(@ModelAttribute StandardPageQueryParam standardPageQueryParam) {
        return standardService.list(standardPageQueryParam);
    }

    @ApiOperation("删除Demo")
    @DeleteMapping("{demoID}")
    public Resp delete(@PathVariable String demoID) {
        return standardService.delete(demoID);
    }

    @ApiOperation("全量更新")
    @PutMapping
    @Check({"[demoIDLong,demoID]@d", "demoName@ml(128)"})
    public Resp put(@ModelAttribute StandardDetailVo StandardDetailVo) {
        return standardService.put(StandardDetailVo);
    }

    @ApiOperation("差量更新")
    @PatchMapping
    @Check({"demoID@d", "demoName@ml(128)"})
    public Resp patch(@ModelAttribute StandardParam standardParam) {
        return standardService.patch(standardParam);
    }

}
```

## Service 服务层
- 负责具体的业务处理、统一继承BaseService、使用startPage方法分页、使用@Transactional管理事务
- 设计上考虑接口模块化、服务化，按业务最小粒度设计，做到业务可重复使用
- 涉及业务的接口（如有成功、失败情况）使用Resp类包装返回结果，使用Resp.success、Resp.failue方法返回结果
- 公共服务接口声明在dubbo provider项目、使用dubbo consumer远程调用
## Dao 持久层
- 使用mybatis-generator生成代码
- 删除无用增删改查语句、RespMapper
- 尽量少关联表查询，限制在4表以内，尽量使用主键查询数据、尽量不要用mybatis的RespMapper映射方法

## Properties 配置
- 使用ConfigUtil.getProperty获取属性值
```
ConfigUtil.getProperties("dubbo.register.url");
```
- 新框架使用yml配置属性，使用EnvironmentAware读取配置

## Log 日志记录


# 前端开发
## AngularJS网络请求
- 统一使用Rest服务封装方法get、post、patch、put、delete向后台发起网络请求，禁止使用$http或其他网络请求方案，如非要用请说明原因
- 一般情况网络请求只需处理正常的业务响应，即HttpStatus=200，Resp.status=200的业务处理，如果需要定制异常或错误的响应方式则声明error function参数
- 定制异常处理，传入error function参数配置异常响应

```
app.controller('Controller',
  ['$scope', 'Rest', // 注入服务
    function ($scope, Rest) {
        /**
         * Http Get Post Patch Put Delete请求方法，所有Http请求调用参数结构都一致，只需要区分方法名即可访问后台接口
         * option 对象参数
         *    @param: url                必填 接口请求地址
         *    @param: params 请求参数    选填 接口请求参数
         *    @param: success 成功回调   选填 回调参数为接口返回数据
         *    @param: error 错误回调     选填 一般情况网络请求只需处理正常的业务响应，即HttpStatus=200，
         *                                     Resp.status=200的业务处理，
         *                                     如果需要定制异常或错误的响应方式则声明error function参数
         *    @param: config 请求头配置  选填 请求头配置，如特地网络请求使用此参数配置，默认为表单请求
         */
        Rest.get({
            url: "order/" + $scope.orderNo,
            success: function (Resp) {
            	$scope.orderDetail = Resp.infobean;
            }
        });
        Rest.post({
            url: "order",
            success: function (Resp) {
            	Message.info("订单创建成功");
            }
        });
        Rest.delete({
            url: "order",
            success: function (Resp) {
            	Message.info("订单删除成功");
            }
        });
        Rest.patch({
            url: "order",
            success: function (Resp) {
            	Message.info("订单打补丁成功");
            }
        });
        Rest.put({
            url: "order",
            success: function (Resp) {
            	Message.info("订单修改成功");
            }
        });
    }
]);
	
```
- 日期格式化使用dateFormat方法
    - dateFormat  格式为 yyyy-MM-dd
    - dateFormat_ 格式为 yyyy-MM-dd hh:mm: sss
- 字典转换使用convert方法，参数1：字段名首字母大写+Dict结尾，参数2：key值

## 其他
- 所有列表查询页面加上回车查询时间
```
$scope.enterEvent = function (e) {
	var keycode = window.event ? e.keyCode : e.which;
	if (keycode == 13) {
		##调用加载表格方法##
	}
};
```