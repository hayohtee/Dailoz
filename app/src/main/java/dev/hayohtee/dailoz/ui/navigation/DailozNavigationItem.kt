package dev.hayohtee.dailoz.ui.navigation

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.hayohtee.dailoz.R
import dev.hayohtee.dailoz.ui.theme.DailozTheme

@Composable
fun DailozNavigationItem(
    selected: Boolean,
    onClick: () -> Unit,
    selectedIcon: Painter,
    unselectedIcon: Painter,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(onClick = onClick) {
            Crossfade(targetState = selected, label = "Icon animation") { isSelected ->
                if (isSelected) {
                    Icon(
                        painter = selectedIcon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                } else {
                    Icon(
                        painter = unselectedIcon,
                        contentDescription = null,
                        tint = Color(0xFFC6CEDD)
                    )
                }
            }
        }
        if (selected) {
            Spacer(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(4.dp)
                    .background(MaterialTheme.colorScheme.primary)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DailozNavigationItemPreview() {
    DailozTheme {
        DailozNavigationItem(
            selected = true,
            onClick = {},
            unselectedIcon = painterResource(id = R.drawable.document),
            selectedIcon = painterResource(id = R.drawable.document_selected),
            modifier = Modifier
        )
    }
}