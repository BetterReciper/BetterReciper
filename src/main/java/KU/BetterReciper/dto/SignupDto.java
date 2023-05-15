package KU.BetterReciper.dto;

import lombok.Data;

@Data
public class SignupDto {
    private String name;
    private String username;
    private String password;
    private Boolean isConsent;
}
