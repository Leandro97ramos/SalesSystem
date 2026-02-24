package com.icubexs.SalesSystem.infrastructure.jpa.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_role")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class UserRoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_config_det_id")
    private ConfiguracionDetEntity roleConfig;

    @Column(nullable = false)
    private Boolean status;
}