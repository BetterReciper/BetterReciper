package KU.BetterReciper.service;

import KU.BetterReciper.dto.SignupDto;
import KU.BetterReciper.model.Member;
import KU.BetterReciper.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

@Service
public class SignupService {

    @Autowired
    private MemberRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    public boolean isUsernameAvailable(String username) {
        return repository.findByUsername(username) == null;
    }

    public Member createMember(SignupDto member) {
        Member newMember = modelMapper.map(member, Member.class);

        String hashedPassword = passwordEncoder.encode(member.getPassword());

        newMember.setPassword(hashedPassword);

        repository.save(newMember);
        return newMember;
    }
}
