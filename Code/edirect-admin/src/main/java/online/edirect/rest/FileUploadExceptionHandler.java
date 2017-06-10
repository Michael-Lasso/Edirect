package online.edirect.rest;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import online.edirect.utils.ErrorRep;

@ControllerAdvice
public class FileUploadExceptionHandler {

    @ExceptionHandler(FileUploadException.class)
    public ResponseEntity<ErrorRep> appException(FileUploadException e, HttpServletRequest request) {

        ErrorRep error = new ErrorRep();
        error.setMessage(e.getMessage());

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
