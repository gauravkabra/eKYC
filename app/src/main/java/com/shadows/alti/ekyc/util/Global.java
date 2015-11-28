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
package com.shadows.alti.ekyc.util;


/**
 * Instance of this class is accessible across the application It has
 * information like serverUrl, merchant type, currency etc etc
 *
 * @moelahi
 */
public class Global {

  private static Global instance = new Global();

  private String token;
  private String code;

  private Global() {
  }

  public static Global getInstance() {
    return instance;
  }

  public void clear() {

  }

}
