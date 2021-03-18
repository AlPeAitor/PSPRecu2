package com.ejrecupsp.demo

import org.springframework.data.jpa.repository.JpaRepository

interface RepositorioUsuarios:JpaRepository<Usuario, Long>