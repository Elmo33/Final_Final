package ge.msda.firebaseauth

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class UserInfo(
    val name: String = "triko",
    val mobile: String? = "shmiko",
    val address: String? = "niko",
    val link: String? = "diko"
)