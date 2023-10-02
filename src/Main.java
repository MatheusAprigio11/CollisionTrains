import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double lastPosition, positionA, positionB, spdA, spdB,calcTime;
        int time;
        String decis = "Y";

        while (decis.equals("Y")) {
            try {
                System.out.println("Input the first position in KM of the train A>> ");
                positionA = sc.nextInt();

                System.out.println("\nInput the speed of the train A>> ");
                spdA = sc.nextInt();

                System.out.println("\nNow input the first position in KM of the train B>> ");
                positionB = sc.nextInt();

                System.out.println("\nInput the speed of the train B>> ");
                spdB = sc.nextInt();
                if (spdB > 0) {
                    spdB = -spdB;
                }

                if ( spdA >= 0 && spdA <= 300 && positionA >= 0 && spdB <= 10000 ) {
                    if (spdB <= 0 && spdB >= -300 && positionB >= 0 && positionB <= 10000) {
                        calcTime = (positionA - positionB) / (spdB - spdA);
                        lastPosition = positionB + spdB * calcTime;

                        time = (int) calcTime * 3600;
                        time = time * (-1);

                        if (time != 0) {
                            System.out.println();
                            System.out.println("\nLocale of collision: " + lastPosition);
                            System.out.println("\nPassed " + time + " seconds");
                            System.out.println("\nIn the time: " + convertTime(time));
                        } else {
                            System.out.println("\nDoesn't have the collision");
                        }
                    }
                }
            }   catch (InputMismatchException e){
                System.out.println("Invalid Datas. Try again!");
            }
            System.out.println("\nDo you want to continue? [Y] For Yes.");
            System.out.println(">> ");
            decis = sc.next().toUpperCase();
        }
    }
    public static String convertTime(int time){
        //The time is in seconds, so i just convert all of them in hour and minutes.
        int minutes = (time % 3600) / 60;
        int hours = 17 + (time / 3600);
        int seconds = time % 60;

        String formatTime = String.format("%02d:%02d:%02d", hours, minutes, seconds);

        return formatTime;
    }
}