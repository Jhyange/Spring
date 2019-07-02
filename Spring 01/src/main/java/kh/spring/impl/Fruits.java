package kh.spring.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.Spring;

public class Fruits {
private List<String> name;
private Set<String> namesSet;
private Map<String,Integer> namesMap;
public Fruits(List<String> name, Set<String> namesSet, Map<String, Integer> namesMap) {
	this.name = name;
	this.namesSet = namesSet;
	this.namesMap = namesMap;
}
public Fruits() {
}
public List<String> getName() {
	return name;
}
public void setName(List<String> name) {
	this.name = name;
}
public Set<String> getNamesSet() {
	return namesSet;
}
public void setNamesSet(Set<String> namesSet) {
	this.namesSet = namesSet;
}
public Map<String, Integer> getNamesMap() {
	return namesMap;
}
public void setNamesMap(Map<String, Integer> namesMap) {
	this.namesMap = namesMap;
}
}
