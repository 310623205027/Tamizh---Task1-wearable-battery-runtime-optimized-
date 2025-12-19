public class mainfunction {

    public static double getMinimumRuntime(
            double batteryCapacity,
            double initialBattery,
            double[][] tasks,
            double chargeRate) {

        double battery = initialBattery;
        double totalTime = 0.0;

        for (int i = 0; i < tasks.length; i++) {
            double duration = tasks[i][0];
            double drainRate = tasks[i][1];
            double requiredEnergy = duration * drainRate;

            // Feasibility check
            if (requiredEnergy > batteryCapacity) {
                return -1;
            }

            // Charge only if required
            if (battery < requiredEnergy) {
                double deficit = requiredEnergy - battery;
                double idleTime = deficit / chargeRate;

                battery += idleTime * chargeRate;

                if (battery > batteryCapacity) {
                    return -1;
                }

                totalTime += idleTime;
            }

            // Execute task
            battery -= requiredEnergy;
            totalTime += duration;
        }

        return Math.round(totalTime * 10.0) / 10.0;
    }

    public static void main(String[] args) {
        double batteryCapacity = 100;
        double initialBattery = 40;
        double chargeRate = 5;

        double[][] tasks = {
                {10, 3},
                {8, 4},
                {5, 6}
        };

        System.out.println(
                getMinimumRuntime(batteryCapacity, initialBattery, tasks, chargeRate)
        );
    }
}
