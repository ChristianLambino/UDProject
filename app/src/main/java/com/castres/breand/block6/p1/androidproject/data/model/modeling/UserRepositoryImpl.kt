package com.castres.breand.block6.p1.androidproject.data.model.modeling

import com.castres.breand.block6.p1.androidproject.data.model.User
import com.castres.breand.block6.p1.androidproject.data.modeling.API
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class UserRepositoryImpl(
    private val api: API
) : UserRepository {

    override suspend fun registerUser(): Flow<Result<User>> {
        return flow {
            try {
                val userFromAPI = api.registerUser()
                emit(Result.Success(userFromAPI))
            } catch (e: IOException) {
                emit(Result.Error(message = "Error registering user: ${e.message}"))
            } catch (e: HttpException) {
                emit(Result.Error(message = "Error registering user: ${e.message}"))
            } catch (e: Exception) {
                emit(Result.Error(message = "Error registering user: ${e.message}"))
            }
        }
    }
}
