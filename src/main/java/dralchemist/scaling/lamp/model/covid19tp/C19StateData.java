package dralchemist.scaling.lamp.model.covid19tp;

import lombok.Data;

@Data
public class C19StateData {
	
    String date;
    String state;
    String positive;
    String negative;
    String pending;
    String hospitalizedCurrently;
    String hospitalizedCumulative;
    String inIcuCurrently;
    String inIcuCumulative;
    String onVentilatorCurrently;
    String onVentilatorCumulative;
    String recovered;
    String dataQualityGrade;
    String lastUpdateEt;
    String dateModified;
    String checkTimeEt;
    String death;
    String hospitalized;
    String dateChecked;
    String totalTestsViral;
    String positiveTestsViral;
    String negativeTestsViral;
    String positiveCasesViral;
    String deathConfirmed;
    String deathProbable;
    String totalTestEncountersViral;
    String totalTestsPeopleViral;
    String totalTestsAntibody;
    String positiveTestsAntibody;
    String negativeTestsAntibody;
    String totalTestsPeopleAntibody;
    String positiveTestsPeopleAntibody;
    String negativeTestsPeopleAntibody;
    String totalTestsPeopleAntigen;
    String positiveTestsPeopleAntigen;
    String totalTestsAntigen;
    String positiveTestsAntigen;
    String fips;
    String positiveIncrease;
    String negativeIncrease;
    String total;
    String totalTestResultsSource;
    String totalTestResults;
    String totalTestResultsIncrease;
    String posNeg;
    String deathIncrease;
    String hospitalizedIncrease;
    String hash;
    String commercialScore;
    String negativeRegularScore;
    String negativeScore;
    String positiveScore;
    String score;
    String grade;

}
