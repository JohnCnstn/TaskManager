package com.johncnstn.data.dto;

import com.johncnstn.data.entity.Manager;
import com.johncnstn.data.entity.Client;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class CountryDto {
    @NotNull
    @NotEmpty
    @Setter
    @Getter
    private String name;

    @NotNull
    @NotEmpty
    @Setter
    @Getter
    private String description;

    @Setter
    @Getter
    private long quantity;

    @Getter
    @Setter
    private Manager manager;

    @Getter
    @Setter
    private Set<Client> clients;

}
