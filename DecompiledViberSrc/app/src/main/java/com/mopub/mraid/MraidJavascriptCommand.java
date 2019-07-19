package com.mopub.mraid;

public enum MraidJavascriptCommand
{
  private final String a;

  static
  {
    // Byte code:
    //   0: new 2	com/mopub/mraid/MraidJavascriptCommand
    //   3: dup
    //   4: ldc 23
    //   6: iconst_0
    //   7: ldc 25
    //   9: invokespecial 29	com/mopub/mraid/MraidJavascriptCommand:<init>	(Ljava/lang/String;ILjava/lang/String;)V
    //   12: putstatic 31	com/mopub/mraid/MraidJavascriptCommand:CLOSE	Lcom/mopub/mraid/MraidJavascriptCommand;
    //   15: new 33	com/mopub/mraid/MraidJavascriptCommand$1
    //   18: dup
    //   19: ldc 34
    //   21: iconst_1
    //   22: ldc 36
    //   24: invokespecial 37	com/mopub/mraid/MraidJavascriptCommand$1:<init>	(Ljava/lang/String;ILjava/lang/String;)V
    //   27: putstatic 39	com/mopub/mraid/MraidJavascriptCommand:EXPAND	Lcom/mopub/mraid/MraidJavascriptCommand;
    //   30: new 2	com/mopub/mraid/MraidJavascriptCommand
    //   33: dup
    //   34: ldc 40
    //   36: iconst_2
    //   37: ldc 42
    //   39: invokespecial 29	com/mopub/mraid/MraidJavascriptCommand:<init>	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: putstatic 44	com/mopub/mraid/MraidJavascriptCommand:USE_CUSTOM_CLOSE	Lcom/mopub/mraid/MraidJavascriptCommand;
    //   45: new 46	com/mopub/mraid/MraidJavascriptCommand$2
    //   48: dup
    //   49: ldc 47
    //   51: iconst_3
    //   52: ldc 49
    //   54: invokespecial 50	com/mopub/mraid/MraidJavascriptCommand$2:<init>	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: putstatic 52	com/mopub/mraid/MraidJavascriptCommand:OPEN	Lcom/mopub/mraid/MraidJavascriptCommand;
    //   60: new 54	com/mopub/mraid/MraidJavascriptCommand$3
    //   63: dup
    //   64: ldc 55
    //   66: iconst_4
    //   67: ldc 57
    //   69: invokespecial 58	com/mopub/mraid/MraidJavascriptCommand$3:<init>	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: putstatic 60	com/mopub/mraid/MraidJavascriptCommand:RESIZE	Lcom/mopub/mraid/MraidJavascriptCommand;
    //   75: new 2	com/mopub/mraid/MraidJavascriptCommand
    //   78: dup
    //   79: ldc 61
    //   81: iconst_5
    //   82: ldc 63
    //   84: invokespecial 29	com/mopub/mraid/MraidJavascriptCommand:<init>	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: putstatic 65	com/mopub/mraid/MraidJavascriptCommand:SET_ORIENTATION_PROPERTIES	Lcom/mopub/mraid/MraidJavascriptCommand;
    //   90: new 67	com/mopub/mraid/MraidJavascriptCommand$4
    //   93: dup
    //   94: ldc 68
    //   96: bipush 6
    //   98: ldc 70
    //   100: invokespecial 71	com/mopub/mraid/MraidJavascriptCommand$4:<init>	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: putstatic 73	com/mopub/mraid/MraidJavascriptCommand:PLAY_VIDEO	Lcom/mopub/mraid/MraidJavascriptCommand;
    //   106: new 75	com/mopub/mraid/MraidJavascriptCommand$5
    //   109: dup
    //   110: ldc 76
    //   112: bipush 7
    //   114: ldc 78
    //   116: invokespecial 79	com/mopub/mraid/MraidJavascriptCommand$5:<init>	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: putstatic 81	com/mopub/mraid/MraidJavascriptCommand:STORE_PICTURE	Lcom/mopub/mraid/MraidJavascriptCommand;
    //   122: new 83	com/mopub/mraid/MraidJavascriptCommand$6
    //   125: dup
    //   126: ldc 84
    //   128: bipush 8
    //   130: ldc 86
    //   132: invokespecial 87	com/mopub/mraid/MraidJavascriptCommand$6:<init>	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: putstatic 89	com/mopub/mraid/MraidJavascriptCommand:CREATE_CALENDAR_EVENT	Lcom/mopub/mraid/MraidJavascriptCommand;
    //   138: new 2	com/mopub/mraid/MraidJavascriptCommand
    //   141: dup
    //   142: ldc 90
    //   144: bipush 9
    //   146: ldc 92
    //   148: invokespecial 29	com/mopub/mraid/MraidJavascriptCommand:<init>	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: putstatic 94	com/mopub/mraid/MraidJavascriptCommand:UNSPECIFIED	Lcom/mopub/mraid/MraidJavascriptCommand;
    //   154: bipush 10
    //   156: anewarray 2	com/mopub/mraid/MraidJavascriptCommand
    //   159: astore_0
    //   160: aload_0
    //   161: iconst_0
    //   162: getstatic 31	com/mopub/mraid/MraidJavascriptCommand:CLOSE	Lcom/mopub/mraid/MraidJavascriptCommand;
    //   165: aastore
    //   166: aload_0
    //   167: iconst_1
    //   168: getstatic 39	com/mopub/mraid/MraidJavascriptCommand:EXPAND	Lcom/mopub/mraid/MraidJavascriptCommand;
    //   171: aastore
    //   172: aload_0
    //   173: iconst_2
    //   174: getstatic 44	com/mopub/mraid/MraidJavascriptCommand:USE_CUSTOM_CLOSE	Lcom/mopub/mraid/MraidJavascriptCommand;
    //   177: aastore
    //   178: aload_0
    //   179: iconst_3
    //   180: getstatic 52	com/mopub/mraid/MraidJavascriptCommand:OPEN	Lcom/mopub/mraid/MraidJavascriptCommand;
    //   183: aastore
    //   184: aload_0
    //   185: iconst_4
    //   186: getstatic 60	com/mopub/mraid/MraidJavascriptCommand:RESIZE	Lcom/mopub/mraid/MraidJavascriptCommand;
    //   189: aastore
    //   190: aload_0
    //   191: iconst_5
    //   192: getstatic 65	com/mopub/mraid/MraidJavascriptCommand:SET_ORIENTATION_PROPERTIES	Lcom/mopub/mraid/MraidJavascriptCommand;
    //   195: aastore
    //   196: aload_0
    //   197: bipush 6
    //   199: getstatic 73	com/mopub/mraid/MraidJavascriptCommand:PLAY_VIDEO	Lcom/mopub/mraid/MraidJavascriptCommand;
    //   202: aastore
    //   203: aload_0
    //   204: bipush 7
    //   206: getstatic 81	com/mopub/mraid/MraidJavascriptCommand:STORE_PICTURE	Lcom/mopub/mraid/MraidJavascriptCommand;
    //   209: aastore
    //   210: aload_0
    //   211: bipush 8
    //   213: getstatic 89	com/mopub/mraid/MraidJavascriptCommand:CREATE_CALENDAR_EVENT	Lcom/mopub/mraid/MraidJavascriptCommand;
    //   216: aastore
    //   217: aload_0
    //   218: bipush 9
    //   220: getstatic 94	com/mopub/mraid/MraidJavascriptCommand:UNSPECIFIED	Lcom/mopub/mraid/MraidJavascriptCommand;
    //   223: aastore
    //   224: aload_0
    //   225: putstatic 96	com/mopub/mraid/MraidJavascriptCommand:b	[Lcom/mopub/mraid/MraidJavascriptCommand;
    //   228: return
  }

  private MraidJavascriptCommand(String paramString)
  {
    this.a = paramString;
  }

  static MraidJavascriptCommand a(String paramString)
  {
    for (MraidJavascriptCommand localMraidJavascriptCommand : values())
      if (localMraidJavascriptCommand.a.equals(paramString))
        return localMraidJavascriptCommand;
    return UNSPECIFIED;
  }

  String a()
  {
    return this.a;
  }

  boolean a(PlacementType paramPlacementType)
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mraid.MraidJavascriptCommand
 * JD-Core Version:    0.6.2
 */