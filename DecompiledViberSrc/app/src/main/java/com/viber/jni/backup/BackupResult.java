package com.viber.jni.backup;

public class BackupResult
{
  public final int errorCode;
  public final long handle;

  public BackupResult(long paramLong, int paramInt)
  {
    this.handle = paramLong;
    this.errorCode = paramInt;
  }

  public static enum ErrorCode
  {
    private int value;

    static
    {
      EmptyPhoneNumber = new ErrorCode("EmptyPhoneNumber", 1, 1);
      CantOpenFile = new ErrorCode("CantOpenFile", 2, 2);
      HeaderIsInvalid = new ErrorCode("HeaderIsInvalid", 3, 3);
      CantFindFileToAppend = new ErrorCode("CantFindFileToAppend", 4, 4);
      PhoneNumberMismatch = new ErrorCode("PhoneNumberMismatch", 5, 5);
      IncompatibleVersionToAppend = new ErrorCode("IncompatibleVersionToAppend", 6, 6);
      ErrorCode[] arrayOfErrorCode = new ErrorCode[7];
      arrayOfErrorCode[0] = NoError;
      arrayOfErrorCode[1] = EmptyPhoneNumber;
      arrayOfErrorCode[2] = CantOpenFile;
      arrayOfErrorCode[3] = HeaderIsInvalid;
      arrayOfErrorCode[4] = CantFindFileToAppend;
      arrayOfErrorCode[5] = PhoneNumberMismatch;
      arrayOfErrorCode[6] = IncompatibleVersionToAppend;
    }

    private ErrorCode(int paramInt)
    {
      this.value = paramInt;
    }

    public static ErrorCode fromInt(int paramInt)
    {
      for (ErrorCode localErrorCode : values())
        if (localErrorCode.value == paramInt)
          return localErrorCode;
      throw new RuntimeException("Unexpected error code: " + paramInt);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.backup.BackupResult
 * JD-Core Version:    0.6.2
 */