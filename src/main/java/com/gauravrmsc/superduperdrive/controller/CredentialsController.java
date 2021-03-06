package com.gauravrmsc.superduperdrive.controller;

import com.gauravrmsc.superduperdrive.model.Credentials;
import com.gauravrmsc.superduperdrive.model.Result;
import com.gauravrmsc.superduperdrive.service.CredentialsService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/credentials")
public class CredentialsController {

  @Autowired
  CredentialsService credentialsService;

  @PostMapping("/add")
  public String addCredentials(Credentials credentials, Model model, Principal principal)
      throws Exception {
    Result result = credentialsService.addNewCredentials(credentials, principal.getName());
    model.addAttribute("result", result);
    return "result";
  }

  @PostMapping("/delete")
  public String deleteCredentials(long credentialId, Model model, Principal principal) {
    Result result = credentialsService.deleteCredentals(credentialId, principal.getName());
    model.addAttribute("result", result);
    return "result";
  }

}
