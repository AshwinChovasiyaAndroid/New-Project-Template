package com.example.myapplication.data.remote

import retrofit2.HttpException
import retrofit2.Response

fun inTryCatch(block: () -> Unit, onError: (message: String) -> Unit) {
    try {
        block()
    }catch (ex:Exception){
        onError(ex.localizedMessage?:"Something went wrong")
    }
}

suspend fun <T> handleApi(
    execute: suspend () -> Response<T>
): Resource<T> {
    return try {
        val response = execute()
        val body = response.body()
        if (response.isSuccessful && body != null) {
            return Resource.Success(response.body())
        } else {
            return Resource.Failure(code = response.code(), message = response.message())
        }
    } catch (e: HttpException) {
        return Resource.Failure(code = e.code(), message = e.message())
    } catch (e: Throwable) {
        return Resource.Failure(0,e.localizedMessage?:"Something went wrong")
    }
}


sealed class Resource<T> {
    class Loading<T> : Resource<T>()
    data class Success<T>(val data: T?) : Resource<T>()
    data class Failure<T>(val code:Int,val message:String) : Resource<T>()
}

sealed class AuthResource<T> {
    class Loading<T> : Resource<T>()
    data class Success<T>(val data: T?) : Resource<T>()
    data class UnAuthorized<T>(val message:String) : Resource<T>()
    data class Failure<T>(val throwable: Throwable) : Resource<T>()
}
