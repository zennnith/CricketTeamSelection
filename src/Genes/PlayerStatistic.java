/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Genes;

/**
 *
 * @author ZenitH
 */
public class PlayerStatistic extends Player{
    
    private double battingAvg;
    private double battingstrkRate;
    
    private double bowlingAvg;
    private double bowlingeconomy;
    private double bowlingstrkRate;
    
    private int catches;
    private int stumpings;

    /**
     * @return the battingAvg
     */
    public double getBattingAvg() {
        return battingAvg;
    }

    /**
     * @param battingAvg the battingAvg to set
     */
    public void setBattingAvg(double battingAvg) {
        this.battingAvg = battingAvg;
    }

    /**
     * @return the battingstrkRate
     */
    public double getBattingstrkRate() {
        return battingstrkRate;
    }

    /**
     * @param battingstrkRate the battingstrkRate to set
     */
    public void setBattingstrkRate(double battingstrkRate) {
        this.battingstrkRate = battingstrkRate;
    }

    /**
     * @return the bowlingAvg
     */
    public double getBowlingAvg() {
        return bowlingAvg;
    }

    /**
     * @param bowlingAvg the bowlingAvg to set
     */
    public void setBowlingAvg(double bowlingAvg) {
        this.bowlingAvg = bowlingAvg;
    }

    /**
     * @return the bowlingeconomy
     */
    public double getBowlingeconomy() {
        return bowlingeconomy;
    }

    /**
     * @param bowlingeconomy the bowlingeconomy to set
     */
    public void setBowlingeconomy(double bowlingeconomy) {
        this.bowlingeconomy = bowlingeconomy;
    }

    /**
     * @return the bowlingstrkRate
     */
    public double getBowlingstrkRate() {
        return bowlingstrkRate;
    }

    /**
     * @param bowlingstrkRate the bowlingstrkRate to set
     */
    public void setBowlingstrkRate(double bowlingstrkRate) {
        this.bowlingstrkRate = bowlingstrkRate;
    }

    /**
     * @return the catches
     */
    public int getCatches() {
        return catches;
    }

    /**
     * @param catches the catches to set
     */
    public void setCatches(int catches) {
        this.catches = catches;
    }

    /**
     * @return the stumpings
     */
    public int getStumpings() {
        return stumpings;
    }

    /**
     * @param stumpings the stumpings to set
     */
    public void setStumpings(int stumpings) {
        this.stumpings = stumpings;
    }
    
}
