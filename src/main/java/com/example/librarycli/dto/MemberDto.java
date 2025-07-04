package com.example.librarycli.dto;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberDto {
  private long id;
  private String firstName;
  private String lastName;
  private String email;
  private List<BookDto> borrowedBooks;
  private List<BranchDto> visitedBranches;

  public long getId() { return id; }
  public void setId(long id) { this.id = id; }
  public String getFirstName() { return firstName; }
  public void setFirstName(String firstName) { this.firstName = firstName; }
  public String getLastName() { return lastName; }
  public void setLastName(String lastName) { this.lastName = lastName; }
  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }
  public List<BookDto> getBorrowedBooks() { return borrowedBooks; }
  public void setBorrowedBooks(List<BookDto> borrowedBooks) { this.borrowedBooks = borrowedBooks; }
  public List<BranchDto> getVisitedBranches() { return visitedBranches; }
  public void setVisitedBranches(List<BranchDto> visitedBranches) { this.visitedBranches = visitedBranches; }
}
