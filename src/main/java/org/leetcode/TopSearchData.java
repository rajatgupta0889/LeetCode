package org.leetcode;

public class TopSearchData {
}

/*
*   3rd Party API or Event for the Search term ->
*   We need to store this in a DB for 30 days
*   Process this data to analyze -->
*   Show that analyze data to user -->  Hour based
*
*
*   Data ---> Search Term , Source, timestamp, ProductRank, ProductId
*  Analyze data on frequent  Time Frame >
*
*
*   Schema -> Search Term , Source, timestamp, ProductRank, ProductId
*   AnalyzedData ->
           item, count, source,startTime, endTime
*
*
*   Controller  --> SearchController,  - > Endpoint to get the Search based
*   Service --> SearchService, KafkaEventService, AggregatorService
*   DataLayer ---> Repositories, Data
*
* */
// GET  /search?period=60&source&startTime&endTime&top=20