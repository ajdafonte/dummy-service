package pt.caires.dummyservice;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.Test;


/**
 *
 */
class RandomPercentTest
{

    @Test
    void testRandomPercent()
    {
        final String clusterA = "clusterA";
        final String clusterB = "clusterB";
        final ArrayList<String> myList = new ArrayList<>();
        final Random rand = new Random();
        for (int i = 0; i < 1000; i++)
        {
            final int probability = rand.nextInt(100);
            if (probability < 30)
            {
                myList.add(clusterA);
            }
            else
            {
                myList.add(clusterB);
            }
        }

        System.out.println("Number of cluster A:" + myList.stream().filter(s -> s.equals(clusterA)).count());
        System.out.println("Number of cluster B:" + myList.stream().filter(s -> s.equals(clusterB)).count());
    }
}
