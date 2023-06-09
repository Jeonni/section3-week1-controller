package com.codestates.member;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/members", produces = {MediaType.APPLICATION_JSON_VALUE})
public class MemberController {
    // 회원 정보를 등록해주는 핸들러 메서드
    @PostMapping
    public String postMember(@RequestParam("email") String email,
                             @RequestParam("name") String name,
                             @RequestParam("phone") String phone) {
        System.out.println("# email: " + email);
        System.out.println("# name: " + name);
        System.out.println("# phone: " + phone);

        // 응답 문자열을 String -> JSON 형식에 맞게 작성
        String response =
                "{\"" +
                        "email\":\"" + email + "\"," +
                        "\"name\":\"" + name + "\",\"" +
                        "phone\":\"" + phone +
                        "\"}";
        return response;
    }

    // 특정 회원의 정보를 클라이언트 쪽으로 제공해주는 핸들러 메서드
    // @RequestMapping 에 설정된 URI + @GetMapping 에 설정한 URI가 합쳐진 상태 --> ”/v1/members/{member-id}”
    // {member-id}: 회원 식별자, 클라이언트가 요청을 보낼 때, URI로 어떤 값을 지정하느냐에 따라 동적으로 바뀌는 값
    @GetMapping("/{member-id}")
    public String getMember(@PathVariable("member-id") long memberId) { // @PathVariable: 들러 메서드의 파라미터 종류 중 하나 @GetMapping("/{member-id}") 중괄호 안의 문자열과 동일하게 지정
        System.out.println("# memberId: " + memberId);

        // not implementation
        return null;
    }

    @GetMapping
    public String getMembers() {
        System.out.println("# get Members");

        // not implementation
        return null;
    }
}
