package com.castres.breand.block6.p1.androidproject.data.model.modeling

import com.castres.breand.block6.p1.androidproject.dataclass.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class UserRepositoryImpl(
    private val api: API
) : UserRepository {

    override suspend fun registerUser(userData: User): Flow<Result<String>>{
        return flow {
            try {
                val response = api.registerUser(userData)
                if (response.isSuccessful) {
                    emit(Result.Success("User registered successfully"))
                } else {
                    emit(Result.Error(message = "Error registering user: ${response.errorBody()?.string()}"))
                }
            } catch (e: IOException) {
                emit(Result.Error(message = "Network error: ${e.message}"))
            } catch (e: HttpException) {
                emit(Result.Error(message = "HTTP error: ${e.message}"))
            } catch (e: Exception) {
                emit(Result.Error(message = "Error: ${e.message}"))
            }
        }
    }
}
