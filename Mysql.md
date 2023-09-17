## 时间差：

- TIMESTAMPDIFF(interval, time_start, time_end)可计算time_start-time_end的时间差，单位以指定的interval为准，常用可选：
  - SECOND 秒
  - MINUTE 分钟（返回秒数差除以60的整数部分）
  - HOUR 小时（返回秒数差除以3600的整数部分）
  - DAY 天数（返回秒数差除以3600*24的整数部分）
  - MONTH 月数
  - YEAR 年数

```sql
delete from exam_record
where score<60 and timestampdiff(minute,start_time,submit_time)<5;
```

## 删除记录的方式汇总：

- 根据条件删除：DELETE FROM tb_name [WHERE options] [ [ ORDER BY fields ] LIMIT n ]
- 全部删除（表清空，包含自增计数器重置）：TRUNCATE table tb_name



## 修改表：

1.添加字段：

```sql
alter table xx 

add 字段名 类型;
```

2.修改列名：

```sql
alter table xx

change 原名 新名 类型；
```

3.修改字段类型约束默认值

```sql
alter table xx

modify 字段名 类型 [新约束] [默认值]；
```

4.删除列

```sql
alter table xx

drop 字段名；
```

5.修改表名：

```sql
alter table xx

rename 新表名；


```

