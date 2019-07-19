package com.appnexus.opensdk.utils;

public enum HttpErrorCode
{
  static
  {
    NO_HTTP_RESPONSE = new HttpErrorCode("NO_HTTP_RESPONSE", 2);
    HTTP_PROTOCOL_ERROR = new HttpErrorCode("HTTP_PROTOCOL_ERROR", 3);
    TRANSPORT_ERROR = new HttpErrorCode("TRANSPORT_ERROR", 4);
    UNKNOWN_ERROR = new HttpErrorCode("UNKNOWN_ERROR", 5);
    HttpErrorCode[] arrayOfHttpErrorCode = new HttpErrorCode[6];
    arrayOfHttpErrorCode[0] = CONNECTION_FAILURE;
    arrayOfHttpErrorCode[1] = URI_SYNTAX_ERROR;
    arrayOfHttpErrorCode[2] = NO_HTTP_RESPONSE;
    arrayOfHttpErrorCode[3] = HTTP_PROTOCOL_ERROR;
    arrayOfHttpErrorCode[4] = TRANSPORT_ERROR;
    arrayOfHttpErrorCode[5] = UNKNOWN_ERROR;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.utils.HttpErrorCode
 * JD-Core Version:    0.6.2
 */