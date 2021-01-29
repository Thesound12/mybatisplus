package com.bjfu.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.sun.xml.internal.ws.spi.db.DatabindingException;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author Thesound
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    private final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");

        this.setFieldValByName("createTime", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
