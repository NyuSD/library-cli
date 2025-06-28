package com.example.librarycli.ui;

import com.example.librarycli.dto.*;
import com.example.librarycli.service.LibraryApiClient;
import java.util.List;
import java.util.Scanner;

public class ConsoleUi {

  private final LibraryApiClient api;
  private final Scanner in;

  public ConsoleUi(LibraryApiClient api, Scanner in) {
    this.api = api;
    this.in  = in;
  }

  public void run() {
    System.out.println("=== Library CLI ===");
    while (true) {
      System.out.println("""
          1) Which library branches operate in a city?
          2) Which books has a member borrowed?
          3) Which library branches stock a book?
          4) Which library branches has a member visited?
          0) Quit
          """);
      System.out.print("Choose: ");
      String choice = in.nextLine().trim();
      try {
        switch (choice) {
          case "1" -> handleBranchesInCity();
          case "2" -> handleBooksByMember();
          case "3" -> handleBranchesByBook();
          case "4" -> handleBranchesVisited();
          case "0" -> { System.out.println("Bye!"); return; }
          default  -> System.out.println("Invalid choice\n");
        }
      } catch (Exception ex) {
        System.out.println("⚠️  Error: " + ex.getMessage() + "\n");
      }
    }
  }

  private void handleBranchesInCity() throws Exception {
    long id = askLong("City id");
    List<BranchDto> branches = api.getBranchesInCity(id);
    branches.forEach(b -> System.out.printf("• %s (%s)%n", b.getName(), b.getStreetAddress()));
    System.out.println();
  }

  private void handleBooksByMember() throws Exception {
    long id = askLong("Member id");
    List<BookDto> books = api.getBooksBorrowedByMember(id);
    books.forEach(b -> System.out.printf("• %s – %s%n", b.getTitle(), b.getAuthor()));
    System.out.println();
  }

  private void handleBranchesByBook() throws Exception {
    long id = askLong("Book id");
    List<BranchDto> branches = api.getBranchesStockingBook(id);
    branches.forEach(b -> System.out.printf("• %s (%s)%n", b.getName(), b.getStreetAddress()));
    System.out.println();
  }

  private void handleBranchesVisited() throws Exception {
    long id = askLong("Member id");
    List<BranchDto> branches = api.getBranchesVisitedByMember(id);
    branches.forEach(b -> System.out.printf("• %s (%s)%n", b.getName(), b.getStreetAddress()));
    System.out.println();
  }

  private long askLong(String label) {
    System.out.print(label + ": ");
    return Long.parseLong(in.nextLine().trim());
  }
}
