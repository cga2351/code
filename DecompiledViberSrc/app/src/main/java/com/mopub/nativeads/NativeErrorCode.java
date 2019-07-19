package com.mopub.nativeads;

import com.mopub.mobileads.MoPubError;

public enum NativeErrorCode
  implements MoPubError
{
  private final String a;

  static
  {
    IMAGE_DOWNLOAD_FAILURE = new NativeErrorCode("IMAGE_DOWNLOAD_FAILURE", 3, "Unable to download images associated with ad.");
    INVALID_REQUEST_URL = new NativeErrorCode("INVALID_REQUEST_URL", 4, "Invalid request url.");
    UNEXPECTED_RESPONSE_CODE = new NativeErrorCode("UNEXPECTED_RESPONSE_CODE", 5, "Received unexpected response code from server.");
    SERVER_ERROR_RESPONSE_CODE = new NativeErrorCode("SERVER_ERROR_RESPONSE_CODE", 6, "Server returned erroneous response code.");
    CONNECTION_ERROR = new NativeErrorCode("CONNECTION_ERROR", 7, "Network is unavailable.");
    UNSPECIFIED = new NativeErrorCode("UNSPECIFIED", 8, "Unspecified error occurred.");
    NETWORK_INVALID_REQUEST = new NativeErrorCode("NETWORK_INVALID_REQUEST", 9, "Third-party network received invalid request.");
    NETWORK_TIMEOUT = new NativeErrorCode("NETWORK_TIMEOUT", 10, "Third-party network failed to respond in a timely manner.");
    NETWORK_NO_FILL = new NativeErrorCode("NETWORK_NO_FILL", 11, "Third-party network failed to provide an ad.");
    NETWORK_INVALID_STATE = new NativeErrorCode("NETWORK_INVALID_STATE", 12, "Third-party network failed due to invalid internal state.");
    NATIVE_RENDERER_CONFIGURATION_ERROR = new NativeErrorCode("NATIVE_RENDERER_CONFIGURATION_ERROR", 13, "A required renderer was not registered for the CustomEventNative.");
    NATIVE_ADAPTER_CONFIGURATION_ERROR = new NativeErrorCode("NATIVE_ADAPTER_CONFIGURATION_ERROR", 14, "CustomEventNative was configured incorrectly.");
    NATIVE_ADAPTER_NOT_FOUND = new NativeErrorCode("NATIVE_ADAPTER_NOT_FOUND", 15, "Unable to find CustomEventNative.");
    NativeErrorCode[] arrayOfNativeErrorCode = new NativeErrorCode[16];
    arrayOfNativeErrorCode[0] = AD_SUCCESS;
    arrayOfNativeErrorCode[1] = EMPTY_AD_RESPONSE;
    arrayOfNativeErrorCode[2] = INVALID_RESPONSE;
    arrayOfNativeErrorCode[3] = IMAGE_DOWNLOAD_FAILURE;
    arrayOfNativeErrorCode[4] = INVALID_REQUEST_URL;
    arrayOfNativeErrorCode[5] = UNEXPECTED_RESPONSE_CODE;
    arrayOfNativeErrorCode[6] = SERVER_ERROR_RESPONSE_CODE;
    arrayOfNativeErrorCode[7] = CONNECTION_ERROR;
    arrayOfNativeErrorCode[8] = UNSPECIFIED;
    arrayOfNativeErrorCode[9] = NETWORK_INVALID_REQUEST;
    arrayOfNativeErrorCode[10] = NETWORK_TIMEOUT;
    arrayOfNativeErrorCode[11] = NETWORK_NO_FILL;
    arrayOfNativeErrorCode[12] = NETWORK_INVALID_STATE;
    arrayOfNativeErrorCode[13] = NATIVE_RENDERER_CONFIGURATION_ERROR;
    arrayOfNativeErrorCode[14] = NATIVE_ADAPTER_CONFIGURATION_ERROR;
    arrayOfNativeErrorCode[15] = NATIVE_ADAPTER_NOT_FOUND;
  }

  private NativeErrorCode(String paramString)
  {
    this.a = paramString;
  }

  public int getIntCode()
  {
    switch (1.a[ordinal()])
    {
    default:
      return 10000;
    case 1:
      return 2;
    case 2:
      return 1;
    case 3:
    }
    return 0;
  }

  public final String toString()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.NativeErrorCode
 * JD-Core Version:    0.6.2
 */