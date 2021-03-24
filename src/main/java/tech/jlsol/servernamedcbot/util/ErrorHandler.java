package tech.jlsol.servernamedcbot.util;

import java.util.Optional;

public class ErrorHandler {
    public static String getErrorMessage(Integer errorCode, Optional<String> errorMessage){
        return String.format("ERROR CODE: %d \n %s",
                ErrorHandler.ErrorCodes.FILE_CREATION_EXCEPTION, errorMessage.get().replace(null, ""));
    }
    public static class ErrorCodes{
        public static Integer FILE_NOT_FOUND = 20;
        public static Integer FILE_CREATION_EXCEPTION = 21;
        public static Integer FILE_IO_EXCEPTION = 22;
        public static Integer SECURITY_EXCEPTION = 30;
        public static Integer SQL_EXCEPTION = 40;
    }
}
