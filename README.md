Wearable Battery Runtime Optimizer
Problem Summary

This project addresses a battery scheduling and optimization problem commonly seen in wearable and embedded systems.
A device with limited battery capacity must execute a sequence of tasks in a fixed order, where each task consumes battery at a constant rate. Between tasks, the device may enter an idle state to recharge the battery at a constant rate.

The objective is to execute all tasks in the minimum possible total runtime while ensuring that the battery level never drops below zero or exceeds the maximum capacity at any point in time.

Approach

A greedy, continuous-time simulation approach is used to solve the problem efficiently.

Key ideas:

Tasks are executed as early as possible.

Charging is treated as a cost because it increases total runtime.

The device only charges when the current battery level is insufficient for the next task.

When charging is required, only the minimum necessary charging time is added.

This approach avoids unnecessary idle periods and guarantees an optimal runtime.

Key Design Decisions

Used a greedy strategy instead of dynamic programming to keep the solution efficient and scalable.

Simulated battery behavior continuously to reflect real-world firmware operation.

Added early feasibility checks to immediately reject impossible task sequences.

Kept the implementation simple, readable, and production-oriented.

Assumptions & Trade-offs

Battery drain and recharge rates are constant throughout execution.

Tasks are non-preemptive and must run to completion once started.

Floating-point arithmetic is used, and the final result is rounded to one decimal place.

Time & Space Complexity

Time Complexity: O(n), where n is the number of tasks

Space Complexity: O(1), as only constant extra memory is used

Project Structure
wearable-battery-runtime-optimizer
│
├── src/
│   └── BatteryRuntimeOptimizer.java
│
├── README.md
└── sample-input-output.txt

How to Run

Navigate to the src directory.

Compile the program:

javac BatteryRuntimeOptimizer.java


Run the program:

java BatteryRuntimeOptimizer

Sample Output

A sample input and corresponding output are provided in sample-input-output.txt for reference.

Author

Dhivya V
