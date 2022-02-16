package com.coding.batchProcessingChallenge.writer;

import com.coding.batchProcessingChallenge.domain.*;
import com.coding.batchProcessingChallenge.repository.*;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.json.JacksonJsonObjectMarshaller;
import org.springframework.batch.item.json.JsonFileItemWriter;
import org.springframework.batch.item.json.builder.JsonFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TweetWriter implements ItemWriter<Tweet>, StepExecutionListener {

    @Autowired
    private IUserRespository userRespository;

    @Autowired
    private IPlaceRespository placeRespository;

    @Autowired
    private ITweetEntityRespository tweetEntityRespository;

    @Autowired
    private IHashtagRespository hashtagRespository;

    @Autowired
    private ITweetRespository tweetRespository;

    @Autowired
    private IUserMentionRespository userMentionRespository;

    @Autowired
    private IUrlEntityRespository urlEntityRespository;

    @Autowired
    private IGeometryRespository geometryRespository;

    private StepExecution stepExecution;

    User user;

    Place place;

    Geometry coordinates;

    TweetEntity entities;

    List<TweetHashtagEntity> validHashtags;

    List<TweetHashtagEntity> validSymbols;

    List<UserMention> userMentions;

    List<UrlEntity> urls;

    @Override
    public void write(List<? extends Tweet> items) throws Exception {

        for (Tweet item : items) {
            //save user
            user = item.getUser();
            if (user != null) {
                System.out.println("***************Saving user*********************");
                dbWriteUser(user);
            }else{
                System.out.println("***************saving user failed***********");
            }

            //save place
            if (place != null) {
                System.out.println("***************Saving place*********************");
                dbWritePlace(place);
            }else{
                System.out.println("***************saving place failed***********");
            }
            //save geo
            coordinates = item.getCoordinates();
            if (coordinates != null) {
                System.out.println("***************Saving Geometry*********************");
                dbWriteGeometry(coordinates);
            }else{
                System.out.println("***************saving Geometry failed***********");
            }
            //prepare tweet Entity
            entities = item.getEntities();

            //set tweet hash tags
            validHashtags = entities.getTweetHashtags();
            if (validHashtags.size() > 0) {
                System.out.println("***************Saving hastags*********************");
                dbWriteHashTags(validHashtags);
            }else{
                System.out.println("***************saving hashtags failed***********");
            }

            //set sumbols
            validSymbols = entities.getSymbols();

            //set user mentions
            userMentions = entities.getUserMentions();
            if (userMentions.size() > 0) {
                System.out.println("***************Saving usermentions*********************");
                dbWriteUserMentions(userMentions);
            }else{
                System.out.println("***************saving usermentions failed***********");
            }
            //set urls
            urls = entities.getUrls();
            if (urls.size() > 0) {
                System.out.println("***************Saving urls*********************");
                dbWriteUrls(urls);
            }else{
                System.out.println("***************saving urls failed***********");
            }

            if (entities != null) {
                System.out.println("***************Saving tweet entities*********************");
                dbWriteTweetEntity(entities);
            }else{
                System.out.println("***************saving tweet entities failed***********");
            }

            if (item != null) {
                System.out.println("***************Saving tweet*********************");
                dbWriteTweet(item);
            }else{
                System.out.println("***************saving twee failed***********");
            }
        }

        System.out.println("Saving tweets to db");
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {

        return null;
    }

    private void writeUser(User person, ExecutionContext executionContext) throws Exception {
        JsonFileItemWriter<User> itemWriter = new JsonFileItemWriter<>(new FileSystemResource("output/user.json"), new JacksonJsonObjectMarshaller<>());

        itemWriter.open(executionContext);
        itemWriter.write(Collections.singletonList(person));
        itemWriter.close();
    }



    private RepositoryItemWriter dbWritePlace(Place entity) throws Exception {

        RepositoryItemWriter<Place> itemWriter = new RepositoryItemWriter<>();
        itemWriter.setRepository(placeRespository);
        itemWriter.setMethodName("save");
        itemWriter.write(Collections.singletonList(entity));
        itemWriter.afterPropertiesSet();


        return itemWriter;
    }

    private RepositoryItemWriter dbWriteUser(User person) throws Exception {

        RepositoryItemWriter<User> itemWriter = new RepositoryItemWriter<>();
        itemWriter.setRepository(userRespository);
        itemWriter.setMethodName("save");
        itemWriter.write(Collections.singletonList(person));
        itemWriter.afterPropertiesSet();
        return itemWriter;
    }

    private RepositoryItemWriter dbWriteGeometry(Geometry person) throws Exception {

        RepositoryItemWriter<Geometry> itemWriter = new RepositoryItemWriter<>();
        itemWriter.setRepository(geometryRespository);
        itemWriter.setMethodName("save");
        itemWriter.write(Collections.singletonList(person));
        itemWriter.afterPropertiesSet();
        return itemWriter;
    }

    private RepositoryItemWriter dbWriteHashTags(List<TweetHashtagEntity> entity) throws Exception {

        RepositoryItemWriter<TweetHashtagEntity> itemWriter = new RepositoryItemWriter<>();
        itemWriter.setRepository(hashtagRespository);
        itemWriter.setMethodName("save");
        itemWriter.write(entity);
        itemWriter.afterPropertiesSet();

        return itemWriter;
    }

    private RepositoryItemWriter dbWriteUserMentions(List<UserMention> entity) throws Exception {

        RepositoryItemWriter<UserMention> itemWriter = new RepositoryItemWriter<>();
        itemWriter.setRepository(userMentionRespository);
        itemWriter.setMethodName("save");
        itemWriter.write(entity);
        itemWriter.afterPropertiesSet();

        return itemWriter;
    }

    private RepositoryItemWriter dbWriteUrls(List<UrlEntity> entity) throws Exception {

        RepositoryItemWriter<UrlEntity> itemWriter = new RepositoryItemWriter<>();
        itemWriter.setRepository(urlEntityRespository);
        itemWriter.setMethodName("save");
        itemWriter.write(entity);
        itemWriter.afterPropertiesSet();
        return itemWriter;
    }

    private RepositoryItemWriter dbWriteTweetEntity(TweetEntity person) throws Exception {

        RepositoryItemWriter<TweetEntity> itemWriter = new RepositoryItemWriter<>();
        itemWriter.setRepository(tweetEntityRespository);
        itemWriter.setMethodName("save");
        itemWriter.write(Collections.singletonList(person));
        itemWriter.afterPropertiesSet();
        return itemWriter;
    }

    private RepositoryItemWriter dbWriteTweet(Tweet person) throws Exception {

        RepositoryItemWriter<Tweet> itemWriter = new RepositoryItemWriter<>();
        itemWriter.setRepository(tweetRespository);
        itemWriter.setMethodName("save");
        itemWriter.write(Collections.singletonList(person));
        itemWriter.afterPropertiesSet();
        return itemWriter;
    }
}
