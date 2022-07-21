package com.tlglearning.wordcount;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordCounter {

  private final Map<String, Integer> counts = new HashMap<>();
  private int totalWords;


  public Set<String> words() {
    return counts.keySet();
  }

  public int get(String word) {
    return counts.getOrDefault(word, 0);
  }

  public Map<String, Integer> getCounts() {
    return Collections.unmodifiableMap(counts);
  }

  public void add(String text) {
    String trimmedLine = text.trim();
    if (!trimmedLine.isEmpty()) {
      String[] words = splitWords(trimmedLine);
      countWords(words);
    }
  }

  public int size() {
    return counts.size();
  }

  public int total() {
    return totalWords;
  }

  @Override
  public String toString() {
    return counts.toString();
  }


  //helper methods, not visible outside of world
  void countWords(String[] words) {
    for (String word: words) {
      // DONE TODO Check if word is already present as a key in counts:
      // if it's not present, add it to counts with a value of 1
      // otherwise, get the current value, add 1 to it update the map with the new value.
      counts.put(word, get(word) + 1);
      totalWords++;
    }

  }

  // Made it package private by removing private before String[]
  String[] splitWords(String text) {
    return text
        .toLowerCase()
        .split("[\\W_]+");
  }
}
