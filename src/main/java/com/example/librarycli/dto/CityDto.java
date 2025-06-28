package com.example.librarycli.dto;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityDto {
  private long id;
  private String name;
  private String state;
  private int population;
  private List<BranchDto> branches;

  public long getId() { return id; }
  public void setId(long id) { this.id = id; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public String getState() { return state; }
  public void setState(String state) { this.state = state; }
  public int getPopulation() { return population; }
  public void setPopulation(int population) { this.population = population; }
  public List<BranchDto> getBranches() { return branches; }
  public void setBranches(List<BranchDto> branches) { this.branches = branches; }
}
