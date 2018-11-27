import java.io.Serializable;

public class Mark implements Serializable
{
    private double firstAttestation, secondAttestation, finalExam, overall;
    private double gpa;
    private String symbol_mark;

    public Mark()
    {
        firstAttestation = secondAttestation = finalExam = overall = 0.0;
    }

    public Mark(double mark, int attestation)
    {
        switch (attestation)
        {
            case 1:
                firstAttestation = mark;
                break;
            case 2:
                secondAttestation = mark;
                break;
            case 3:
                finalExam = mark;
        }
    }

    public void calculate_overall()
    {
        overall = firstAttestation + secondAttestation + finalExam;
    }

    public void calculate_symbolMark()
    {
        if(overall >= 95 && overall <= 100)
            symbol_mark = "A";
        else if(overall >= 90 && overall < 95)
            symbol_mark = "A-";
        else if(overall >= 85 && overall < 90)
            symbol_mark = "B+";
        else if(overall >= 80 && overall < 85)
            symbol_mark = "B";
        else if(overall >= 75 && overall < 80)
            symbol_mark = "B-";
        else if(overall >= 70 && overall < 75)
            symbol_mark = "C+";
        else if(overall >= 65 && overall < 70)
            symbol_mark = "C";
        else if(overall >= 60 && overall < 65)
            symbol_mark = "C-";
        else if(overall >= 55 && overall < 60)
            symbol_mark = "D+";
        else if(overall >= 50 && overall < 55)
            symbol_mark = "D";
        else
            symbol_mark = "F";
    }

    public double getGpa(int credits) {
        calculate_GPA(credits);
        return gpa;
    }

    public String getSymbol_mark() {
        calculate_symbolMark();
        return symbol_mark;
    }

    public void calculate_GPA(int credit)
    {
        gpa = (overall*credit)/credit;
    }
    public void setFinalExam(double finalExam) {
        this.finalExam = finalExam;
    }

    public void setFirstAttestation(double firstAttestation) {
        this.firstAttestation = firstAttestation;
    }

    public void setOverall(double overall) {
        this.overall = overall;
    }

    public void setSecondAttestation(double secondAttestation) {
        this.secondAttestation = secondAttestation;
    }

    public double getFinalExam() {
        return finalExam;
    }

    public double getFirstAttestation() {
        return firstAttestation;
    }

    public double getOverall() {

        return firstAttestation+secondAttestation+finalExam;
    }

    public double getSecondAttestation() {
        return secondAttestation;
    }

    @Override
    public String toString() {
        return (firstAttestation + " " + secondAttestation+ " " + finalExam+ " " + overall);
    }
}