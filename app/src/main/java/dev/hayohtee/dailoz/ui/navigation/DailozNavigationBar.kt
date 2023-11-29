package dev.hayohtee.dailoz.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.hayohtee.dailoz.R
import dev.hayohtee.dailoz.ui.screen.activity.ActivityDestination
import dev.hayohtee.dailoz.ui.screen.home.HomeDestination
import dev.hayohtee.dailoz.ui.screen.profile.ProfileDestination
import dev.hayohtee.dailoz.ui.screen.task.TaskDestination
import dev.hayohtee.dailoz.ui.theme.DailozTheme

@Composable
fun DailozNavigationBar(
    currentDestination: DailozDestination,
    onItemClick: (DailozDestination) -> Unit,
    onAddTaskClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .shadow(
                elevation = 20.dp,
                spotColor = Color(0x54C6C6C6),
                ambientColor = Color(0x54C6C6C6)
            )
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(20.dp))
            .padding(16.dp)
            .fillMaxWidth()
            .height(50.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        DailozNavigationItem(
            selected = currentDestination == HomeDestination,
            onClick = { onItemClick(HomeDestination)},
            selectedIcon = painterResource(id = R.drawable.home_selected),
            unselectedIcon = painterResource(id = R.drawable.home)
        )
        DailozNavigationItem(
            selected = currentDestination == TaskDestination,
            onClick = { onItemClick(TaskDestination) },
            selectedIcon = painterResource(id = R.drawable.document_selected),
            unselectedIcon = painterResource(id = R.drawable.document)
        )
        IconButton(
            onClick = onAddTaskClick,
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            modifier = Modifier.size(50.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.bi_plus),
                contentDescription = null
            )
        }
        DailozNavigationItem(
            selected = currentDestination == ActivityDestination,
            onClick = { onItemClick(ActivityDestination) },
            selectedIcon = painterResource(id = R.drawable.activity_selected),
            unselectedIcon = painterResource(id = R.drawable.activity)
        )
        DailozNavigationItem(
            selected = currentDestination == ProfileDestination,
            onClick = { onItemClick(ProfileDestination) },
            selectedIcon = painterResource(id = R.drawable.folder_selected),
            unselectedIcon = painterResource(id = R.drawable.folder)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DailozNavigationBarPreview() {
    DailozTheme {
        DailozNavigationBar(
            currentDestination = HomeDestination,
            onItemClick = {},
            onAddTaskClick = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}