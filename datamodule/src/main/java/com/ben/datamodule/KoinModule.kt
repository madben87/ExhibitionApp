package com.ben.datamodule

import com.ben.model.data_manager.ExhibitsLoader
import org.koin.dsl.module

val dataModule = module {
    single { ExhibitsLoaderImpl(get()) as ExhibitsLoader }
}