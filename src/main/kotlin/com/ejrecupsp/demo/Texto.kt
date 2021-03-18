package com.ejrecupsp.demo

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Texto(var id: String="", var textoCifrado: String="") {


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
        return Objects.hash(idAuto,id,textoCifrado)
    }

    override fun toString(): String{
        return "Su id es $id. Su texto cifrado es $textoCifrado"
    }
}