package android.support.v4.graphics.drawable;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.util.Preconditions;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

public class IconCompat extends CustomVersionedParcelable
{
  private static final float ADAPTIVE_ICON_INSET_FACTOR = 0.25F;
  private static final int AMBIENT_SHADOW_ALPHA = 30;
  private static final float BLUR_FACTOR = 0.01041667F;
  static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
  private static final float DEFAULT_VIEW_PORT_SCALE = 0.6666667F;
  private static final String EXTRA_INT1 = "int1";
  private static final String EXTRA_INT2 = "int2";
  private static final String EXTRA_OBJ = "obj";
  private static final String EXTRA_TINT_LIST = "tint_list";
  private static final String EXTRA_TINT_MODE = "tint_mode";
  private static final String EXTRA_TYPE = "type";
  private static final float ICON_DIAMETER_FACTOR = 0.9166667F;
  private static final int KEY_SHADOW_ALPHA = 61;
  private static final float KEY_SHADOW_OFFSET_FACTOR = 0.02083333F;
  private static final String TAG = "IconCompat";
  public static final int TYPE_UNKNOWN = -1;
  public byte[] mData;
  public int mInt1;
  public int mInt2;
  Object mObj1;
  public Parcelable mParcelable;
  public ColorStateList mTintList = null;
  PorterDuff.Mode mTintMode = DEFAULT_TINT_MODE;
  public String mTintModeStr;
  public int mType;

  public IconCompat()
  {
  }

  private IconCompat(int paramInt)
  {
    this.mType = paramInt;
  }

  public static IconCompat createFromBundle(Bundle paramBundle)
  {
    int i = paramBundle.getInt("type");
    IconCompat localIconCompat = new IconCompat(i);
    localIconCompat.mInt1 = paramBundle.getInt("int1");
    localIconCompat.mInt2 = paramBundle.getInt("int2");
    if (paramBundle.containsKey("tint_list"))
      localIconCompat.mTintList = ((ColorStateList)paramBundle.getParcelable("tint_list"));
    if (paramBundle.containsKey("tint_mode"))
      localIconCompat.mTintMode = PorterDuff.Mode.valueOf(paramBundle.getString("tint_mode"));
    switch (i)
    {
    case 0:
    default:
      Log.w("IconCompat", "Unknown type " + i);
      return null;
    case -1:
    case 1:
    case 5:
      localIconCompat.mObj1 = paramBundle.getParcelable("obj");
    case 2:
    case 4:
    case 3:
    }
    while (true)
    {
      return localIconCompat;
      localIconCompat.mObj1 = paramBundle.getString("obj");
      continue;
      localIconCompat.mObj1 = paramBundle.getByteArray("obj");
    }
  }

  public static IconCompat createFromIcon(Context paramContext, Icon paramIcon)
  {
    Preconditions.checkNotNull(paramIcon);
    switch (getType(paramIcon))
    {
    case 3:
    default:
      IconCompat localIconCompat2 = new IconCompat(-1);
      localIconCompat2.mObj1 = paramIcon;
      return localIconCompat2;
    case 2:
      String str = getResPackage(paramIcon);
      try
      {
        IconCompat localIconCompat1 = createWithResource(getResources(paramContext, str), str, getResId(paramIcon));
        return localIconCompat1;
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        throw new IllegalArgumentException("Icon resource cannot be found");
      }
    case 4:
    }
    return createWithContentUri(getUri(paramIcon));
  }

  public static IconCompat createFromIcon(Icon paramIcon)
  {
    Preconditions.checkNotNull(paramIcon);
    switch (getType(paramIcon))
    {
    case 3:
    default:
      IconCompat localIconCompat = new IconCompat(-1);
      localIconCompat.mObj1 = paramIcon;
      return localIconCompat;
    case 2:
      return createWithResource(null, getResPackage(paramIcon), getResId(paramIcon));
    case 4:
    }
    return createWithContentUri(getUri(paramIcon));
  }

  static Bitmap createLegacyIconFromAdaptiveIcon(Bitmap paramBitmap, boolean paramBoolean)
  {
    int i = (int)(0.6666667F * Math.min(paramBitmap.getWidth(), paramBitmap.getHeight()));
    Bitmap localBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint(3);
    float f1 = 0.5F * i;
    float f2 = 0.9166667F * f1;
    if (paramBoolean)
    {
      float f3 = 0.01041667F * i;
      localPaint.setColor(0);
      localPaint.setShadowLayer(f3, 0.0F, 0.02083333F * i, 1023410176);
      localCanvas.drawCircle(f1, f1, f2, localPaint);
      localPaint.setShadowLayer(f3, 0.0F, 0.0F, 503316480);
      localCanvas.drawCircle(f1, f1, f2, localPaint);
      localPaint.clearShadowLayer();
    }
    localPaint.setColor(-16777216);
    BitmapShader localBitmapShader = new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    Matrix localMatrix = new Matrix();
    localMatrix.setTranslate(-(paramBitmap.getWidth() - i) / 2, -(paramBitmap.getHeight() - i) / 2);
    localBitmapShader.setLocalMatrix(localMatrix);
    localPaint.setShader(localBitmapShader);
    localCanvas.drawCircle(f1, f1, f2, localPaint);
    localCanvas.setBitmap(null);
    return localBitmap;
  }

  public static IconCompat createWithAdaptiveBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
      throw new IllegalArgumentException("Bitmap must not be null.");
    IconCompat localIconCompat = new IconCompat(5);
    localIconCompat.mObj1 = paramBitmap;
    return localIconCompat;
  }

  public static IconCompat createWithBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
      throw new IllegalArgumentException("Bitmap must not be null.");
    IconCompat localIconCompat = new IconCompat(1);
    localIconCompat.mObj1 = paramBitmap;
    return localIconCompat;
  }

  public static IconCompat createWithContentUri(Uri paramUri)
  {
    if (paramUri == null)
      throw new IllegalArgumentException("Uri must not be null.");
    return createWithContentUri(paramUri.toString());
  }

  public static IconCompat createWithContentUri(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("Uri must not be null.");
    IconCompat localIconCompat = new IconCompat(4);
    localIconCompat.mObj1 = paramString;
    return localIconCompat;
  }

  public static IconCompat createWithData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null)
      throw new IllegalArgumentException("Data must not be null.");
    IconCompat localIconCompat = new IconCompat(3);
    localIconCompat.mObj1 = paramArrayOfByte;
    localIconCompat.mInt1 = paramInt1;
    localIconCompat.mInt2 = paramInt2;
    return localIconCompat;
  }

  public static IconCompat createWithResource(Context paramContext, int paramInt)
  {
    if (paramContext == null)
      throw new IllegalArgumentException("Context must not be null.");
    return createWithResource(paramContext.getResources(), paramContext.getPackageName(), paramInt);
  }

  public static IconCompat createWithResource(Resources paramResources, String paramString, int paramInt)
  {
    if (paramString == null)
      throw new IllegalArgumentException("Package must not be null.");
    if (paramInt == 0)
      throw new IllegalArgumentException("Drawable resource ID must not be 0");
    IconCompat localIconCompat = new IconCompat(2);
    localIconCompat.mInt1 = paramInt;
    if (paramResources != null)
      try
      {
        localIconCompat.mObj1 = paramResources.getResourceName(paramInt);
        return localIconCompat;
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        throw new IllegalArgumentException("Icon resource cannot be found");
      }
    localIconCompat.mObj1 = paramString;
    return localIconCompat;
  }

  private static int getResId(Icon paramIcon)
  {
    if (Build.VERSION.SDK_INT >= 28)
      return paramIcon.getResId();
    try
    {
      int i = ((Integer)paramIcon.getClass().getMethod("getResId", new Class[0]).invoke(paramIcon, new Object[0])).intValue();
      return i;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Log.e("IconCompat", "Unable to get icon resource", localIllegalAccessException);
      return 0;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Log.e("IconCompat", "Unable to get icon resource", localInvocationTargetException);
      return 0;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Log.e("IconCompat", "Unable to get icon resource", localNoSuchMethodException);
    }
    return 0;
  }

  private static String getResPackage(Icon paramIcon)
  {
    if (Build.VERSION.SDK_INT >= 28)
      return paramIcon.getResPackage();
    try
    {
      String str = (String)paramIcon.getClass().getMethod("getResPackage", new Class[0]).invoke(paramIcon, new Object[0]);
      return str;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Log.e("IconCompat", "Unable to get icon package", localIllegalAccessException);
      return null;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Log.e("IconCompat", "Unable to get icon package", localInvocationTargetException);
      return null;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Log.e("IconCompat", "Unable to get icon package", localNoSuchMethodException);
    }
    return null;
  }

  private static Resources getResources(Context paramContext, String paramString)
  {
    Resources localResources1;
    if ("android".equals(paramString))
      localResources1 = Resources.getSystem();
    while (true)
    {
      return localResources1;
      PackageManager localPackageManager = paramContext.getPackageManager();
      try
      {
        ApplicationInfo localApplicationInfo = localPackageManager.getApplicationInfo(paramString, 8192);
        localResources1 = null;
        if (localApplicationInfo != null)
        {
          Resources localResources2 = localPackageManager.getResourcesForApplication(localApplicationInfo);
          return localResources2;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        Log.e("IconCompat", String.format("Unable to find pkg=%s for icon", new Object[] { paramString }), localNameNotFoundException);
      }
    }
    return null;
  }

  private static int getType(Icon paramIcon)
  {
    if (Build.VERSION.SDK_INT >= 28)
      return paramIcon.getType();
    try
    {
      int i = ((Integer)paramIcon.getClass().getMethod("getType", new Class[0]).invoke(paramIcon, new Object[0])).intValue();
      return i;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Log.e("IconCompat", "Unable to get icon type " + paramIcon, localIllegalAccessException);
      return -1;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Log.e("IconCompat", "Unable to get icon type " + paramIcon, localInvocationTargetException);
      return -1;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Log.e("IconCompat", "Unable to get icon type " + paramIcon, localNoSuchMethodException);
    }
    return -1;
  }

  private static Uri getUri(Icon paramIcon)
  {
    if (Build.VERSION.SDK_INT >= 28)
      return paramIcon.getUri();
    try
    {
      Uri localUri = (Uri)paramIcon.getClass().getMethod("getUri", new Class[0]).invoke(paramIcon, new Object[0]);
      return localUri;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Log.e("IconCompat", "Unable to get icon uri", localIllegalAccessException);
      return null;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Log.e("IconCompat", "Unable to get icon uri", localInvocationTargetException);
      return null;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Log.e("IconCompat", "Unable to get icon uri", localNoSuchMethodException);
    }
    return null;
  }

  private Drawable loadDrawableInner(Context paramContext)
  {
    switch (this.mType)
    {
    default:
    case 1:
    case 5:
    case 2:
      while (true)
      {
        return null;
        return new BitmapDrawable(paramContext.getResources(), (Bitmap)this.mObj1);
        return new BitmapDrawable(paramContext.getResources(), createLegacyIconFromAdaptiveIcon((Bitmap)this.mObj1, false));
        String str2 = getResPackage();
        if (TextUtils.isEmpty(str2))
          str2 = paramContext.getPackageName();
        Resources localResources = getResources(paramContext, str2);
        try
        {
          Drawable localDrawable = ResourcesCompat.getDrawable(localResources, this.mInt1, paramContext.getTheme());
          return localDrawable;
        }
        catch (RuntimeException localRuntimeException)
        {
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = Integer.valueOf(this.mInt1);
          arrayOfObject[1] = this.mObj1;
          Log.e("IconCompat", String.format("Unable to load resource 0x%08x from pkg=%s", arrayOfObject), localRuntimeException);
        }
      }
    case 3:
      return new BitmapDrawable(paramContext.getResources(), BitmapFactory.decodeByteArray((byte[])this.mObj1, this.mInt1, this.mInt2));
    case 4:
    }
    Uri localUri = Uri.parse((String)this.mObj1);
    String str1 = localUri.getScheme();
    if (("content".equals(str1)) || ("file".equals(str1)));
    while (true)
    {
      Object localObject;
      try
      {
        InputStream localInputStream = paramContext.getContentResolver().openInputStream(localUri);
        localObject = localInputStream;
        if (localObject == null)
          break;
        return new BitmapDrawable(paramContext.getResources(), BitmapFactory.decodeStream((InputStream)localObject));
      }
      catch (Exception localException)
      {
        Log.w("IconCompat", "Unable to load image from URI: " + localUri, localException);
        localObject = null;
        continue;
      }
      try
      {
        localObject = new FileInputStream(new File((String)this.mObj1));
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        Log.w("IconCompat", "Unable to load image from path: " + localUri, localFileNotFoundException);
        localObject = null;
      }
    }
  }

  private static String typeToString(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "UNKNOWN";
    case 1:
      return "BITMAP";
    case 5:
      return "BITMAP_MASKABLE";
    case 3:
      return "DATA";
    case 2:
      return "RESOURCE";
    case 4:
    }
    return "URI";
  }

  public void addToShortcutIntent(Intent paramIntent, Drawable paramDrawable, Context paramContext)
  {
    checkResource(paramContext);
    switch (this.mType)
    {
    case 3:
    case 4:
    default:
      throw new IllegalArgumentException("Icon type not supported for intent shortcuts");
    case 1:
      localObject = (Bitmap)this.mObj1;
      if (paramDrawable == null)
        break;
    case 5:
      for (localObject = ((Bitmap)localObject).copy(((Bitmap)localObject).getConfig(), true); ; localObject = createLegacyIconFromAdaptiveIcon((Bitmap)this.mObj1, true))
      {
        if (paramDrawable != null)
        {
          int j = ((Bitmap)localObject).getWidth();
          int k = ((Bitmap)localObject).getHeight();
          paramDrawable.setBounds(j / 2, k / 2, j, k);
          paramDrawable.draw(new Canvas((Bitmap)localObject));
        }
        paramIntent.putExtra("android.intent.extra.shortcut.ICON", (Parcelable)localObject);
        return;
      }
    case 2:
    }
    Context localContext;
    try
    {
      localContext = paramContext.createPackageContext(getResPackage(), 0);
      if (paramDrawable == null)
      {
        paramIntent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(localContext, this.mInt1));
        return;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      throw new IllegalArgumentException("Can't find package " + this.mObj1, localNameNotFoundException);
    }
    Drawable localDrawable = ContextCompat.getDrawable(localContext, this.mInt1);
    int i;
    if ((localDrawable.getIntrinsicWidth() <= 0) || (localDrawable.getIntrinsicHeight() <= 0))
      i = ((ActivityManager)localContext.getSystemService("activity")).getLauncherLargeIconSize();
    Bitmap localBitmap;
    for (Object localObject = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888); ; localObject = localBitmap)
    {
      localDrawable.setBounds(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      localDrawable.draw(new Canvas((Bitmap)localObject));
      break;
      localBitmap = Bitmap.createBitmap(localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
    }
  }

  public void checkResource(Context paramContext)
  {
    String str1;
    if (this.mType == 2)
    {
      str1 = (String)this.mObj1;
      if (str1.contains(":"))
        break label27;
    }
    label27: String str4;
    String str5;
    int i;
    do
    {
      return;
      String str2 = str1.split(":", -1)[1];
      String str3 = str2.split("/", -1)[0];
      str4 = str2.split("/", -1)[1];
      str5 = str1.split(":", -1)[0];
      i = getResources(paramContext, str5).getIdentifier(str4, str3, str5);
    }
    while (this.mInt1 == i);
    Log.i("IconCompat", "Id has changed for " + str5 + "/" + str4);
    this.mInt1 = i;
  }

  public int getResId()
  {
    if ((this.mType == -1) && (Build.VERSION.SDK_INT >= 23))
      return getResId((Icon)this.mObj1);
    if (this.mType != 2)
      throw new IllegalStateException("called getResId() on " + this);
    return this.mInt1;
  }

  public String getResPackage()
  {
    if ((this.mType == -1) && (Build.VERSION.SDK_INT >= 23))
      return getResPackage((Icon)this.mObj1);
    if (this.mType != 2)
      throw new IllegalStateException("called getResPackage() on " + this);
    return ((String)this.mObj1).split(":", -1)[0];
  }

  public int getType()
  {
    if ((this.mType == -1) && (Build.VERSION.SDK_INT >= 23))
      return getType((Icon)this.mObj1);
    return this.mType;
  }

  public Uri getUri()
  {
    if ((this.mType == -1) && (Build.VERSION.SDK_INT >= 23))
      return getUri((Icon)this.mObj1);
    return Uri.parse((String)this.mObj1);
  }

  public Drawable loadDrawable(Context paramContext)
  {
    checkResource(paramContext);
    Drawable localDrawable;
    if (Build.VERSION.SDK_INT >= 23)
      localDrawable = toIcon().loadDrawable(paramContext);
    do
    {
      return localDrawable;
      localDrawable = loadDrawableInner(paramContext);
    }
    while ((localDrawable == null) || ((this.mTintList == null) && (this.mTintMode == DEFAULT_TINT_MODE)));
    localDrawable.mutate();
    DrawableCompat.setTintList(localDrawable, this.mTintList);
    DrawableCompat.setTintMode(localDrawable, this.mTintMode);
    return localDrawable;
  }

  public void onPostParceling()
  {
    this.mTintMode = PorterDuff.Mode.valueOf(this.mTintModeStr);
    switch (this.mType)
    {
    case 0:
    default:
      return;
    case -1:
      if (this.mParcelable != null)
      {
        this.mObj1 = this.mParcelable;
        return;
      }
      throw new IllegalArgumentException("Invalid icon");
    case 1:
    case 5:
      if (this.mParcelable != null)
      {
        this.mObj1 = this.mParcelable;
        return;
      }
      this.mObj1 = this.mData;
      this.mType = 3;
      this.mInt1 = 0;
      this.mInt2 = this.mData.length;
      return;
    case 2:
    case 4:
      this.mObj1 = new String(this.mData, Charset.forName("UTF-16"));
      return;
    case 3:
    }
    this.mObj1 = this.mData;
  }

  public void onPreParceling(boolean paramBoolean)
  {
    this.mTintModeStr = this.mTintMode.name();
    switch (this.mType)
    {
    case 0:
    default:
      return;
    case -1:
      if (paramBoolean)
        throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
      this.mParcelable = ((Parcelable)this.mObj1);
      return;
    case 1:
    case 5:
      if (paramBoolean)
      {
        Bitmap localBitmap = (Bitmap)this.mObj1;
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localBitmap.compress(Bitmap.CompressFormat.PNG, 90, localByteArrayOutputStream);
        this.mData = localByteArrayOutputStream.toByteArray();
        return;
      }
      this.mParcelable = ((Parcelable)this.mObj1);
      return;
    case 4:
      this.mData = this.mObj1.toString().getBytes(Charset.forName("UTF-16"));
      return;
    case 2:
      this.mData = ((String)this.mObj1).getBytes(Charset.forName("UTF-16"));
      return;
    case 3:
    }
    this.mData = ((byte[])this.mObj1);
  }

  public IconCompat setTint(int paramInt)
  {
    return setTintList(ColorStateList.valueOf(paramInt));
  }

  public IconCompat setTintList(ColorStateList paramColorStateList)
  {
    this.mTintList = paramColorStateList;
    return this;
  }

  public IconCompat setTintMode(PorterDuff.Mode paramMode)
  {
    this.mTintMode = paramMode;
    return this;
  }

  public Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    switch (this.mType)
    {
    case 0:
    default:
      throw new IllegalArgumentException("Invalid icon");
    case 1:
    case 5:
      localBundle.putParcelable("obj", (Bitmap)this.mObj1);
    case -1:
    case 2:
    case 4:
    case 3:
    }
    while (true)
    {
      localBundle.putInt("type", this.mType);
      localBundle.putInt("int1", this.mInt1);
      localBundle.putInt("int2", this.mInt2);
      if (this.mTintList != null)
        localBundle.putParcelable("tint_list", this.mTintList);
      if (this.mTintMode != DEFAULT_TINT_MODE)
        localBundle.putString("tint_mode", this.mTintMode.name());
      return localBundle;
      localBundle.putParcelable("obj", (Parcelable)this.mObj1);
      continue;
      localBundle.putString("obj", (String)this.mObj1);
      continue;
      localBundle.putByteArray("obj", (byte[])this.mObj1);
    }
  }

  public Icon toIcon()
  {
    Icon localIcon;
    switch (this.mType)
    {
    case 0:
    default:
      throw new IllegalArgumentException("Unknown type");
    case -1:
      localIcon = (Icon)this.mObj1;
      return localIcon;
    case 1:
      localIcon = Icon.createWithBitmap((Bitmap)this.mObj1);
    case 5:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      if (this.mTintList != null)
        localIcon.setTintList(this.mTintList);
      if (this.mTintMode == DEFAULT_TINT_MODE)
        break;
      localIcon.setTintMode(this.mTintMode);
      return localIcon;
      if (Build.VERSION.SDK_INT >= 26)
      {
        localIcon = Icon.createWithAdaptiveBitmap((Bitmap)this.mObj1);
      }
      else
      {
        localIcon = Icon.createWithBitmap(createLegacyIconFromAdaptiveIcon((Bitmap)this.mObj1, false));
        continue;
        localIcon = Icon.createWithResource(getResPackage(), this.mInt1);
        continue;
        localIcon = Icon.createWithData((byte[])this.mObj1, this.mInt1, this.mInt2);
        continue;
        localIcon = Icon.createWithContentUri((String)this.mObj1);
      }
    }
  }

  public String toString()
  {
    if (this.mType == -1)
      return String.valueOf(this.mObj1);
    StringBuilder localStringBuilder1 = new StringBuilder("Icon(typ=").append(typeToString(this.mType));
    switch (this.mType)
    {
    default:
    case 1:
    case 5:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      if (this.mTintList != null)
      {
        localStringBuilder1.append(" tint=");
        localStringBuilder1.append(this.mTintList);
      }
      if (this.mTintMode != DEFAULT_TINT_MODE)
        localStringBuilder1.append(" mode=").append(this.mTintMode);
      localStringBuilder1.append(")");
      return localStringBuilder1.toString();
      localStringBuilder1.append(" size=").append(((Bitmap)this.mObj1).getWidth()).append("x").append(((Bitmap)this.mObj1).getHeight());
      continue;
      StringBuilder localStringBuilder2 = localStringBuilder1.append(" pkg=").append(getResPackage()).append(" id=");
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(getResId());
      localStringBuilder2.append(String.format("0x%08x", arrayOfObject));
      continue;
      localStringBuilder1.append(" len=").append(this.mInt1);
      if (this.mInt2 != 0)
      {
        localStringBuilder1.append(" off=").append(this.mInt2);
        continue;
        localStringBuilder1.append(" uri=").append(this.mObj1);
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface IconType
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.graphics.drawable.IconCompat
 * JD-Core Version:    0.6.2
 */