package project.redis.common.exception;

import lombok.Getter;

@Getter
public class ErrorCode {

    private String messageId;

    public ErrorCode(String messageId) {
        this.messageId = messageId;
    }

    public static ErrorCode NOT_FOUND = new ErrorCode("COMMON.ERROR.NOT_FOUND");
    public static ErrorCode NOT_NULL = new ErrorCode("COMMON.ERROR.NOT_NULL");
    public static ErrorCode NOT_BLANK = new ErrorCode("COMMON.ERROR.NOT_BLANK");

}
