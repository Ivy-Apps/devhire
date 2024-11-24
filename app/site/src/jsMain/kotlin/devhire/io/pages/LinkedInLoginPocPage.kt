package devhire.io.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.browser.http.HttpMethod
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.forms.Input
import kotlinx.browser.window
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.await
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Page("/poc")
@Composable
fun LinkedInApp() {
    var accessToken by remember { mutableStateOf<String?>(null) }
    var profileData by remember { mutableStateOf<Map<String, String>?>(null) }
    var inputUrl by remember { mutableStateOf("") }

    // Handle LinkedIn OAuth redirection
    LaunchedEffect(Unit) {
        val queryParams = window.location.search
        if (queryParams.contains("code")) {
            val authCode = queryParams.substringAfter("code=").substringBefore("&")
            MainScope().launch {
                accessToken = fetchAccessToken(authCode)
            }
        }
    }

    Div(attrs = { style { padding(16.px) } }) {
        if (accessToken == null) {
            // LinkedIn Login Button
            Button(attrs = {
                onClick {
                    val clientId = "YOUR_CLIENT_ID"
                    val redirectUri = "YOUR_REDIRECT_URI"
                    val scope = "r_liteprofile%20r_emailaddress"
                    window.location.href =
                        "https://www.linkedin.com/oauth/v2/authorization?response_type=code&client_id=$clientId&redirect_uri=$redirectUri&scope=$scope"
                }
            }) {
                Text("Login with LinkedIn")
            }
        } else {
            // Profile input and display area
            Div(attrs = { style { padding(16.px) } }) {
                Input(
                    type = InputType.Text,
                    value = inputUrl,
                    onValueChange = {
                        inputUrl = it
                    }
                )
                Button(attrs = {
                    onClick {
                        MainScope().launch {
                            profileData = fetchProfileData(inputUrl, accessToken!!)
                        }
                    }
                }) {
                    Text("Fetch Profile")
                }
            }

            profileData?.let { data ->
                Div(attrs = { style { padding(16.px); border(1.px, LineStyle.Solid, Color.black) } }) {
                    P { Text("Name: ${data["name"]}") }
                    P { Text("Headline: ${data["headline"]}") }
                    P { Text("Profile URL: ${data["profileUrl"]}") }
                }
            }
        }
    }
}

// Fetch access token using LinkedIn OAuth code
suspend fun fetchAccessToken(authCode: String): String? {
    val clientId = "YOUR_CLIENT_ID"
    val clientSecret = "YOUR_CLIENT_SECRET"
    val redirectUri = "YOUR_REDIRECT_URI"
    val tokenUrl = "https://www.linkedin.com/oauth/v2/accessToken"

    window.fetch(HttpMethod.POST)
    val response = kotlinx.browser.window.fetch(tokenUrl, object : dynamic {
        method = "POST"
        headers = json("Content-Type" to "application/x-www-form-urlencoded")
        body = "grant_type=authorization_code&code=$authCode&redirect_uri=$redirectUri&client_id=$clientId&client_secret=$clientSecret"
    }).await()

    if (response.ok) {
        val json = response.json().await()
        return json.access_token as? String
    }
    return null
}

// Fetch LinkedIn profile data by URL
suspend fun fetchProfileData(profileUrl: String, accessToken: String): Map<String, String>? {
    val apiUrl = "https://api.linkedin.com/v2/me"
    val response = kotlinx.browser.window.fetch(apiUrl, object : dynamic {
        method = "GET"
        headers = json("Authorization" to "Bearer $accessToken")
    }).await()

    if (response.ok) {
        val json = response.json().await()
        return mapOf(
            "name" to "${json.localizedFirstName} ${json.localizedLastName}",
            "headline" to json.localizedHeadline as String,
            "profileUrl" to profileUrl
        )
    }
    return null
}
