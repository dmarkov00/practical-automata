package practical.automata.controllers;

import org.springframework.http.HttpStatus;
import practical.automata.models.NdfaFromRegexResult;
import practical.automata.models.Regex;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import practical.automata.calculations.ndfa_from_regex.NdfaFromRegex;

/**
 * TODO: create endpoints for each assignment and connect it to the front-end
 */
public class AutomataController {

    // TODO: update the logic to go through the CalculationsManager class
    @PostMapping(path = "/automata-file-from-regex")
    public ResponseEntity automataFileFromRegex(@RequestBody Regex regex) {

        NdfaFromRegex ndfaFromRegex = new NdfaFromRegex(regex);

        NdfaFromRegexResult ndfaFromRegexResult = ndfaFromRegex.generateFile();

        if (ndfaFromRegexResult == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            return ResponseEntity.ok(ndfaFromRegexResult);
        }
        
    }
}
