package com.ishaan.ElasticSearch;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ElasticSearchConnector {
    private static final String ELASTICSEARCH_HOST = "localhost";
    private static final int ELASTICSEARCH_PORT = 9200;
    private static final String INDEX_NAME = "twitter_index";

    public static void publishToDataLakeCluster(String tweet)
    {
        RestHighLevelClient restHighLevelClient = new
                RestHighLevelClient(RestClient.builder(new HttpHost(ELASTICSEARCH_HOST, ELASTICSEARCH_PORT,"http")));
        IndexRequest indexRequest = new IndexRequest(INDEX_NAME)
                .source(tweet ,XContentType.JSON);
        IndexResponse indexResponse = null;
        try {
            indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Optionally, you can process the IndexResponse if needed
        String id = indexResponse.getId();
        System.out.println("Message successfully published to Elasticsearch with ID: " + id);

    }
}
