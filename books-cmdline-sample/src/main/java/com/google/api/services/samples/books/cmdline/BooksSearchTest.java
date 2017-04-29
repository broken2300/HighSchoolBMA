/*
 * Copyright (c) 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.api.services.samples.books.cmdline;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Chen@google.com (Your Name Here)
 *
 */
public class BooksSearchTest {
  BooksSearch bs = new BooksSearch();
  @Test
  public void test() {
    //fail("Not yet implemented");
  }
  
  @Test
  public void writerTest(){
    
    assertNotNull(bs);
  }

  @Test
  public void writeTest(){
    bs.writeFile("--author,ban");
    FileReader fr;
    try {
      fr = new FileReader("src/GBAPI/Google_book_list.txt");
      BufferedReader br = new BufferedReader(fr);
      assertNotNull(fr);
      assertNotNull(br);
      try {
        assertTrue(br.readLine().length()>0);
      } catch (IOException exception) {
        fail("ioexception");
        exception.printStackTrace();
      }
    } catch (FileNotFoundException exception) {
      fail("file not found");
      exception.printStackTrace();
    }
    
  }
}
