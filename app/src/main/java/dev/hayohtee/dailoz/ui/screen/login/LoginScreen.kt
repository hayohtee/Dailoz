package dev.hayohtee.dailoz.ui.screen.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import dev.hayohtee.dailoz.ui.screen.common.RegistrationOptions
import dev.hayohtee.dailoz.ui.theme.DailozTheme

@Composable
fun LoginScreen(
    uiState: LoginUiState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onForgotPasswordClick: () -> Unit,
    onLoginClick: () -> Unit,
    onGoogleClick: () -> Unit,
    onSignupClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.medium_padding))
    ) {
        Text(
            text = stringResource(id = R.string.login),
            style = MaterialTheme.typography.headlineLarge.copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        )

        LoginFields(
            email = uiState.email,
            onEmailChange = onEmailChange,
            password = uiState.password,
            onPasswordChange = onPasswordChange,
            onForgotPasswordClick = onForgotPasswordClick,
            onLoginClick = onLoginClick
        )

        RegistrationOptions(onGoogleClick = onGoogleClick)

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.dont_have_account),
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.onBackground
                )
            )
            TextButton(onClick = onSignupClick) {
                Text(text = stringResource(id = R.string.signup))
            }
        }
    }
}

@Composable
fun LoginFields(
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    onForgotPasswordClick: () -> Unit,
    onLoginClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.medium_padding))
    ) {
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
        TextButton(
            onClick = onForgotPasswordClick,
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(
                text = stringResource(id = R.string.forgot_password),
                style = MaterialTheme.typography.bodySmall
            )
        }
        Button(
            onClick = onLoginClick,
            shape = RoundedCornerShape(14.dp),
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 52.dp)
        ) {
            Text(text = stringResource(id = R.string.login))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    DailozTheme {
        LoginScreen(
            uiState = LoginUiState(),
            onEmailChange = {},
            onPasswordChange = {},
            onForgotPasswordClick = {},
            onLoginClick = {},
            onGoogleClick = {},
            onSignupClick = {}
        )
    }
}