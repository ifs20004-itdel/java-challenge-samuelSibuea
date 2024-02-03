package ist.challenge.samuel_sibuea.controller;

import ist.challenge.samuel_sibuea.dto.AuthRequestDto;
import ist.challenge.samuel_sibuea.entity.User;
import ist.challenge.samuel_sibuea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok(userService.findAll());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Object> editUser(@PathVariable int id, @RequestBody AuthRequestDto newData){
        Map<String,Object > response = new HashMap<>();

        Optional<User> optionalUser = userService.getUserById(id);
        User user = optionalUser.get();
        if(userService.existByUsername(newData.getUsername())){
            response.put("message","Username sudah terpakai");
            response.put("HttpStatus",409);
            return ResponseEntity.status(409).body(response);
        }else if(user.getPassword().equals(newData.getPassword())){
            response.put("message","Password tidak boleh sama dengan password sebelumnya");
            response.put("HttpStatus",400);
            return ResponseEntity.status(400).body(response);
        }
        user.setUsername(newData.getUsername());
        user.setPassword(newData.getPassword());

        response.put("message","Data berhasil diedit");
        response.put("HttpStatus",201);
        response.put("data",user);
        return ResponseEntity.status(201).body(userService.editUser(user));
    }
}
