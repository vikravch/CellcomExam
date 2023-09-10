package com.vikravch.cellcomexam.core

class UserNotFoundException : Exception("User not found")
class NoInternetException : Exception("No internet connection")
class ServerException(message: String) : Exception(message)
class WrongRequestException(message: String) : Exception(message)

data class ServerError(
    val code: Int,
    val message: String
)