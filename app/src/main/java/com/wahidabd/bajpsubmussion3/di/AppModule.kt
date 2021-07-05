package com.wahidabd.bajpsubmussion3.di

import android.content.Context
import com.wahidabd.bajpsubmussion3.data.MyRepository
import com.wahidabd.bajpsubmussion3.data.local.LocalDataSource
import com.wahidabd.bajpsubmussion3.data.local.MyDatabase
import com.wahidabd.bajpsubmussion3.data.network.Api
import com.wahidabd.bajpsubmussion3.data.remote.RemoteDataSource
import com.wahidabd.bajpsubmussion3.utils.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideApi(retrofit: Retrofit): Api =
        retrofit.create(Api::class.java)

    @Singleton
    @Provides
    fun provideRemoteDataSource(api: Api) = RemoteDataSource(api)

    @Singleton
    @Provides
    fun provideLocalDataSource(db: MyDatabase) = LocalDataSource(db)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) = MyDatabase.getDatabase(context)

    @Singleton
    @Provides
    fun provideFavoriteDao(db: MyDatabase) = db.favoriteDao()

    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: RemoteDataSource, localDataSource: LocalDataSource) =
        MyRepository(remoteDataSource, localDataSource)


}