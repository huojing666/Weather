package com.Config;

import com.job.WeatherDateSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Sweeney
 * @date 2020/6/26 9:37 PM
 */

@Configuration
public class QuartzConfiguration {
    /**
     * 定义更新频率
     * */
    private static final int TIME = 1800;

    /**
     * JobDetail
     * */
    @Bean
    public JobDetail weatherDataSyncJobDetail() {
        return JobBuilder.newJob(WeatherDateSyncJob.class).withIdentity("WeatherDateSyncJob")
                .storeDurably().build();
    }

    /**
     * Trigger
     * */
    @Bean
    public Trigger weatherDataSyncTrigger() {

        SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(TIME).repeatForever();

        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail())
                .withIdentity("weatherDataSyncTrigger").withSchedule(schedBuilder).build();
    }
}
