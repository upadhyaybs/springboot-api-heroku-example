package com.codify.demo;


import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestParallel {

        @Test
        void testParallel(){
            String karateoutputPath="build/reports";
            Results results = Runner.path("classpath:com.codify.demo")
                    .outputCucumberJson(true)
                    .karateEnv("demo")
                    .parallel(5);
            generateReport(results.getReportDir());
            assertTrue(results.getFailCount()==0, results.getErrorMessages());
        }

        void generateReport(String karateoutputPath){
            File reportOutputDir=new File(karateoutputPath);
            Collection<File> jsonFiles= FileUtils.listFiles(reportOutputDir,new String[]{"json"},true);
            List<String> jsonPaths=new ArrayList<>(jsonFiles.size());
            jsonFiles.forEach(file->jsonPaths.add(file.getAbsolutePath()));

            String projectName="spring-boot-api-heroku-demo";

          //  Configuration configuration = new Configuration(new File("target"), "demo");
            Configuration configuration=new Configuration(reportOutputDir,projectName);
            configuration.setSortingMethod(SortingMethod.NATURAL);
            configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
            configuration.setTrendsStatsFile(new File("build/demo-trends.json"));

            ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, configuration);
            reportBuilder.generateReports();

        }

}
