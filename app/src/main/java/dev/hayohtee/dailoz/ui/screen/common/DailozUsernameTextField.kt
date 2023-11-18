package dev.hayohtee.dailoz.ui.screen.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import dev.hayohtee.dailoz.R
import dev.hayohtee.dailoz.ui.theme.DailozTheme

@Composable
fun DailozUsernameTextField(
    username: String,
    onUsernameChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = username,
        onValueChange = onUsernameChange,
        modifier = modifier,
        placeholder = {
            Text(text = stringResource(id = R.string.username))
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        ),
        singleLine = true,
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = null
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedLeadingIconColor = MaterialTheme.colorScheme.primary,
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun DailozUsernameTextFieldPreview() {
    DailozTheme {
        DailozUsernameTextField(
            username = "",
            onUsernameChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.medium_padding))
        )
    }
}