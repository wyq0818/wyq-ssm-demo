package com.wyq.cloud.producer.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
/*
 * @Author:wuyongqiang
 * @Date:2020-12-15 15:40:15:40
 */
public class MybatisPlusGenerator {
    private static MybatisPlusGenerator single = null;

    private MybatisPlusGenerator() {
        super();
    }

    private static MybatisPlusGenerator getSingle() {
        if (single == null) {
            single = new MybatisPlusGenerator();
        }
        return single;
    }

    public void autoGeneration() {
        //全局输出配置
        GlobalConfig gc = new GlobalConfig();
        gc
                .setBaseResultMap(true)//通用查询映射结果
                .setBaseColumnList(true)//通用查询结果列
//                .setSwagger2(true)
                .setActiveRecord(false)
                .setEnableCache(false)
                .setAuthor("WuYongQiang")
                //指定输出文件夹位置
               // .setOutputDir("E:\\service_component\\ssm-plus\\src\\main\\java")
                .setOutputDir("E:")
                .setFileOverride(true)
                .setServiceName("%sService");

        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        String dbUrl = "jdbc:mysql://localhost:3306/spring-boot?serverTimezone=UTC";
        dataSourceConfig
                .setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("root")
                .setDriverName("com.mysql.cj.jdbc.Driver");

        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
//                .setTablePrefix("")//表前缀 生成时不映射到类名中
//                .setFieldPrefix("")//属性前缀
                .setCapitalMode(true)
                .setEntityLombokModel(false)//是否使用lombok
//                .setDbColumnUnderline(true) //
                .setNaming(NamingStrategy.underline_to_camel)//驼峰
//                .setExclude(new String[]{"user"}) // 不用生成的表
                .setInclude("user");//要生成的表

        //生成模板配置
        TemplateConfig tc = new TemplateConfig();
//        tc
//                .setController("...")
//                .setEntity("template/entity.java.vm")
//                .setController("template/controller.java.vm")
//                .setMapper("...")
//                .setXml("...")
//                .setService("...")
//                .setServiceImpl("...");

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc
                .setParent("com.wyq.web.boot")
                .setController("controller")
                .setEntity("entity");

        //自动生成
        new AutoGenerator().setGlobalConfig(gc)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                //.setTemplate(tc)
                .setPackageInfo(pc)
                .execute();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MybatisPlusGenerator generator = MybatisPlusGenerator.getSingle();
        generator.autoGeneration();
    }


}
