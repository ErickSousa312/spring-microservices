package spring.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*
import jakarta.validation.constraints.*
import kotlinx.serialization.Serializable

@Serializable
@Entity
class Person (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private var id: Long? = null,
    @field:NotBlank(message = "Name must not be blank")
    @field:Size(min = 2)
    private var name:String? = null,
    @field:NotBlank(message = "Email must not be blank")
    private var email: String? = null,
){
    override fun toString(): String {
        return "Person(id=$id name=$name, email=$email)"
    }
}

