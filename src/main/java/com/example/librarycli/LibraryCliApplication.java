package com.example.librarycli;

import com.example.librarycli.service.LibraryApiClient;
import com.example.librarycli.ui.ConsoleUi;
import java.util.Scanner;

public class LibraryCliApplication {
  public static void main(String[] args) {
    String base = (args.length > 0) ? args[0] : "http://localhost:8080";
    LibraryApiClient api = new LibraryApiClient(base);
    try (Scanner in = new Scanner(System.in)) {
      new ConsoleUi(api, in).run();
    }
  }
}
