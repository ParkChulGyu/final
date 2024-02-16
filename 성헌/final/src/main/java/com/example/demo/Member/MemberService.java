package com.example.demo.Member;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.FileDownL.PhotoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@Service
@Transactional
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member searchMemberById(Long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);

        // findById의 반환값이 Optional이므로 적절히 처리
        return optionalMember.orElse(null);
    }

}
