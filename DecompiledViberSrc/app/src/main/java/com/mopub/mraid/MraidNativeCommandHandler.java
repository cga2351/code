package com.mopub.mraid;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Toast;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Intents;
import com.mopub.common.util.ResponseHeader;
import java.io.File;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class MraidNativeCommandHandler
{
  public static final String ANDROID_CALENDAR_CONTENT_TYPE = "vnd.android.cursor.item/event";
  private static final String[] a = { "yyyy-MM-dd'T'HH:mm:ssZZZZZ", "yyyy-MM-dd'T'HH:mmZZZZZ" };

  private String a(int paramInt)
    throws IllegalArgumentException
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("invalid day of week " + paramInt);
    case 0:
      return "SU";
    case 1:
      return "MO";
    case 2:
      return "TU";
    case 3:
      return "WE";
    case 4:
      return "TH";
    case 5:
      return "FR";
    case 6:
    }
    return "SA";
  }

  private Date a(String paramString)
  {
    String[] arrayOfString = a;
    int i = arrayOfString.length;
    Object localObject = null;
    int j = 0;
    while (true)
    {
      String str;
      if (j < i)
        str = arrayOfString[j];
      try
      {
        Date localDate = new SimpleDateFormat(str, Locale.US).parse(paramString);
        localObject = localDate;
        if (localObject != null)
          return localObject;
      }
      catch (ParseException localParseException)
      {
        j++;
      }
    }
  }

  private Map<String, Object> a(Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    if ((!paramMap.containsKey("description")) || (!paramMap.containsKey("start")))
      throw new IllegalArgumentException("Missing start and description fields");
    localHashMap.put("title", paramMap.get("description"));
    if ((paramMap.containsKey("start")) && (paramMap.get("start") != null))
    {
      Date localDate1 = a((String)paramMap.get("start"));
      if (localDate1 != null)
      {
        localHashMap.put("beginTime", Long.valueOf(localDate1.getTime()));
        if ((paramMap.containsKey("end")) && (paramMap.get("end") != null))
        {
          Date localDate2 = a((String)paramMap.get("end"));
          if (localDate2 == null)
            break label318;
          localHashMap.put("endTime", Long.valueOf(localDate2.getTime()));
        }
        if (paramMap.containsKey("location"))
          localHashMap.put("eventLocation", paramMap.get("location"));
        if (paramMap.containsKey("summary"))
          localHashMap.put("description", paramMap.get("summary"));
        if (paramMap.containsKey("transparency"))
          if (!((String)paramMap.get("transparency")).equals("transparent"))
            break label328;
      }
    }
    label318: label328: for (int i = 1; ; i = 0)
    {
      localHashMap.put("availability", Integer.valueOf(i));
      localHashMap.put("rrule", b(paramMap));
      return localHashMap;
      throw new IllegalArgumentException("Invalid calendar event: start time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
      throw new IllegalArgumentException("Invalid calendar event: start is null.");
      throw new IllegalArgumentException("Invalid calendar event: end time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
    }
  }

  private String b(int paramInt)
    throws IllegalArgumentException
  {
    if ((paramInt != 0) && (paramInt >= -31) && (paramInt <= 31))
      return "" + paramInt;
    throw new IllegalArgumentException("invalid day of month " + paramInt);
  }

  private String b(String paramString)
    throws IllegalArgumentException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    boolean[] arrayOfBoolean = new boolean[7];
    String[] arrayOfString = paramString.split(",");
    int i = arrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      int k = Integer.parseInt(arrayOfString[j]);
      if (k == 7)
        k = 0;
      if (arrayOfBoolean[k] == 0)
      {
        localStringBuilder.append(a(k) + ",");
        arrayOfBoolean[k] = true;
      }
    }
    if (arrayOfString.length == 0)
      throw new IllegalArgumentException("must have at least 1 day of the week if specifying repeating weekly");
    localStringBuilder.deleteCharAt(-1 + localStringBuilder.length());
    return localStringBuilder.toString();
  }

  private String b(Map<String, String> paramMap)
    throws IllegalArgumentException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1;
    if (paramMap.containsKey("frequency"))
    {
      str1 = (String)paramMap.get("frequency");
      if (!paramMap.containsKey("interval"))
        break label379;
    }
    label379: for (int i = Integer.parseInt((String)paramMap.get("interval")); ; i = -1)
    {
      if ("daily".equals(str1))
      {
        localStringBuilder.append("FREQ=DAILY;");
        if (i != -1)
          localStringBuilder.append("INTERVAL=" + i + ";");
      }
      while (true)
      {
        return localStringBuilder.toString();
        if ("weekly".equals(str1))
        {
          localStringBuilder.append("FREQ=WEEKLY;");
          if (i != -1)
            localStringBuilder.append("INTERVAL=" + i + ";");
          if (paramMap.containsKey("daysInWeek"))
          {
            String str3 = b((String)paramMap.get("daysInWeek"));
            if (str3 == null)
              throw new IllegalArgumentException("invalid ");
            localStringBuilder.append("BYDAY=" + str3 + ";");
          }
        }
        else
        {
          if (!"monthly".equals(str1))
            break;
          localStringBuilder.append("FREQ=MONTHLY;");
          if (i != -1)
            localStringBuilder.append("INTERVAL=" + i + ";");
          if (paramMap.containsKey("daysInMonth"))
          {
            String str2 = c((String)paramMap.get("daysInMonth"));
            if (str2 == null)
              throw new IllegalArgumentException();
            localStringBuilder.append("BYMONTHDAY=" + str2 + ";");
          }
        }
      }
      throw new IllegalArgumentException("frequency is only supported for daily, weekly, and monthly.");
    }
  }

  private String c(String paramString)
    throws IllegalArgumentException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    boolean[] arrayOfBoolean = new boolean[63];
    String[] arrayOfString = paramString.split(",");
    int i = arrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      int k = Integer.parseInt(arrayOfString[j]);
      if (arrayOfBoolean[(k + 31)] == 0)
      {
        localStringBuilder.append(b(k) + ",");
        arrayOfBoolean[(k + 31)] = true;
      }
    }
    if (arrayOfString.length == 0)
      throw new IllegalArgumentException("must have at least 1 day of the month if specifying repeating weekly");
    localStringBuilder.deleteCharAt(-1 + localStringBuilder.length());
    return localStringBuilder.toString();
  }

  private void c(final Context paramContext, final String paramString, final c paramc)
  {
    new AlertDialog.Builder(paramContext).setTitle("Save Image").setMessage("Download image to Picture gallery?").setNegativeButton("Cancel", null).setPositiveButton("Okay", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        MraidNativeCommandHandler.this.b(paramContext, paramString, paramc);
      }
    }).setCancelable(true).show();
  }

  static boolean c(Context paramContext)
  {
    return Intents.deviceCanHandleIntent(paramContext, new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.item/event"));
  }

  public static boolean isStorePictureSupported(Context paramContext)
  {
    return ("mounted".equals(Environment.getExternalStorageState())) && (DeviceUtils.isPermissionGranted(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE"));
  }

  void a(Context paramContext, String paramString, c paramc)
    throws a
  {
    if (!isStorePictureSupported(paramContext))
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Error downloading file - the device does not have an SD card mounted, or the Android permission is not granted." });
      throw new a("Error downloading file  - the device does not have an SD card mounted, or the Android permission is not granted.");
    }
    if ((paramContext instanceof Activity))
    {
      c(paramContext, paramString, paramc);
      return;
    }
    Toast.makeText(paramContext, "Downloading image to Picture gallery...", 0).show();
    b(paramContext, paramString, paramc);
  }

  void a(Context paramContext, Map<String, String> paramMap)
    throws a
  {
    if (c(paramContext))
    {
      Intent localIntent;
      try
      {
        Map localMap = a(paramMap);
        localIntent = new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.item/event");
        Iterator localIterator = localMap.keySet().iterator();
        while (true)
        {
          if (!localIterator.hasNext())
            break label261;
          str = (String)localIterator.next();
          localObject = localMap.get(str);
          if (!(localObject instanceof Long))
            break;
          localIntent.putExtra(str, ((Long)localObject).longValue());
        }
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        while (true)
        {
          MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "no calendar app installed" });
          throw new a("Action is unsupported on this device - no calendar app installed");
          if (!(localObject instanceof Integer))
            break;
          localIntent.putExtra(str, ((Integer)localObject).intValue());
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        while (true)
        {
          String str;
          Object localObject;
          MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = ("create calendar: invalid parameters " + localIllegalArgumentException.getMessage());
          MoPubLog.log(localSdkLogEvent, arrayOfObject);
          throw new a(localIllegalArgumentException);
          localIntent.putExtra(str, (String)localObject);
        }
      }
      catch (Exception localException)
      {
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "could not create calendar event" });
        throw new a(localException);
      }
      label261: localIntent.setFlags(268435456);
      paramContext.startActivity(localIntent);
      return;
    }
    MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "unsupported action createCalendarEvent for devices pre-ICS" });
    throw new a("Action is unsupported on this device (need Android version Ice Cream Sandwich or above)");
  }

  boolean a(Activity paramActivity, View paramView)
  {
    if (paramActivity.getWindow() == null);
    while ((0x1000000 & paramActivity.getWindow().getAttributes().flags) == 0)
      return false;
    return true;
  }

  boolean a(Context paramContext)
  {
    Intent localIntent = new Intent("android.intent.action.DIAL");
    localIntent.setData(Uri.parse("tel:"));
    return Intents.deviceCanHandleIntent(paramContext, localIntent);
  }

  void b(final Context paramContext, String paramString, final c paramc)
  {
    AsyncTasks.safeExecuteOnExecutor(new a(paramContext, new MraidNativeCommandHandler.a.a()
    {
      public void onFailure()
      {
        Toast.makeText(paramContext, "Image failed to download.", 0).show();
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Error downloading and saving image file." });
        paramc.onFailure(new a("Error downloading and saving image file."));
      }

      public void onSuccess()
      {
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Image successfully saved." });
      }
    }), new String[] { paramString });
  }

  boolean b(Context paramContext)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse("sms:"));
    return Intents.deviceCanHandleIntent(paramContext, localIntent);
  }

  @VisibleForTesting
  static class a extends AsyncTask<String, Void, Boolean>
  {
    private final Context a;
    private final a b;

    public a(Context paramContext, a parama)
    {
      this.a = paramContext.getApplicationContext();
      this.b = parama;
    }

    private File a()
    {
      return new File(Environment.getExternalStorageDirectory(), "Pictures");
    }

    private String a(URI paramURI, Map<String, List<String>> paramMap)
    {
      Preconditions.checkNotNull(paramURI);
      String str1 = paramURI.getPath();
      if ((str1 == null) || (paramMap == null))
        return null;
      String str2 = new File(str1).getName();
      List localList = (List)paramMap.get(ResponseHeader.CONTENT_TYPE.getKey());
      if ((localList == null) || (localList.isEmpty()) || (localList.get(0) == null))
        return str2;
      for (String str3 : ((String)localList.get(0)).split(";"))
        if (str3.contains("image/"))
        {
          String str4 = "." + str3.split("/")[1];
          if (str2.endsWith(str4))
            break;
          return str2 + str4;
        }
      return str2;
    }

    private void a(String paramString)
    {
      MraidNativeCommandHandler.b localb = new MraidNativeCommandHandler.b(paramString, null, null);
      MediaScannerConnection localMediaScannerConnection = new MediaScannerConnection(this.a, localb);
      MraidNativeCommandHandler.b.a(localb, localMediaScannerConnection);
      localMediaScannerConnection.connect();
    }

    // ERROR //
    protected Boolean a(String[] paramArrayOfString)
    {
      // Byte code:
      //   0: aload_1
      //   1: ifnull +14 -> 15
      //   4: aload_1
      //   5: arraylength
      //   6: ifeq +9 -> 15
      //   9: aload_1
      //   10: iconst_0
      //   11: aaload
      //   12: ifnonnull +8 -> 20
      //   15: iconst_0
      //   16: invokestatic 138	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   19: areturn
      //   20: aload_0
      //   21: invokespecial 140	com/mopub/mraid/MraidNativeCommandHandler$a:a	()Ljava/io/File;
      //   24: astore_2
      //   25: aload_2
      //   26: invokevirtual 143	java/io/File:mkdirs	()Z
      //   29: pop
      //   30: aload_1
      //   31: iconst_0
      //   32: aaload
      //   33: astore 4
      //   35: aload 4
      //   37: invokestatic 147	java/net/URI:create	(Ljava/lang/String;)Ljava/net/URI;
      //   40: astore 5
      //   42: aload 4
      //   44: invokestatic 153	com/mopub/common/MoPubHttpUrlConnection:getHttpUrlConnection	(Ljava/lang/String;)Ljava/net/HttpURLConnection;
      //   47: astore 12
      //   49: new 155	java/io/BufferedInputStream
      //   52: dup
      //   53: aload 12
      //   55: invokevirtual 161	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   58: invokespecial 164	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
      //   61: astore 7
      //   63: aload 12
      //   65: getstatic 167	com/mopub/common/util/ResponseHeader:LOCATION	Lcom/mopub/common/util/ResponseHeader;
      //   68: invokevirtual 66	com/mopub/common/util/ResponseHeader:getKey	()Ljava/lang/String;
      //   71: invokevirtual 171	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   74: astore 15
      //   76: aload 15
      //   78: invokestatic 175	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   81: ifne +10 -> 91
      //   84: aload 15
      //   86: invokestatic 147	java/net/URI:create	(Ljava/lang/String;)Ljava/net/URI;
      //   89: astore 5
      //   91: new 28	java/io/File
      //   94: dup
      //   95: aload_2
      //   96: aload_0
      //   97: aload 5
      //   99: aload 12
      //   101: invokevirtual 179	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
      //   104: invokespecial 181	com/mopub/mraid/MraidNativeCommandHandler$a:a	(Ljava/net/URI;Ljava/util/Map;)Ljava/lang/String;
      //   107: invokespecial 38	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   110: astore 16
      //   112: new 183	java/io/FileOutputStream
      //   115: dup
      //   116: aload 16
      //   118: invokespecial 186	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   121: astore 9
      //   123: aload 7
      //   125: aload 9
      //   127: invokestatic 192	com/mopub/common/util/Streams:copyContent	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
      //   130: aload_0
      //   131: aload 16
      //   133: invokevirtual 193	java/io/File:toString	()Ljava/lang/String;
      //   136: invokespecial 195	com/mopub/mraid/MraidNativeCommandHandler$a:a	(Ljava/lang/String;)V
      //   139: iconst_1
      //   140: invokestatic 138	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   143: astore 18
      //   145: aload 7
      //   147: invokestatic 199	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
      //   150: aload 9
      //   152: invokestatic 199	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
      //   155: aload 18
      //   157: areturn
      //   158: astore 10
      //   160: aconst_null
      //   161: astore 9
      //   163: aconst_null
      //   164: astore 7
      //   166: iconst_0
      //   167: invokestatic 138	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   170: astore 11
      //   172: aload 7
      //   174: invokestatic 199	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
      //   177: aload 9
      //   179: invokestatic 199	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
      //   182: aload 11
      //   184: areturn
      //   185: astore 6
      //   187: aconst_null
      //   188: astore 7
      //   190: aload 6
      //   192: astore 8
      //   194: aconst_null
      //   195: astore 9
      //   197: aload 7
      //   199: invokestatic 199	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
      //   202: aload 9
      //   204: invokestatic 199	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
      //   207: aload 8
      //   209: athrow
      //   210: astore 14
      //   212: aload 14
      //   214: astore 8
      //   216: aconst_null
      //   217: astore 9
      //   219: goto -22 -> 197
      //   222: astore 8
      //   224: goto -27 -> 197
      //   227: astore 13
      //   229: aconst_null
      //   230: astore 9
      //   232: goto -66 -> 166
      //   235: astore 17
      //   237: goto -71 -> 166
      //
      // Exception table:
      //   from	to	target	type
      //   42	63	158	java/lang/Exception
      //   42	63	185	finally
      //   63	91	210	finally
      //   91	123	210	finally
      //   123	145	222	finally
      //   166	172	222	finally
      //   63	91	227	java/lang/Exception
      //   91	123	227	java/lang/Exception
      //   123	145	235	java/lang/Exception
    }

    protected void a(Boolean paramBoolean)
    {
      if ((paramBoolean != null) && (paramBoolean.booleanValue()))
      {
        this.b.onSuccess();
        return;
      }
      this.b.onFailure();
    }

    static abstract interface a
    {
      public abstract void onFailure();

      public abstract void onSuccess();
    }
  }

  private static class b
    implements MediaScannerConnection.MediaScannerConnectionClient
  {
    private final String a;
    private final String b;
    private MediaScannerConnection c;

    private b(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }

    private void a(MediaScannerConnection paramMediaScannerConnection)
    {
      this.c = paramMediaScannerConnection;
    }

    public void onMediaScannerConnected()
    {
      if (this.c != null)
        this.c.scanFile(this.a, this.b);
    }

    public void onScanCompleted(String paramString, Uri paramUri)
    {
      if (this.c != null)
        this.c.disconnect();
    }
  }

  static abstract interface c
  {
    public abstract void onFailure(a parama);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mraid.MraidNativeCommandHandler
 * JD-Core Version:    0.6.2
 */