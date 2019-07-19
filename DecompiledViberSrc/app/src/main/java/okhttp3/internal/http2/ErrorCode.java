package okhttp3.internal.http2;

public enum ErrorCode
{
  public final int httpCode;

  static
  {
    INTERNAL_ERROR = new ErrorCode("INTERNAL_ERROR", 2, 2);
    FLOW_CONTROL_ERROR = new ErrorCode("FLOW_CONTROL_ERROR", 3, 3);
    REFUSED_STREAM = new ErrorCode("REFUSED_STREAM", 4, 7);
    CANCEL = new ErrorCode("CANCEL", 5, 8);
    COMPRESSION_ERROR = new ErrorCode("COMPRESSION_ERROR", 6, 9);
    CONNECT_ERROR = new ErrorCode("CONNECT_ERROR", 7, 10);
    ENHANCE_YOUR_CALM = new ErrorCode("ENHANCE_YOUR_CALM", 8, 11);
    INADEQUATE_SECURITY = new ErrorCode("INADEQUATE_SECURITY", 9, 12);
    HTTP_1_1_REQUIRED = new ErrorCode("HTTP_1_1_REQUIRED", 10, 13);
    ErrorCode[] arrayOfErrorCode = new ErrorCode[11];
    arrayOfErrorCode[0] = NO_ERROR;
    arrayOfErrorCode[1] = PROTOCOL_ERROR;
    arrayOfErrorCode[2] = INTERNAL_ERROR;
    arrayOfErrorCode[3] = FLOW_CONTROL_ERROR;
    arrayOfErrorCode[4] = REFUSED_STREAM;
    arrayOfErrorCode[5] = CANCEL;
    arrayOfErrorCode[6] = COMPRESSION_ERROR;
    arrayOfErrorCode[7] = CONNECT_ERROR;
    arrayOfErrorCode[8] = ENHANCE_YOUR_CALM;
    arrayOfErrorCode[9] = INADEQUATE_SECURITY;
    arrayOfErrorCode[10] = HTTP_1_1_REQUIRED;
  }

  private ErrorCode(int paramInt)
  {
    this.httpCode = paramInt;
  }

  public static ErrorCode fromHttp2(int paramInt)
  {
    for (ErrorCode localErrorCode : values())
      if (localErrorCode.httpCode == paramInt)
        return localErrorCode;
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.http2.ErrorCode
 * JD-Core Version:    0.6.2
 */