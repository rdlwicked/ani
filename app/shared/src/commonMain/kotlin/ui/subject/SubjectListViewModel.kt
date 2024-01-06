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

package me.him188.animationgarden.app.ui.subject

import androidx.compose.runtime.Stable
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.yield
import me.him188.animationgarden.app.platform.Context
import me.him188.animationgarden.app.ui.event.SubjectNavigator
import me.him188.animationgarden.app.ui.framework.AbstractViewModel
import me.him188.animationgarden.app.ui.framework.launchInBackground
import me.him188.animationgarden.datasources.api.SearchSession
import me.him188.animationgarden.datasources.api.Subject
import me.him188.animationgarden.utils.logging.info
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Stable
class SubjectListViewModel(
    val searchSession: SearchSession<Subject>,
) : AbstractViewModel(), KoinComponent {
    private val subjectNavigator: SubjectNavigator by inject()

    private val _loading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading

    private val _list: MutableStateFlow<List<Subject>> = MutableStateFlow(listOf())
    val list: StateFlow<List<Subject>> get() = _list

    private val _hasMore: MutableStateFlow<Boolean> = MutableStateFlow(true)
    val hasMore: StateFlow<Boolean> get() = _hasMore

    fun loadMore() {
        logger.info { "loadMore()" }
        if (_loading.value) return
        if (!hasMore.value) return

        launchInBackground(start = CoroutineStart.UNDISPATCHED) {
            _loading.value = true
            yield()

            try {
                logger.info { "Requesting next page" }
                val nextPage = searchSession.nextPageOrNull()
                if (nextPage == null) {
                    _hasMore.value = false
                } else {
                    _list.value += nextPage
                    _hasMore.value = true
                }
            } catch (e: Throwable) {
                _hasMore.value = false
                throw e
            } finally {
                _loading.value = false
            }
        }
    }

    fun onClickSubjectPreview(
        context: Context,
        subject: Subject,
    ) {
        subjectNavigator.navigateToSubjectDetails(context, subject.id)
    }
}