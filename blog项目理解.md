# 结构

![image-20230912203948845](images\image-20230912203948845.png)



# model

## Article

- 成员变量：

```java
	private int id;
    private String title;
    private String subtitle;
    private String md_content;
    private String html_content;
    private String createdate;
    private int sub_id=0;
    private int main_id;
    private String mname;
    private String sname;
    private int top;
```

- 表：

![image-20230912204843194](images\image-20230912204843194.png)

> `TEXT`可用于存储可以从`1`字节到`4GB`长度的文本字符串。 我们经常在电子商务网站中找到用于在新闻站点存储物品的`TEXT`数据类型，如：产品详细描述。
>
> 与`CHAR`和`VARCHAR`不同，您不必在列使用`TEXT`类型时指定存储长度。 此外，当检索或插入文本数据(如`CHAR`和`VARCHAR`)时，MySQL不会删除或填充空格。
>
> > 请注意，`TEXT`数据不存储在数据库服务器的内存中，因此，每当查询`TEXT`数据时，MySQL都必须从磁盘读取它，这与`CHAR`和`VARCHAR`相比要慢得多。
>
> //更多请阅读：https://www.yiibai.com/mysql/text.html 

所以我推测`pri`vate String md_content;`
    private String html_content;`是博客文章内容

- 成员方法

  - 构造函数【**养成写默认构造的习惯**】】

  ```java
  public Article() {
      }
  
      public Article(int id,String title, String subtitle, String md_content, String html_content, String createdate, int sub_id, int main_id, String mname,String sname, int top) {
          this.id = id;
          this.title = title;
          this.subtitle = subtitle;
          this.md_content = md_content;
          this.html_content = html_content;
          this.createdate = createdate;
          this.sub_id = sub_id;
          this.main_id = main_id;
          this.mname = mname;
          this.sname = sname;
          this.top = top;
      }
  
  ```

  - 构造方法+1

    ```java
    public Article(Map<String, Object> map) {
            this.id = (int) map.get("id");
            this.title = (String) map.get("title");
            this.subtitle = (String) map.get("subtitle");
            this.md_content = (String) map.get("md_content");
            this.html_content = (String) map.get("html_content");
            this.createdate = (String) map.get("createdate");
    //        if (map.get("sub_id")!=null)
    //            this.sub_id = (int) map.get("sub_id");
            this.main_id = (int) map.get("main_id");
            this.mname = (String) map.get("mname");
            this.sname = (String) map.get("sname");
            this.top = (int) map.get("top");
        }
    ```

    

> 方法名：
> V get(Object key)
>
> 参数：
> key：要获取其对应值的键
>
> 返回值：
> 该键对应的值（如果存在），如果键不存在，则返回null

由`Map<String, Object> map`可知value是Object类型，所以用强制类型转换转换成对应类型:`this.id = (int) map.get("id");`

## category(分类)

```java
public Category(Map<String, Object> map) {
        this.main_id = (int) map.get("id");
        this.main_name = (String) map.get("name");
        if (map.get("sub_id")!=null)
            this.sub_id = (int) map.get("sub_id");
        if (map.get("sub_name")!=null)
            this.sub_name = (String) map.get("sub_name");
        this.sub_count =  (Number)map.get("sub_count");
    }
```

因为可能没有子分类，所以加判断 `if (map.get("sub_id")!=null)`



## 