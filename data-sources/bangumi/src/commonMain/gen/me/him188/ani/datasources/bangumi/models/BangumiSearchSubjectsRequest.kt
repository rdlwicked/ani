/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package me.him188.ani.datasources.bangumi.models

import me.him188.ani.datasources.bangumi.models.BangumiSearchSubjectsRequestFilter

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * 
 *
 * @param keyword 
 * @param sort 排序规则  - `match` meilisearch 的默认排序，按照匹配程度 - `heat` 收藏人数 - `rank` 排名由高到低 - `score` 评分 
 * @param filter 
 */
@Serializable

data class BangumiSearchSubjectsRequest(

    @SerialName(value = "keyword") @Required val keyword: kotlin.String,

    /* 排序规则  - `match` meilisearch 的默认排序，按照匹配程度 - `heat` 收藏人数 - `rank` 排名由高到低 - `score` 评分  */
    @SerialName(value = "sort") val sort: BangumiSearchSubjectsRequest.Sort? = Sort.MATCH,

    @SerialName(value = "filter") val filter: BangumiSearchSubjectsRequestFilter? = null

) {

    /**
     * 排序规则  - `match` meilisearch 的默认排序，按照匹配程度 - `heat` 收藏人数 - `rank` 排名由高到低 - `score` 评分 
     *
     * Values: MATCH,HEAT,RANK,SCORE
     */
    @Serializable
    enum class Sort(val value: kotlin.String) {
        @SerialName(value = "match")
        MATCH("match"),
        @SerialName(value = "heat")
        HEAT("heat"),
        @SerialName(value = "rank")
        RANK("rank"),
        @SerialName(value = "score")
        SCORE("score");
    }
}
