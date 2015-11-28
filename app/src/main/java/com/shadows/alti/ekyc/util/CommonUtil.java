/*******************************************************************************
 * Copyright © Visa 2015. All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Visa. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms and conditions
 * entered into with Visa.
 *
 * @Author VinayakaS
 ******************************************************************************/
package com.shadows.alti.ekyc.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.InputFilter;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

//import com.visa.nxg.epos.async.LogoutProcessor;


/**
 * Container class for all the common methods to be used across different
 * modules
 *
 * @author Vsridhara
 */
public class CommonUtil {

    /*private static final Logger logger = Logger.getLogger(CommonUtil.class
            .getName());

    private static Gson gson;
    *//**
     * Converts String to date in the specified format
     *
     * @param dateInString
     * @param currentFormat
     * @param destFormat
     * @return
     *//*
    public static Date convertStringToDate(String dateInString,
                                           String currentFormat, String destFormat) {
        SimpleDateFormat tempFormat = new SimpleDateFormat(currentFormat);
        SimpleDateFormat actFormat = new SimpleDateFormat(destFormat);
        try {

            Date date = tempFormat.parse(dateInString);
            String format2 = actFormat.format(date);
            DateFormat fomDateFormat = new SimpleDateFormat(destFormat);
            return fomDateFormat.parse(format2);
        } catch (ParseException e) {
            return null;
        }
    }

    *//**
     * Changes Date in String from one format to other
     *
     * @param dateInString
     * @param sourceFormat
     * @param destFormat
     * @return
     *//*
    public static String changeDateFormat(String dateInString,
                                          String sourceFormat, String destFormat) {
        try {
            SimpleDateFormat source = new SimpleDateFormat(sourceFormat);
            Date sourceDate;
            sourceDate = source.parse(dateInString);
            DateFormat dest = new SimpleDateFormat(destFormat);
            return dest.format(sourceDate);
        } catch (ParseException e) {
            return null;
        }
    }

    *//**
     * Checks if a String object is Empty
     *
     * @param string
     * @return
     *//*
    public static boolean isEmpty(String string) {
        if (string == null || string.trim().equals("")) {
            return true;
        }
        return false;
    }

    *//**
     * Returns Current system date in String format
     *
     * @return
     *//*
    public static String getCurrentDateInString() {
        Date currDate = new Date();
        DateFormat dest = new SimpleDateFormat("yyyy-MM-dd");
        return dest.format(currDate);
    }

    *//**
     * Returns current Time in String
     *
     * @return
     *//*
    public static String getCurrentTimeInString() {
        Date currDate = new Date();
        DateFormat dest = new SimpleDateFormat("HH:mm:ss");
        return dest.format(currDate);
    }

    *//**
     * Returns difference between two dates /Null
     *
     * @param fromDate
     * @param toDate
     * @return
     *//*
    public static int getDifferenceBNDays(Date fromDate, Date toDate) {
        long diff = toDate.getTime() - fromDate.getTime();
        return (int) (diff / 86400000);
    }


    public static String getStringOfLength(Integer number, int i) {
        if (number == null) {
            return null;
        }
        String integer = number + "";
        if (integer.length() == i) {
            return integer;
        }
        StringBuffer temp = new StringBuffer();
        for (int j = 0; j < i - integer.length(); j++) {
            temp.append("0");
        }
        temp.append(integer);
        return temp.toString();
    }

    public static String getStringFromDouble(Double doubleInput) {

        if (doubleInput == null) {
            return null;
        }
        String format = String.format("%.2f", doubleInput);
        String[] split = format.split("\\.");
        StringBuffer finalStringBuffer = new StringBuffer();
        int length = split[0].length();
        for (int i = 0; i < 10 - length; i++) {
            finalStringBuffer.append("0");
        }
        finalStringBuffer.append(split[0]);
        finalStringBuffer.append(split[1]);
        return finalStringBuffer.toString();
    }

    public static String getOptOutData(Double saleAmount, int saleCount,
                                       Double refundAmount, int refundCount) {
        // To be done
        return null;
    }

    public static String getBatchTotals(Double saleAmount, int saleCount,
                                        Double refundAmount, int refundCount) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(CommonUtil.getStringOfLength(saleCount, 3));
        buffer.append(CommonUtil.getStringFromDouble(saleAmount));
        buffer.append(CommonUtil.getStringOfLength(refundCount, 3));
        buffer.append(CommonUtil.getStringFromDouble(refundAmount));
        for (int i = 0; i < 60; i++) {
            buffer.append("0");
        }
        return buffer.toString();
    }

    public static String timeInPPFormat(String transactionTime) {
        String[] split = transactionTime.split(":");
        StringBuffer buffer = new StringBuffer();
        for (String string : split) {
            buffer.append(string);
        }
        return buffer.toString();
    }

    public static String dateInPPFormat(String transactionDate) {
        String[] split = transactionDate.split("-");
        return split[1] + split[2];
    }

    public static String getCardNumber(String trackData) {
        if (trackData.contains(";")) {
            return trackData.substring(13, 17);
        } else {
            return trackData.substring(12, 16);
        }
    }


    public static byte[] charArrayToByteArray(char[] charArray) {
        byte[] result = new byte[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            result[i] = (byte) charArray[i];
        }
        return result;
    }

    public static char[] byteArrayToCharArray(byte[] byteArray) {
        char[] result = new char[byteArray.length];
        for (int i = 0; i < byteArray.length; i++) {
            result[i] = (char) byteArray[i];
        }
        return result;
    }

    public static byte[] charArrayToByteArrayOfLength(char[] byteArray, int length) {
        byte[] result = new byte[length];
        for (int i = 0; i < length; i++) {
            result[i] = (byte) byteArray[i];
        }
        return result;
    }

    public static char[] getSubCharArray(char[] charArray, int length) {
        char[] result = new char[length];
        for (int i = 0; i < length; i++) {
            result[i] = (char) charArray[i];
        }
        return result;
    }

    public static byte[] getByteArrayOfLength(byte[] byteArray, int length) {
        byte[] result = new byte[length];
        for (int i = 0; i < length; i++) {
            result[i] = byteArray[i];
        }
        return result;
    }

    public static Gson getGson(){
        if(gson==null){
            GsonBuilder builder = new GsonBuilder();
            gson = builder.create();
        }
        return gson;
    }

    *//* This method checks to see if the device is online. Returns true if online, else false*//*
    public static boolean isOnline(Context context) {

        // Connectivity manager gives you access to the current state of the connection
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        } else {
            return false;
        }
    }

    *//*Adding common functionality for home click button.*//*
    public static void returnToHome(Context context){


        Intent intent = new Intent(context, Landing.class);
        context.startActivity(intent);
        return;
    }

    public static void changeLanguage(Context ctx,String languageCode)
    {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        ctx.getResources().updateConfiguration(config,
                ctx.getResources().getDisplayMetrics());
    }

    *//**
     * Convert the BitMap to String
     * @param bitmap
     * @return
     *//*
    public static byte[] convertBitMapToByte(Bitmap bitmap){

        ByteArrayOutputStream blob = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, blob);
        byte[] byteArray = blob.toByteArray();

        return byteArray;
    }

    *//**
     * @param byteArray
     * @return bitmap (from given string)
     *//*
    public static Bitmap convertByteToBitMap(byte[] byteArray){

        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
        //InputStream inputStream  = new ByteArrayInputStream(byteArray);
        //Bitmap bitmap  = BitmapFactory.decodeStream(inputStream);

        //byteArray = null;

        return bitmap;

    }
*/

    public static boolean isOnline(Context context) {

        // Connectivity manager gives you access to the current state of the connection
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        } else {
            return false;
        }
    }

    /*To stop copy/paste in editText box */

    public static void validateEditBox(EditText eb_id){

        if (android.os.Build.VERSION.SDK_INT < 11) {
            eb_id.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {

                @Override
                public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo) {
                    menu.clear();
                }
            });
        } else {
            eb_id.setCustomSelectionActionModeCallback(new ActionMode.Callback() {

                public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                    return false;
                }

                public void onDestroyActionMode(ActionMode mode) {

                }

                public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                    return false;
                }

                public boolean onActionItemClicked(ActionMode mode,
                                                   MenuItem item) {
                    return false;
                }
            });
        }
    };

   /* public static Bitmap loadBitmapFromView(View view) {
        Bitmap bmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmap);
        view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        view.draw(canvas);
        return bmap;
    }

    public static void addImage(Document document,byte[] byteArray)
    {
        Image image = null;
        try
        {
            image = Image.getInstance(byteArray);
        }
        catch (BadElementException e)
        {
            Log.e("Image","Bad Element exception occured");
        }
        catch (MalformedURLException e)
        {
            Log.e("Image","Bad URL exception occured");
        }
        catch (IOException e)
        {
            Log.e("Image","IOException occured");
        }
        image.scaleAbsolute(540f, 700f);
        try
        {
            document.add(image);
        } catch (DocumentException e) {
            Log.e("Image","Failed to add image to document");
            return;
        }
    }

    *//**
     * Validation Check provide Activity Context
     * @param activity
     * @param currentPsswd
     * @param newPsswd
     * @param confirmPsswd
     * @param currentPin
     * @param newPin
     * @param confirmPin
     * @return
     *//*
    public static boolean validationCheck(Activity activity,Context ctx,EditText currentPsswd,EditText newPsswd,EditText confirmPsswd,EditText currentPin,EditText newPin,EditText confirmPin)
    {
        boolean isEmpty = true;
        char[] currentPwdChars = null;
        char[] passwordNewChars = null;
        char[] confirmPasswordChars = null;
        char[] currentPinChars = null;
        char[] pinNewChars = null;
        char[] confPinChars = null;

        if(newPsswd!=null) {
            passwordNewChars = new char[newPsswd.length()];
            newPsswd.getText().getChars(0, newPsswd.length(), passwordNewChars, 0);
        }
        if(confirmPsswd!=null) {
            confirmPasswordChars = new char[confirmPsswd.length()];
            confirmPsswd.getText().getChars(0, confirmPsswd.length(), confirmPasswordChars, 0);
        }
        if(currentPsswd!=null) {
            currentPwdChars = new char[currentPsswd.length()];
            currentPsswd.getText().getChars(0, currentPsswd.length(), currentPwdChars, 0);
        }

        if(currentPin!=null) {
            currentPin.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
            currentPinChars = new char[currentPin.length()];
            currentPin.getText().getChars(0, currentPin.length(), currentPinChars, 0);
        }
        if(newPin!=null) {
            newPin.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
            pinNewChars = new char[newPin.length()];
            newPin.getText().getChars(0, newPin.length(), pinNewChars, 0);
        }
        if(confirmPin!=null) {
            confirmPin.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
            confPinChars = new char[confirmPin.length()];
            confirmPin.getText().getChars(0, confirmPin.length(), confPinChars, 0);
        }

        if(currentPsswd!=null) {
            if (currentPwdChars.length == 0 && passwordNewChars.length == 0 && confirmPasswordChars.length == 0 &&
                    currentPinChars.length == 0 && pinNewChars.length == 0 && confPinChars.length == 0) {
                currentPsswd.setError(ctx.getResources().getString(R.string.pin_or_password));
                Drawable d = currentPsswd.getBackground();
                d.setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                isEmpty = false;
                return isEmpty;
            }
        }

        if(newPsswd!=null && confirmPsswd!=null && currentPsswd!=null) {
            if (currentPwdChars.length != 0 || passwordNewChars.length != 0 || confirmPasswordChars.length != 0) {
                if (currentPwdChars.length == 0 || passwordNewChars.length == 0 || confirmPasswordChars.length == 0) {
                    currentPsswd.setError(ctx.getResources().getString(R.string.not_empty_password));
                    Drawable d = currentPsswd.getBackground();
                    d.setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                    newPsswd.setText("");
                    confirmPsswd.setText("");
                    currentPsswd.setText("");
                    isEmpty = false;
                    return isEmpty;
                }
            }
        }

        if ((null!=currentPinChars &&currentPinChars.length != 0) || (null!=pinNewChars && pinNewChars.length != 0) || (null!=confPinChars && confPinChars.length != 0)) {
            if (!nullCheck(currentPinChars) && !nullCheck(pinNewChars) && !nullCheck(confPinChars)) {
                currentPin.setError(ctx.getResources().getString(R.string.not_empty_pin));
                Drawable d = currentPin.getBackground();
                d.setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                currentPin.setText("");
                newPin.setText("");
                confirmPin.setText("");
                isEmpty = false;
                return isEmpty;
            }
        }


        if(newPsswd!=null && currentPsswd!=null) {
            if (Arrays.equals(currentPwdChars, passwordNewChars) && passwordNewChars.length != 0) {
                newPsswd.setError(ctx.getResources().getString(R.string.not_current_password));
                Drawable d = newPsswd.getBackground();
                d.setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                newPsswd.setText("");
                currentPsswd.setText("");
                isEmpty = false;
                return isEmpty;
            }
        }

        if(newPsswd!=null && confirmPsswd!=null) {
            if (!Arrays.equals(passwordNewChars, confirmPasswordChars) && passwordNewChars.length != 0) {
                newPsswd.setError(ctx.getResources().getString(R.string.same_new_confirm_password));
                Drawable d = newPsswd.getBackground();
                d.setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                newPsswd.setText("");
                confirmPsswd.setText("");
                isEmpty = false;
                return isEmpty;
            }
        }

        if(newPsswd!=null && confirmPsswd!=null) {
            if (passwordNewChars.length != 0 || confirmPasswordChars.length != 0) {
                if (!checkPasswordComplexity(passwordNewChars)) {
                    newPsswd.setError(ctx.getResources().getString(R.string.error_password_complexity));
                    Drawable d = newPsswd.getBackground();
                    d.setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                    newPsswd.setText("");
                    confirmPsswd.setText("");
                    isEmpty = false;
                    return isEmpty;
                }
            }
        }

        if(currentPin!=null && newPin!=null) {
            if (Arrays.equals(currentPinChars, pinNewChars) && pinNewChars.length != 0) {
                newPin.setError(ctx.getResources().getString(R.string.not_current_pin));
                Drawable d = newPin.getBackground();
                d.setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                currentPin.setText("");
                newPin.setText("");
                isEmpty = false;
                return isEmpty;
            }
        }
        if(confirmPin!=null && newPin!=null) {
            if (!Arrays.equals(confPinChars, pinNewChars) && pinNewChars.length != 0) {
                newPin.setError(ctx.getResources().getString(R.string.new_pin_confirm_pin));
                Drawable d = newPin.getBackground();
                d.setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                newPin.setText("");
                confirmPin.setText("");
                isEmpty = false;
                return  isEmpty;
            }
        }
        if(currentPin!=null && newPin!=null && confirmPin!=null) {
            if (currentPinChars.length != 0 || pinNewChars.length != 0 || confPinChars.length != 0) {
                if (currentPinChars.length <= 3 || pinNewChars.length <= 3 || confPinChars.length <= 3) {
                    currentPin.setError(ctx.getResources().getString(R.string.four_digit_pan));
                    Drawable d = currentPin.getBackground();
                    d.setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                    currentPin.setText("");
                    newPin.setText("");
                    confirmPin.setText("");
                    isEmpty = false;
                    return isEmpty;
                }
            }
        }

        if(newPin!=null && confirmPin!=null) {
            if (pinNewChars.length != 0 || confPinChars.length != 0) {
                if (pinNewChars.length <= 3 || confPinChars.length <= 3) {
                    newPin.setError(ctx.getResources().getString(R.string.four_digit_pan));
                    Drawable d = newPin.getBackground();
                    d.setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                    newPin.setText("");
                    confirmPin.setText("");
                    isEmpty = false;
                    return isEmpty;
                }
            }
        }
        return isEmpty;
    }

    private static boolean nullCheck(char[] value)
    {
        if(value!=null && value.length!=0)
            return true;
        else
            return false;

    }
    private static boolean checkPasswordComplexity(char[] password) {
        Character[] validOperators = { '@', '#', '$', '%','!','&','^','*','(',')'};
        List<Character> validOp = Arrays.asList(validOperators);
        if (password.length < 8 || password.length > 20) {
            return false;
        }
        boolean upper = false;
        boolean lower = false;
        boolean digit = false;
        boolean symbol = false;
        for (char ch : password) {
            if (Character.isUpperCase(ch)) {
                upper = true;
            } else if (Character.isLowerCase(ch)) {
                lower = true;
            } else if (Character.isDigit(ch)) {
                digit = true;
            } else if (validOp.contains(ch)) {
                symbol = true;
            }
            if (upper && lower && digit && symbol) {
                return true;
            }
        }
        return upper && lower && digit && symbol;
    }*/

}
