package spring.repositories

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import spring.entities.Person
import java.util.*

@Repository
interface PersonRepository : CrudRepository<Person, Long> {
}