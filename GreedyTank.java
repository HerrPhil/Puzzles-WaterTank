import java.util.*;
import java.util.regex.*;

public class GreedyTank {

    public static void main(String [] args) {
        System.out.printf("Hello greedy water tank solution%n");
        if (args != null && args.length == 1 && args[0].toLowerCase().equals("-usage")) {
            System.out.printf("java GreedyTank%n");
        }
        GreedyTank solution = new GreedyTank();
        int minimumTanks = solution.findMinimumTanks();
        System.out.printf("The minimum number of tanks is %d%n", minimumTanks);
    }

    private int findMinimumTanks() {

//                       12345678901234567890xxxxx
        String street = "H---HH-H----H--H---H";
//      String street = "H---HH-H--HHH--H---H";
//        String street = "-H-HH-H";
//        String street = "-H-HH--";
//        String street = "H---H-H";
//        String street = "--H";

        System.out.printf("check this street %s%n", street);

        int result = -1;

        // if the street has nothing, then return no solution result.

        if (street == null || street.isEmpty()) {
            System.out.printf("street has nothing%n");
            return result;
        }

        if (street.length() > 20) {
            System.out.printf("The street is too long %d%n", street.length());
            return result;
        }

        // if street has one or more empty spaces and no houses, then return no solution result.
        Pattern emptyPattern = Pattern.compile("^([-]+)$");
        Matcher emptyMatcher = emptyPattern.matcher(street);
        if (emptyMatcher.find()) {
            String found = emptyMatcher.group(1);
            System.out.printf("found %s%n", found);
            return result;
        } else {
            System.out.printf("found no empty matches%n");
        }

        // if street has one house, then return no solution result.
        Pattern hasOneHousePattern = Pattern.compile("^(H)$");
        Matcher hasOneHouseMatcher = hasOneHousePattern.matcher(street);
        if (hasOneHouseMatcher.find()) {
            String found = hasOneHouseMatcher.group(1);
            System.out.printf("found %s%n", found);
            return result;
        } else {
            System.out.printf("found no has one house matches%n");
        }

        // if street starts with two houses, then return no solution result.
        Pattern startsWithTwoHousesPattern = Pattern.compile("^(HH[-,H]*)$");
        Matcher startsWithTwoHousesMatcher = startsWithTwoHousesPattern.matcher(street);
        if (startsWithTwoHousesMatcher.find()) {
            String found = startsWithTwoHousesMatcher.group(1);
            System.out.printf("found %s%n", found);
            return result;
        } else {
            System.out.printf("found no starts with two houses matches%n");
        }

        // if street ends with two houses, then return no solution result.
        Pattern endsWithTwoHousesPattern = Pattern.compile("^([-,H]*HH)$");
        Matcher endsWithTwoHousesMatcher = endsWithTwoHousesPattern.matcher(street);
        if (endsWithTwoHousesMatcher.find()) {
            String found = endsWithTwoHousesMatcher.group(1);
            System.out.printf("found %s%n", found);
            return result;
        } else {
            System.out.printf("found no ends with two houses matches%n");
        }

        // if street has one house and one empty space, then return 1 solution result.
        Pattern oneHouseOneSpacePattern = Pattern.compile("^(H-)$|^(-H)$");
        Matcher oneHouseOneSpaceMatcher = oneHouseOneSpacePattern.matcher(street);
        if (oneHouseOneSpaceMatcher.find()) {
            String found = oneHouseOneSpaceMatcher.group(1);
            if (found == null) {
                found = oneHouseOneSpaceMatcher.group(2);
            }
            System.out.printf("found %s%n", found);
            result = 1;
            return result;
        } else {
            System.out.printf("found no one house one space matches%n");
        }

        result = 0;

        // Otherwise, find minimum number of tanks

        char [] streetValues = street.toCharArray();

        // check if index position 1 is free to place a bucket there
        char first = streetValues[0];
        char next = streetValues[1];
        if (first == 'H' && next == '-') {
            streetValues[1] = 'T';
            result++;
        }

        for (int i = 1; i < street.length() - 1; i++) {

            // skip empty spaces or tanks or unrecognized values
            if (streetValues[i] == '-' || streetValues[i] == 'T' || streetValues[i] != 'H') {
                continue;
            }

            // otherwise the ith value should be a house now

            // check if we already placed a bucket at i - 1
            char previous = streetValues[i - 1];
            if (previous == 'T') {
                continue;
            } else {
                // check if i + 1 is free to place a bucket there
                next = streetValues[i + 1];
                if (next == '-') {
                    streetValues[i + 1] = 'T';
                    result++;
                }
                if (next == 'H' && previous == '-') {
                    streetValues[i - 1] = 'T';
                    result++;
                }
                if (next == 'H' && previous == 'H') {
                    // impossible
                    return -1;
                }
            }
        }

        // check if the last position is a house,
        // and whether the previous position is a tank
        int last = street.length() - 1;
        if (streetValues[last - 1] == '-' && streetValues[last] == 'H') {
            streetValues[last - 1] = 'T';
            result++;
        }

        String streetWithTanks = String.valueOf(streetValues);
        System.out.printf("Here is the solution %s%n", streetWithTanks);
        return result;
    }

}
