package com.puppetlabs.jenkins.plugins.puppetgatling;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.*;

import org.mockito.Mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith( JUnit4.class )
public class PuppetGatlingPublisherTest {

  @Test
  public void test() {
    assertThat( "What is going on?", endsWith("!") );
  }

}
