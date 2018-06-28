package practical.automata.controllers;

import org.springframework.http.HttpStatus;
import practical.automata.models.AutomataFileFromRegexResult;
import practical.automata.models.Regex;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import practical.automata.calculations.regex.AutomataFileFromRegex;

public class AutomataController {


    @PostMapping(path = "/automata-file-from-regex")
    public ResponseEntity automataFileFromRegex(@RequestBody Regex regex) {

        AutomataFileFromRegex automataFileFromRegex = new AutomataFileFromRegex(regex);

        AutomataFileFromRegexResult automataFileFromRegexResult = automataFileFromRegex.generateFile();

        if (automataFileFromRegexResult == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            return ResponseEntity.ok(automataFileFromRegexResult);
        }
        
    }
}
