package com.tamara.crudKotlin.services

import com.tamara.crudKotlin.entities.Person
import com.tamara.crudKotlin.exceptions.RequiredObjectIsNullException
import com.tamara.crudKotlin.exceptions.ResourceNotFoundException
import com.tamara.crudKotlin.repositories.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonServices {

    @Autowired
    private lateinit var repository: PersonRepository

    fun create(person: Person?): Person {

        if (person == null) throw RequiredObjectIsNullException()
        return repository.save(person)
    }

    fun findAll(): List<Person> = repository.findAll()

    fun findById(id: Long): Person =
        repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID") }

    fun update(person: Person?): Person {
        if (person == null) throw RequiredObjectIsNullException()

        val entity: Person = repository.findById(person.id!!)
            .orElseThrow { ResourceNotFoundException("No records found for this ID") }
        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender
        return repository.save(entity)
    }

    fun delete(id: Long) {
        val entity: Person = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID") }
        repository.delete(entity)
    }
}