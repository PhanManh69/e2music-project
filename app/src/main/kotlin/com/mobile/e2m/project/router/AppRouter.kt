package com.mobile.e2m.project.router

import androidx.navigation.NavController

interface AppRouter {
    fun bind(navController: NavController)

    fun unbind()

    fun getNavController(): NavController?
}
