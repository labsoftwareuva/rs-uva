package br.uva.rsuva.controller.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class Aplicacao extends Application {
          @Override
          public Set<Class<?>> getClasses() {
                      Set<Class<?>> classes = new HashSet<Class<?>>();
                      classes.add(RESTfulHelloWorld.class);
                      return classes;
          }
}
