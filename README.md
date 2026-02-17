# Robotics Control Systems
This repository is practice for implemeting classic control algs and motion planning. The goal is to understand the math behind it
and also learn how to write the sim for each.

## PID
PID is a feedback based control system that calculates the error between the setpoint and goal position. 
The controller then applies three components:
### Proportional (P)
This constant reacts to the current error. A larger error means a stronger correction. 
### Integral (I)
Accumulates past error over time. Mainly used to help the system when it undershoots.
### Derivative (D)
Predicts future error by looking at rate of change. This constant reduces overshoot.

After running the PID sim, export the logs as a CSV file and plot the graphs in matlab:
```
data = readtable('pid_data.csv');

% Create figure with subplots
figure('Position', [100, 100, 1200, 800]);

% Position vs Time
subplot(2,2,1);
plot(data.Time, data.Position, 'b-', 'LineWidth', 2);
hold on;
yline(100, 'r--', 'LineWidth', 2);
xlabel('Time (s)');
ylabel('Position');
title('Position vs Time');
legend({'Position', 'Target'});
grid on;

% Error vs Time
subplot(2,2,2);
plot(data.Time, data.Error, 'r-', 'LineWidth', 2);
xlabel('Time (s)');
ylabel('Error');
title('Error vs Time');
grid on;

% Control Output vs Time
subplot(2,2,3);
plot(data.Time, data.Output, 'g-', 'LineWidth', 2);
xlabel('Time (s)');
ylabel('PID Output');
title('PID Output vs Time');
grid on;
```

Graph with default PID params:

<img width="1196" height="826" alt="Screenshot 2026-02-16 at 4 35 09 PM" src="https://github.com/user-attachments/assets/bb4f8d45-9550-438e-ba80-ebff73bf1ad1" /> 


