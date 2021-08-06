package com.example.sotnikov.model

class Sites {
    var siteName : String = ""
    var siteUrl : String = ""

    constructor(){}

   constructor(siteName:String,siteUrl:String):super(){
        this.siteName = siteName
        this.siteUrl = siteUrl
    }
}