package ist.challenge.samuel_sibuea.controller;


import ist.challenge.samuel_sibuea.dto.AuthRequestDto;
import ist.challenge.samuel_sibuea.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    private ResponseEntity<Object> registerUser(@RequestBody AuthRequestDto authRequestDto){
        Map<String,Object > response = new HashMap<>();
        if(authService.findByUsername(authRequestDto.getUsername())){
            response.put("message","Username sudah terpakai");
            response.put("HttpStatus", 409);
            return ResponseEntity.status(409).body(response);
        }

        response.put("message","Registrasi berhasil");
        response.put("HttpStatus",200);
        response.put("data", authRequestDto);
        authService.registerUser(authRequestDto);

        return ResponseEntity.status(201).body(
                response
        );
    }

    @PostMapping("/login")
    private ResponseEntity<Object> loginUser(@RequestBody AuthRequestDto authRequestDto){
        Map<String,Object > response = new HashMap<>();
        if(authRequestDto.getUsername().isEmpty() || authRequestDto.getPassword().isEmpty()){
            response.put("message","Username dan / atau password kosong");
            response.put("HttpStatus", 400);
            return ResponseEntity.status(400).body(response);
        }
        if(authService.findUser(authRequestDto)){
            response.put("message","Sukses Login");
            response.put("HttpStatus", 200);
            return ResponseEntity.status(200).body(response);
        }else{
            response.put("message","Username dan / atau password salah");
            response.put("HttpStatus", 401);
            return ResponseEntity.status(401).body(response);
        }
    }
}
