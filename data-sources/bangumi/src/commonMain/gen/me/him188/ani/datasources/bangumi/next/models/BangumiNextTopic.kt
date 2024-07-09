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
    "UnusedImport",
)

package me.him188.ani.datasources.bangumi.next.models

import me.him188.ani.datasources.bangumi.next.models.BangumiNextUser

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * 
 *
 * @param createdAt 发帖时间，unix time stamp in seconds
 * @param creator 
 * @param id topic id
 * @param parentID 小组/条目ID
 * @param repliesCount
 * @param title 
 * @param updatedAt 最后回复时间，unix time stamp in seconds
 */
@Serializable

data class BangumiNextTopic(

    /* 发帖时间，unix time stamp in seconds */
    @SerialName(value = "createdAt") @Required val createdAt: kotlin.Int,

    @SerialName(value = "creator") @Required val creator: BangumiNextUser,

    /* topic id */
    @SerialName(value = "id") @Required val id: kotlin.Int,

    /* 小组/条目ID */
    @SerialName(value = "parentID") @Required val parentID: kotlin.Int,

    @SerialName(value = "repliesCount") @Required val repliesCount: kotlin.Int,

    @SerialName(value = "title") @Required val title: kotlin.String,

    /* 最后回复时间，unix time stamp in seconds */
    @SerialName(value = "updatedAt") @Required val updatedAt: kotlin.Int

)

