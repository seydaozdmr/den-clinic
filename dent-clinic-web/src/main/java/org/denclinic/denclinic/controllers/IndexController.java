package org.denclinic.denclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    //istemci anasayfayı istediği zaman geri döndürülecek bilgilerin belirlendiği ve hangi sayfaya yönlendirilme olacağının
    //(templated/index.html) belirlendiği metot:
    @RequestMapping("/")
    public String index(){

        return "index";
    }
}
