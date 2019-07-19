package android.support.v4.print;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.CancellationSignal.OnCancelListener;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintAttributes.Builder;
import android.print.PrintAttributes.Margins;
import android.print.PrintAttributes.MediaSize;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentAdapter.WriteResultCallback;
import android.print.PrintDocumentInfo;
import android.print.PrintDocumentInfo.Builder;
import android.print.PrintManager;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class PrintHelper
{

  @SuppressLint({"InlinedApi"})
  public static final int COLOR_MODE_COLOR = 2;

  @SuppressLint({"InlinedApi"})
  public static final int COLOR_MODE_MONOCHROME = 1;
  static final boolean IS_MIN_MARGINS_HANDLING_CORRECT = false;
  private static final String LOG_TAG = "PrintHelper";
  private static final int MAX_PRINT_SIZE = 3500;
  public static final int ORIENTATION_LANDSCAPE = 1;
  public static final int ORIENTATION_PORTRAIT = 2;
  static final boolean PRINT_ACTIVITY_RESPECTS_ORIENTATION = false;
  public static final int SCALE_MODE_FILL = 2;
  public static final int SCALE_MODE_FIT = 1;
  int mColorMode = 2;
  final Context mContext;
  BitmapFactory.Options mDecodeOptions = null;
  final Object mLock = new Object();
  int mOrientation = 1;
  int mScaleMode = 2;

  static
  {
    boolean bool1 = true;
    boolean bool2;
    if ((Build.VERSION.SDK_INT < 20) || (Build.VERSION.SDK_INT > 23))
    {
      bool2 = bool1;
      PRINT_ACTIVITY_RESPECTS_ORIENTATION = bool2;
      if (Build.VERSION.SDK_INT == 23)
        break label42;
    }
    while (true)
    {
      IS_MIN_MARGINS_HANDLING_CORRECT = bool1;
      return;
      bool2 = false;
      break;
      label42: bool1 = false;
    }
  }

  public PrintHelper(Context paramContext)
  {
    this.mContext = paramContext;
  }

  static Bitmap convertBitmapForColorMode(Bitmap paramBitmap, int paramInt)
  {
    if (paramInt != 1)
      return paramBitmap;
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    ColorMatrix localColorMatrix = new ColorMatrix();
    localColorMatrix.setSaturation(0.0F);
    localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    localCanvas.setBitmap(null);
    return localBitmap;
  }

  private static PrintAttributes.Builder copyAttributes(PrintAttributes paramPrintAttributes)
  {
    PrintAttributes.Builder localBuilder = new PrintAttributes.Builder().setMediaSize(paramPrintAttributes.getMediaSize()).setResolution(paramPrintAttributes.getResolution()).setMinMargins(paramPrintAttributes.getMinMargins());
    if (paramPrintAttributes.getColorMode() != 0)
      localBuilder.setColorMode(paramPrintAttributes.getColorMode());
    if ((Build.VERSION.SDK_INT >= 23) && (paramPrintAttributes.getDuplexMode() != 0))
      localBuilder.setDuplexMode(paramPrintAttributes.getDuplexMode());
    return localBuilder;
  }

  static Matrix getMatrix(int paramInt1, int paramInt2, RectF paramRectF, int paramInt3)
  {
    Matrix localMatrix = new Matrix();
    float f1 = paramRectF.width() / paramInt1;
    if (paramInt3 == 2);
    for (float f2 = Math.max(f1, paramRectF.height() / paramInt2); ; f2 = Math.min(f1, paramRectF.height() / paramInt2))
    {
      localMatrix.postScale(f2, f2);
      localMatrix.postTranslate((paramRectF.width() - f2 * paramInt1) / 2.0F, (paramRectF.height() - f2 * paramInt2) / 2.0F);
      return localMatrix;
    }
  }

  static boolean isPortrait(Bitmap paramBitmap)
  {
    return paramBitmap.getWidth() <= paramBitmap.getHeight();
  }

  private Bitmap loadBitmap(Uri paramUri, BitmapFactory.Options paramOptions)
    throws FileNotFoundException
  {
    InputStream localInputStream = null;
    if ((paramUri == null) || (this.mContext == null))
      throw new IllegalArgumentException("bad argument to loadBitmap");
    try
    {
      localInputStream = this.mContext.getContentResolver().openInputStream(paramUri);
      Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream, null, paramOptions);
      if (localInputStream != null);
      try
      {
        localInputStream.close();
        return localBitmap;
      }
      catch (IOException localIOException2)
      {
        Log.w("PrintHelper", "close fail ", localIOException2);
        return localBitmap;
      }
    }
    finally
    {
      if (localInputStream == null);
    }
    try
    {
      localInputStream.close();
      throw localObject;
    }
    catch (IOException localIOException1)
    {
      while (true)
        Log.w("PrintHelper", "close fail ", localIOException1);
    }
  }

  public static boolean systemSupportsPrint()
  {
    return Build.VERSION.SDK_INT >= 19;
  }

  public int getColorMode()
  {
    return this.mColorMode;
  }

  public int getOrientation()
  {
    if ((Build.VERSION.SDK_INT >= 19) && (this.mOrientation == 0))
      return 1;
    return this.mOrientation;
  }

  public int getScaleMode()
  {
    return this.mScaleMode;
  }

  // ERROR //
  Bitmap loadConstrainedBitmap(Uri paramUri)
    throws FileNotFoundException
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_1
    //   3: ifnull +10 -> 13
    //   6: aload_0
    //   7: getfield 62	android/support/v4/print/PrintHelper:mContext	Landroid/content/Context;
    //   10: ifnonnull +13 -> 23
    //   13: new 198	java/lang/IllegalArgumentException
    //   16: dup
    //   17: ldc 242
    //   19: invokespecial 203	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   22: athrow
    //   23: new 244	android/graphics/BitmapFactory$Options
    //   26: dup
    //   27: invokespecial 245	android/graphics/BitmapFactory$Options:<init>	()V
    //   30: astore_3
    //   31: aload_3
    //   32: iload_2
    //   33: putfield 248	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   36: aload_0
    //   37: aload_1
    //   38: aload_3
    //   39: invokespecial 250	android/support/v4/print/PrintHelper:loadBitmap	(Landroid/net/Uri;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   42: pop
    //   43: aload_3
    //   44: getfield 253	android/graphics/BitmapFactory$Options:outWidth	I
    //   47: istore 5
    //   49: aload_3
    //   50: getfield 256	android/graphics/BitmapFactory$Options:outHeight	I
    //   53: istore 6
    //   55: iload 5
    //   57: ifle +8 -> 65
    //   60: iload 6
    //   62: ifgt +5 -> 67
    //   65: aconst_null
    //   66: areturn
    //   67: iload 5
    //   69: iload 6
    //   71: invokestatic 259	java/lang/Math:max	(II)I
    //   74: istore 7
    //   76: iload 7
    //   78: sipush 3500
    //   81: if_icmple +16 -> 97
    //   84: iload 7
    //   86: iconst_1
    //   87: iushr
    //   88: istore 7
    //   90: iload_2
    //   91: iconst_1
    //   92: ishl
    //   93: istore_2
    //   94: goto -18 -> 76
    //   97: iload_2
    //   98: ifle -33 -> 65
    //   101: iload 5
    //   103: iload 6
    //   105: invokestatic 261	java/lang/Math:min	(II)I
    //   108: iload_2
    //   109: idiv
    //   110: ifle -45 -> 65
    //   113: aload_0
    //   114: getfield 54	android/support/v4/print/PrintHelper:mLock	Ljava/lang/Object;
    //   117: astore 8
    //   119: aload 8
    //   121: monitorenter
    //   122: aload_0
    //   123: new 244	android/graphics/BitmapFactory$Options
    //   126: dup
    //   127: invokespecial 245	android/graphics/BitmapFactory$Options:<init>	()V
    //   130: putfield 52	android/support/v4/print/PrintHelper:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   133: aload_0
    //   134: getfield 52	android/support/v4/print/PrintHelper:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   137: iconst_1
    //   138: putfield 264	android/graphics/BitmapFactory$Options:inMutable	Z
    //   141: aload_0
    //   142: getfield 52	android/support/v4/print/PrintHelper:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   145: iload_2
    //   146: putfield 267	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   149: aload_0
    //   150: getfield 52	android/support/v4/print/PrintHelper:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   153: astore 10
    //   155: aload 8
    //   157: monitorexit
    //   158: aload_0
    //   159: aload_1
    //   160: aload 10
    //   162: invokespecial 250	android/support/v4/print/PrintHelper:loadBitmap	(Landroid/net/Uri;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   165: astore 14
    //   167: aload_0
    //   168: getfield 54	android/support/v4/print/PrintHelper:mLock	Ljava/lang/Object;
    //   171: astore 15
    //   173: aload 15
    //   175: monitorenter
    //   176: aload_0
    //   177: aconst_null
    //   178: putfield 52	android/support/v4/print/PrintHelper:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   181: aload 15
    //   183: monitorexit
    //   184: aload 14
    //   186: areturn
    //   187: astore 16
    //   189: aload 15
    //   191: monitorexit
    //   192: aload 16
    //   194: athrow
    //   195: astore 9
    //   197: aload 8
    //   199: monitorexit
    //   200: aload 9
    //   202: athrow
    //   203: astore 11
    //   205: aload_0
    //   206: getfield 54	android/support/v4/print/PrintHelper:mLock	Ljava/lang/Object;
    //   209: astore 12
    //   211: aload 12
    //   213: monitorenter
    //   214: aload_0
    //   215: aconst_null
    //   216: putfield 52	android/support/v4/print/PrintHelper:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   219: aload 12
    //   221: monitorexit
    //   222: aload 11
    //   224: athrow
    //   225: astore 13
    //   227: aload 12
    //   229: monitorexit
    //   230: aload 13
    //   232: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   176	184	187	finally
    //   189	192	187	finally
    //   122	158	195	finally
    //   197	200	195	finally
    //   158	167	203	finally
    //   214	222	225	finally
    //   227	230	225	finally
  }

  public void printBitmap(String paramString, Bitmap paramBitmap)
  {
    printBitmap(paramString, paramBitmap, null);
  }

  public void printBitmap(String paramString, Bitmap paramBitmap, OnPrintFinishCallback paramOnPrintFinishCallback)
  {
    if ((Build.VERSION.SDK_INT < 19) || (paramBitmap == null))
      return;
    PrintManager localPrintManager = (PrintManager)this.mContext.getSystemService("print");
    if (isPortrait(paramBitmap));
    for (PrintAttributes.MediaSize localMediaSize = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT; ; localMediaSize = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE)
    {
      PrintAttributes localPrintAttributes = new PrintAttributes.Builder().setMediaSize(localMediaSize).setColorMode(this.mColorMode).build();
      localPrintManager.print(paramString, new PrintBitmapAdapter(paramString, this.mScaleMode, paramBitmap, paramOnPrintFinishCallback), localPrintAttributes);
      return;
    }
  }

  public void printBitmap(String paramString, Uri paramUri)
    throws FileNotFoundException
  {
    printBitmap(paramString, paramUri, null);
  }

  public void printBitmap(String paramString, Uri paramUri, OnPrintFinishCallback paramOnPrintFinishCallback)
    throws FileNotFoundException
  {
    if (Build.VERSION.SDK_INT < 19)
      return;
    PrintUriAdapter localPrintUriAdapter = new PrintUriAdapter(paramString, paramUri, paramOnPrintFinishCallback, this.mScaleMode);
    PrintManager localPrintManager = (PrintManager)this.mContext.getSystemService("print");
    PrintAttributes.Builder localBuilder = new PrintAttributes.Builder();
    localBuilder.setColorMode(this.mColorMode);
    if ((this.mOrientation == 1) || (this.mOrientation == 0))
      localBuilder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
    while (true)
    {
      localPrintManager.print(paramString, localPrintUriAdapter, localBuilder.build());
      return;
      if (this.mOrientation == 2)
        localBuilder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
    }
  }

  public void setColorMode(int paramInt)
  {
    this.mColorMode = paramInt;
  }

  public void setOrientation(int paramInt)
  {
    this.mOrientation = paramInt;
  }

  public void setScaleMode(int paramInt)
  {
    this.mScaleMode = paramInt;
  }

  void writeBitmap(final PrintAttributes paramPrintAttributes, final int paramInt, final Bitmap paramBitmap, final ParcelFileDescriptor paramParcelFileDescriptor, final CancellationSignal paramCancellationSignal, final PrintDocumentAdapter.WriteResultCallback paramWriteResultCallback)
  {
    if (IS_MIN_MARGINS_HANDLING_CORRECT);
    for (final PrintAttributes localPrintAttributes = paramPrintAttributes; ; localPrintAttributes = copyAttributes(paramPrintAttributes).setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build())
    {
      new AsyncTask()
      {
        // ERROR //
        protected Throwable doInBackground(Void[] paramAnonymousArrayOfVoid)
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 31	android/support/v4/print/PrintHelper$1:val$cancellationSignal	Landroid/os/CancellationSignal;
          //   4: invokevirtual 63	android/os/CancellationSignal:isCanceled	()Z
          //   7: ifeq +5 -> 12
          //   10: aconst_null
          //   11: areturn
          //   12: new 65	android/print/pdf/PrintedPdfDocument
          //   15: dup
          //   16: aload_0
          //   17: getfield 29	android/support/v4/print/PrintHelper$1:this$0	Landroid/support/v4/print/PrintHelper;
          //   20: getfield 69	android/support/v4/print/PrintHelper:mContext	Landroid/content/Context;
          //   23: aload_0
          //   24: getfield 33	android/support/v4/print/PrintHelper$1:val$pdfAttributes	Landroid/print/PrintAttributes;
          //   27: invokespecial 72	android/print/pdf/PrintedPdfDocument:<init>	(Landroid/content/Context;Landroid/print/PrintAttributes;)V
          //   30: astore_3
          //   31: aload_0
          //   32: getfield 35	android/support/v4/print/PrintHelper$1:val$bitmap	Landroid/graphics/Bitmap;
          //   35: aload_0
          //   36: getfield 33	android/support/v4/print/PrintHelper$1:val$pdfAttributes	Landroid/print/PrintAttributes;
          //   39: invokevirtual 78	android/print/PrintAttributes:getColorMode	()I
          //   42: invokestatic 82	android/support/v4/print/PrintHelper:convertBitmapForColorMode	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
          //   45: astore 4
          //   47: aload_0
          //   48: getfield 31	android/support/v4/print/PrintHelper$1:val$cancellationSignal	Landroid/os/CancellationSignal;
          //   51: invokevirtual 63	android/os/CancellationSignal:isCanceled	()Z
          //   54: istore 5
          //   56: iload 5
          //   58: ifne +336 -> 394
          //   61: aload_3
          //   62: iconst_1
          //   63: invokevirtual 86	android/print/pdf/PrintedPdfDocument:startPage	(I)Landroid/graphics/pdf/PdfDocument$Page;
          //   66: astore 9
          //   68: getstatic 90	android/support/v4/print/PrintHelper:IS_MIN_MARGINS_HANDLING_CORRECT	Z
          //   71: ifeq +121 -> 192
          //   74: new 92	android/graphics/RectF
          //   77: dup
          //   78: aload 9
          //   80: invokevirtual 98	android/graphics/pdf/PdfDocument$Page:getInfo	()Landroid/graphics/pdf/PdfDocument$PageInfo;
          //   83: invokevirtual 104	android/graphics/pdf/PdfDocument$PageInfo:getContentRect	()Landroid/graphics/Rect;
          //   86: invokespecial 107	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
          //   89: astore 10
          //   91: aload 4
          //   93: invokevirtual 112	android/graphics/Bitmap:getWidth	()I
          //   96: aload 4
          //   98: invokevirtual 115	android/graphics/Bitmap:getHeight	()I
          //   101: aload 10
          //   103: aload_0
          //   104: getfield 39	android/support/v4/print/PrintHelper$1:val$fittingMode	I
          //   107: invokestatic 119	android/support/v4/print/PrintHelper:getMatrix	(IILandroid/graphics/RectF;I)Landroid/graphics/Matrix;
          //   110: astore 11
          //   112: getstatic 90	android/support/v4/print/PrintHelper:IS_MIN_MARGINS_HANDLING_CORRECT	Z
          //   115: ifeq +178 -> 293
          //   118: aload 9
          //   120: invokevirtual 123	android/graphics/pdf/PdfDocument$Page:getCanvas	()Landroid/graphics/Canvas;
          //   123: aload 4
          //   125: aload 11
          //   127: aconst_null
          //   128: invokevirtual 129	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
          //   131: aload_3
          //   132: aload 9
          //   134: invokevirtual 133	android/print/pdf/PrintedPdfDocument:finishPage	(Landroid/graphics/pdf/PdfDocument$Page;)V
          //   137: aload_0
          //   138: getfield 31	android/support/v4/print/PrintHelper$1:val$cancellationSignal	Landroid/os/CancellationSignal;
          //   141: invokevirtual 63	android/os/CancellationSignal:isCanceled	()Z
          //   144: istore 12
          //   146: iload 12
          //   148: ifeq +175 -> 323
          //   151: aload_3
          //   152: invokevirtual 136	android/print/pdf/PrintedPdfDocument:close	()V
          //   155: aload_0
          //   156: getfield 41	android/support/v4/print/PrintHelper$1:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
          //   159: astore 15
          //   161: aload 15
          //   163: ifnull +10 -> 173
          //   166: aload_0
          //   167: getfield 41	android/support/v4/print/PrintHelper$1:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
          //   170: invokevirtual 139	android/os/ParcelFileDescriptor:close	()V
          //   173: aload 4
          //   175: aload_0
          //   176: getfield 35	android/support/v4/print/PrintHelper$1:val$bitmap	Landroid/graphics/Bitmap;
          //   179: if_acmpeq +215 -> 394
          //   182: aload 4
          //   184: invokevirtual 142	android/graphics/Bitmap:recycle	()V
          //   187: aconst_null
          //   188: areturn
          //   189: astore_2
          //   190: aload_2
          //   191: areturn
          //   192: new 65	android/print/pdf/PrintedPdfDocument
          //   195: dup
          //   196: aload_0
          //   197: getfield 29	android/support/v4/print/PrintHelper$1:this$0	Landroid/support/v4/print/PrintHelper;
          //   200: getfield 69	android/support/v4/print/PrintHelper:mContext	Landroid/content/Context;
          //   203: aload_0
          //   204: getfield 37	android/support/v4/print/PrintHelper$1:val$attributes	Landroid/print/PrintAttributes;
          //   207: invokespecial 72	android/print/pdf/PrintedPdfDocument:<init>	(Landroid/content/Context;Landroid/print/PrintAttributes;)V
          //   210: astore 19
          //   212: aload 19
          //   214: iconst_1
          //   215: invokevirtual 86	android/print/pdf/PrintedPdfDocument:startPage	(I)Landroid/graphics/pdf/PdfDocument$Page;
          //   218: astore 20
          //   220: new 92	android/graphics/RectF
          //   223: dup
          //   224: aload 20
          //   226: invokevirtual 98	android/graphics/pdf/PdfDocument$Page:getInfo	()Landroid/graphics/pdf/PdfDocument$PageInfo;
          //   229: invokevirtual 104	android/graphics/pdf/PdfDocument$PageInfo:getContentRect	()Landroid/graphics/Rect;
          //   232: invokespecial 107	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
          //   235: astore 10
          //   237: aload 19
          //   239: aload 20
          //   241: invokevirtual 133	android/print/pdf/PrintedPdfDocument:finishPage	(Landroid/graphics/pdf/PdfDocument$Page;)V
          //   244: aload 19
          //   246: invokevirtual 136	android/print/pdf/PrintedPdfDocument:close	()V
          //   249: goto -158 -> 91
          //   252: astore 6
          //   254: aload_3
          //   255: invokevirtual 136	android/print/pdf/PrintedPdfDocument:close	()V
          //   258: aload_0
          //   259: getfield 41	android/support/v4/print/PrintHelper$1:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
          //   262: astore 7
          //   264: aload 7
          //   266: ifnull +10 -> 276
          //   269: aload_0
          //   270: getfield 41	android/support/v4/print/PrintHelper$1:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
          //   273: invokevirtual 139	android/os/ParcelFileDescriptor:close	()V
          //   276: aload 4
          //   278: aload_0
          //   279: getfield 35	android/support/v4/print/PrintHelper$1:val$bitmap	Landroid/graphics/Bitmap;
          //   282: if_acmpeq +8 -> 290
          //   285: aload 4
          //   287: invokevirtual 142	android/graphics/Bitmap:recycle	()V
          //   290: aload 6
          //   292: athrow
          //   293: aload 11
          //   295: aload 10
          //   297: getfield 146	android/graphics/RectF:left	F
          //   300: aload 10
          //   302: getfield 149	android/graphics/RectF:top	F
          //   305: invokevirtual 155	android/graphics/Matrix:postTranslate	(FF)Z
          //   308: pop
          //   309: aload 9
          //   311: invokevirtual 123	android/graphics/pdf/PdfDocument$Page:getCanvas	()Landroid/graphics/Canvas;
          //   314: aload 10
          //   316: invokevirtual 159	android/graphics/Canvas:clipRect	(Landroid/graphics/RectF;)Z
          //   319: pop
          //   320: goto -202 -> 118
          //   323: aload_3
          //   324: new 161	java/io/FileOutputStream
          //   327: dup
          //   328: aload_0
          //   329: getfield 41	android/support/v4/print/PrintHelper$1:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
          //   332: invokevirtual 165	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
          //   335: invokespecial 168	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
          //   338: invokevirtual 172	android/print/pdf/PrintedPdfDocument:writeTo	(Ljava/io/OutputStream;)V
          //   341: aload_3
          //   342: invokevirtual 136	android/print/pdf/PrintedPdfDocument:close	()V
          //   345: aload_0
          //   346: getfield 41	android/support/v4/print/PrintHelper$1:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
          //   349: astore 13
          //   351: aload 13
          //   353: ifnull +10 -> 363
          //   356: aload_0
          //   357: getfield 41	android/support/v4/print/PrintHelper$1:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
          //   360: invokevirtual 139	android/os/ParcelFileDescriptor:close	()V
          //   363: aload 4
          //   365: aload_0
          //   366: getfield 35	android/support/v4/print/PrintHelper$1:val$bitmap	Landroid/graphics/Bitmap;
          //   369: if_acmpeq +25 -> 394
          //   372: aload 4
          //   374: invokevirtual 142	android/graphics/Bitmap:recycle	()V
          //   377: aconst_null
          //   378: areturn
          //   379: astore 8
          //   381: goto -105 -> 276
          //   384: astore 14
          //   386: goto -23 -> 363
          //   389: astore 16
          //   391: goto -218 -> 173
          //   394: aconst_null
          //   395: areturn
          //
          // Exception table:
          //   from	to	target	type
          //   0	10	189	java/lang/Throwable
          //   12	56	189	java/lang/Throwable
          //   151	161	189	java/lang/Throwable
          //   166	173	189	java/lang/Throwable
          //   173	187	189	java/lang/Throwable
          //   254	264	189	java/lang/Throwable
          //   269	276	189	java/lang/Throwable
          //   276	290	189	java/lang/Throwable
          //   290	293	189	java/lang/Throwable
          //   341	351	189	java/lang/Throwable
          //   356	363	189	java/lang/Throwable
          //   363	377	189	java/lang/Throwable
          //   61	91	252	finally
          //   91	118	252	finally
          //   118	146	252	finally
          //   192	249	252	finally
          //   293	320	252	finally
          //   323	341	252	finally
          //   269	276	379	java/io/IOException
          //   356	363	384	java/io/IOException
          //   166	173	389	java/io/IOException
        }

        protected void onPostExecute(Throwable paramAnonymousThrowable)
        {
          if (paramCancellationSignal.isCanceled())
          {
            paramWriteResultCallback.onWriteCancelled();
            return;
          }
          if (paramAnonymousThrowable == null)
          {
            PrintDocumentAdapter.WriteResultCallback localWriteResultCallback = paramWriteResultCallback;
            PageRange[] arrayOfPageRange = new PageRange[1];
            arrayOfPageRange[0] = PageRange.ALL_PAGES;
            localWriteResultCallback.onWriteFinished(arrayOfPageRange);
            return;
          }
          Log.e("PrintHelper", "Error writing printed content", paramAnonymousThrowable);
          paramWriteResultCallback.onWriteFailed(null);
        }
      }
      .execute(new Void[0]);
      return;
    }
  }

  public static abstract interface OnPrintFinishCallback
  {
    public abstract void onFinish();
  }

  private class PrintBitmapAdapter extends PrintDocumentAdapter
  {
    private PrintAttributes mAttributes;
    private final Bitmap mBitmap;
    private final PrintHelper.OnPrintFinishCallback mCallback;
    private final int mFittingMode;
    private final String mJobName;

    PrintBitmapAdapter(String paramInt, int paramBitmap, Bitmap paramOnPrintFinishCallback, PrintHelper.OnPrintFinishCallback arg5)
    {
      this.mJobName = paramInt;
      this.mFittingMode = paramBitmap;
      this.mBitmap = paramOnPrintFinishCallback;
      Object localObject;
      this.mCallback = localObject;
    }

    public void onFinish()
    {
      if (this.mCallback != null)
        this.mCallback.onFinish();
    }

    public void onLayout(PrintAttributes paramPrintAttributes1, PrintAttributes paramPrintAttributes2, CancellationSignal paramCancellationSignal, PrintDocumentAdapter.LayoutResultCallback paramLayoutResultCallback, Bundle paramBundle)
    {
      int i = 1;
      this.mAttributes = paramPrintAttributes2;
      PrintDocumentInfo localPrintDocumentInfo = new PrintDocumentInfo.Builder(this.mJobName).setContentType(i).setPageCount(i).build();
      if (!paramPrintAttributes2.equals(paramPrintAttributes1));
      while (true)
      {
        paramLayoutResultCallback.onLayoutFinished(localPrintDocumentInfo, i);
        return;
        int j = 0;
      }
    }

    public void onWrite(PageRange[] paramArrayOfPageRange, ParcelFileDescriptor paramParcelFileDescriptor, CancellationSignal paramCancellationSignal, PrintDocumentAdapter.WriteResultCallback paramWriteResultCallback)
    {
      PrintHelper.this.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, paramParcelFileDescriptor, paramCancellationSignal, paramWriteResultCallback);
    }
  }

  private class PrintUriAdapter extends PrintDocumentAdapter
  {
    PrintAttributes mAttributes;
    Bitmap mBitmap;
    final PrintHelper.OnPrintFinishCallback mCallback;
    final int mFittingMode;
    final Uri mImageFile;
    final String mJobName;
    AsyncTask<Uri, Boolean, Bitmap> mLoadBitmap;

    PrintUriAdapter(String paramUri, Uri paramOnPrintFinishCallback, PrintHelper.OnPrintFinishCallback paramInt, int arg5)
    {
      this.mJobName = paramUri;
      this.mImageFile = paramOnPrintFinishCallback;
      this.mCallback = paramInt;
      int i;
      this.mFittingMode = i;
      this.mBitmap = null;
    }

    void cancelLoad()
    {
      synchronized (PrintHelper.this.mLock)
      {
        if (PrintHelper.this.mDecodeOptions != null)
        {
          if (Build.VERSION.SDK_INT < 24)
            PrintHelper.this.mDecodeOptions.requestCancelDecode();
          PrintHelper.this.mDecodeOptions = null;
        }
        return;
      }
    }

    public void onFinish()
    {
      super.onFinish();
      cancelLoad();
      if (this.mLoadBitmap != null)
        this.mLoadBitmap.cancel(true);
      if (this.mCallback != null)
        this.mCallback.onFinish();
      if (this.mBitmap != null)
      {
        this.mBitmap.recycle();
        this.mBitmap = null;
      }
    }

    public void onLayout(final PrintAttributes paramPrintAttributes1, final PrintAttributes paramPrintAttributes2, final CancellationSignal paramCancellationSignal, final PrintDocumentAdapter.LayoutResultCallback paramLayoutResultCallback, Bundle paramBundle)
    {
      int i = 1;
      try
      {
        this.mAttributes = paramPrintAttributes2;
        if (paramCancellationSignal.isCanceled())
        {
          paramLayoutResultCallback.onLayoutCancelled();
          return;
        }
      }
      finally
      {
      }
      if (this.mBitmap != null)
      {
        PrintDocumentInfo localPrintDocumentInfo = new PrintDocumentInfo.Builder(this.mJobName).setContentType(i).setPageCount(i).build();
        if (!paramPrintAttributes2.equals(paramPrintAttributes1));
        while (true)
        {
          paramLayoutResultCallback.onLayoutFinished(localPrintDocumentInfo, i);
          return;
          int j = 0;
        }
      }
      this.mLoadBitmap = new AsyncTask()
      {
        protected Bitmap doInBackground(Uri[] paramAnonymousArrayOfUri)
        {
          try
          {
            Bitmap localBitmap = PrintHelper.this.loadConstrainedBitmap(PrintHelper.PrintUriAdapter.this.mImageFile);
            return localBitmap;
          }
          catch (FileNotFoundException localFileNotFoundException)
          {
          }
          return null;
        }

        protected void onCancelled(Bitmap paramAnonymousBitmap)
        {
          paramLayoutResultCallback.onLayoutCancelled();
          PrintHelper.PrintUriAdapter.this.mLoadBitmap = null;
        }

        protected void onPostExecute(Bitmap paramAnonymousBitmap)
        {
          int i = 1;
          super.onPostExecute(paramAnonymousBitmap);
          if ((paramAnonymousBitmap != null) && ((!PrintHelper.PRINT_ACTIVITY_RESPECTS_ORIENTATION) || (PrintHelper.this.mOrientation == 0)));
          while (true)
          {
            try
            {
              PrintAttributes.MediaSize localMediaSize = PrintHelper.PrintUriAdapter.this.mAttributes.getMediaSize();
              if ((localMediaSize != null) && (localMediaSize.isPortrait() != PrintHelper.isPortrait(paramAnonymousBitmap)))
              {
                Matrix localMatrix = new Matrix();
                localMatrix.postRotate(90.0F);
                int k = paramAnonymousBitmap.getWidth();
                int m = paramAnonymousBitmap.getHeight();
                paramAnonymousBitmap = Bitmap.createBitmap(paramAnonymousBitmap, 0, 0, k, m, localMatrix, i);
              }
              PrintHelper.PrintUriAdapter.this.mBitmap = paramAnonymousBitmap;
              if (paramAnonymousBitmap == null)
                break label188;
              PrintDocumentInfo localPrintDocumentInfo = new PrintDocumentInfo.Builder(PrintHelper.PrintUriAdapter.this.mJobName).setContentType(i).setPageCount(i).build();
              if (!paramPrintAttributes2.equals(paramPrintAttributes1))
              {
                paramLayoutResultCallback.onLayoutFinished(localPrintDocumentInfo, i);
                PrintHelper.PrintUriAdapter.this.mLoadBitmap = null;
                return;
              }
            }
            finally
            {
            }
            int j = 0;
            continue;
            label188: paramLayoutResultCallback.onLayoutFailed(null);
          }
        }

        protected void onPreExecute()
        {
          paramCancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener()
          {
            public void onCancel()
            {
              PrintHelper.PrintUriAdapter.this.cancelLoad();
              PrintHelper.PrintUriAdapter.1.this.cancel(false);
            }
          });
        }
      }
      .execute(new Uri[0]);
    }

    public void onWrite(PageRange[] paramArrayOfPageRange, ParcelFileDescriptor paramParcelFileDescriptor, CancellationSignal paramCancellationSignal, PrintDocumentAdapter.WriteResultCallback paramWriteResultCallback)
    {
      PrintHelper.this.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, paramParcelFileDescriptor, paramCancellationSignal, paramWriteResultCallback);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.print.PrintHelper
 * JD-Core Version:    0.6.2
 */