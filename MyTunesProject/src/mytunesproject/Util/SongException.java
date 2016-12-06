/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesproject.Util;

/**
 *
 * @author simon
 */
public class SongException extends Exception {
        // All constructors are copied from super for full compliance
    // No implementation here. Message used for messages to GUI
    
    public SongException()
    {
    }

    public SongException(String message)
    {
        super(message);
    }

    public SongException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public SongException(Throwable cause)
    {
        super(cause);
    }

    public SongException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
