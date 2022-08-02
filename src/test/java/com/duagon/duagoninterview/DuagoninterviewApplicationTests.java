package com.duagon.duagoninterview;

import com.duagon.duagoninterview.service.PricesService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
class DuagonInterviewApplicationTest {

    @Autowired
    private PricesService pricesService;

    @Test void priceTest1() {
        String[] result = pricesService.findPricesWithInterviewRules(Timestamp.valueOf("2020-06-14 10:00:00"), 35455, 1);
        Assertions.assertEquals(6, result.length);
        System.out.print("========================================================================================= \n");
        System.out.print(Arrays.toString(result) + "\n");
        System.out.print("========================================================================================= \n");
    }

    @Test void priceTest2() {
        String[] result = pricesService.findPricesWithInterviewRules(Timestamp.valueOf("2020-06-14 16:00:00"), 35455, 1);
        Assertions.assertEquals(6, result.length);
        System.out.print("========================================================================================= \n");
        System.out.print(Arrays.toString(result) + "\n");
        System.out.print("========================================================================================= \n");
    }

    @Test void priceTest3() {
        String[] result = pricesService.findPricesWithInterviewRules(Timestamp.valueOf("2020-06-14 21:00:00"), 35455, 1);
        Assertions.assertEquals(6, result.length);
        System.out.print("========================================================================================= \n");
        System.out.print(Arrays.toString(result) + "\n");
        System.out.print("========================================================================================= \n");
    }

    @Test void priceTest4() {
        String[] result = pricesService.findPricesWithInterviewRules(Timestamp.valueOf("2020-06-15 10:00:00"), 35455, 1);
        Assertions.assertEquals(6, result.length);
        System.out.print("========================================================================================= \n");
        System.out.print(Arrays.toString(result) + "\n");
        System.out.print("========================================================================================= \n");
    }

    @Test void priceTest5() {
        String[] result = pricesService.findPricesWithInterviewRules(Timestamp.valueOf("2020-06-16 21:00:00"), 35455, 1);
        Assertions.assertEquals(6, result.length);
        System.out.print("========================================================================================= \n");
        System.out.print(Arrays.toString(result) + "\n");
        System.out.print("========================================================================================= \n");
    }

    // One more test with a date that is not going to be in our database
    @Test void priceTest6() {
        String[] result = pricesService.findPricesWithInterviewRules(Timestamp.valueOf("2022-02-22 22:22:22"), 35455, 1);
        // Length = 1 as we have to announce that there is no data
        Assertions.assertEquals(1, result.length);
        System.out.print("========================================================================================= \n");
        System.out.print(Arrays.toString(result) + "\n");
        System.out.print("========================================================================================= \n");
    }
}
