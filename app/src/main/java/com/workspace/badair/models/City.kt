package com.workspace.badair.models

import java.io.Serializable

data class City (
    var city : String? = "",
    var state : String? = "",
    var country : String? = "",
    var location : MutableList<Location>? = mutableListOf(),
    var current : MutableList<Weather>? = mutableListOf(),
    var pollution : MutableList<Pollution>? = mutableListOf()

):Serializable