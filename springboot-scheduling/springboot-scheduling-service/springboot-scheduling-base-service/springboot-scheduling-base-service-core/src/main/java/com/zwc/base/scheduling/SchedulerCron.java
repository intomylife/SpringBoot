package com.zwc.base.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName SchedulerCron
 * @Desc TODO   定时任务 - 表达式
 * @Date 2019/4/16 21:37
 * @Version 1.0
 */
@Service
public class SchedulerCron {

    // 时间格式化
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /*
     * @ClassName SchedulerCron
     * @Desc TODO   上一次开始执行时间点之后 15 秒再执行
     * @Date 2019/4/16 21:45
     * @Version 1.0
     */
    @Scheduled(cron = "*/15 * * * * ?")
    public void cron(){
        System.out.println("SchedulerCron ---> cron() 方法执行了：" + sdf.format(new Date()));
    }

}
