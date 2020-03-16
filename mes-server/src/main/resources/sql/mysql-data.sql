# 测试插入语句，尽量使得多次执行，结果相同，以免出现覆盖数据的问题
insert into demo_entity (`name`,`create_time`,`update_time`) values ("leiming",localtime(),localtime())