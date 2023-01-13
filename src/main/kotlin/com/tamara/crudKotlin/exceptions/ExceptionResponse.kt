package com.tamara.crudKotlin.exceptions

import java.io.Serializable
import java.util.*

class ExceptionResponse(val timestamp: Date, val message: String?, val details: String) : Serializable {

    companion object {
        private const val serialVersionUID = 1L
    }
}
