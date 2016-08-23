package ej.com.messenger.model.database;

/**
 * @author Emil Jarosiewicz on 2015-05-12.
 */
public class Response {

    private int success;

    public Response(int success) {
        this.success = success;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }
}
