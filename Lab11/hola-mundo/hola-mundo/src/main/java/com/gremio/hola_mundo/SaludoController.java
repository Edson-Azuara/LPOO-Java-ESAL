package com.gremio.hola_mundo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gremio.model.Aventurero;

@Controller
public class SaludoController {

    @GetMapping("/saludo")
    public String saludo(Model model) {

        // Aquí preparamos los datos (el Model)
        String mensaje  = "¡Hola Mundo desde Spring Boot!";
        String gremio   = "Gran Gremio de Aventureros";
        int    nivel    = 1;

        // Los enviamos a la vista
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("gremio",  gremio);
        model.addAttribute("nivel",   nivel);

        return "saludo";   // busca templates/saludo.html
    }

    @GetMapping("/aventurero")
    public String aventurero(Model model) {
        Aventurero a = new Aventurero("Sylva", "Druida", 10);
        model.addAttribute("aventurero", a);
        return "aventurero";
    }
}