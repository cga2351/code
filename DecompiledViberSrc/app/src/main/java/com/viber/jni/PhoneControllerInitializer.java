package com.viber.jni;

import android.os.Bundle;
import java.util.Arrays;

public class PhoneControllerInitializer
{
  private short _GenNum;
  private int _PhoneType;
  private String _PushToken;
  private byte[] _UDID;
  private String _advertizingId;
  private int _appMode;
  Bundle _clientEnvConfig;
  final PhoneControllerDelegate _delegate;
  private byte[] _deviceKey;
  private int _deviceRole;
  private byte[] _excludedFeatures;
  String[] _featureList;
  private int _lbPort;
  private short _myCountryCode;
  private String _myCountryShortName;
  private String _myPhoneNumber;
  private boolean _needMidMapping;
  private int _notificationFlags;
  private int _pixieMode;
  private int _pixiePort;
  private String _pttPath;
  private String _rtpDumpsPath;
  private int _serverEnv;
  private int _systemId;

  public PhoneControllerInitializer(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString1, int paramInt1, short paramShort1, String paramString2, short paramShort2, String paramString3, String paramString4, PhoneControllerDelegate paramPhoneControllerDelegate, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString5, int paramInt7, String paramString6, boolean paramBoolean, byte[] paramArrayOfByte3, int paramInt8, ClientEnvConfig paramClientEnvConfig, FeatureList paramFeatureList)
  {
    this._UDID = paramArrayOfByte1;
    this._deviceKey = paramArrayOfByte2;
    this._PushToken = paramString1;
    this._PhoneType = paramInt1;
    this._GenNum = paramShort1;
    this._myCountryCode = paramShort2;
    this._myPhoneNumber = paramString3;
    this._delegate = paramPhoneControllerDelegate;
    this._deviceRole = paramInt2;
    this._appMode = paramInt3;
    this._pixieMode = paramInt4;
    this._pixiePort = paramInt5;
    this._pttPath = paramString4;
    this._serverEnv = paramInt6;
    this._myCountryShortName = paramString2;
    this._advertizingId = paramString5;
    this._systemId = paramInt7;
    this._rtpDumpsPath = paramString6;
    this._needMidMapping = paramBoolean;
    this._excludedFeatures = paramArrayOfByte3;
    this._notificationFlags = paramInt8;
    this._clientEnvConfig = JniUtils.toBundle(paramClientEnvConfig);
    if (paramFeatureList != null);
    for (String[] arrayOfString = paramFeatureList.toArray(); ; arrayOfString = null)
    {
      this._featureList = arrayOfString;
      return;
    }
  }

  public String toString()
  {
    return "PhoneControllerInitializer{_PushToken='" + this._PushToken + '\'' + ", _deviceKey=" + Arrays.toString(this._deviceKey) + ", _PhoneType=" + this._PhoneType + ", _GenNum=" + this._GenNum + ", _myCountryCode=" + this._myCountryCode + ", _myPhoneNumber='" + this._myPhoneNumber + '\'' + ", _delegate=" + this._delegate + ", _appMode=" + this._appMode + ", _lbPort=" + this._lbPort + ", _pixieMode=" + this._pixieMode + ", _pixiePort=" + this._pixiePort + ", _pttPath='" + this._pttPath + '\'' + ", _serverEnv=" + this._serverEnv + ", _myCountryShortName='" + this._myCountryShortName + '\'' + ", _deviceRole=" + this._deviceRole + ", _advertizingId='" + this._advertizingId + '\'' + ", _systemId=" + this._systemId + '\'' + ", _rtpDumpsPath=" + this._rtpDumpsPath + '\'' + ", _excludedFeatures=" + Arrays.toString(this._excludedFeatures) + '\'' + ", _featureList=" + Arrays.toString(this._featureList) + '\'' + ", _UDID=" + Arrays.toString(this._UDID) + '\'' + ", _clientEnvConfig=" + JniUtils.bundleToString(this._clientEnvConfig) + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.PhoneControllerInitializer
 * JD-Core Version:    0.6.2
 */