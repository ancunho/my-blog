package online.cunho.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class TbPostCustomerDto extends BaseRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer postCustomerId;
    private Integer postId;
    private Integer customerId;
    private String paidYn;
    private String joinedYn;
    private String joinedTime;
    private String pcOrderNo;
    private String option01;
    private String option02;
    private String option03;
    private String option04;
    private String option05;
    private String createTime;
    private String updateTime;
}
