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
 * @param createdAt
 * @param creator
 * @param id
 * @param state
 * @param text
 * @param topicID
 * @param topicTitle 
 */
@Serializable

data class BangumiNextGroupReply(

    @SerialName(value = "createdAt") @Required val createdAt: kotlin.Int,

    @SerialName(value = "creator") @Required val creator: BangumiNextUser,

    @SerialName(value = "id") @Required val id: kotlin.Int,

    @SerialName(value = "state") @Required val state: kotlin.Int,

    @SerialName(value = "text") @Required val text: kotlin.String,

    @SerialName(value = "topicID") @Required val topicID: kotlin.Int,

    @SerialName(value = "topicTitle") @Required val topicTitle: kotlin.String

)

