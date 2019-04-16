package com.zwc.base.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName SchedulerFixed
 * @Desc TODO   定时任务 - 指定秒
 * @Date 2019/4/16 21:26
 * @Version 1.0
 */
@Service
public class SchedulerFixed {

    // 时间格式化
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /*
     * @ClassName SchedulerFixed
     * @Desc TODO   上一次开始执行时间点之后 3 秒再执行
     * @Date 2019/4/16 21:28
     * @Version 1.0
     */
    @Scheduled(fixedRate = 3000)
    public void fixedRate(){
        System.out.println("SchedulerFixed ---> fixedRate() 方法执行了：" + sdf.format(new Date()));
    }

    /*
     * @ClassName SchedulerFixed
     * @Desc TODO   上一次执行完毕时间点之后 6 秒再执行
     * @Date 2019/4/16 21:32
     * @Version 1.0
     */
    @Scheduled(fixedDelay = 6000)
    public void fixedDelay(){
        System.out.println("SchedulerFixed ---> fixedDelay() 方法执行了：" + sdf.format(new Date()));
    }

    /*
     * @ClassName SchedulerFixed
     * @Desc TODO   第一次延迟 10 秒后执行，之后每一次都按每 1 秒执行一次
     * @Date 2019/4/16 21:35
     * @Version 1.0
     */
    @Scheduled(initialDelay = 10000 , fixedRate = 1000)
    public void initialDelayAndFixedRate(){
        System.out.println("SchedulerFixed ---> initialDelayAndFixedRate() 方法执行了：" + sdf.format(new Date()));
    }

}
