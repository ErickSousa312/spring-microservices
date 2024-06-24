package spring.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import spring.entities.Person
import spring.repositories.PersonRepository
import java.util.*

@Service
class PersonService ( val personRepository: PersonRepository) {
    fun save(person: Person): Person {
        return personRepository.save(person)
    }
    fun delete(id: Long): Optional<Person> {
        val person:Optional<Person> = personRepository.findById(id)
        if(person.isPresent){
            personRepository.deleteById(id)
            return Optional.of(person.get())
        }
        return Optional.empty()
    }
    fun findOne(id: Long): Optional<Person> {
        return personRepository.findById(id)
    }
    fun findAll(): List<Person> {
        val person =  personRepository.findAll()
        return person.toList()
    }
}