### solrj study project

**注意：**
- 使用jdk1.8，否则会报 Exception in thread "main" java.lang.UnsupportedClassVersionError: org/apache/solr/common/params/SolrParams : Unsupported major.minor version 52.0
- 使用 sort 的字段的 multiValued 值必须设置为 false，否则会报 can not sort on multivalued field