package com.ejrecupsp.demo

import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import java.security.MessageDigest

class ControladorCripto {
    companion object {
        fun encriptar(textoEnString: String, llaveEnString: String): String {
            val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
            cipher.init(Cipher.ENCRYPT_MODE, getKey(llaveEnString))
            return URLEncoder.encode(Base64.getEncoder().encodeToString(cipher.doFinal(textoEnString.toByteArray(Charsets.UTF_8))),StandardCharsets.UTF_8)
        }

        fun getKey(llaveEnString: String): SecretKeySpec {
            var llaveUtf8 = llaveEnString.toByteArray(Charsets.UTF_8)
            val sha = MessageDigest.getInstance("SHA-1")
            llaveUtf8 = sha.digest(llaveUtf8)
            llaveUtf8 = llaveUtf8.copyOf(16)
            return SecretKeySpec(llaveUtf8, "AES")
        }
    }


}