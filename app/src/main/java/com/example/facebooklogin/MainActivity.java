package com.example.facebooklogin;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        printKeyHash();
    }

    private void printKeyHash() {

           try{
               PackageInfo info = getPackageManager().getPackageInfo("com.example.facebooklogin", PackageManager.GET_SIGNATURES);
               for (Signature signature:info.signatures)
               {
                   MessageDigest md = MessageDigest.getInstance("SHA");
                   md.update( signature.toByteArray() );
                   Log.d( "KeyHash", Base64.encodeToString( md.digest(),Base64.DEFAULT ) );

               }

           } catch (PackageManager.NameNotFoundException e) {
               e.printStackTrace();
           } catch (NoSuchAlgorithmException e) {
               e.printStackTrace();
           }
    }

   /* private void printKeyhash() {

        try{
            PackageInfo info = getPackageManager().getPackageInfo("com.example.facebooklogin", PackageManager.GET_SIGNATURES);

            for (Signature signature:info.signatures)
            {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update( signature.toByteArray() );
                Log.d( "KeyHash", Base64.encodeToString( md.digest(),Base64.DEFAULT ) );

            }


        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }*/
    }



