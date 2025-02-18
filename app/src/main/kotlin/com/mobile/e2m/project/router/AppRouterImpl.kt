package com.mobile.e2m.project.router

import androidx.navigation.NavController

class AppRouterImpl : AppRouter {

    private var navController: NavController? = null

    override fun bind(navController: NavController) {
        this.navController = navController
    }

    override fun unbind() {
        this.navController = null
    }

    override fun getNavController(): NavController? = navController
}
