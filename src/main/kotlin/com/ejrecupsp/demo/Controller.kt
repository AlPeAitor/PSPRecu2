package com.ejrecupsp.demo

import org.springframework.web.bind.annotation.*

@RestController
class Controller(private val repoUsu:RepositorioUsuarios, private val repoTexto: RepositorioTexto) {

    val claveAdmin="1234ClaveAdmin"

    @GetMapping("/usuarios/{id}")
    fun getUsu(@PathVariable id: Long):Usuario{
        return repoUsu.findById(id).get()
    }

    @PostMapping("/usuario")
    fun insertUsu(@RequestBody usu : Usuario){
        repoUsu.save(usu)
    }
    @PostMapping("/usuario/peticion/{id}/{texto}")
    fun insertTexto(@RequestBody txt : Texto){
        repoTexto.save(txt)
    }

    /*
    devuelven una string contodo lo que hay dentro, no creo que sea lo adecuado...
    */
    @GetMapping("/admin/1")
    fun encriptacionMultiple(): String{
        return ControladorCripto.encriptar(repoUsu.findAll().toString(), claveAdmin)
    }

    @GetMapping("/admin/{id}")
    fun encriptacionUnica(@PathVariable id: String):String{
        return ControladorCripto.encriptar(id, claveAdmin)
    }

    @GetMapping("/admin")
    fun encriptacionTextos(): String{
        return ControladorCripto.encriptar(repoTexto.findAll().toString(), claveAdmin)
    }

}