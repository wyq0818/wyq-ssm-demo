package com.wyq.cloud.producer.util.bean;

/*
 * @Author:wuyongqiang
 * @Date:2020-12-23 15:49:15:49
 */
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BeanMapperUtils
{
    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <T> T map(Object source, Class<T> destinationClass)
    {
        return mapper.map(source, destinationClass);
    }

    public static <T> List<T> mapList(Collection<?> sourceList, Class<T> destinationClass)
    {
        List destinationList = Lists.newArrayList();
        for (Iterator localIterator = sourceList.iterator(); localIterator.hasNext(); ) { Object sourceObject = localIterator.next();
            Object destinationObject = mapper.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }

    public static void copy(Object source, Object destinationObject)
    {
        mapper.map(source, destinationObject);
    }
}
