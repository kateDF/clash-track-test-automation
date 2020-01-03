package com.karpuk.clashtrack.api.test;

import com.karpuk.clashtrack.api.core.model.Clan;
import com.karpuk.clashtrack.api.core.model.ClansSearchResponse;
import com.karpuk.clashtrack.api.test.base.ClansSearchTestData;
import org.springframework.http.ResponseEntity;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClansSearchTest extends ClansSearchTestData {

    @Test(dataProvider = "dp-min-clan-level")
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

    @Test(dataProvider = "dp-incorrect-min-clan-level")
    public void testIncorrectFilterByMinClanLevel(String minLevel) {
        Map<String, String> queries = new HashMap<>();
        queries.put("minClanLevel", minLevel);

        ResponseEntity result = clanSearchService.filterClans(queries);
        softAssert.assertThat(result.getStatusCodeValue()).as("Verify status code").isEqualTo(400);
        softAssert.assertThat(result.getBody().toString()).as("Verify error reason").contains("minClanLevel must be at least 2");
        softAssert.assertAll();
    }

    @Test(dataProvider = "dp-limits")
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

    @Test(dataProvider = "dp-valid-clan-tags")
    public void testSearchClanByTag(String clanTag) {
        ResponseEntity<Clan> result = clanSearchService.searchClanByTag(clanTag);
        softAssert.assertThat(result.getStatusCodeValue()).as("Verify status code").isEqualTo(200);

        Clan resultClan = result.getBody();
        softAssert.assertThat(resultClan.getTag()).as("Verify clan tag").isEqualTo(clanTag);
        softAssert.assertAll();
    }

    @Test(dataProvider = "dp-invalid-clan-tags")
    public void testSearchClanByInvalidTag(String invalidClanTag) {
        ResponseEntity result = clanSearchService.searchClanByTag(invalidClanTag);
        softAssert.assertThat(result.getStatusCodeValue()).as("Verify status code").isEqualTo(404);
        softAssert.assertThat(result.getBody().toString()).as("Verify error reason").contains("notFound");
        softAssert.assertAll();
    }

}
