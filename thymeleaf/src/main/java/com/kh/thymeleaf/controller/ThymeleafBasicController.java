package com.kh.thymeleaf.controller;

import com.kh.thymeleaf.member.model.vo.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/th")//기본어노테이션 => 모든 http 메서드 처리가능( GET, POST, PUT, DELETE 등)
public class ThymeleafBasicController {

    @GetMapping("/text") //GET 요청만 처리, Spring 4.3 부터 추가됨.
    public String basic(Model model){
        model.addAttribute("msg", "thymeleaf 이용하기");
        model.addAttribute("data", "kh");

        return "basic/text_test";
    }

    @GetMapping("/opr") //GET 요청만 처리, Spring 4.3 부터 추가됨.
    public String opTest(){
        return "basic/op_test";
    }

    @GetMapping("/form") //GET 요청만 처리, Spring 4.3 부터 추가됨.
    public String getFormTest(Model model){
        model.addAttribute("data", "thymeleaf");

        return "basic/form_test";
    }

    @PostMapping("/form") //GET 요청만 처리, Spring 4.3 부터 추가됨.
    public String postFormTest(String test2, String thymeleaf){
        System.out.println("test2 : " + test2);
        System.out.println("thymeleaf : " + thymeleaf);

        return "basic/form_test";
    }

    @GetMapping("/if")
    public String ifTest(Model model){
        model.addAttribute("score", 20);
        return "basic/if_test";
    }

    @GetMapping("/loop")
    public String loopTest(Model model){
        Member m1 = new Member("user01", "pass01", "김은우", 11);
        Member m2 = new Member("user02", "pass02", "박은우", 22);
        Member m3 = new Member("user03", "pass03", "차은우", 33);
        Member m4 = new Member("user04", "pass04", "오은우", 44);

        ArrayList<Member> list = new ArrayList<>();
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);

        model.addAttribute("list", list); //검색 or 조회기능
        model.addAttribute("member", m1); //결과 1개인경우
        return "basic/loop_test";
    }

    @GetMapping("/href")
    public String hrefTest(){
        return "basic/href_test";
    }

    @GetMapping("/checked")
    public String checkedTest(Model model){
        model.addAttribute("isChecked", true);
        return "basic/href_test";
    }
}
