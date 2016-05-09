package com.lucidworks.spark

import org.apache.solr.client.solrj.SolrQuery
import org.apache.spark.Partition

trait SolrRDDPartition extends Partition {
  def cursorMark: String
  def solrShard: SolrShard
  def query: SolrQuery
  def preferredReplica: SolrReplica // Preferred replica to query
  def otherReplicas: List[SolrReplica]
}

case class ShardRDDPartition(
    index: Int,
    cursorMark: String,
    solrShard: SolrShard,
    query: SolrQuery,
    preferredReplica: SolrReplica,
    otherReplicas: List[SolrReplica])
  extends SolrRDDPartition

case class SplitRDDPartition(
    index: Int,
    cursorMark: String,
    solrShard: SolrShard,
    query: SolrQuery,
    preferredReplica: SolrReplica,
    otherReplicas: List[SolrReplica])
  extends SolrRDDPartition
