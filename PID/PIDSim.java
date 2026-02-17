package PID;

public class PIDSim {
    public static void main(String[] args) {
        double target = 100; // target position
        double initial = 0; //initial position

        double error = target - initial;
        // params here can be messed/tuned with to see how they affect the system
        PID pid = new PID(error, 1, 0.01, 0.2, 10, 2, 2, 10);

        double dt = 0.02;
        double time = 0;
        double currentPosition = initial;

        // header for csv 
        System.out.println("Time,Position,Error,Output");
        while (!pid.isSettled()) {
            error = target - currentPosition;
            double output = pid.calculate(error);
            // simple physics sim: position changes by output every 20ms
            currentPosition += output * dt;
            System.out.println(String.format("%.2f,%.2f,%.2f,%.2f", time, currentPosition, error, output));

            time += dt;
        }
    }
}
