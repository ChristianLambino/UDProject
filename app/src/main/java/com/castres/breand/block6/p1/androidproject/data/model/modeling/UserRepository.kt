package com.castres.breand.block6.p1.androidproject.data.model.modeling

import com.castres.breand.block6.p1.androidproject.dataclass.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun registerUser(userData: User): Flow<Result<User>>

}