package com.karpuk.clashtrack.api.test;

import com.karpuk.clashtrack.api.core.model.Clan;
import com.karpuk.clashtrack.api.core.model.ClansSearchResponse;
import com.karpuk.clashtrack.api.test.base.SpringAwareTestBaseApi;
import org.springframework.http.ResponseEntity;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClansSearchTest extends SpringAwareTestBaseApi {

    @Test
    public void testFilterByMinClanLevel() {
        Map<String, String> queries = new HashMap<>();
        queries.put("limit", "10");
        queries.put("minClanLevel", "15");

        ResponseEntity<ClansSearchResponse> result = clanSearchService.filterClans(queries);
        softAssert.assertThat(result.getStatusCode().toString()).as("Verify status code").isEqualTo("200 OK");

        int expectedLevel = Integer.parseInt(queries.get("minClanLevel"));
        List<Clan> resultClans = result.getBody().getItems();
        softAssert.assertThat(clanSearchService.isAllClansHasNotLessLevel(resultClans, expectedLevel)).as("Verify levels").isTrue();
        softAssert.assertAll();
    }

}
