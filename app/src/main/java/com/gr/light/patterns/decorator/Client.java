package com.gr.light.patterns.decorator;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-19
 **/
public class Client {
    private final static String TAG = "Decorator";
    public static void execute(){

        SchoolReport schoolReport;
        schoolReport = new FourthGradeSchoolReport();
        schoolReport = new HighScoreDecorator(schoolReport);
        schoolReport = new SortDecorator(schoolReport);
        schoolReport.report();
        schoolReport.sign("WSS");
    }
}
