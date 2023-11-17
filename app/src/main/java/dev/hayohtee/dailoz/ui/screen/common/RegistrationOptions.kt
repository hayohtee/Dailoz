package dev.hayohtee.dailoz.ui.screen.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.hayohtee.dailoz.R
import dev.hayohtee.dailoz.ui.theme.DailozTheme

@Composable
fun RegistrationOptions(
    onGoogleClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.medium_padding))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.medium_padding))
        ) {
            Divider(modifier = Modifier.weight(0.5f))
            Text(
                text = stringResource(id = R.string.or_with),

                )
            Divider(modifier = Modifier.weight(0.5f))
        }
        IconButton(
            onClick = onGoogleClick,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.google),
                contentDescription = stringResource(id = R.string.google),
                tint = Color.Unspecified
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrationOptionsPreview() {
    DailozTheme {
        RegistrationOptions(
            onGoogleClick = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}