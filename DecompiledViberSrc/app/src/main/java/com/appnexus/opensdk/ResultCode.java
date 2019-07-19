package com.appnexus.opensdk;

public enum ResultCode
{
  static
  {
    INVALID_REQUEST = new ResultCode("INVALID_REQUEST", 1);
    UNABLE_TO_FILL = new ResultCode("UNABLE_TO_FILL", 2);
    MEDIATED_SDK_UNAVAILABLE = new ResultCode("MEDIATED_SDK_UNAVAILABLE", 3);
    NETWORK_ERROR = new ResultCode("NETWORK_ERROR", 4);
    INTERNAL_ERROR = new ResultCode("INTERNAL_ERROR", 5);
    ResultCode[] arrayOfResultCode = new ResultCode[6];
    arrayOfResultCode[0] = SUCCESS;
    arrayOfResultCode[1] = INVALID_REQUEST;
    arrayOfResultCode[2] = UNABLE_TO_FILL;
    arrayOfResultCode[3] = MEDIATED_SDK_UNAVAILABLE;
    arrayOfResultCode[4] = NETWORK_ERROR;
    arrayOfResultCode[5] = INTERNAL_ERROR;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.ResultCode
 * JD-Core Version:    0.6.2
 */