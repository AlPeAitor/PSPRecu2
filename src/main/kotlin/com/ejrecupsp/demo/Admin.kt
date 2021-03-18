package com.ejrecupsp.demo

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Admin(var nombre: String="", var contrasenia: String="") {


    @Id
    @GeneratedValue
    public val idAuto: Long? = null

    override fun equals(other: Any?): Boolean {
        if (other is Usuario){
            return other.idAuto == idAuto && idAuto != null
        } else {
            return false
        }
    }

    override fun hashCode(): Int {
        return Objects.hash(idAuto,nombre,contrasenia)
    }

    override fun toString(): String{
        return "el admin se llama $nombre. Su contraseña es $contrasenia"
    }
}