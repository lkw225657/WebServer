package net.transino.lms.modules.ext.ws.server;

/**
 * @author lee
 * @since 5.0
 */
public class WsProcessorException extends RuntimeException {
    private static final long serialVersionUID = 3957230613154795468L;
    private String messageCode;

    public WsProcessorException(String messageCode, String message) {
        super(message);
        this.messageCode = messageCode;
    }

    public WsProcessorException(Throwable cause) {
        super(cause);
        this.messageCode = "9550";
    }

    public String getMessageCode(){
        return this.messageCode;
    }
}
