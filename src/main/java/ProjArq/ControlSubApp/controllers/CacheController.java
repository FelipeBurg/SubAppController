package ProjArq.ControlSubApp.controllers;

import ProjArq.ControlSubApp.aplicacao.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login/cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @GetMapping("/{appId}")
    public ResponseEntity<String> getCacheInfo(@PathVariable String appId) {
        String cacheInfo = cacheService.getCacheInfo(appId);
        if (cacheInfo == null) {
            return ResponseEntity.status(404).body("Cache miss: Informação não encontrada para o appId: " + appId);
        }
        return ResponseEntity.ok(cacheInfo);
    }

    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        // Retornar um status mais detalhado
        int cacheSize = cacheService.getCacheSize(); // Assumindo que o método getCacheSize() foi implementado
        return ResponseEntity.ok("AssCache is running! It currently stores " + cacheSize + " items.");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        // Tratamento genérico de exceções para este controlador
        return ResponseEntity.status(500).body("Erro interno do servidor: " + e.getMessage());
    }
}
