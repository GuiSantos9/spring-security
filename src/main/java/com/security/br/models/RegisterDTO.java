package com.security.br.models;
import com.security.br.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}