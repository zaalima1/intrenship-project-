<<<<<<< HEAD:src/main/java/com/example/siya/controller/StatementPageController.java
package com.example.siya.controller;
=======
package VaultCore_Financial.controller;
>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/controller/StatementPageController.java



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatementPageController {

    @GetMapping("/statement-page")
    public String showStatementPage() {
        return "statement";
    }
}
