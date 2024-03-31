package me.him188.ani.app.tools

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember


/**
 * @see TimeFormatter
 * @see LocalTimeFormatter
 */
@Composable
fun formatDateTime(
    timestamp: Long, // millis
): String {
    val formatter = LocalTimeFormatter.current
    return remember(timestamp) { formatter.format(timestamp) }
//    val formatter = remember(format) { DateTimeFormatter.ofPattern(format) }
//    return remember(timestamp) {
//        formatter.format(java.time.Instant.ofEpochMilli(timestamp))
//    }
}

//@Composable
//fun formatDateTime(
//    timestamp: OffsetDateTime, // millis
//    format: String = "yyyy-MM-dd HH:mm:ss",
//): String {
//    val formatter = DateTimeFormatter.ofPattern(format)
//    timestamp.atZoneSameInstant(java.time.ZoneId.systemDefault())
//    return formatter.format(java.time.Instant.ofEpochMilli(timestamp))
//}