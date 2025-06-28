package com.example.librarycli.dto;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BranchDto {
  private long id;
  private String name;
  private String streetAddress;
  private String openHours;
  private List<BookDto> books;

  public long getId() { return id; }
  public void setId(long id) { this.id = id; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public String getStreetAddress() { return streetAddress; }
  public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }
  public String getOpenHours() { return openHours; }
  public void setOpenHours(String openHours) { this.openHours = openHours; }
  public List<BookDto> getBooks() { return books; }
  public void setBooks(List<BookDto> books) { this.books = books; }
}
