package com.karpuk.clashtrack.api.test.service;

import com.karpuk.clashtrack.api.core.model.Clan;
import com.karpuk.clashtrack.api.core.model.ClansSearchResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClanSearchService extends BaseService {

    public ResponseEntity<ClansSearchResponse> filterClans(Map<String, String> queries) {
        URI uri = buildUri(restContextHolder.getClansSearchUrl(), queries, null);
        MultiValueMap<String, String> headers = restContextHolder.getDefaultHeaders();
        return restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<String>(headers), ClansSearchResponse.class);
    }

    public boolean isAllClansHasNotLessLevel(List<Clan> resultClans, int expectedLevel) {
        return resultClans.stream()
                .mapToInt(Clan::getClanLevel)
                .allMatch(i -> i >= (expectedLevel));
    }

    private static URI buildUri(String url, Map<String, String> queries, Map<String, String> paths) {
        URI uri = UriComponentsBuilder
                .fromUriString(url)
                .buildAndExpand(getNotNull(paths))
                .toUri();
        for (Map.Entry<String, String> entry : getNotNull(queries).entrySet()) {
            uri = UriComponentsBuilder
                    .fromUri(uri)
                    .queryParam(entry.getKey(), entry.getValue())
                    .build()
                    .toUri();
        }
        return uri;
    }

    private static Map<String, String> getNotNull(Map<String, String> originalMap) {
        return originalMap != null ? originalMap : new HashMap<>();
    }
}
