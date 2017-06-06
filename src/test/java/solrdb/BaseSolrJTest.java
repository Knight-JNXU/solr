
package solrdb;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author liuwen
 * @version 1.0
 * @date 2017年6月5日
 * funcation : 
 */
public class BaseSolrJTest{
    
    private final Logger LOGGER = org.apache.log4j.Logger.getLogger(this.getClass());
    
    private final String HOST_URL = "http://localhost:8983/solr";
    private final String CORE = "pgdb";
    
    private SolrClient getSolrClientInstance(){
        return new HttpSolrClient.Builder(HOST_URL + "/" + CORE).build();
    }
    
    @Test
    public void helloWorld(){
        LOGGER.debug("hello world!");
    }
    
    /**
     * 输出SolrDocumentList
     * @param solrDocumentList
     */
    private void printSolrDocumentList(SolrDocumentList solrDocumentList){
        for(SolrDocument solrDocument : solrDocumentList){
            LOGGER.debug(solrDocument.toString());
        }
    }
    
    @Test
    public void baseQuery(){
        try{
            SolrClient solrClient = getSolrClientInstance();
            SolrQuery solrQuery = new SolrQuery();
            
            solrQuery.setQuery("*:*");
            
            solrQuery.addSort("item_id", ORDER.asc);
            
            //设置高亮
            solrQuery.setHighlight(true);
            solrQuery.addHighlightField("item_name");
            solrQuery.setHighlightSimplePre("<font color='red'>");
            solrQuery.setHighlightSimplePost("</front>");
            
            
            
            QueryResponse queryResponse = solrClient.query(solrQuery);
            SolrDocumentList solrDocumentList = queryResponse.getResults();
            printSolrDocumentList(solrDocumentList);
        }catch (Exception e){
            LOGGER.error(e.toString());
        }
    }
    
    /**
     * setQuery中放多个条件
     */
    @Test
    public void multiQuery(){
        try{
            SolrClient solrClient = getSolrClientInstance();
            SolrQuery solrQuery = new SolrQuery();
//            这两种写法都可以
//            solrQuery.setQuery("category_name:鞋* OR category_name:裤* ");
            solrQuery.setQuery("category_name:鞋*  category_name:裤* ");
            QueryResponse queryResponse = solrClient.query(solrQuery);
            SolrDocumentList solrDocumentList = queryResponse.getResults();
            printSolrDocumentList(solrDocumentList);
        }catch (Exception e){
            LOGGER.error(e.toString());
        }
    }
    
    @Test
    public void queryQ(){
        try{
            SolrClient solrClient = getSolrClientInstance();
            SolrQuery solrQuery = new SolrQuery();
            solrQuery.set("q", "item_name:AZTEC");
            QueryResponse queryResponse = solrClient.query(solrQuery);
            SolrDocumentList solrDocumentList = queryResponse.getResults();
            for(SolrDocument solrDocument : solrDocumentList){
                LOGGER.debug(solrDocument.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error(e.toString());
        }
        
    }
    
    
    
}
