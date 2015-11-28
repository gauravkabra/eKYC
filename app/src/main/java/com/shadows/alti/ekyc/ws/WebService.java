/*******************************************************************************
 * Copyright Â© Visa 2015. All rights reserved.
 * <p/>
 * This software is the confidential and proprietary information
 * of Visa. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms and conditions
 * entered into with Visa.
 *
 * @Author Reshu Gupta
 ******************************************************************************/
package com.shadows.alti.ekyc.ws;

import java.io.IOException;

/**
 * Class WebService called by processor
 *
 * @author Rgupta2072
 */
public class WebService {

   /* private static final Logger logger = Logger.getLogger(WebService.class
            .getName());
    private static final String HOST_ADDRESS = "https://merchantepos.com/";
    private static final String CONTEXT = "services";
    private static final String JSON = "application/json";
    private static final String UTF8 = "UTF-8";
    private String TAG = WebService.class.getSimpleName();
    private URL hostname;
    private Gson gson;


    private Global global;
    private String cert;

    *//**
     * Gets server URL and checks it should not be null
     *//*
    public WebService() {

        this.global = Global.getInstance();

        try {
            this.hostname = new URL(HOST_ADDRESS);
        } catch (MalformedURLException ex) {
            LoggerUtil.getLogger().logError("Invalid hostname");
        }

        GsonBuilder builder = new GsonBuilder();
        gson = builder.create();
    }

    *//**
     * To call post
     *
     * @param service
     * @param data
     * @throws CommunicationException
     *//*
    public <T> Response post(String service, T data)
            throws CommunicationException {
        return putAndpost(HttpMethods.POST.toString(), service, data);
    }

    *//**
     * To call put
     *
     * @param service
     * @param data
     * @return
     * @throws CommunicationException
     *//*
    public <T> Response put(String service, T data) throws CommunicationException {
        return putAndpost(HttpMethods.PUT.toString(), service, data);
    }

    *//**
     * To call put and post
     *
     * @param method
     * @param service
     * @param data
     * @return
     * @throws CommunicationException
     *//*
    private <T> Response putAndpost(String method, String service, T data)
            throws CommunicationException {
        CommunicationModel model = new CommunicationModel();
        HttpsURLConnection connection = null;
        byte[] hmacSessionKey = null;
        OutputStream outputStream=null;
        try {
            byte[] sessionKey = CryptoUtil.getSessionKey(32);
            String encryptedSessionKey = CryptoUtil.getEncryptedSessionKey(sessionKey);
            hmacSessionKey = CryptoUtil.getSessionKey(32);
            String encryptedHmacSessionKey = CryptoUtil.getEncryptedSessionKey(hmacSessionKey);
            byte b = 0;
            model.setSessionToken(encryptedSessionKey);
            model.setHmacSessionToken(encryptedHmacSessionKey);
            String xml = gson.toJson(data);
            logger.log(Level.INFO, "Plain: " + xml);
            String encrypt = "";
            try {
                encrypt = CryptoUtil.encode(xml, sessionKey);
                // Arrays.fill(sessionKey, b);
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Unable to encrypt the data");
            }
            model.setData(encrypt);
            try {
                String hmac = CryptoUtil.getHmac(hmacSessionKey, encrypt);
                model.setHmac(hmac);
            } catch (Exception e1) {
                logger.log(Level.SEVERE, "Unable to extract hmac");
            }
            URL url = new URL(hostname, CONTEXT + service);
            logger.log(Level.INFO, url.toString());
            try {
                connection=new ExtendedHttpsURLConnectionFactory().createHttpsURLConnection(url);
            } catch(Exception e){
                logger.log(Level.SEVERE,"Exception while getting https url connection");
                throw new CommunicationException("Connection Failed ");
            } catch (Throwable throwable) {
                logger.log(Level.SEVERE,"Throwable while getting https url connection");
                throw new CommunicationException("Connection Failed ");
            }
            connection.setDoOutput(true);
            connection.setRequestMethod(method);
            connection.setRequestProperty(HttpHeaders.CONTENT_TYPE.toString(), JSON);
            connection.setRequestProperty(HttpHeaders.ACCEPT.toString(), JSON);

            if (global.getToken() != null)
                connection.setRequestProperty(HttpHeaders.SESSION_TOKEN.toString(), global.getToken());
            if (global.getCode() != null)
                connection.setRequestProperty(HttpHeaders.CSRF.toString(), global.getCode());
            logger.log(Level.INFO, "To: " + gson.toJson(model));

            outputStream = connection.getOutputStream();
            outputStream.write(gson.toJson(model).getBytes(UTF8));
            outputStream.flush();

            return getResponse(connection, sessionKey);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error in connection");
            throw new CommunicationException("Connection Failed ");
        } finally {
            if (connection != null) {
                try {
                    connection.disconnect();
                } catch (Exception e) {
                    logger.log(Level.SEVERE, "Unable to close connection");
                }
            }
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (Exception e) {
                    logger.log(Level.SEVERE, "Unable to close outputStream");
                }
            }
            byte b = 0;
            Arrays.fill(hmacSessionKey, b);
            hmacSessionKey = null;
        }
    }


    *//**
     * HttpUrlConnection will throw an IOException if any 4XX com.visa.nxg.epos.spire.response is sent.
     * If we com.visa.nxg.epos.spire.request the com.visa.nxg.epos.spire.status again, this time the internal com.visa.nxg.epos.spire.status will be
     * properly set, and we'll be able to retrieve it.
     *
     * @param connection
     * @return
     * @throws IOException
     *//*
    private Response getResponse(HttpURLConnection connection, byte[] sessionKey) throws IOException {
        int status = 0;
        String content = "";

        try {
            status = connection.getResponseCode();
        } catch (IOException e) {
            status = connection.getResponseCode();
        } catch (Exception e) {
            Log.d(TAG, "Url connection failed");
        }

        Log.d(TAG, "Status: " + status);

        if (status == 401) {
            Response response=new Response(401);
            response.setSessionKey(sessionKey);
            return new Response(401);
        }
        InputStream stream = connection.getErrorStream();
        if (stream == null) {
            stream = connection.getInputStream();
        }

        try (Scanner scanner = new Scanner(stream, UTF8)) {
            scanner.useDelimiter("\\Z");
            while (scanner.hasNext()) {
                content =content+scanner.next();
            }
        }catch (Exception e){
            Log.e(TAG,"Error while scanning");
        }finally {
            if(stream!=null){
                stream.close();
            }
        }

        Log.d(TAG, "Content: " + content);

        String code = connection.getHeaderField(HttpHeaders.CSRF.toString());
        if (code != null)
            global.setCode(code);
        content=content.trim();
        Response response=new Response(status, content);
        response.setSessionKey(sessionKey);
        return response;
    }


    *//**
     *
     * @param service
     *            URL, opens connection, hits service and gets response. Finally
     *            closes the connection
     * @return Response
     * @throws CommunicationException
     *//*
    public Response get(String service) throws CommunicationException {
        HttpsURLConnection connection = null;
        try {
            URL url = new URL(hostname, CONTEXT + service);
            logger.log(Level.INFO, url.toString());
            try {
                connection=new ExtendedHttpsURLConnectionFactory().createHttpsURLConnection(url);
            } catch(Exception e){
                logger.log(Level.SEVERE,"Exception while getting https url connection");
                throw new CommunicationException("Connection Failed ");
            } catch (Throwable throwable) {
                logger.log(Level.SEVERE,"Throwable while getting https url connection");
                throw new CommunicationException("Connection Failed ");
            }

            connection.setRequestMethod(HttpMethods.GET.toString());
            connection.setRequestProperty(HttpHeaders.ACCEPT.toString(), JSON);

            if (global.getToken() != null)
                connection.setRequestProperty(HttpHeaders.SESSION_TOKEN.toString(), global.getToken());

            if (global.getCode() != null)
                connection.setRequestProperty(HttpHeaders.CSRF.toString(), global.getCode());

            connection.connect();
            return getResponse(connection, null);
        } catch (MalformedURLException e) {
            throw new CommunicationException("Error in connection");
        } catch (IOException e) {
            throw new CommunicationException("Error in connection");
        } finally {
            if (connection != null)
                try {
                    connection.disconnect();
                } catch (Exception e) {
                    logger.log(Level.SEVERE, "Unable to close connection");
                }
        }
    }*/
}
