package com.shreyansh.instagramclone.Models

class User {
    var Image:String?=null
    var Name:String?=null
            var Email:String?=null
    var Password:String?=null
    constructor()


    constructor(Image: String?, Name: String?, Email: String?, Password: String?) {
        this.Image = Image
        this.Name = Name
        this.Email = Email
        this.Password = Password
    }

    constructor(Name: String?, Email: String?, Password: String?) {
        this.Name = Name
        this.Email = Email
        this.Password = Password
    }


}