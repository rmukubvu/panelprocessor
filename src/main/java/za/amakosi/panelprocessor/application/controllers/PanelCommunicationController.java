package za.amakosi.panelprocessor.application.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import za.amakosi.panelprocessor.application.dto.PanelRequestMessage;
import za.amakosi.panelprocessor.application.dto.ResponseMessage;
import za.amakosi.panelprocessor.application.dto.mapper.PanelRequestMessageMapper;
import za.amakosi.panelprocessor.application.dto.mapper.ResponseMessageMapper;
import za.amakosi.panelprocessor.domain.aggregate.panel.PanelService;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/panel")
@AllArgsConstructor
public class PanelCommunicationController {

    private PanelService panelService;

    @GetMapping("/register-info")
    public ResponseEntity<?> registerInfo() {
       return ResponseEntity.ok().body(panelService.registerInfo());
    }

    @PostMapping
    public @ResponseBody ResponseEntity<Collection<ResponseMessage>> queryPanel(@Validated @RequestBody PanelRequestMessage model) {
        var response = panelService.queryPanel(PanelRequestMessageMapper.INSTANCE.toDomain(model));
        return new ResponseEntity<>(response.stream().map(ResponseMessageMapper.INSTANCE::fromDomain).collect(Collectors.toList()), HttpStatus.OK);
    }

}
