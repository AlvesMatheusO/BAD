package com.workspace.badair.models

import java.io.Serializable

class Weather (
    serializable: Serializable,
    var ts : String = "",
    var tp : Int = 0,
    var pr : Int = 0,
    var hu : Int = 0,
    var ws : Double = 0.0,
    var wd : Int = 0,
    var ic : String = ""
)