import java.util.*;

class TestScoreAnalyzer {
    private List<Integer> testScores;

    public TestScoreAnalyzer(List<Integer> testScores) {
        this.testScores = testScores;
    }

    public double calculateAverageScore() {
        int sum = 0;
        for (int score : testScores) {
            sum += score;
        }
        return (double) sum / testScores.size();
    }

    public double calculateMedianScore() {
        List<Integer> sortedScores = new ArrayList<>(testScores);
        Collections.sort(sortedScores);
        int size = sortedScores.size();
        if (size % 2 == 0) {
            return (sortedScores.get(size / 2 - 1) + sortedScores.get(size / 2)) / 2.0;
        } else {
            return sortedScores.get(size / 2);
        }
    }

    public List<Integer> getScoresAboveAverage(double averageScore) {
        List<Integer> aboveAverageScores = new ArrayList<>();
        for (int score : testScores) {
            if (score > averageScore) {
                aboveAverageScores.add(score);
            }
        }
        return aboveAverageScores;
    }

    public List<Integer> getScoresAtAverage(double averageScore) {
        List<Integer> atAverageScores = new ArrayList<>();
        for (int score : testScores) {
            if (score == averageScore) {
                atAverageScores.add(score);
            }
        }
        return atAverageScores;
    }

    public List<Integer> getScoresBelowAverage(double averageScore) {
        List<Integer> belowAverageScores = new ArrayList<>();
        for (int score : testScores) {
            if (score < averageScore) {
                belowAverageScores.add(score);
            }
        }
        return belowAverageScores;
    }

    public void analyzeScores() {
        double averageScore = calculateAverageScore();
        double medianScore = calculateMedianScore();

        List<Integer> aboveAverageScores = getScoresAboveAverage(averageScore);
        List<Integer> atAverageScores = getScoresAtAverage(averageScore);
        List<Integer> belowAverageScores = getScoresBelowAverage(averageScore);

        System.out.println("Test Score Analysis:");
        System.out.println("Average Score: " + averageScore);
        System.out.println("Median Score: " + medianScore);
        System.out.println("Number of Students Above Average: " + aboveAverageScores.size() + ", Median Score: " + calculateMedianScore(aboveAverageScores));
        System.out.println("Number of Students At Average: " + atAverageScores.size() + ", Median Score: " + calculateMedianScore(atAverageScores));
        System.out.println("Number of Students Below Average: " + belowAverageScores.size() + ", Median Score: " + calculateMedianScore(belowAverageScores));
    }
}

public class Main {
    public static void main(String[] args) {
        // Sample student test scores
        List<Integer> studentScores = Arrays.asList(85, 92, 78, 88, 90, 72, 68, 95, 82, 75);

        TestScoreAnalyzer analyzer = new TestScoreAnalyzer(studentScores);
        analyzer.analyzeScores();
    }
}
