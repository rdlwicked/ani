/*
 * Animation Garden App
 * Copyright (C) 2022  Him188
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package me.him188.animationgarden.datasources.bangumi

import me.him188.animationgarden.datasources.api.SearchSession
import me.him188.animationgarden.datasources.api.Subject
import me.him188.animationgarden.datasources.api.SubjectProvider
import me.him188.animationgarden.datasources.api.SubjectSearchQuery

class BangumiSubjectProvider(
    private val client: BangumiClient = BangumiClient.create(),
) : SubjectProvider {
    override val id: String get() = "Bangumi"

    override fun startSearch(query: SubjectSearchQuery): SearchSession<Subject> =
        BangumiSearchSession(client, query)

//    override suspend fun getSubjectDetails(id: String): SubjectDetails? {
//        return client.subjects.getSubjectById(id.toLong())?.toSubjectDetails()
//    }
}