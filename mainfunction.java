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

         
            if (requiredEnergy > batteryCapacity) {
                return -1;
            }

           
            if (battery < requiredEnergy) {
                double deficit = requiredEnergy - battery;
                double idleTime = deficit / chargeRate;

                battery += idleTime * chargeRate;
                totalTime += idleTime;

                if (battery > batteryCapacity) {
                    return -1;
                }
            }

            
            battery -= requiredEnergy;
            totalTime += duration;
        }

        
        return Math.round(totalTime * 10.0) / 10.0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Wearable Battery Runtime Optimizer ===\n");

        
        System.out.print("Enter battery capacity: ");
        double batteryCapacity = sc.nextDouble();

        System.out.print("Enter initial battery level: ");
        double initialBattery = sc.nextDouble();

        System.out.print("Enter charging rate per unit time: ");
        double chargeRate = sc.nextDouble();

        
        System.out.print("\nEnter number of tasks: ");
        int n = sc.nextInt();

        double[][] tasks = new double[n][2];

        System.out.println("\nEnter task details (duration, drain rate):");
        for (int i = 0; i < n; i++) {
            System.out.print("Task " + (i + 1) + " duration: ");
            tasks[i][0] = sc.nextDouble();

            System.out.print("Task " + (i + 1) + " drain rate: ");
            tasks[i][1] = sc.nextDouble();
        }

        double result = getMinimumRuntime(
                batteryCapacity,
                initialBattery,
                tasks,
                chargeRate
        );

        System.out.println("\n=== Output ===");

        if (result == -1) {
            System.out.println("It is NOT possible to execute all tasks with the given constraints.");
        } else {
            System.out.println("Minimum total runtime required: " + result + " units");
        }

        sc.close();
    }
}

