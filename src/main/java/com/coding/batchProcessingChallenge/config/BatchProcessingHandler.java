package com.coding.batchProcessingChallenge.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.coding.batchProcessingChallenge.Listener.TweetSkipListener;
import com.coding.batchProcessingChallenge.domain.Tweet;
import com.coding.batchProcessingChallenge.processor.TweetProcessor;
import com.coding.batchProcessingChallenge.writer.TweetWriter;
import com.fasterxml.jackson.core.JsonParseException;

@EnableBatchProcessing
@Configuration
public class BatchProcessingHandler {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    final Integer skipLimit = 10000;

    final Integer chunkSize = 3;

    @Value("${input.tweet.file}")
    private String inputFile;


    @StepScope
    @Bean
    public JsonItemReader<Tweet> jsonItemReader() {

        JsonItemReader<Tweet> reader = new JsonItemReader<Tweet>(new FileSystemResource(inputFile), new JacksonJsonObjectReader<Tweet>(Tweet.class));

        return reader;
    }
    @Bean
    public Step step1() {

        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(1);
        taskExecutor.setMaxPoolSize(1);
        taskExecutor.afterPropertiesSet();

        return steps.get("step1")
                .<Tweet, Tweet>chunk(chunkSize)
                .reader(jsonItemReader())
                .processor(processor())
                .writer(writer())
                .faultTolerant()
                .skip(JsonParseException.class)
                .skipLimit(skipLimit)
                .skip(ParseException.class)
                .skipLimit(skipLimit)
                .skip(IllegalArgumentException.class)
                .skipLimit(skipLimit)
                .skip(NullPointerException.class)
                .skipLimit(skipLimit)
                .skip(RuntimeException.class)
                .skipLimit(skipLimit)
                .listener(new TweetSkipListener())
                .taskExecutor(taskExecutor)
                .build();

    }

    @Bean
    public Job tweetJob() {
        return jobs.get("tweetJob")
        		
                .incrementer(new RunIdIncrementer())
               .start(step1())
                .build();
    }

    @Bean
    public TweetProcessor processor() {
        return new TweetProcessor();
    }

    @Bean
    public TweetWriter writer() {
        return new TweetWriter();
    }

}


