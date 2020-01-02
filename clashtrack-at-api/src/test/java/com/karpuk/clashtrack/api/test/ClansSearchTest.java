package com.karpuk.clashtrack.api.test;

import com.karpuk.clashtrack.api.core.model.Clan;
import com.karpuk.clashtrack.api.core.model.ClansSearchResponse;
import com.karpuk.clashtrack.api.test.base.SpringAwareTestBaseApi;
import org.springframework.http.ResponseEntity;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClansSearchTest extends SpringAwareTestBaseApi {


    @DataProvider(name = "data-provider-min-clan-level")
    public Object[][] dataProviderMinClassLevel() {
        return new Object[][]{{"3"}, {"10"}, {"12"}
        };
    }

    @DataProvider(name = "data-provider-limits")
    public Object[][] dataProviderLimitNumberOfClans() {
        return new Object[][]{{"100"}, {"1"}, {"0"}
        };
    }

    @Test(dataProvider = "data-provider-min-clan-level")
    public void testFilterByMinClanLevel(String minLevel) {
        Map<String, String> queries = new HashMap<>();
        queries.put("limit", "10");
        queries.put("minClanLevel", minLevel);

        ResponseEntity<ClansSearchResponse> result = clanSearchService.filterClans(queries);
        softAssert.assertThat(result.getStatusCodeValue()).as("Verify status code").isEqualTo(200);

        List<Clan> resultClans = result.getBody().getItems();
        int expectedLevel = Integer.parseInt(minLevel);
        softAssert.assertThat(clanSearchService.isAllClansHasNotLessLevel(resultClans, expectedLevel)).as("Verify levels").isTrue();
        softAssert.assertAll();
    }

    @Test(dataProvider = "data-provider-limits")
    public void testLimitOfItems(String limit) {
        Map<String, String> queries = new HashMap<>();
        queries.put("limit", limit);
        queries.put("minClanLevel", "2");

        ResponseEntity<ClansSearchResponse> result = clanSearchService.filterClans(queries);
        softAssert.assertThat(result.getStatusCodeValue()).as("Verify status code").isEqualTo(200);

        List<Clan> resultClans = result.getBody().getItems();
        int expectedNumOfClans = Integer.parseInt(limit);
        softAssert.assertThat(resultClans.size()).as("Verify number of result clans").isEqualTo(expectedNumOfClans);
        softAssert.assertAll();
    }

}
