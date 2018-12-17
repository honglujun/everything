package com.example.everything.common.dto;

import com.terran4j.commons.api2doc.annotations.ApiComment;
import lombok.Data;

import java.io.Serializable;

/**
 * @author win10
 */
@Data
@ApiComment(value = "登录人信息")
public class LoginAuthDto implements Serializable {
    private static final long serialVersionUID = 6819008712054517830L;

    @ApiComment(value = "用户ID", sample = "123")
    private Long userId;
    @ApiComment(value = "登录名", sample = "李斯")
    private String loginName;
    @ApiComment(value = "用户名", sample = "秦汉")
    private String userName;
    @ApiComment(value = "组织ID", sample = "12131")
    private Long groupId;
    @ApiComment(value = "组织名称", sample = "大秦")
    private String groupName;

    public LoginAuthDto() {
    }

    public LoginAuthDto(Long userId, String loginName, String userName) {
        this.userId = userId;
        this.loginName = loginName;
        this.userName = userName;
    }

    public LoginAuthDto(Long userId, String loginName, String userName, Long groupId, String groupName) {
        this.userId = userId;
        this.loginName = loginName;
        this.userName = userName;
        this.groupId = groupId;
        this.groupName = groupName;
    }
}
