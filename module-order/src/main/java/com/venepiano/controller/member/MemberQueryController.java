package com.venepiano.controller.member;

import com.venepiano.controller.member.body.MemberResponseBody;
import com.venepiano.controller.responsebody.GeneralResponseBody;
import com.venepiano.service.member.MemberQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberQueryController {
    private final MemberQueryService memberQueryService;

    @GetMapping(value = "/api/v1/members")
    public ResponseEntity<GeneralResponseBody<List<MemberResponseBody>>> getMembers(
            @RequestParam(value = "teamId") String teamId
    ) {
        List<MemberResponseBody> result = memberQueryService.findMembersByTeamId(teamId)
                .stream()
                .map(MemberResponseBody::from)
                .toList();

        return new ResponseEntity<>(GeneralResponseBody.from(result), HttpStatus.OK);
    }
}
