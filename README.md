# Puzzles-WaterTank

Here is the description of the water tank problem.

## Minimum number of water tanks

Find the minimum number of tanks needed to collect rainwater from all the houses.

We are given a string representing a street with houses and empty spaces.

To collect water from the houses, each house must have a bucket placed next to it.

For a string S of length N:

For example, given S="-H-HH--", the result is "-HTHHT-", that is 2 buckets.

If there is no solution, then return -1;

Some edge cases:

S="H", the result is -1, there is no plot for a tank.

S="HH-HH", the result is -1, there is no plot for a tank for the first and last house.

Assume N is an integer within the range [1..20].

S is a string of either 'H' or '-'.

Another wording:

You are given a 0-indexd string STREET.

Each character in STREET is either 'H' representing a house, or '-' representing an empty space.

You can place tanks on the empty spaces to collect rainwater that falls from the adjacent houses.

The rainwater from a house at index i is collected if a tank is placed at index i - 1 and/or i + 1.

A single tank, if placed adjacent to two houses, can collect the rainwater from both houses.

Return the minimum number of tanks needed so that for every house, there is at least one tank collecting rainwater from it,
or -1 if it is impossible.


I learned today, with some google sleuthing, that this problem is a greedy algorithm problem.

A greedy algorithm is an algorithm that finds a solution to problems in the shortest time/steps possible.

What is a greedy algorithm in computer science?

A greedy algorithm is an algorithmic strategy that makes the best optimal choice at each small stage with the goal of this eventually leading to a globally optimal solution.

This means the algorithm picks the best solution at the moment without regard for consequences.

