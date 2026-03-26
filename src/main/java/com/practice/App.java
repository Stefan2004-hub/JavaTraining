package com.practice;

/** Application entry point. */
import java.util.logging.Logger;

public final class App {

  private static final Logger LOGGER = Logger.getLogger(App.class.getName());

  private App() {}

  /** Starts the application. */
  public static void main() {
    LOGGER.info("Interview practice project. Run tests with: mvn test");
  }
}
