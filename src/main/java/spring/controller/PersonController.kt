package spring.controller

import kotlinx.serialization.Serializable
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import spring.entities.Person
import spring.exceptions.UserNotFoundException
import spring.services.PersonService
import java.util.*

@RestController
@RequestMapping("/users")
class PersonController(
    private var personService: PersonService
) {

    private val logger: org.slf4j.Logger? = LoggerFactory.getLogger(PersonController::class.java)

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Long): ResponseEntity<Person> {
        val person = personService.findOne(id)
        if (person.isEmpty) {
            throw UserNotFoundException("id: $id")
        }
        return ResponseEntity.ok(person.get())
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable("id") id: Long): ResponseEntity<MessageResponse<Person?>> {
        val person = personService.delete(id)
        if (person.isEmpty) {
            throw UserNotFoundException("not found id: $id")
        }
        return ResponseEntity.ok(MessageResponse(
            message = "successful",
            data = person.get()
        ))
    }

    @GetMapping("/all")
    fun all(): ResponseEntity<List<Person>> {
        val persons = personService.findAll()
        return ResponseEntity.ok(persons)
    }
    @PostMapping("/add")
    fun add(@RequestBody person: Person): ResponseEntity<Person> {
        println(person)
        logger?.info("Received request to add person: {}", person)
        personService.save(person)
        return ResponseEntity.ok(person)
    }
}