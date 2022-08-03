package karate.features;


import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.intuit.karate.junit5.Karate;
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

public class TestRunner {

        @Test
        void testParallel(){
            String karateoutputPath="build/reports/karate-reports";
            Results results = Karate.run().relativeTo(getClass())
                    .outputCucumberJson(true)
                    .tags("~@ignore")
                    .reportDir(karateoutputPath)
                    .parallel(1);

            generateReport(results.getReportDir());

            assertTrue(results.getFailCount()==0, results.getErrorMessages());
        }

        void generateReport(String karateoutputPath){
            File reportOutputDir=new File(karateoutputPath);
            Collection<File> jsonFiles= FileUtils.listFiles(reportOutputDir,new String[]{"json"},true);
            List<String> jsonPaths=new ArrayList<>(jsonFiles.size());
            jsonFiles.forEach(file->jsonPaths.add(file.getAbsolutePath()));

            String projectName="spring-boot-api-heroku-demo";

            Configuration configuration=new Configuration(reportOutputDir,projectName);
            configuration.setSortingMethod(SortingMethod.NATURAL);
            configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
            ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, configuration);
            reportBuilder.generateReports();

        }

}
