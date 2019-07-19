package com.viber.svg.jni;

import android.graphics.Matrix;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonPictureRasterizationInfoStorage extends PictureRasterizationInfoStorage
{
  private static final String FIELD_PICTURES = "pic";
  private static final String FIELD_PICTURE_BITMAP_HEIGHT = "h";
  private static final String FIELD_PICTURE_BITMAP_WIDTH = "w";
  private static final String FIELD_PICTURE_RASTERIZE_MATRIX = "ram";
  private static final String FIELD_PICTURE_RENDER_MATRIX = "rem";
  private static final String FIELD_PREPARE_VIEWPORT_HEIGHT = "pvph";
  private static final String FIELD_PREPARE_VIEWPORT_WIDTH = "pvpw";
  private static final String FIELD_RASTERIZATION_VERSION = "v";
  private static final Logger L = Logger.create(JsonPictureRasterizationInfoStorage.class.getSimpleName());

  public JsonPictureRasterizationInfoStorage(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramString, paramInt1, paramInt2, paramInt3, "json");
  }

  private BitmapPictureRenderer.PictureRasterizationInfo[] internalLoad()
    throws IOException, JSONException
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.filename)));
    L.debug("Loading " + this.filename);
    JSONObject localJSONObject1 = new JSONObject(readFile(localBufferedReader));
    int i = localJSONObject1.getInt("v");
    int j = localJSONObject1.getInt("pvpw");
    int k = localJSONObject1.getInt("pvph");
    if ((i != this.rasterizationVersion) || (j != this.prepareViewportWidth) || (k != this.prepareViewportHeight))
    {
      L.debug("Rasterization info mismatch (v:" + i + ", " + "pvpw" + ": " + j + ", " + "pvph" + ": " + k + "), expected (" + "v" + ":" + this.rasterizationVersion + ", " + "pvpw" + ": " + this.prepareViewportWidth + ", " + "pvph" + ": " + this.prepareViewportHeight + ")");
      return null;
    }
    float[] arrayOfFloat = { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
    JSONArray localJSONArray = localJSONObject1.getJSONArray("pic");
    BitmapPictureRenderer.PictureRasterizationInfo[] arrayOfPictureRasterizationInfo = new BitmapPictureRenderer.PictureRasterizationInfo[localJSONArray.length()];
    for (int m = 0; m < arrayOfPictureRasterizationInfo.length; m++)
      if (!localJSONArray.isNull(m))
      {
        JSONObject localJSONObject2 = localJSONArray.getJSONObject(m);
        arrayOfPictureRasterizationInfo[m] = new BitmapPictureRenderer.PictureRasterizationInfo(localJSONObject2.getInt("w"), localJSONObject2.getInt("h"), readMatrix(localJSONObject2.getJSONArray("ram"), arrayOfFloat), readMatrix(localJSONObject2.getJSONArray("rem"), arrayOfFloat));
      }
    return arrayOfPictureRasterizationInfo;
  }

  private void internalSave(BitmapPictureRenderer.PictureRasterizationInfo[] paramArrayOfPictureRasterizationInfo)
    throws IOException, JSONException
  {
    OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(new FileOutputStream(this.filename));
    L.debug("infos.length: " + paramArrayOfPictureRasterizationInfo.length);
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("v", this.rasterizationVersion);
    localJSONObject1.put("pvpw", this.prepareViewportWidth);
    localJSONObject1.put("pvph", this.prepareViewportHeight);
    float[] arrayOfFloat = { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
    JSONArray localJSONArray = new JSONArray();
    for (int i = 0; i < paramArrayOfPictureRasterizationInfo.length; i++)
    {
      BitmapPictureRenderer.PictureRasterizationInfo localPictureRasterizationInfo = paramArrayOfPictureRasterizationInfo[i];
      JSONObject localJSONObject2 = null;
      if (localPictureRasterizationInfo != null)
      {
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("w", localPictureRasterizationInfo.bitmapWidth);
        localJSONObject2.put("h", localPictureRasterizationInfo.bitmapHeight);
        localJSONObject2.put("ram", jsonizeMatrix(localPictureRasterizationInfo.rasterizeMatrix, arrayOfFloat));
        localJSONObject2.put("rem", jsonizeMatrix(localPictureRasterizationInfo.renderMatrix, arrayOfFloat));
      }
      localJSONArray.put(i, localJSONObject2);
    }
    localJSONObject1.put("pic", localJSONArray);
    localOutputStreamWriter.write(localJSONObject1.toString(2));
    localOutputStreamWriter.close();
  }

  private JSONArray jsonizeMatrix(Matrix paramMatrix, float[] paramArrayOfFloat)
    throws JSONException
  {
    paramMatrix.getValues(paramArrayOfFloat);
    JSONArray localJSONArray = new JSONArray();
    for (int i = 0; i < 6; i++)
      localJSONArray.put(i, paramArrayOfFloat[i]);
    return localJSONArray;
  }

  private Matrix readMatrix(JSONArray paramJSONArray, float[] paramArrayOfFloat)
    throws JSONException
  {
    for (int i = 0; i < 6; i++)
      paramArrayOfFloat[i] = ((float)paramJSONArray.getDouble(i));
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(paramArrayOfFloat);
    return localMatrix;
  }

  public BitmapPictureRenderer.PictureRasterizationInfo[] load()
    throws IOException
  {
    try
    {
      BitmapPictureRenderer.PictureRasterizationInfo[] arrayOfPictureRasterizationInfo = internalLoad();
      return arrayOfPictureRasterizationInfo;
    }
    catch (JSONException localJSONException)
    {
      throw new IOException("json error", localJSONException);
    }
  }

  public void save(BitmapPictureRenderer.PictureRasterizationInfo[] paramArrayOfPictureRasterizationInfo)
    throws IOException
  {
    try
    {
      internalSave(paramArrayOfPictureRasterizationInfo);
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new IOException("json error", localJSONException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.JsonPictureRasterizationInfoStorage
 * JD-Core Version:    0.6.2
 */