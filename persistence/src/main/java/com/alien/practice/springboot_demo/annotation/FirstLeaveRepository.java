package com.alien.practice.springboot_demo.annotation;

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 *  一级仓储 {@link  Repository}
 *  <br/>
 *  层次： @Component -> @Repository -> @FirstLeaveRepository
 *  <br/>
 * {@link Target} --用于定义在注解的上边，表明该注解可以使用的范围。
 * 取值(ElementType)有：
 * 　1.CONSTRUCTOR:用于描述构造器
 * 　2.FIELD:用于描述域
 * 　3.LOCAL_VARIABLE:用于描述局部变量
 * 　4.METHOD:用于描述方法
 * 　5.PACKAGE:用于描述包 用于记录java文件的package文件信息，不使用在一般的类中，而用在固定文件package-info.java中。
 *          注意命名一定是“package-info”。由于package- info.java并不是一个合法的类，
 *          使用eclipse创建类的方式会提示不合法，所以需要以创建文件的方式来创建package-info.java。
 * 　6.PARAMETER:用于描述参数
 * 　7.TYPE:用于描述类、接口(包括注解类型) 或enum声明
 *   8.ANNOTATION_TYPE,  表明此注解可以用在注解类型上
 *   9.TYPE_PARAMETER,   类型参数声明
 *   10.TYPE_USE  类型使用声明
 * <br/>
 * {@link Retention}注解有一个属性value，是RetentionPolicy类型的，Enum RetentionPolicy是一个枚举类型，
 * 这个枚举决定了Retention注解应该如何去保持，也可理解为Rentention 搭配 RententionPolicy使用。
 * RetentionPolicy有3个值：CLASS  RUNTIME   SOURCE
 * 按生命周期来划分可分为3类：
 *      1、RetentionPolicy.SOURCE：注解只保留在源文件，当Java文件编译成class文件的时候，注解被遗弃；
 *      2、RetentionPolicy.CLASS：注解被保留到class文件，但jvm加载class文件时候被遗弃，这是默认的生命周期；
 *      3、RetentionPolicy.RUNTIME：注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在；
 * 这3个生命周期分别对应于：Java源文件(.java文件) ---> .class文件 ---> 内存中的字节码。
 * <br/>
 * {@link Documented} 注释的作用及其javadoc文档生成工具的使用
 * <br/>
 * {@link Repository} 仓储角色
 *
 * @autoor Alien
 * @date 2019-03-13
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repository
public @interface FirstLeaveRepository {

    String value() default "";

}
