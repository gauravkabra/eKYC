package com.shadows.alti.ekyc.listeners;


import com.shadows.alti.ekyc.ws.Response;

/**
 * Created by Vsridhara on 9/5/2015.
 */
public interface AsyncResponse {
    void onSuccess(Response response);
    void onFailure(Response response);
    void onSessionExpired();
}
