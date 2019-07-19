package com.mixpanel.android.mpmetrics;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Parcel;
import android.os.Parcelable;
import com.mixpanel.android.b.e;
import com.mixpanel.android.b.f;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class InAppNotification
  implements Parcelable
{
  private static final Pattern FILE_EXTENSION_PATTERN = Pattern.compile("(\\.[^./]+$)");
  private static final String LOGTAG = "MixpanelAPI.InAppNotif";
  private final int mBackgroundColor;
  private final String mBody;
  private final int mBodyColor;
  protected final JSONObject mDescription;
  protected final JSONObject mExtras;
  protected final int mId;
  private Bitmap mImage;
  private final String mImageUrl;
  protected final int mMessageId;

  public InAppNotification()
  {
    this.mDescription = null;
    this.mExtras = null;
    this.mId = 0;
    this.mMessageId = 0;
    this.mBackgroundColor = 0;
    this.mBody = null;
    this.mBodyColor = 0;
    this.mImageUrl = null;
  }

  // ERROR //
  public InAppNotification(Parcel paramParcel)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 39	java/lang/Object:<init>	()V
    //   4: new 60	org/json/JSONObject
    //   7: dup
    //   8: invokespecial 61	org/json/JSONObject:<init>	()V
    //   11: astore_2
    //   12: new 60	org/json/JSONObject
    //   15: dup
    //   16: invokespecial 61	org/json/JSONObject:<init>	()V
    //   19: astore_3
    //   20: new 60	org/json/JSONObject
    //   23: dup
    //   24: aload_1
    //   25: invokevirtual 67	android/os/Parcel:readString	()Ljava/lang/String;
    //   28: invokespecial 70	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   31: astore 4
    //   33: new 60	org/json/JSONObject
    //   36: dup
    //   37: aload_1
    //   38: invokevirtual 67	android/os/Parcel:readString	()Ljava/lang/String;
    //   41: invokespecial 70	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   44: astore 5
    //   46: aload 4
    //   48: astore 6
    //   50: aload_0
    //   51: aload 6
    //   53: putfield 41	com/mixpanel/android/mpmetrics/InAppNotification:mDescription	Lorg/json/JSONObject;
    //   56: aload_0
    //   57: aload 5
    //   59: putfield 43	com/mixpanel/android/mpmetrics/InAppNotification:mExtras	Lorg/json/JSONObject;
    //   62: aload_0
    //   63: aload_1
    //   64: invokevirtual 74	android/os/Parcel:readInt	()I
    //   67: putfield 45	com/mixpanel/android/mpmetrics/InAppNotification:mId	I
    //   70: aload_0
    //   71: aload_1
    //   72: invokevirtual 74	android/os/Parcel:readInt	()I
    //   75: putfield 47	com/mixpanel/android/mpmetrics/InAppNotification:mMessageId	I
    //   78: aload_0
    //   79: aload_1
    //   80: invokevirtual 74	android/os/Parcel:readInt	()I
    //   83: putfield 49	com/mixpanel/android/mpmetrics/InAppNotification:mBackgroundColor	I
    //   86: aload_0
    //   87: aload_1
    //   88: invokevirtual 67	android/os/Parcel:readString	()Ljava/lang/String;
    //   91: putfield 51	com/mixpanel/android/mpmetrics/InAppNotification:mBody	Ljava/lang/String;
    //   94: aload_0
    //   95: aload_1
    //   96: invokevirtual 74	android/os/Parcel:readInt	()I
    //   99: putfield 53	com/mixpanel/android/mpmetrics/InAppNotification:mBodyColor	I
    //   102: aload_0
    //   103: aload_1
    //   104: invokevirtual 67	android/os/Parcel:readString	()Ljava/lang/String;
    //   107: putfield 55	com/mixpanel/android/mpmetrics/InAppNotification:mImageUrl	Ljava/lang/String;
    //   110: aload_0
    //   111: aload_1
    //   112: ldc 76
    //   114: invokevirtual 82	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   117: invokevirtual 86	android/os/Parcel:readParcelable	(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;
    //   120: checkcast 76	android/graphics/Bitmap
    //   123: putfield 88	com/mixpanel/android/mpmetrics/InAppNotification:mImage	Landroid/graphics/Bitmap;
    //   126: return
    //   127: astore 8
    //   129: ldc 12
    //   131: ldc 90
    //   133: invokestatic 96	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload_2
    //   137: astore 6
    //   139: aload_3
    //   140: astore 5
    //   142: goto -92 -> 50
    //   145: astore 7
    //   147: aload 4
    //   149: astore_2
    //   150: goto -21 -> 129
    //
    // Exception table:
    //   from	to	target	type
    //   20	33	127	org/json/JSONException
    //   33	46	145	org/json/JSONException
  }

  InAppNotification(JSONObject paramJSONObject)
    throws b
  {
    try
    {
      this.mDescription = paramJSONObject;
      this.mExtras = paramJSONObject.getJSONObject("extras");
      this.mId = paramJSONObject.getInt("id");
      this.mMessageId = paramJSONObject.getInt("message_id");
      this.mBackgroundColor = paramJSONObject.getInt("bg_color");
      this.mBody = e.a(paramJSONObject, "body");
      this.mBodyColor = paramJSONObject.optInt("body_color");
      this.mImageUrl = paramJSONObject.getString("image_url");
      this.mImage = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new b("Notification JSON was unexpected or bad", localJSONException);
    }
  }

  static String sizeSuffixUrl(String paramString1, String paramString2)
  {
    Matcher localMatcher = FILE_EXTENSION_PATTERN.matcher(paramString1);
    if (localMatcher.find())
      paramString1 = localMatcher.replaceFirst(paramString2 + "$1");
    return paramString1;
  }

  public int describeContents()
  {
    return 0;
  }

  public int getBackgroundColor()
  {
    return this.mBackgroundColor;
  }

  public String getBody()
  {
    return this.mBody;
  }

  public int getBodyColor()
  {
    return this.mBodyColor;
  }

  JSONObject getCampaignProperties()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("campaign_id", getId());
      localJSONObject.put("message_id", getMessageId());
      localJSONObject.put("message_type", "inapp");
      localJSONObject.put("message_subtype", getType().toString());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      f.e("MixpanelAPI.InAppNotif", "Impossible JSON Exception", localJSONException);
    }
    return localJSONObject;
  }

  protected JSONObject getExtras()
  {
    return this.mExtras;
  }

  public int getId()
  {
    return this.mId;
  }

  public Bitmap getImage()
  {
    return this.mImage;
  }

  public String getImage2xUrl()
  {
    return sizeSuffixUrl(this.mImageUrl, "@2x");
  }

  public String getImage4xUrl()
  {
    return sizeSuffixUrl(this.mImageUrl, "@4x");
  }

  public String getImageUrl()
  {
    return this.mImageUrl;
  }

  public int getMessageId()
  {
    return this.mMessageId;
  }

  public abstract a getType();

  public boolean hasBody()
  {
    return this.mBody != null;
  }

  void setImage(Bitmap paramBitmap)
  {
    this.mImage = paramBitmap;
  }

  String toJSON()
  {
    return this.mDescription.toString();
  }

  public String toString()
  {
    return this.mDescription.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mDescription.toString());
    paramParcel.writeString(this.mExtras.toString());
    paramParcel.writeInt(this.mId);
    paramParcel.writeInt(this.mMessageId);
    paramParcel.writeInt(this.mBackgroundColor);
    paramParcel.writeString(this.mBody);
    paramParcel.writeInt(this.mBodyColor);
    paramParcel.writeString(this.mImageUrl);
    paramParcel.writeParcelable(this.mImage, paramInt);
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.InAppNotification
 * JD-Core Version:    0.6.2
 */