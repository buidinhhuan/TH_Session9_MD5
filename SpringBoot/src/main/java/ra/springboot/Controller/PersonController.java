package ra.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import ra.springboot.Exception.PersonException;
import ra.springboot.Model.Dto.Request.PersonRequest;
import ra.springboot.Model.Dto.Response.PersonResponse;
import ra.springboot.Service.IPersonService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v7/persons")
public class PersonController {
    @Autowired
    private IPersonService personService;

    @GetMapping
    public ResponseEntity<List<PersonResponse>> findAll() {
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponse> findById(@PathVariable Long id) {
        return new ResponseEntity<>(personService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonResponse> add(@RequestBody @Valid PersonRequest personRequest) throws MethodArgumentNotValidException, PersonException {
        return new ResponseEntity<>(personService.save(personRequest), HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<PersonResponse> update(@RequestBody @Valid PersonRequest personRequest, @PathVariable Long id) throws MethodArgumentNotValidException, PersonException {
        return new ResponseEntity<>(personService.update(personRequest, id), HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PersonResponse> delete(@PathVariable Long id) {
        return new ResponseEntity<>(personService.delete(id), HttpStatus.OK);
    }
}
