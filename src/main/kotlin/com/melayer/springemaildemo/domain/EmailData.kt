package com.melayer.springemaildemo.domain

data class EmailData(

        var to: String? = null,

        var subject: String? = null,

        var data: String? = null
) {
}