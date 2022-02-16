package com.coding.batchProcessingChallenge.Listener;

import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.batch.core.annotation.OnSkipInProcess;
import org.springframework.batch.core.annotation.OnSkipInRead;
import org.springframework.batch.core.annotation.OnSkipInWrite;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.file.FlatFileParseException;

import java.io.FileOutputStream;
import java.io.IOException;

public class TweetSkipListener {
    private String readErrorFileName = "error/read_skipped";
    private String processErrFileName ="error/process_skipped";
    private String writeErrFileName ="error/write_skipped";

    @OnSkipInRead
    public void onSkipRead(Throwable t){
        if(t instanceof JsonParseException){
            onSkip(t.getMessage(),readErrorFileName);
        }else  if ( t instanceof ParseException){
            onSkip(t.getMessage(),processErrFileName );
        }else if ( t instanceof NullPointerException){
            onSkip(t.getMessage(),processErrFileName );
        }else  if ( t instanceof RuntimeException){
            onSkip(t.getMessage(),processErrFileName );
        }else{
            onSkip(t.getMessage(),processErrFileName );
        }
    }

    @OnSkipInProcess
    public void onSkipinProcess(Object item, Throwable t){
        if ( t instanceof ParseException){
            onSkip(t.getMessage(),processErrFileName );
        }else if ( t instanceof NullPointerException){
            onSkip(t.getMessage(),processErrFileName );
        }else  if ( t instanceof RuntimeException){
            onSkip(item,processErrFileName );
        }else{
            onSkip(t.getMessage(),processErrFileName );
        }
    }

    @OnSkipInWrite
    public void onSkipinWrite(Object item, Throwable t){
        if ( t instanceof NullPointerException){
            onSkip("Item is null..."+t.getMessage(),writeErrFileName );
        }else if(t instanceof RuntimeException){
            onSkip(item,writeErrFileName );
        }else if(t instanceof IllegalArgumentException){
            onSkip(t.getMessage(),writeErrFileName );
        }
    }

    public void onSkip(Object o, String fName){
        FileOutputStream fos = null;
        try {
            fos =  new FileOutputStream(fName, true);
            fos.write(o.toString().getBytes());
            fos.write("\r\n".getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
