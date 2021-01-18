package org.yu.restfulcrud.exception;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserNotExistException.java
 * @Description TODO
 * @createTime 2021年01月18日 22:13:00
 */
public class UserNotExistException extends RuntimeException{
    public UserNotExistException() {
        super("用户不存在");
    }
}
