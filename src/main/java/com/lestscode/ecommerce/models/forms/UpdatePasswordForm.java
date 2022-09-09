package com.lestscode.ecommerce.models.forms;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;

@Data
public class UpdatePasswordForm {

    @NonNull @NotBlank
    private String oldPassword;
    @NonNull @NotBlank
    private String newPassword;
    @NonNull @NotBlank
    private String newPasswordConfirm;

}
