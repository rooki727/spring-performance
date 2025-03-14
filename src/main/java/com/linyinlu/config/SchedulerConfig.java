package com.linyinlu.config;

import com.linyinlu.service.SelfAssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulerConfig {
     @Autowired
    private SelfAssessmentService selfAssessmentService;

    @Scheduled(fixedRate = 600000)
    public void deleteDataEveryTenMinutes() {
        // 进行定时删除操作
        selfAssessmentService.deleteSelfAssessmentScheduled();
        System.out.println("删除了数据");
    }
}
