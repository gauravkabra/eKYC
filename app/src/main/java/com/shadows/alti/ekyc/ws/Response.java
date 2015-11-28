/*******************************************************************************
 * Copyright © Visa 2015. All rights reserved.
 * <p/>
 * This software is the confidential and proprietary information
 * of Visa. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms and conditions
 * entered into with Visa.
 *
 * @Author Chandanks
 ******************************************************************************/
package com.shadows.alti.ekyc.ws;

/**
 * To handle server com.visa.nxg.epos.spire.response
 *
 * @author Rgupta2072
 *
 */

public class Response {

/*  private int status;
  private String content;
  private byte[] sessionKey;
  private Gson gson;

  public Response(int status) {
    this(status, null);
  }

  public Response(int status, String content) {
    this.status = status;
    this.content = content;
    gson = new GsonBuilder().create();
  }

  public <T> T getEntity(Class<T> classOfT) {
    if (content == null)
      return null;

    return gson.fromJson(content, classOfT);
  }

  public <T> T getEntity(Type type) {
    if (content == null)
      return null;

    return gson.fromJson(content, type);
  }

  public Result getError() {
    if (content == null || ok())
      return null;

    return gson.fromJson(content, Result.class);
  }

  *//**
   * To get com.visa.nxg.epos.spire.status
   *
   * @return com.visa.nxg.epos.spire.status
   *//*
  public int getStatus() {
    return status;
  }

  *//**
   * Checks com.visa.nxg.epos.spire.status == 200
   *
   * @return com.visa.nxg.epos.spire.status
   *//*
  public boolean ok() {
    return status == 200;
  }

  *//**
   * Checks com.visa.nxg.epos.spire.status == 406
   *
   * @return com.visa.nxg.epos.spire.status
   *//*
  public boolean isFailed() {
    return status == 406;
  }

  *//**
   * Checks com.visa.nxg.epos.spire.status >= 500
   *
   * @return com.visa.nxg.epos.spire.status
   *//*
  public boolean isServerError() {
    return status >= 500;
  }

  *//**
   * Checks com.visa.nxg.epos.spire.status == 400
   *
   * @return com.visa.nxg.epos.spire.status
   *//*
  public boolean isBadRequest() {
    return status == 400;
  }

  *//**
   * Checks com.visa.nxg.epos.spire.status == 500
   *
   * @return com.visa.nxg.epos.spire.status
   *//*
  public boolean isInternalServerError() {
    return status == 500;
  }

  *//**
   * Checks com.visa.nxg.epos.spire.status == 408
   *
   * @return com.visa.nxg.epos.spire.status
   *//*
  public boolean isRequestTimeout() {
    return status == 408;
  }

  *//**
   * Checks com.visa.nxg.epos.spire.status == 404
   *
   * @return com.visa.nxg.epos.spire.status
   *//*
  public boolean isNotFound() {
    return status == 404;
  }

  *//**
   * Checks com.visa.nxg.epos.spire.status == 401
   *
   * @return com.visa.nxg.epos.spire.status
   *//*
  public boolean isSessionExpired() {
    return status == 401;
  }


    public byte[] getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(byte[] sessionKey) {
        this.sessionKey = sessionKey;
    }*/
}
