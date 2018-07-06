package com.prud.zm.pi.batch.helper;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prud.zm.pi.batch.constant.PIBatchConstant;

@Component
public class PaymentBatchJobLauncher {

	@Autowired
    private JobLauncher jobLauncher;
 
    @Autowired
    private Job exportILDataJob;
    
    public String invokeJob() throws Exception {
 
            JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                    .toJobParameters();
            jobLauncher.run(exportILDataJob, jobParameters);
 
        return PIBatchConstant.BATCH_INVOKE_SUCCESS_STATUS;
    }
}
