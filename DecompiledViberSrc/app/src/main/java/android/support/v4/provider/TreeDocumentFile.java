package android.support.v4.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;

class TreeDocumentFile extends DocumentFile
{
  private Context mContext;
  private Uri mUri;

  TreeDocumentFile(DocumentFile paramDocumentFile, Context paramContext, Uri paramUri)
  {
    super(paramDocumentFile);
    this.mContext = paramContext;
    this.mUri = paramUri;
  }

  private static void closeQuietly(AutoCloseable paramAutoCloseable)
  {
    if (paramAutoCloseable != null);
    try
    {
      paramAutoCloseable.close();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Exception localException)
    {
    }
  }

  private static Uri createFile(Context paramContext, Uri paramUri, String paramString1, String paramString2)
  {
    try
    {
      Uri localUri = DocumentsContract.createDocument(paramContext.getContentResolver(), paramUri, paramString1, paramString2);
      return localUri;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public boolean canRead()
  {
    return DocumentsContractApi19.canRead(this.mContext, this.mUri);
  }

  public boolean canWrite()
  {
    return DocumentsContractApi19.canWrite(this.mContext, this.mUri);
  }

  public DocumentFile createDirectory(String paramString)
  {
    Uri localUri = createFile(this.mContext, this.mUri, "vnd.android.document/directory", paramString);
    if (localUri != null)
      return new TreeDocumentFile(this, this.mContext, localUri);
    return null;
  }

  public DocumentFile createFile(String paramString1, String paramString2)
  {
    Uri localUri = createFile(this.mContext, this.mUri, paramString1, paramString2);
    if (localUri != null)
      return new TreeDocumentFile(this, this.mContext, localUri);
    return null;
  }

  public boolean delete()
  {
    try
    {
      boolean bool = DocumentsContract.deleteDocument(this.mContext.getContentResolver(), this.mUri);
      return bool;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public boolean exists()
  {
    return DocumentsContractApi19.exists(this.mContext, this.mUri);
  }

  public String getName()
  {
    return DocumentsContractApi19.getName(this.mContext, this.mUri);
  }

  public String getType()
  {
    return DocumentsContractApi19.getType(this.mContext, this.mUri);
  }

  public Uri getUri()
  {
    return this.mUri;
  }

  public boolean isDirectory()
  {
    return DocumentsContractApi19.isDirectory(this.mContext, this.mUri);
  }

  public boolean isFile()
  {
    return DocumentsContractApi19.isFile(this.mContext, this.mUri);
  }

  public boolean isVirtual()
  {
    return DocumentsContractApi19.isVirtual(this.mContext, this.mUri);
  }

  public long lastModified()
  {
    return DocumentsContractApi19.lastModified(this.mContext, this.mUri);
  }

  public long length()
  {
    return DocumentsContractApi19.length(this.mContext, this.mUri);
  }

  // ERROR //
  public DocumentFile[] listFiles()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	android/support/v4/provider/TreeDocumentFile:mContext	Landroid/content/Context;
    //   4: invokevirtual 37	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 17	android/support/v4/provider/TreeDocumentFile:mUri	Landroid/net/Uri;
    //   12: aload_0
    //   13: getfield 17	android/support/v4/provider/TreeDocumentFile:mUri	Landroid/net/Uri;
    //   16: invokestatic 103	android/provider/DocumentsContract:getDocumentId	(Landroid/net/Uri;)Ljava/lang/String;
    //   19: invokestatic 107	android/provider/DocumentsContract:buildChildDocumentsUriUsingTree	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   22: astore_2
    //   23: new 109	java/util/ArrayList
    //   26: dup
    //   27: invokespecial 111	java/util/ArrayList:<init>	()V
    //   30: astore_3
    //   31: aload_1
    //   32: aload_2
    //   33: iconst_1
    //   34: anewarray 113	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: ldc 115
    //   41: aastore
    //   42: aconst_null
    //   43: aconst_null
    //   44: aconst_null
    //   45: invokevirtual 121	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   48: astore 11
    //   50: aload 11
    //   52: astore 5
    //   54: aload 5
    //   56: invokeinterface 126 1 0
    //   61: ifeq +126 -> 187
    //   64: aload 5
    //   66: iconst_0
    //   67: invokeinterface 130 2 0
    //   72: astore 12
    //   74: aload_3
    //   75: aload_0
    //   76: getfield 17	android/support/v4/provider/TreeDocumentFile:mUri	Landroid/net/Uri;
    //   79: aload 12
    //   81: invokestatic 133	android/provider/DocumentsContract:buildDocumentUriUsingTree	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   84: invokevirtual 137	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   87: pop
    //   88: goto -34 -> 54
    //   91: astore 4
    //   93: ldc 139
    //   95: new 141	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   102: ldc 144
    //   104: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload 4
    //   109: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 160	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   118: pop
    //   119: aload 5
    //   121: invokestatic 162	android/support/v4/provider/TreeDocumentFile:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   124: aload_3
    //   125: aload_3
    //   126: invokevirtual 166	java/util/ArrayList:size	()I
    //   129: anewarray 168	android/net/Uri
    //   132: invokevirtual 172	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   135: checkcast 174	[Landroid/net/Uri;
    //   138: astore 8
    //   140: aload 8
    //   142: arraylength
    //   143: anewarray 4	android/support/v4/provider/DocumentFile
    //   146: astore 9
    //   148: iconst_0
    //   149: istore 10
    //   151: iload 10
    //   153: aload 8
    //   155: arraylength
    //   156: if_icmpge +52 -> 208
    //   159: aload 9
    //   161: iload 10
    //   163: new 2	android/support/v4/provider/TreeDocumentFile
    //   166: dup
    //   167: aload_0
    //   168: aload_0
    //   169: getfield 15	android/support/v4/provider/TreeDocumentFile:mContext	Landroid/content/Context;
    //   172: aload 8
    //   174: iload 10
    //   176: aaload
    //   177: invokespecial 61	android/support/v4/provider/TreeDocumentFile:<init>	(Landroid/support/v4/provider/DocumentFile;Landroid/content/Context;Landroid/net/Uri;)V
    //   180: aastore
    //   181: iinc 10 1
    //   184: goto -33 -> 151
    //   187: aload 5
    //   189: invokestatic 162	android/support/v4/provider/TreeDocumentFile:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   192: goto -68 -> 124
    //   195: astore 6
    //   197: aconst_null
    //   198: astore 5
    //   200: aload 5
    //   202: invokestatic 162	android/support/v4/provider/TreeDocumentFile:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   205: aload 6
    //   207: athrow
    //   208: aload 9
    //   210: areturn
    //   211: astore 6
    //   213: goto -13 -> 200
    //   216: astore 4
    //   218: aconst_null
    //   219: astore 5
    //   221: goto -128 -> 93
    //
    // Exception table:
    //   from	to	target	type
    //   54	88	91	java/lang/Exception
    //   31	50	195	finally
    //   54	88	211	finally
    //   93	119	211	finally
    //   31	50	216	java/lang/Exception
  }

  public boolean renameTo(String paramString)
  {
    try
    {
      Uri localUri = DocumentsContract.renameDocument(this.mContext.getContentResolver(), this.mUri, paramString);
      boolean bool = false;
      if (localUri != null)
      {
        this.mUri = localUri;
        bool = true;
      }
      return bool;
    }
    catch (Exception localException)
    {
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.provider.TreeDocumentFile
 * JD-Core Version:    0.6.2
 */