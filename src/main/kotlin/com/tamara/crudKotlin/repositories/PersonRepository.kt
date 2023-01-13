package com.tamara.crudKotlin.repositories

import com.tamara.crudKotlin.entities.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<Person, Long>
