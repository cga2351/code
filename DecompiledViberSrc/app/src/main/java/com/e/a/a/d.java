package com.e.a.a;

class d
{
  // ERROR //
  protected static java.security.Signature a(com.e.a.h paramh, java.security.Provider paramProvider)
    throws com.e.a.d
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 18	com/e/a/h:e	Lcom/e/a/h;
    //   4: invokevirtual 22	com/e/a/h:equals	(Ljava/lang/Object;)Z
    //   7: ifeq +36 -> 43
    //   10: ldc 24
    //   12: astore_3
    //   13: aconst_null
    //   14: astore_2
    //   15: aload_1
    //   16: ifnull +180 -> 196
    //   19: aload_3
    //   20: aload_1
    //   21: invokestatic 30	java/security/Signature:getInstance	(Ljava/lang/String;Ljava/security/Provider;)Ljava/security/Signature;
    //   24: astore 8
    //   26: aload 8
    //   28: astore 6
    //   30: aload_2
    //   31: ifnull +9 -> 40
    //   34: aload 6
    //   36: aload_2
    //   37: invokevirtual 34	java/security/Signature:setParameter	(Ljava/security/spec/AlgorithmParameterSpec;)V
    //   40: aload 6
    //   42: areturn
    //   43: aload_0
    //   44: getstatic 37	com/e/a/h:f	Lcom/e/a/h;
    //   47: invokevirtual 22	com/e/a/h:equals	(Ljava/lang/Object;)Z
    //   50: ifeq +11 -> 61
    //   53: ldc 39
    //   55: astore_3
    //   56: aconst_null
    //   57: astore_2
    //   58: goto -43 -> 15
    //   61: aload_0
    //   62: getstatic 42	com/e/a/h:g	Lcom/e/a/h;
    //   65: invokevirtual 22	com/e/a/h:equals	(Ljava/lang/Object;)Z
    //   68: ifeq +11 -> 79
    //   71: ldc 44
    //   73: astore_3
    //   74: aconst_null
    //   75: astore_2
    //   76: goto -61 -> 15
    //   79: aload_0
    //   80: getstatic 47	com/e/a/h:k	Lcom/e/a/h;
    //   83: invokevirtual 22	com/e/a/h:equals	(Ljava/lang/Object;)Z
    //   86: ifeq +27 -> 113
    //   89: new 49	java/security/spec/PSSParameterSpec
    //   92: dup
    //   93: ldc 51
    //   95: ldc 53
    //   97: getstatic 58	java/security/spec/MGF1ParameterSpec:SHA256	Ljava/security/spec/MGF1ParameterSpec;
    //   100: bipush 32
    //   102: iconst_1
    //   103: invokespecial 62	java/security/spec/PSSParameterSpec:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/security/spec/AlgorithmParameterSpec;II)V
    //   106: astore_2
    //   107: ldc 64
    //   109: astore_3
    //   110: goto -95 -> 15
    //   113: aload_0
    //   114: getstatic 67	com/e/a/h:l	Lcom/e/a/h;
    //   117: invokevirtual 22	com/e/a/h:equals	(Ljava/lang/Object;)Z
    //   120: ifeq +27 -> 147
    //   123: new 49	java/security/spec/PSSParameterSpec
    //   126: dup
    //   127: ldc 69
    //   129: ldc 53
    //   131: getstatic 71	java/security/spec/MGF1ParameterSpec:SHA384	Ljava/security/spec/MGF1ParameterSpec;
    //   134: bipush 48
    //   136: iconst_1
    //   137: invokespecial 62	java/security/spec/PSSParameterSpec:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/security/spec/AlgorithmParameterSpec;II)V
    //   140: astore_2
    //   141: ldc 73
    //   143: astore_3
    //   144: goto -129 -> 15
    //   147: aload_0
    //   148: getstatic 76	com/e/a/h:m	Lcom/e/a/h;
    //   151: invokevirtual 22	com/e/a/h:equals	(Ljava/lang/Object;)Z
    //   154: ifeq +27 -> 181
    //   157: new 49	java/security/spec/PSSParameterSpec
    //   160: dup
    //   161: ldc 78
    //   163: ldc 53
    //   165: getstatic 80	java/security/spec/MGF1ParameterSpec:SHA512	Ljava/security/spec/MGF1ParameterSpec;
    //   168: bipush 64
    //   170: iconst_1
    //   171: invokespecial 62	java/security/spec/PSSParameterSpec:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/security/spec/AlgorithmParameterSpec;II)V
    //   174: astore_2
    //   175: ldc 82
    //   177: astore_3
    //   178: goto -163 -> 15
    //   181: new 8	com/e/a/d
    //   184: dup
    //   185: aload_0
    //   186: getstatic 87	com/e/a/a/e:a	Ljava/util/Set;
    //   189: invokestatic 92	com/e/a/a/a:a	(Lcom/e/a/h;Ljava/util/Collection;)Ljava/lang/String;
    //   192: invokespecial 95	com/e/a/d:<init>	(Ljava/lang/String;)V
    //   195: athrow
    //   196: aload_3
    //   197: invokestatic 98	java/security/Signature:getInstance	(Ljava/lang/String;)Ljava/security/Signature;
    //   200: astore 5
    //   202: aload 5
    //   204: astore 6
    //   206: goto -176 -> 30
    //   209: astore 4
    //   211: new 8	com/e/a/d
    //   214: dup
    //   215: new 100	java/lang/StringBuilder
    //   218: dup
    //   219: ldc 102
    //   221: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   224: aload 4
    //   226: invokevirtual 107	java/security/NoSuchAlgorithmException:getMessage	()Ljava/lang/String;
    //   229: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: aload 4
    //   237: invokespecial 117	com/e/a/d:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   240: athrow
    //   241: astore 7
    //   243: new 8	com/e/a/d
    //   246: dup
    //   247: new 100	java/lang/StringBuilder
    //   250: dup
    //   251: ldc 119
    //   253: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   256: aload 7
    //   258: invokevirtual 120	java/security/InvalidAlgorithmParameterException:getMessage	()Ljava/lang/String;
    //   261: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: aload 7
    //   269: invokespecial 117	com/e/a/d:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   272: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   19	26	209	java/security/NoSuchAlgorithmException
    //   196	202	209	java/security/NoSuchAlgorithmException
    //   34	40	241	java/security/InvalidAlgorithmParameterException
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.a.d
 * JD-Core Version:    0.6.2
 */