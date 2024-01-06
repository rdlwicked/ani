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

package me.him188.animationgarden.app.ui.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import me.him188.animationgarden.app.platform.isInLandscapeMode
import me.him188.animationgarden.app.ui.home.LocalContentPaddings
import me.him188.animationgarden.app.ui.subject.SubjectPreviewColumn

/**
 * 搜索页面
 */
@Composable
fun SearchPage(viewModel: SearchViewModel) {
    if (isInLandscapeMode()) {
        SearchPageLandscape(viewModel)
    } else {
        SearchPagePortrait(viewModel)
    }
}

@Composable
private fun SearchPageLandscape(viewModel: SearchViewModel) {
    SearchPagePortrait(viewModel)
}

@Composable
private fun SearchPagePortrait(viewModel: SearchViewModel) {
    Column(
        Modifier.padding(
            top = LocalContentPaddings.current.calculateTopPadding(),
            start = LocalContentPaddings.current.calculateStartPadding(LocalLayoutDirection.current),
            end = LocalContentPaddings.current.calculateEndPadding(LocalLayoutDirection.current),
        ).fillMaxSize()
    ) {
        val viewModel by viewModel.result.collectAsState()
        viewModel?.let {
            SubjectPreviewColumn(it)
        }
    }
}

//@Composable
//internal expect fun PreviewHomePage()