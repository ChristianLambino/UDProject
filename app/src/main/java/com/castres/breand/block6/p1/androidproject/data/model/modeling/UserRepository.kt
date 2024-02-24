package com.castres.breand.block6.p1.androidproject.data.model.modeling

import com.castres.breand.block6.p1.androidproject.data.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun registerUser(): Flow<Result<User>>
}