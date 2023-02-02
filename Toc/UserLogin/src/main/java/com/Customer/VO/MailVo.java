package com.Customer.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * PROJECT_NAME MailVo
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/1/29~22:21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String Object;

    private String content;

    private String target;

    private String from;
}
