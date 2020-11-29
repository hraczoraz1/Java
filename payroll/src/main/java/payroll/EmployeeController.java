package payroll;

import java.util.List;
import java.util.stream.Collectors;

import javax.swing.text.html.parser.Entity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.*;
import org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.WebFluxBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@RestController
class EmployeeController {

  private final EmployeeRepository repository;

  private final EmployeeModelAssembler assembler;

  EmployeeController(@Lazy EmployeeRepository repository,@Lazy EmployeeModelAssembler assembler) {

    this.repository = repository;
    this.assembler = assembler;
  }

//  Aggregate root
//  @GetMapping("/employees/{id}")
//  EntityModel<Employee> one(@PathVariable Long id) {
//
//    Employee employee = repository.findById(id) //
//       .orElseThrow(() -> new EmployeeNotFoundException(id));
//
//  return EntityModel.of(employee, //
//    linkTo(methodOn(EmployeeController.class).one(id)).withSelfRel(),
//    linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
//  }
  
  @GetMapping("/employees/{id}")
  EntityModel<Employee> one(@PathVariable Long id) {

    Employee employee = repository.findById(id) //
        .orElseThrow(() -> new EmployeeNotFoundException(id));

    return assembler.toModel(employee);
  }
  
  @GetMapping("/employees")
  CollectionModel<EntityModel<Employee>> all() {

    List<EntityModel<Employee>> employees = repository.findAll().stream() //
        .map(assembler::toModel) //
        .collect(Collectors.toList());

    return CollectionModel.of(employees, linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
  }
  
/*  @GetMapping("/employees")
  CollectionModel<EntityModel<Employee>> all() {

   List<EntityModel<Employee>> employees = repository.findAll().stream()
        .map(employee -> EntityModel.of(employee,
            linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(),
            linkTo(methodOn(EmployeeController.class).all()).withRel("employees")))
        .collect(Collectors.toList());

    return CollectionModel.of(employees, linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
  }
*/
  
  @PostMapping("/employees")
  ResponseEntity<?> newEmployee(@RequestBody Employee newEmployee) {

    EntityModel<Employee> entityModel = assembler.toModel(repository.save(newEmployee));

    return ResponseEntity //
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
        .body(entityModel);
  }

  // Single item



  @PutMapping("/employees/{id}")
  ResponseEntity<?> replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

    Employee updatedEmployee = repository.findById(id) //
        .map(employee -> {
          employee.setName(newEmployee.getName());
          employee.setRole(newEmployee.getRole());
          return repository.save(employee);
        }) //
        .orElseGet(() -> {
          newEmployee.setId(id);
          return repository.save(newEmployee);
        });

    EntityModel<Employee> entityModel = assembler.toModel(updatedEmployee);

    return ResponseEntity //
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
        .body(entityModel);
  }

  @DeleteMapping("/employees/{id}")
  ResponseEntity<?> deleteEmployee(@PathVariable Long id) {

    repository.deleteById(id);

    return ResponseEntity.noContent().build();
  }
  
  @Component
  class EmployeeModelAssembler implements RepresentationModelAssembler<Employee, EntityModel<Employee>> {

    @Override
    public EntityModel<Employee> toModel(Employee employee) {

      return EntityModel.of(employee, //
          linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(),
          linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
    }
  }
}