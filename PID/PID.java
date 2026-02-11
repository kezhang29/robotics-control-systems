package PID;
/**
 * General-use PID class in robotics. Contains timeout, settle time, 
 * and starti to prevent integral windup.
 */
public class PID {
    private final double kP;
    private final double kI;
    private final double kD;
    private final double starti;

    private double timeSpentRunning = 0;
    private double timeSpentSettled = 0;
    private final double timeout;

    private final double settleError;
    private final double settleTime;
    private double accumulatedError = 0;
    private double previousError = 0;

    public PID(double error, double kP, double kI, double kD, double starti, double settleError, double settleTime, double timeout) {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
        this.starti = starti;
        this.settleError = settleError;
        this.settleTime = settleTime;
        this.timeout = timeout;
    }

    public double calculate(double error) {
        if (Math.abs(error) < starti) {
            accumulatedError += error;
        }

        if ((error>0 && previousError<0)||(error<0 && previousError>0)){ 
            accumulatedError = 0; 
        }

        double output =  kP * error + kI * accumulatedError + kD * (error-previousError);

        previousError = error;

        if (Math.abs(error) < settleError) {
            timeSpentSettled += 0.02;
        } else {
            timeSpentSettled = 0;
        }

        timeSpentRunning += 0.02;
        return output;
    }

    public boolean isSettled() {
        if (timeSpentRunning > timeout && timeout != 0) {
            return true;
        }
        if (timeSpentSettled > settleTime) {
            return true;
        }
        return false;
    }
}
