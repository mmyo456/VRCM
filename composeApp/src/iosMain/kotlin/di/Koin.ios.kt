package io.github.vrcmteam.vrcm.di

import coil3.PlatformContext
import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings
import org.koin.core.logger.Logger
import org.koin.core.logger.PrintLogger
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


actual val platformModule: Module = module {
    singleOf<Logger>(::PrintLogger)
    singleOf<PlatformContext>(PlatformContext::INSTANCE)
    singleOf<Settings.Factory>(NSUserDefaultsSettings::Factory)
}