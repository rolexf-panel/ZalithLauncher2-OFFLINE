package com.movtery.zalithlauncher.ui.notice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.movtery.zalithlauncher.ui.theme.cardColor
import com.movtery.zalithlauncher.ui.theme.onCardColor

@Composable
fun OfflineForkNoticeDialog(
    neverShow: Boolean,
    onNeverShowChanged: (Boolean) -> Unit,
    onClose: () -> Unit,
    onVisitRepo: () -> Unit
) {
    Dialog(
        onDismissRequest = onClose,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(0.85f),
            shape = MaterialTheme.shapes.extraLarge,
            shadowElevation = 6.dp,
            color = cardColor(false),
            contentColor = onCardColor()
        ) {
            Column(
                modifier = Modifier.padding(24.dp)
            ) {
                Text(
                    text = "Zalith Launcher 2 - Offline Fork",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        text = "This is an unofficial offline fork of Zalith Launcher 2.\n\n" +
                                "The following restriction has been removed:\n" +
                                "• Microsoft account no longer required to create offline accounts\n" +
                                "• You can now create and use offline accounts directly without signing in\n\n" +
                                "Commit: 1e94fb7f\n" +
                                "\"fix: remove all offline restrictions for account management\"",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = neverShow,
                        onCheckedChange = onNeverShowChanged
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Never Show",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    FilledTonalButton(
                        modifier = Modifier.weight(1f),
                        onClick = onClose
                    ) {
                        Text("Close")
                    }

                    Button(
                        modifier = Modifier.weight(1f),
                        onClick = onVisitRepo
                    ) {
                        Text("Visit Repo")
                    }
                }
            }
        }
    }
}
