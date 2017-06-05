
package solrdb;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
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
    
    private final static String HOST_URL = "http://localhost:8983/solr";
    private final static String CORE = "pgdb";
    
    private SolrClient getSolrClientInstance(){
        return new HttpSolrClient.Builder(HOST_URL + "/" + CORE).build();
    }
    
    @Test
    public void helloWorld(){
        LOGGER.debug("hello world!");
    }
    
    @Test
    public void baseQuery(){
        try{
            SolrClient solrClient = getSolrClientInstance();
            SolrQuery solrQuery = new SolrQuery();
            solrQuery.setQuery("*:*");
            QueryResponse queryResponse = solrClient.query(solrQuery);
            SolrDocumentList solrDocumentList = queryResponse.getResults();
            for(SolrDocument solrDocument : solrDocumentList){
                LOGGER.info(solrDocument.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error(e.toString());
        }
        
    }
    
    public static void main(String[] args){
        System.out.println("hello world");
        try{
            SolrClient solrClient = new HttpSolrClient.Builder(HOST_URL + "/" + CORE).build();
            SolrQuery solrQuery = new SolrQuery();
            solrQuery.setQuery("*:*");
            QueryResponse queryResponse = solrClient.query(solrQuery);
            SolrDocumentList solrDocumentList = queryResponse.getResults();
            for(SolrDocument solrDocument : solrDocumentList){
//                LOGGER.info(solrDocument.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
//            LOGGER.error(e.toString());
        }
    }
}
