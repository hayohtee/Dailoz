package dev.hayohtee.dailoz.ui.screen.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.hayohtee.dailoz.R
import dev.hayohtee.dailoz.ui.screen.common.DailozEmailTextField
import dev.hayohtee.dailoz.ui.screen.common.DailozPasswordTextField
import dev.hayohtee.dailoz.ui.screen.common.DailozUsernameTextField
import dev.hayohtee.dailoz.ui.screen.common.RegistrationOptions
import dev.hayohtee.dailoz.ui.theme.DailozTheme

@Composable
fun SignupScreen(
    uiState: SignupUiState,
    onUsernameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onCreateClick: () -> Unit,
    onGoogleClick: () -> Unit,
    onSignInClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.medium_padding)),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = stringResource(id = R.string.signup),
            style = MaterialTheme.typography.headlineLarge.copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        )

        SignupFields(
            username = uiState.username,
            onUsernameChange = onUsernameChange,
            email = uiState.email,
            onEmailChange = onEmailChange,
            password = uiState.password,
            onPasswordChange = onPasswordChange,
            onCreateClick = onCreateClick
        )

        RegistrationOptions(onGoogleClick = onGoogleClick)

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.have_any_account),
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.onBackground
                )
            )
            TextButton(onClick = onSignInClick) {
                Text(text = stringResource(id = R.string.signin))
            }
        }

    }
}

@Composable
fun SignupFields(
    username: String,
    onUsernameChange: (String) -> Unit,
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    onCreateClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.medium_padding))
    ) {
        DailozUsernameTextField(
            username = username,
            onUsernameChange = onUsernameChange,
            modifier = Modifier.fillMaxWidth()
        )
        DailozEmailTextField(
            email = email,
            onEmailChange = onEmailChange,
            modifier = Modifier.fillMaxWidth()
        )

        DailozPasswordTextField(
            password = password,
            onPasswordChange = onPasswordChange,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onCreateClick,
            shape = RoundedCornerShape(14.dp),
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 52.dp)
        ) {
            Text(text = stringResource(id = R.string.create))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SignupScreenPreview() {
    DailozTheme {
        SignupScreen(
            uiState = SignupUiState(),
            onUsernameChange = {},
            onEmailChange = {},
            onPasswordChange = {},
            onCreateClick = {},
            onGoogleClick = {},
            onSignInClick = {}
        )
    }
}