package no.asgari.civilization.server.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@JsonRootName("playerDTO")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Data
public class PlayerDTO {
    private String playerId;

    @NotNull
    private String username;

    @Email
    @NotNull
    private String email;

    @NotBlank
    @NotNull
    private String password;

    @NotBlank
    @NotNull
    private String passwordCopy;

    private String pbfId;

}