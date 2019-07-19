// IRemoteInterface.aidl
package com.example.cga2351.testapp;

// Declare any non-default types here with import statements
import com.example.cga2351.testapp.RemoteBean1;

interface IRemoteInterface {
    String func1(in String param1, in RemoteBean1 param2);
}
