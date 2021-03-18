package com.ejrecupsp.demo

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Usuario(var nombre: String="") {


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
        return Objects.hash(idAuto,nombre,contra)
    }


    var contra: String = "14"
    var idUsu = ""
    var claveCifrado = ""
    constructor (nombre: String, contra: String): this(nombre){
        this.contra = contra
        this.idUsu = nombre.first() + nombre.count().toString()
        this.claveCifrado = (nombre.first().toInt()+nombre.count()).toString()
    }
    override fun toString(): String{
        return "Name is $nombre. Contraseña is $contra. idUsu is $idUsu. claveCifrado es $claveCifrado"
    }
}