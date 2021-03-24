package tech.jlsol.servernamedcbot.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import javax.annotation.Nullable;

public class Config {

  /**
   * reads values from .prop(erties) file
   *
   * @param path      path to file
   * @param filename  filename (without ending)
   * @param key       category for value
   * @return          returns value
   */
  public static String readConfig(String path, String filename, String key) {
    Properties prop = new Properties();
    InputStream input = null;
    if (FileHelper.checkFile(path, filename, "prop")) {
      try {
        input = new FileInputStream((path + "/" + filename + ".prop"));

        prop.load(input);

        prop.getProperty(key);
      } catch (IOException e) {
        Logger.error(
          ErrorHandler.getErrorMessage(
            ErrorHandler.ErrorCodes.FILE_IO_EXCEPTION,
            java.util.Optional.ofNullable(e.getMessage())
          )
        );
      } finally {
        if (input != null) {
          try {
            input.close();
          } catch (IOException e) {
            Logger.error(
              ErrorHandler.getErrorMessage(
                ErrorHandler.ErrorCodes.FILE_IO_EXCEPTION,
                java.util.Optional.ofNullable(e.getMessage())
              )
            );
          }
        }
      }
    }
    return prop.getProperty(key);
  }

  /**
   * Writes Properties in a .prop(erties) file
   *
   * @param path      path to file
   * @param filename  filename (without ending)
   * @param key       category
   * @param value     value for category
   */
  public static void writeConfig(
    String path,
    String filename,
    String key,
    String value
  ) {
    if (FileHelper.checkFile(path, filename, "prop")) {
      Properties properties = new Properties();
      OutputStream outputStream = null;

      try {
        outputStream =
          new FileOutputStream(path + "/" + filename + ".prop", true);
      } catch (FileNotFoundException e) {
        Logger.error(
          ErrorHandler.getErrorMessage(
            ErrorHandler.ErrorCodes.FILE_NOT_FOUND,
            java.util.Optional.ofNullable(e.getMessage())
          )
        );
      }
      properties.setProperty(key, value);

      try {
        properties.store(outputStream, null);
      } catch (IOException e1) {
        Logger.error(e1.getMessage());
        e1.printStackTrace();
      }
    }
  }
}

class ReadFile {

  /**
   * <p>read.</p>
   *
   * @param path a {@link java.lang.String} object.
   * @param filename a {@link java.lang.String} object.
   * @param ending a {@link java.lang.String} object.
   * @return a {@link java.util.List} object.
   */
  @Nullable
  public static List<String> read(String path, String filename, String ending) {
    ArrayList<String> content = new ArrayList<>();
    try {
      File fileDir = new File(
        String.format("%s/%s.%s", path, filename, ending)
      );

      BufferedReader in = new BufferedReader(
        new InputStreamReader(
          new FileInputStream(fileDir),
          StandardCharsets.UTF_8
        )
      );

      String str;

      while ((str = in.readLine()) != null) {
        System.out.println(str);
        Objects.requireNonNull(content).add(str);
      }
      in.close();
      return content;
    } catch (UnsupportedEncodingException | FileNotFoundException e) {
      Logger.error(
        ErrorHandler.getErrorMessage(
          ErrorHandler.ErrorCodes.FILE_NOT_FOUND,
          java.util.Optional.ofNullable(e.getMessage())
        )
      );
    } catch (IOException e) {
      Logger.error(
        ErrorHandler.getErrorMessage(
          ErrorHandler.ErrorCodes.FILE_IO_EXCEPTION,
          java.util.Optional.ofNullable(e.getMessage())
        )
      );
    }
    return null;
  }
}
