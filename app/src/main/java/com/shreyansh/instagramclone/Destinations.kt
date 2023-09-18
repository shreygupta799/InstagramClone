package com.shreyansh.instagramclone

interface Destinations{
    val route: String
}
object Splash:Destinations{
    override val route="Splash"
}
object SignUp:Destinations{
    override val route="SignUp"

}