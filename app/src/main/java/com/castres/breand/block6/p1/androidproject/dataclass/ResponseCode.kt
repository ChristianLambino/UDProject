package com.castres.breand.block6.p1.androidproject.dataclass

enum class ResponseCode(val code: Int) {
    SUCCESS(200),
    CREATED(201),
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500),
    SERVICE_UNAVAILABLE(503);

    companion object {
        fun fromCode(code: Int): ResponseCode? {
            return values().find { it.code == code }
        }
    }
}
