package com.baomidou.generator;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyBatisPlusGenerator implements Serializable {

    //数据库配置信息【根据项目中数据库的信息修改对应参数】
    private static final String DATABASE = "house1.0";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE + "?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&autoReconnect=true&serverTimezone=GMT%2B8";
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "123456";

    //表名中的下划线
    private static final Pattern LINE_PATTERN = Pattern.compile("_(\\w)");

    //TODO 在这个地方添加需要生成的表名
    private final static String[] TABLE_NAMES = {"house_room_base"};

    //父级包名
    private static final String PARENT_PACKAGE_NAME = "com.baomidou";
    //entity包名
    private static final String ENTITY_PACKAGE_NAME = "po";

    //自定义子包名
    private static final String CHILD_PACKAGE_NAME = ".room";

    //基础路径
    private static String basePath;
    //mapper的接口文件(xxxDao.java)路径
    private static String mapperInterfacePath;
    //mapper的xml文件(xxxDao.xml)路径
    private static String mapperXmlPath;

    static {
        //获取工程路径
        String projectPath = MyBatisPlusGenerator.class.getResource("").getPath();
        //获取target下面的资源路径
        String resourcePath = projectPath.substring(0, projectPath.indexOf("/target"));

        basePath = new StringBuffer(resourcePath).append("/src/main/java").toString();

        //TODO mapper的接口文件(xxxDao.java)路径【根据项目需要,修改最后一个路径参数】
        mapperInterfacePath = new StringBuffer(basePath).append("/").append(PARENT_PACKAGE_NAME.replace(".", "/")).append("/dao").append(CHILD_PACKAGE_NAME.replace(".","/")).toString();

        //TODO mapper的xml文件(xxxDao.xml)路径【根据项目需要,修改最后一个路径参数】
        mapperXmlPath = new StringBuffer(resourcePath).append("/src/main/resources").append("/mapper").toString();
    }

    public static void main(String[] args) {
        generate("zhangkun", PARENT_PACKAGE_NAME);
    }


    /**
     * 自动生成代码
     *
     * @param author      作者
     * @param packageName 包名
     * @param tablePrefix 表前缀 【该参数可用来除掉表名的前缀】
     */
    public static void generate(String author, String packageName, String... tablePrefix) {

        // 全局配置
        GlobalConfig gc = initGlobalConfig(author);
       /* gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);*/
        // 数据源配置
        DataSourceConfig dsc = initDataSourceConfig();
        //TODO 包名配置(还可以添加dao、service等包名)
        PackageConfig pc = new PackageConfig()
                .setParent(packageName)
                .setEntity(ENTITY_PACKAGE_NAME + CHILD_PACKAGE_NAME)
                .setMapper("dao" + CHILD_PACKAGE_NAME)
                .setService("service" + CHILD_PACKAGE_NAME)
                .setServiceImpl("service" + CHILD_PACKAGE_NAME +".impl")
                .setController("controller" + CHILD_PACKAGE_NAME);

        // 模板引擎配置
        FreemarkerTemplateEngine templateEngine = new FreemarkerTemplateEngine();


        //每一个entity都需要单独设置InjectionConfig, StrategyConfig和TemplateConfig
        Map<String, String> tableNameMap = getEntityNames(TABLE_NAMES);
        if (null == tableNameMap || tableNameMap.isEmpty()) {
            return;
        }
        for (String tableName : tableNameMap.keySet()) {
            // 代码生成器
            AutoGenerator mpg = new AutoGenerator();
            mpg.setGlobalConfig(gc);
            mpg.setDataSource(dsc);
            mpg.setPackageInfo(pc);
            mpg.setTemplateEngine(templateEngine);

            // 自定义配置
            InjectionConfig cfg = initInjectionConfig();
            mpg.setCfg(cfg);

            // 策略配置
            StrategyConfig strategy = initStrategyConfig(tableName);
            mpg.setStrategy(strategy);

            // 模板配置
            // mapper文件
            String mapperFile = mapperInterfacePath
                    + "/" + tableNameMap.get(tableName) + "Mapper" + StringPool.DOT_JAVA;
            TemplateConfig tc = initTemplateConfig(mapperFile);
            mpg.setTemplate(tc);

            //开始执行
            mpg.execute();
        }
    }


    /**
     * 配置数据源
     *
     * @return
     */
    private static DataSourceConfig initDataSourceConfig() {
        return new DataSourceConfig()
                .setDbType(DbType.MYSQL)
                .setUrl(URL)
                .setDriverName(DRIVER_NAME)
                .setUsername(USER_NAME)
                .setPassword(PASSWORD);
    }

    /**
     * 全局配置
     *
     * @return
     */
    private static GlobalConfig initGlobalConfig(String author) {

        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(basePath);
        globalConfig.setAuthor(author);
        globalConfig.setOpen(false);
        globalConfig.setServiceName("%sService");
        globalConfig.setFileOverride(true);

        return globalConfig;
    }

    /**
     * 自定义配置
     *
     * @return
     */
    private static InjectionConfig initInjectionConfig() {
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                //自定义输入文件名称
                return mapperXmlPath
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);

        return cfg;
    }

    /**
     * 策略配置
     *
     * @param tableName 数据库表名
     * @return
     */
    private static StrategyConfig initStrategyConfig(String tableName) {
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setCapitalMode(true);
        //生成字段注解@TableField
        strategy.setEntityTableFieldAnnotationEnable(true);
        strategy.setEntityLombokModel(true);
        //setTablePrefix可以生成@TableName注解
        strategy.setTablePrefix("");
        strategy.setInclude(tableName);
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);

        return strategy;
    }

    /**
     * 覆盖Entity以及xml
     *
     * @param mapperFile
     * @return
     */
    private static TemplateConfig initTemplateConfig(String mapperFile) {
        TemplateConfig tc = new TemplateConfig();
        tc.setXml(null);
        //如果当前Entity已经存在,那么仅仅覆盖Entity
        File file = new File(mapperFile);
        if (file.exists()) {
            tc.setController(null);
            tc.setXml(null);
            tc.setMapper(null);
            tc.setService(null);
            tc.setServiceImpl(null);
            tc.setEntityKt(null);
        }

        return tc;
    }

    /**
     * @param tableNames 数据库表集合
     * @return
     */
    public static Map<String, String> getEntityNames(String[] tableNames) {
        Map<String, String> result = new HashMap<>();
        String entityName;
        for (String tableName : tableNames) {
            entityName = underlineToCamel(tableName);
            result.put(tableName, entityName);
        }
        return result;
    }


    /**
     * 下划线转驼峰
     *
     * @param str
     * @return
     */
    private static String underlineToCamel(String str) {
        if (null == str || "".equals(str)) {
            return str;
        }
        str = str.toLowerCase();
        Matcher matcher = LINE_PATTERN.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);

        str = sb.toString();
        str = str.substring(0, 1).toUpperCase() + str.substring(1);

        return str;
    }
}
