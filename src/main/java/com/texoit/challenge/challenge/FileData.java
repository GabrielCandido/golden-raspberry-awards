package com.texoit.challenge.challenge;

import java.io.FileReader;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

@Component
public class FileData {

    @Autowired
    private MovieRepository repository;

    @EventListener
    public void appReady(ApplicationReadyEvent event){
        CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
        try (FileReader fr = new FileReader(ResourceUtils.getFile("classpath:static/movielist.csv"));
            CSVReader reader = new CSVReaderBuilder(fr).withCSVParser(parser).withSkipLines(1).build())
        {
            String[] values = null;
          
            while((values = reader.readNext()) != null){
                this.repository.save(new Movie(Integer.parseInt(values[0]), values[1], values[2], values[3], (values[4].toUpperCase().equals("YES")) ? true : false));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
