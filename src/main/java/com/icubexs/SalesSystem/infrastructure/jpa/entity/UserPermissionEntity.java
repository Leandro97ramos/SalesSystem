package com.icubexs.SalesSystem.infrastructure.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_permissions")
@Data
public class UserPermissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userPermissionId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "config_type_id", nullable = false)
    private Long configTypeId;

    @Column(name = "permission_level", length = 20)
    private String permissionLevel;
}