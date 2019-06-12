package tech.burdzi0.ineedtofinishthisasap.di

import android.content.Context
import android.content.SharedPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module
import tech.burdzi0.ineedtofinishthisasap.MainActivity
import tech.burdzi0.ineedtofinishthisasap.model.api.LinkService
import tech.burdzi0.ineedtofinishthisasap.model.api.LinkServiceImpl
import tech.burdzi0.ineedtofinishthisasap.presenter.MainActivityPresenter
import tech.burdzi0.ineedtofinishthisasap.view.LinkViewTransformer
import tech.burdzi0.ineedtofinishthisasap.view.LinkViewTransformerImpl

val applicationModule = module(override = true) {
    single<SharedPreferences> { androidContext().getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE) }
    single<LinkService> { LinkServiceImpl() }
    single<LinkViewTransformer> { LinkViewTransformerImpl() }
}