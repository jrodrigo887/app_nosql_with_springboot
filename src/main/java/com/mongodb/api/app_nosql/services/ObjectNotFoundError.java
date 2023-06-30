package com.mongodb.api.app_nosql.services;

public class ObjectNotFoundError  extends RuntimeException {
  private static final long serialVersionUID = 1L;

  ObjectNotFoundError(String msg) {
    super(msg);
  }

}
