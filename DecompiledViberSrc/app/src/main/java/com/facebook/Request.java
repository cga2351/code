package com.facebook;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.location.Location;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Logger;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.model.GraphMultiResult;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObjectList;
import com.facebook.model.GraphPlace;
import com.facebook.model.GraphUser;
import com.facebook.model.OpenGraphAction;
import com.facebook.model.OpenGraphObject;
import com.facebook.model.OpenGraphObject.Factory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Request
{
  private static final String ACCEPT_LANGUAGE_HEADER = "Accept-Language";
  private static final String ACCESS_TOKEN_PARAM = "access_token";
  private static final String ATTACHED_FILES_PARAM = "attached_files";
  private static final String ATTACHMENT_FILENAME_PREFIX = "file";
  private static final String BATCH_APP_ID_PARAM = "batch_app_id";
  private static final String BATCH_BODY_PARAM = "body";
  private static final String BATCH_ENTRY_DEPENDS_ON_PARAM = "depends_on";
  private static final String BATCH_ENTRY_NAME_PARAM = "name";
  private static final String BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM = "omit_response_on_success";
  private static final String BATCH_METHOD_PARAM = "method";
  private static final String BATCH_PARAM = "batch";
  private static final String BATCH_RELATIVE_URL_PARAM = "relative_url";
  private static final String CONTENT_TYPE_HEADER = "Content-Type";
  private static final String FORMAT_JSON = "json";
  private static final String FORMAT_PARAM = "format";
  private static final String ISO_8601_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ssZ";
  public static final int MAXIMUM_BATCH_SIZE = 50;
  private static final String ME = "me";
  private static final String MIME_BOUNDARY = "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f";
  private static final String MY_ACTION_FORMAT = "me/%s";
  public static final String MY_FEED = "me/feed";
  private static final String MY_FRIENDS = "me/friends";
  private static final String MY_OBJECTS_FORMAT = "me/objects/%s";
  public static final String MY_PHOTOS = "me/photos";
  private static final String MY_STAGING_RESOURCES = "me/staging_resources";
  public static final String MY_VIDEOS = "me/videos";
  private static final String OBJECT_PARAM = "object";
  private static final String PICTURE_PARAM = "picture";
  private static final String SDK_ANDROID = "android";
  private static final String SDK_PARAM = "sdk";
  private static final String SEARCH = "search";
  private static final String STAGING_PARAM = "file";
  public static final String TAG = Request.class.getSimpleName();
  private static final String USER_AGENT_BASE = "FBAndroidSDK";
  private static final String USER_AGENT_HEADER = "User-Agent";
  private static final String VIDEOS_SUFFIX = "/videos";
  private static String defaultBatchApplicationId;
  private static volatile String userAgent;
  private static Pattern versionPattern = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
  private String batchEntryDependsOn;
  private String batchEntryName;
  private boolean batchEntryOmitResultOnSuccess = true;
  private Callback callback;
  private GraphObject graphObject;
  private String graphPath;
  private HttpMethod httpMethod;
  private String overriddenURL;
  private Bundle parameters;
  private Session session;
  private boolean skipClientToken = false;
  private Object tag;

  public Request()
  {
    this(null, null, null, null, null);
  }

  public Request(Session paramSession, String paramString)
  {
    this(paramSession, paramString, null, null, null);
  }

  public Request(Session paramSession, String paramString, Bundle paramBundle, HttpMethod paramHttpMethod)
  {
    this(paramSession, paramString, paramBundle, paramHttpMethod, null);
  }

  public Request(Session paramSession, String paramString, Bundle paramBundle, HttpMethod paramHttpMethod, Callback paramCallback)
  {
    this(paramSession, paramString, paramBundle, paramHttpMethod, paramCallback, null);
  }

  public Request(Session paramSession, String paramString1, Bundle paramBundle, HttpMethod paramHttpMethod, Callback paramCallback, String paramString2)
  {
    this.session = paramSession;
    this.graphPath = paramString1;
    this.callback = paramCallback;
    setHttpMethod(paramHttpMethod);
    if (paramBundle != null)
    {
      this.parameters = new Bundle(paramBundle);
      return;
    }
    this.parameters = new Bundle();
  }

  Request(Session paramSession, URL paramURL)
  {
    this.session = paramSession;
    this.overriddenURL = paramURL.toString();
    setHttpMethod(HttpMethod.GET);
    this.parameters = new Bundle();
  }

  private void addCommonParameters()
  {
    if (this.session != null)
    {
      if (!this.session.isOpened())
        throw new FacebookException("Session provided to a Request in un-opened state.");
      if (!this.parameters.containsKey("access_token"))
      {
        String str4 = this.session.getAccessToken();
        Logger.registerAccessToken(str4);
        this.parameters.putString("access_token", str4);
      }
    }
    while (true)
    {
      this.parameters.putString("sdk", "android");
      this.parameters.putString("format", "json");
      return;
      if ((!this.skipClientToken) && (!this.parameters.containsKey("access_token")))
      {
        String str1 = Settings.getApplicationId();
        String str2 = Settings.getClientToken();
        if ((!Utility.isNullOrEmpty(str1)) && (!Utility.isNullOrEmpty(str2)))
        {
          String str3 = str1 + "|" + str2;
          this.parameters.putString("access_token", str3);
        }
        else
        {
          Log.d(TAG, "Warning: Sessionless Request needs token but missing either application ID or client token.");
        }
      }
    }
  }

  private String appendParametersToBaseUrl(String paramString)
  {
    Uri.Builder localBuilder = new Uri.Builder().encodedPath(paramString);
    Iterator localIterator = this.parameters.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = this.parameters.get(str);
      if (localObject == null)
        localObject = "";
      if (isSupportedParameterType(localObject))
      {
        localBuilder.appendQueryParameter(str, parameterToString(localObject).toString());
      }
      else if (this.httpMethod == HttpMethod.GET)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = localObject.getClass().getSimpleName();
        throw new IllegalArgumentException(String.format("Unsupported parameter type for GET request: %s", arrayOfObject));
      }
    }
    return localBuilder.toString();
  }

  static HttpURLConnection createConnection(URL paramURL)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramURL.openConnection();
    localHttpURLConnection.setRequestProperty("User-Agent", getUserAgent());
    localHttpURLConnection.setRequestProperty("Content-Type", getMimeContentType());
    localHttpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().toString());
    localHttpURLConnection.setChunkedStreamingMode(0);
    return localHttpURLConnection;
  }

  public static Response executeAndWait(Request paramRequest)
  {
    List localList = executeBatchAndWait(new Request[] { paramRequest });
    if ((localList == null) || (localList.size() != 1))
      throw new FacebookException("invalid state: expected a single response");
    return (Response)localList.get(0);
  }

  public static List<Response> executeBatchAndWait(RequestBatch paramRequestBatch)
  {
    Validate.notEmptyAndContainsNoNulls(paramRequestBatch, "requests");
    try
    {
      HttpURLConnection localHttpURLConnection = toHttpConnection(paramRequestBatch);
      return executeConnectionAndWait(localHttpURLConnection, paramRequestBatch);
    }
    catch (Exception localException)
    {
      List localList = Response.constructErrorResponses(paramRequestBatch.getRequests(), null, new FacebookException(localException));
      runCallbacks(paramRequestBatch, localList);
      return localList;
    }
  }

  public static List<Response> executeBatchAndWait(Collection<Request> paramCollection)
  {
    return executeBatchAndWait(new RequestBatch(paramCollection));
  }

  public static List<Response> executeBatchAndWait(Request[] paramArrayOfRequest)
  {
    Validate.notNull(paramArrayOfRequest, "requests");
    return executeBatchAndWait(Arrays.asList(paramArrayOfRequest));
  }

  public static RequestAsyncTask executeBatchAsync(RequestBatch paramRequestBatch)
  {
    Validate.notEmptyAndContainsNoNulls(paramRequestBatch, "requests");
    RequestAsyncTask localRequestAsyncTask = new RequestAsyncTask(paramRequestBatch);
    localRequestAsyncTask.executeOnSettingsExecutor();
    return localRequestAsyncTask;
  }

  public static RequestAsyncTask executeBatchAsync(Collection<Request> paramCollection)
  {
    return executeBatchAsync(new RequestBatch(paramCollection));
  }

  public static RequestAsyncTask executeBatchAsync(Request[] paramArrayOfRequest)
  {
    Validate.notNull(paramArrayOfRequest, "requests");
    return executeBatchAsync(Arrays.asList(paramArrayOfRequest));
  }

  public static List<Response> executeConnectionAndWait(HttpURLConnection paramHttpURLConnection, RequestBatch paramRequestBatch)
  {
    List localList = Response.fromHttpConnection(paramHttpURLConnection, paramRequestBatch);
    Utility.disconnectQuietly(paramHttpURLConnection);
    int i = paramRequestBatch.size();
    if (i != localList.size())
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(localList.size());
      arrayOfObject[1] = Integer.valueOf(i);
      throw new FacebookException(String.format("Received %d responses while expecting %d", arrayOfObject));
    }
    runCallbacks(paramRequestBatch, localList);
    HashSet localHashSet = new HashSet();
    Iterator localIterator1 = paramRequestBatch.iterator();
    while (localIterator1.hasNext())
    {
      Request localRequest = (Request)localIterator1.next();
      if (localRequest.session != null)
        localHashSet.add(localRequest.session);
    }
    Iterator localIterator2 = localHashSet.iterator();
    while (localIterator2.hasNext())
      ((Session)localIterator2.next()).extendAccessTokenIfNeeded();
    return localList;
  }

  public static List<Response> executeConnectionAndWait(HttpURLConnection paramHttpURLConnection, Collection<Request> paramCollection)
  {
    return executeConnectionAndWait(paramHttpURLConnection, new RequestBatch(paramCollection));
  }

  public static RequestAsyncTask executeConnectionAsync(Handler paramHandler, HttpURLConnection paramHttpURLConnection, RequestBatch paramRequestBatch)
  {
    Validate.notNull(paramHttpURLConnection, "connection");
    RequestAsyncTask localRequestAsyncTask = new RequestAsyncTask(paramHttpURLConnection, paramRequestBatch);
    paramRequestBatch.setCallbackHandler(paramHandler);
    localRequestAsyncTask.executeOnSettingsExecutor();
    return localRequestAsyncTask;
  }

  public static RequestAsyncTask executeConnectionAsync(HttpURLConnection paramHttpURLConnection, RequestBatch paramRequestBatch)
  {
    return executeConnectionAsync(null, paramHttpURLConnection, paramRequestBatch);
  }

  @Deprecated
  public static RequestAsyncTask executeGraphPathRequestAsync(Session paramSession, String paramString, Callback paramCallback)
  {
    return newGraphPathRequest(paramSession, paramString, paramCallback).executeAsync();
  }

  @Deprecated
  public static RequestAsyncTask executeMeRequestAsync(Session paramSession, GraphUserCallback paramGraphUserCallback)
  {
    return newMeRequest(paramSession, paramGraphUserCallback).executeAsync();
  }

  @Deprecated
  public static RequestAsyncTask executeMyFriendsRequestAsync(Session paramSession, GraphUserListCallback paramGraphUserListCallback)
  {
    return newMyFriendsRequest(paramSession, paramGraphUserListCallback).executeAsync();
  }

  @Deprecated
  public static RequestAsyncTask executePlacesSearchRequestAsync(Session paramSession, Location paramLocation, int paramInt1, int paramInt2, String paramString, GraphPlaceListCallback paramGraphPlaceListCallback)
  {
    return newPlacesSearchRequest(paramSession, paramLocation, paramInt1, paramInt2, paramString, paramGraphPlaceListCallback).executeAsync();
  }

  @Deprecated
  public static RequestAsyncTask executePostRequestAsync(Session paramSession, String paramString, GraphObject paramGraphObject, Callback paramCallback)
  {
    return newPostRequest(paramSession, paramString, paramGraphObject, paramCallback).executeAsync();
  }

  @Deprecated
  public static RequestAsyncTask executeStatusUpdateRequestAsync(Session paramSession, String paramString, Callback paramCallback)
  {
    return newStatusUpdateRequest(paramSession, paramString, paramCallback).executeAsync();
  }

  @Deprecated
  public static RequestAsyncTask executeUploadPhotoRequestAsync(Session paramSession, Bitmap paramBitmap, Callback paramCallback)
  {
    return newUploadPhotoRequest(paramSession, paramBitmap, paramCallback).executeAsync();
  }

  @Deprecated
  public static RequestAsyncTask executeUploadPhotoRequestAsync(Session paramSession, File paramFile, Callback paramCallback)
    throws FileNotFoundException
  {
    return newUploadPhotoRequest(paramSession, paramFile, paramCallback).executeAsync();
  }

  private static String getBatchAppId(RequestBatch paramRequestBatch)
  {
    if (!Utility.isNullOrEmpty(paramRequestBatch.getBatchApplicationId()))
      return paramRequestBatch.getBatchApplicationId();
    Iterator localIterator = paramRequestBatch.iterator();
    while (localIterator.hasNext())
    {
      Session localSession = ((Request)localIterator.next()).session;
      if (localSession != null)
        return localSession.getApplicationId();
    }
    return defaultBatchApplicationId;
  }

  public static final String getDefaultBatchApplicationId()
  {
    return defaultBatchApplicationId;
  }

  private String getGraphPathWithVersion()
  {
    if (versionPattern.matcher(this.graphPath).matches())
      return this.graphPath;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.graphPath;
    return String.format("%s", arrayOfObject);
  }

  private static String getMimeContentType()
  {
    return String.format("multipart/form-data; boundary=%s", new Object[] { "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" });
  }

  private static String getUserAgent()
  {
    if (userAgent == null)
      userAgent = String.format("%s.%s", new Object[] { "FBAndroidSDK", "3.19.1" });
    return userAgent;
  }

  private static boolean hasOnProgressCallbacks(RequestBatch paramRequestBatch)
  {
    Iterator localIterator1 = paramRequestBatch.getCallbacks().iterator();
    while (localIterator1.hasNext())
      if (((RequestBatch.Callback)localIterator1.next() instanceof RequestBatch.OnProgressCallback))
        return true;
    Iterator localIterator2 = paramRequestBatch.iterator();
    while (localIterator2.hasNext())
      if ((((Request)localIterator2.next()).getCallback() instanceof OnProgressCallback))
        return true;
    return false;
  }

  private static boolean isMeRequest(String paramString)
  {
    Matcher localMatcher = versionPattern.matcher(paramString);
    if (localMatcher.matches())
      paramString = localMatcher.group(1);
    return (paramString.startsWith("me/")) || (paramString.startsWith("/me/"));
  }

  private static boolean isSupportedAttachmentType(Object paramObject)
  {
    return ((paramObject instanceof Bitmap)) || ((paramObject instanceof byte[])) || ((paramObject instanceof ParcelFileDescriptor)) || ((paramObject instanceof ParcelFileDescriptorWithMimeType));
  }

  private static boolean isSupportedParameterType(Object paramObject)
  {
    return ((paramObject instanceof String)) || ((paramObject instanceof Boolean)) || ((paramObject instanceof Number)) || ((paramObject instanceof Date));
  }

  public static Request newCustomAudienceThirdPartyIdRequest(Session paramSession, Context paramContext, Callback paramCallback)
  {
    return newCustomAudienceThirdPartyIdRequest(paramSession, paramContext, null, paramCallback);
  }

  public static Request newCustomAudienceThirdPartyIdRequest(Session paramSession, Context paramContext, String paramString, Callback paramCallback)
  {
    if (paramSession == null);
    for (Session localSession = Session.getActiveSession(); ; localSession = paramSession)
    {
      if ((localSession != null) && (!localSession.isOpened()))
        localSession = null;
      if (paramString == null)
        if (localSession == null)
          break label55;
      label55: for (paramString = localSession.getApplicationId(); paramString == null; paramString = Utility.getMetadataApplicationId(paramContext))
        throw new FacebookException("Facebook App ID cannot be determined");
      String str1 = paramString + "/custom_audience_third_party_id";
      AttributionIdentifiers localAttributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(paramContext);
      Bundle localBundle = new Bundle();
      if (localSession == null)
        if (localAttributionIdentifiers.getAttributionId() == null)
          break label182;
      label182: for (String str2 = localAttributionIdentifiers.getAttributionId(); ; str2 = localAttributionIdentifiers.getAndroidAdvertiserId())
      {
        if (localAttributionIdentifiers.getAttributionId() != null)
          localBundle.putString("udid", str2);
        if ((Settings.getLimitEventAndDataUsage(paramContext)) || (localAttributionIdentifiers.isTrackingLimited()))
          localBundle.putString("limit_event_usage", "1");
        return new Request(localSession, str1, localBundle, HttpMethod.GET, paramCallback);
      }
    }
  }

  public static Request newDeleteObjectRequest(Session paramSession, String paramString, Callback paramCallback)
  {
    return new Request(paramSession, paramString, null, HttpMethod.DELETE, paramCallback);
  }

  public static Request newGraphPathRequest(Session paramSession, String paramString, Callback paramCallback)
  {
    return new Request(paramSession, paramString, null, null, paramCallback);
  }

  public static Request newMeRequest(Session paramSession, GraphUserCallback paramGraphUserCallback)
  {
    return new Request(paramSession, "me", null, null, new Callback()
    {
      public void onCompleted(Response paramAnonymousResponse)
      {
        if (this.val$callback != null)
          this.val$callback.onCompleted((GraphUser)paramAnonymousResponse.getGraphObjectAs(GraphUser.class), paramAnonymousResponse);
      }
    });
  }

  public static Request newMyFriendsRequest(Session paramSession, GraphUserListCallback paramGraphUserListCallback)
  {
    return new Request(paramSession, "me/friends", null, null, new Callback()
    {
      public void onCompleted(Response paramAnonymousResponse)
      {
        if (this.val$callback != null)
          this.val$callback.onCompleted(Request.typedListFromResponse(paramAnonymousResponse, GraphUser.class), paramAnonymousResponse);
      }
    });
  }

  public static Request newPlacesSearchRequest(Session paramSession, Location paramLocation, int paramInt1, int paramInt2, String paramString, GraphPlaceListCallback paramGraphPlaceListCallback)
  {
    if ((paramLocation == null) && (Utility.isNullOrEmpty(paramString)))
      throw new FacebookException("Either location or searchText must be specified.");
    Bundle localBundle = new Bundle(5);
    localBundle.putString("type", "place");
    localBundle.putInt("limit", paramInt2);
    if (paramLocation != null)
    {
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Double.valueOf(paramLocation.getLatitude());
      arrayOfObject[1] = Double.valueOf(paramLocation.getLongitude());
      localBundle.putString("center", String.format(localLocale, "%f,%f", arrayOfObject));
      localBundle.putInt("distance", paramInt1);
    }
    if (!Utility.isNullOrEmpty(paramString))
      localBundle.putString("q", paramString);
    Callback local3 = new Callback()
    {
      public void onCompleted(Response paramAnonymousResponse)
      {
        if (this.val$callback != null)
          this.val$callback.onCompleted(Request.typedListFromResponse(paramAnonymousResponse, GraphPlace.class), paramAnonymousResponse);
      }
    };
    return new Request(paramSession, "search", localBundle, HttpMethod.GET, local3);
  }

  public static Request newPostOpenGraphActionRequest(Session paramSession, OpenGraphAction paramOpenGraphAction, Callback paramCallback)
  {
    if (paramOpenGraphAction == null)
      throw new FacebookException("openGraphAction cannot be null");
    if (Utility.isNullOrEmpty(paramOpenGraphAction.getType()))
      throw new FacebookException("openGraphAction must have non-null 'type' property");
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramOpenGraphAction.getType();
    return newPostRequest(paramSession, String.format("me/%s", arrayOfObject), paramOpenGraphAction, paramCallback);
  }

  public static Request newPostOpenGraphObjectRequest(Session paramSession, OpenGraphObject paramOpenGraphObject, Callback paramCallback)
  {
    if (paramOpenGraphObject == null)
      throw new FacebookException("openGraphObject cannot be null");
    if (Utility.isNullOrEmpty(paramOpenGraphObject.getType()))
      throw new FacebookException("openGraphObject must have non-null 'type' property");
    if (Utility.isNullOrEmpty(paramOpenGraphObject.getTitle()))
      throw new FacebookException("openGraphObject must have non-null 'title' property");
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramOpenGraphObject.getType();
    String str = String.format("me/objects/%s", arrayOfObject);
    Bundle localBundle = new Bundle();
    localBundle.putString("object", paramOpenGraphObject.getInnerJSONObject().toString());
    return new Request(paramSession, str, localBundle, HttpMethod.POST, paramCallback);
  }

  public static Request newPostOpenGraphObjectRequest(Session paramSession, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, GraphObject paramGraphObject, Callback paramCallback)
  {
    OpenGraphObject localOpenGraphObject = OpenGraphObject.Factory.createForPost(OpenGraphObject.class, paramString1, paramString2, paramString3, paramString4, paramString5);
    if (paramGraphObject != null)
      localOpenGraphObject.setData(paramGraphObject);
    return newPostOpenGraphObjectRequest(paramSession, localOpenGraphObject, paramCallback);
  }

  public static Request newPostRequest(Session paramSession, String paramString, GraphObject paramGraphObject, Callback paramCallback)
  {
    Request localRequest = new Request(paramSession, paramString, null, HttpMethod.POST, paramCallback);
    localRequest.setGraphObject(paramGraphObject);
    return localRequest;
  }

  public static Request newStatusUpdateRequest(Session paramSession, String paramString, Callback paramCallback)
  {
    return newStatusUpdateRequest(paramSession, paramString, (String)null, null, paramCallback);
  }

  public static Request newStatusUpdateRequest(Session paramSession, String paramString, GraphPlace paramGraphPlace, List<GraphUser> paramList, Callback paramCallback)
  {
    if (paramList != null)
    {
      localArrayList = new ArrayList(paramList.size());
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
        localArrayList.add(((GraphUser)localIterator.next()).getId());
    }
    ArrayList localArrayList = null;
    if (paramGraphPlace == null);
    for (String str = null; ; str = paramGraphPlace.getId())
      return newStatusUpdateRequest(paramSession, paramString, str, localArrayList, paramCallback);
  }

  private static Request newStatusUpdateRequest(Session paramSession, String paramString1, String paramString2, List<String> paramList, Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("message", paramString1);
    if (paramString2 != null)
      localBundle.putString("place", paramString2);
    if ((paramList != null) && (paramList.size() > 0))
      localBundle.putString("tags", TextUtils.join(",", paramList));
    return new Request(paramSession, "me/feed", localBundle, HttpMethod.POST, paramCallback);
  }

  public static Request newUpdateOpenGraphObjectRequest(Session paramSession, OpenGraphObject paramOpenGraphObject, Callback paramCallback)
  {
    if (paramOpenGraphObject == null)
      throw new FacebookException("openGraphObject cannot be null");
    String str = paramOpenGraphObject.getId();
    if (str == null)
      throw new FacebookException("openGraphObject must have an id");
    Bundle localBundle = new Bundle();
    localBundle.putString("object", paramOpenGraphObject.getInnerJSONObject().toString());
    return new Request(paramSession, str, localBundle, HttpMethod.POST, paramCallback);
  }

  public static Request newUpdateOpenGraphObjectRequest(Session paramSession, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, GraphObject paramGraphObject, Callback paramCallback)
  {
    OpenGraphObject localOpenGraphObject = OpenGraphObject.Factory.createForPost(OpenGraphObject.class, null, paramString2, paramString3, paramString4, paramString5);
    localOpenGraphObject.setId(paramString1);
    localOpenGraphObject.setData(paramGraphObject);
    return newUpdateOpenGraphObjectRequest(paramSession, localOpenGraphObject, paramCallback);
  }

  public static Request newUploadPhotoRequest(Session paramSession, Bitmap paramBitmap, Callback paramCallback)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("picture", paramBitmap);
    return new Request(paramSession, "me/photos", localBundle, HttpMethod.POST, paramCallback);
  }

  public static Request newUploadPhotoRequest(Session paramSession, File paramFile, Callback paramCallback)
    throws FileNotFoundException
  {
    ParcelFileDescriptor localParcelFileDescriptor = ParcelFileDescriptor.open(paramFile, 268435456);
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("picture", localParcelFileDescriptor);
    return new Request(paramSession, "me/photos", localBundle, HttpMethod.POST, paramCallback);
  }

  public static Request newUploadStagingResourceWithImageRequest(Session paramSession, Bitmap paramBitmap, Callback paramCallback)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("file", paramBitmap);
    return new Request(paramSession, "me/staging_resources", localBundle, HttpMethod.POST, paramCallback);
  }

  public static Request newUploadStagingResourceWithImageRequest(Session paramSession, File paramFile, Callback paramCallback)
    throws FileNotFoundException
  {
    ParcelFileDescriptorWithMimeType localParcelFileDescriptorWithMimeType = new ParcelFileDescriptorWithMimeType(ParcelFileDescriptor.open(paramFile, 268435456), "image/png");
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("file", localParcelFileDescriptorWithMimeType);
    return new Request(paramSession, "me/staging_resources", localBundle, HttpMethod.POST, paramCallback);
  }

  public static Request newUploadVideoRequest(Session paramSession, File paramFile, Callback paramCallback)
    throws FileNotFoundException
  {
    ParcelFileDescriptor localParcelFileDescriptor = ParcelFileDescriptor.open(paramFile, 268435456);
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable(paramFile.getName(), localParcelFileDescriptor);
    return new Request(paramSession, "me/videos", localBundle, HttpMethod.POST, paramCallback);
  }

  private static String parameterToString(Object paramObject)
  {
    if ((paramObject instanceof String))
      return (String)paramObject;
    if (((paramObject instanceof Boolean)) || ((paramObject instanceof Number)))
      return paramObject.toString();
    if ((paramObject instanceof Date))
      return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(paramObject);
    throw new IllegalArgumentException("Unsupported parameter type.");
  }

  private static void processGraphObject(GraphObject paramGraphObject, String paramString, KeyValueSerializer paramKeyValueSerializer)
    throws IOException
  {
    int m;
    if (isMeRequest(paramString))
    {
      int j = paramString.indexOf(":");
      int k = paramString.indexOf("?");
      if ((j > 3) && ((k == -1) || (j < k)))
        m = 1;
    }
    for (int i = m; ; i = 0)
    {
      Iterator localIterator = paramGraphObject.asMap().entrySet().iterator();
      label68: if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((i != 0) && (((String)localEntry.getKey()).equalsIgnoreCase("image")));
        for (boolean bool = true; ; bool = false)
        {
          processGraphObjectProperty((String)localEntry.getKey(), localEntry.getValue(), paramKeyValueSerializer, bool);
          break label68;
          m = 0;
          break;
        }
      }
      return;
    }
  }

  private static void processGraphObjectProperty(String paramString, Object paramObject, KeyValueSerializer paramKeyValueSerializer, boolean paramBoolean)
    throws IOException
  {
    Class localClass1 = paramObject.getClass();
    Class localClass2;
    Object localObject;
    if (GraphObject.class.isAssignableFrom(localClass1))
    {
      JSONObject localJSONObject2 = ((GraphObject)paramObject).getInnerJSONObject();
      localClass2 = localJSONObject2.getClass();
      localObject = localJSONObject2;
    }
    while (true)
    {
      JSONObject localJSONObject1;
      if (JSONObject.class.isAssignableFrom(localClass2))
      {
        localJSONObject1 = (JSONObject)localObject;
        if (paramBoolean)
        {
          Iterator localIterator = localJSONObject1.keys();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            processGraphObjectProperty(String.format("%s[%s]", new Object[] { paramString, str }), localJSONObject1.opt(str), paramKeyValueSerializer, paramBoolean);
          }
          if (GraphObjectList.class.isAssignableFrom(localClass1))
          {
            JSONArray localJSONArray2 = ((GraphObjectList)paramObject).getInnerJSONArray();
            localClass2 = localJSONArray2.getClass();
            localObject = localJSONArray2;
          }
        }
        else if (localJSONObject1.has("id"))
        {
          processGraphObjectProperty(paramString, localJSONObject1.optString("id"), paramKeyValueSerializer, paramBoolean);
        }
      }
      else
      {
        do
        {
          while (true)
          {
            return;
            if (localJSONObject1.has("url"))
            {
              processGraphObjectProperty(paramString, localJSONObject1.optString("url"), paramKeyValueSerializer, paramBoolean);
              return;
            }
            if (localJSONObject1.has("fbsdk:create_object"))
            {
              processGraphObjectProperty(paramString, localJSONObject1.toString(), paramKeyValueSerializer, paramBoolean);
              return;
              if (!JSONArray.class.isAssignableFrom(localClass2))
                break;
              JSONArray localJSONArray1 = (JSONArray)localObject;
              int i = localJSONArray1.length();
              for (int j = 0; j < i; j++)
              {
                Object[] arrayOfObject = new Object[2];
                arrayOfObject[0] = paramString;
                arrayOfObject[1] = Integer.valueOf(j);
                processGraphObjectProperty(String.format("%s[%d]", arrayOfObject), localJSONArray1.opt(j), paramKeyValueSerializer, paramBoolean);
              }
            }
          }
          if ((String.class.isAssignableFrom(localClass2)) || (Number.class.isAssignableFrom(localClass2)) || (Boolean.class.isAssignableFrom(localClass2)))
          {
            paramKeyValueSerializer.writeString(paramString, localObject.toString());
            return;
          }
        }
        while (!Date.class.isAssignableFrom(localClass2));
        Date localDate = (Date)localObject;
        paramKeyValueSerializer.writeString(paramString, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(localDate));
        return;
        localClass2 = localClass1;
        localObject = paramObject;
      }
    }
  }

  private static void processRequest(RequestBatch paramRequestBatch, Logger paramLogger, int paramInt, URL paramURL, OutputStream paramOutputStream)
    throws IOException, JSONException
  {
    Serializer localSerializer = new Serializer(paramOutputStream, paramLogger);
    if (paramInt == 1)
    {
      Request localRequest = paramRequestBatch.get(0);
      HashMap localHashMap2 = new HashMap();
      Iterator localIterator = localRequest.parameters.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        Object localObject = localRequest.parameters.get(str2);
        if (isSupportedAttachmentType(localObject))
          localHashMap2.put(str2, new Attachment(localRequest, localObject));
      }
      if (paramLogger != null)
        paramLogger.append("  Parameters:\n");
      serializeParameters(localRequest.parameters, localSerializer, localRequest);
      if (paramLogger != null)
        paramLogger.append("  Attachments:\n");
      serializeAttachments(localHashMap2, localSerializer);
      if (localRequest.graphObject != null)
        processGraphObject(localRequest.graphObject, paramURL.getPath(), localSerializer);
      return;
    }
    String str1 = getBatchAppId(paramRequestBatch);
    if (Utility.isNullOrEmpty(str1))
      throw new FacebookException("At least one request in a batch must have an open Session, or a default app ID must be specified.");
    localSerializer.writeString("batch_app_id", str1);
    HashMap localHashMap1 = new HashMap();
    serializeRequestsAsJSON(localSerializer, paramRequestBatch, localHashMap1);
    if (paramLogger != null)
      paramLogger.append("  Attachments:\n");
    serializeAttachments(localHashMap1, localSerializer);
  }

  static void runCallbacks(final RequestBatch paramRequestBatch, List<Response> paramList)
  {
    int i = paramRequestBatch.size();
    ArrayList localArrayList = new ArrayList();
    for (int j = 0; j < i; j++)
    {
      Request localRequest = paramRequestBatch.get(j);
      if (localRequest.callback != null)
        localArrayList.add(new Pair(localRequest.callback, paramList.get(j)));
    }
    Runnable local4;
    Handler localHandler;
    if (localArrayList.size() > 0)
    {
      local4 = new Runnable()
      {
        public void run()
        {
          Iterator localIterator1 = this.val$callbacks.iterator();
          while (localIterator1.hasNext())
          {
            Pair localPair = (Pair)localIterator1.next();
            ((Request.Callback)localPair.first).onCompleted((Response)localPair.second);
          }
          Iterator localIterator2 = paramRequestBatch.getCallbacks().iterator();
          while (localIterator2.hasNext())
            ((RequestBatch.Callback)localIterator2.next()).onBatchCompleted(paramRequestBatch);
        }
      };
      localHandler = paramRequestBatch.getCallbackHandler();
      if (localHandler == null)
        local4.run();
    }
    else
    {
      return;
    }
    localHandler.post(local4);
  }

  private static void serializeAttachments(Map<String, Attachment> paramMap, Serializer paramSerializer)
    throws IOException
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Attachment localAttachment = (Attachment)paramMap.get(str);
      if (isSupportedAttachmentType(localAttachment.getValue()))
        paramSerializer.writeObject(str, localAttachment.getValue(), localAttachment.getRequest());
    }
  }

  private static void serializeParameters(Bundle paramBundle, Serializer paramSerializer, Request paramRequest)
    throws IOException
  {
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramBundle.get(str);
      if (isSupportedParameterType(localObject))
        paramSerializer.writeObject(str, localObject, paramRequest);
    }
  }

  private static void serializeRequestsAsJSON(Serializer paramSerializer, Collection<Request> paramCollection, Map<String, Attachment> paramMap)
    throws JSONException, IOException
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
      ((Request)localIterator.next()).serializeToBatch(localJSONArray, paramMap);
    paramSerializer.writeRequestsAsJson("batch", localJSONArray, paramCollection);
  }

  private void serializeToBatch(JSONArray paramJSONArray, Map<String, Attachment> paramMap)
    throws JSONException, IOException
  {
    JSONObject localJSONObject = new JSONObject();
    if (this.batchEntryName != null)
    {
      localJSONObject.put("name", this.batchEntryName);
      localJSONObject.put("omit_response_on_success", this.batchEntryOmitResultOnSuccess);
    }
    if (this.batchEntryDependsOn != null)
      localJSONObject.put("depends_on", this.batchEntryDependsOn);
    String str1 = getUrlForBatchedRequest();
    localJSONObject.put("relative_url", str1);
    localJSONObject.put("method", this.httpMethod);
    if (this.session != null)
      Logger.registerAccessToken(this.session.getAccessToken());
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator = this.parameters.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      Object localObject = this.parameters.get(str2);
      if (isSupportedAttachmentType(localObject))
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = "file";
        arrayOfObject[1] = Integer.valueOf(paramMap.size());
        String str3 = String.format("%s%d", arrayOfObject);
        localArrayList1.add(str3);
        paramMap.put(str3, new Attachment(this, localObject));
      }
    }
    if (!localArrayList1.isEmpty())
      localJSONObject.put("attached_files", TextUtils.join(",", localArrayList1));
    if (this.graphObject != null)
    {
      final ArrayList localArrayList2 = new ArrayList();
      processGraphObject(this.graphObject, str1, new KeyValueSerializer()
      {
        public void writeString(String paramAnonymousString1, String paramAnonymousString2)
          throws IOException
        {
          ArrayList localArrayList = localArrayList2;
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = paramAnonymousString1;
          arrayOfObject[1] = URLEncoder.encode(paramAnonymousString2, "UTF-8");
          localArrayList.add(String.format("%s=%s", arrayOfObject));
        }
      });
      localJSONObject.put("body", TextUtils.join("&", localArrayList2));
    }
    paramJSONArray.put(localJSONObject);
  }

  // ERROR //
  static final void serializeToUrlConnection(RequestBatch paramRequestBatch, HttpURLConnection paramHttpURLConnection)
    throws IOException, JSONException
  {
    // Byte code:
    //   0: new 236	com/facebook/internal/Logger
    //   3: dup
    //   4: getstatic 1071	com/facebook/LoggingBehavior:REQUESTS	Lcom/facebook/LoggingBehavior;
    //   7: ldc_w 1073
    //   10: invokespecial 1076	com/facebook/internal/Logger:<init>	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;)V
    //   13: astore_2
    //   14: aload_0
    //   15: invokevirtual 458	com/facebook/RequestBatch:size	()I
    //   18: istore_3
    //   19: iload_3
    //   20: iconst_1
    //   21: if_icmpne +127 -> 148
    //   24: aload_0
    //   25: iconst_0
    //   26: invokevirtual 936	com/facebook/RequestBatch:get	(I)Lcom/facebook/Request;
    //   29: getfield 317	com/facebook/Request:httpMethod	Lcom/facebook/HttpMethod;
    //   32: astore 4
    //   34: aload_1
    //   35: aload 4
    //   37: invokevirtual 1078	com/facebook/HttpMethod:name	()Ljava/lang/String;
    //   40: invokevirtual 1081	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   43: aload_1
    //   44: invokevirtual 1085	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   47: astore 5
    //   49: aload_2
    //   50: ldc_w 1087
    //   53: invokevirtual 954	com/facebook/internal/Logger:append	(Ljava/lang/String;)V
    //   56: aload_2
    //   57: ldc_w 1089
    //   60: aload_0
    //   61: invokevirtual 1090	com/facebook/RequestBatch:getId	()Ljava/lang/String;
    //   64: invokevirtual 1094	com/facebook/internal/Logger:appendKeyValue	(Ljava/lang/String;Ljava/lang/Object;)V
    //   67: aload_2
    //   68: ldc_w 1096
    //   71: aload 5
    //   73: invokevirtual 1094	com/facebook/internal/Logger:appendKeyValue	(Ljava/lang/String;Ljava/lang/Object;)V
    //   76: aload_2
    //   77: ldc_w 1098
    //   80: aload_1
    //   81: invokevirtual 1101	java/net/HttpURLConnection:getRequestMethod	()Ljava/lang/String;
    //   84: invokevirtual 1094	com/facebook/internal/Logger:appendKeyValue	(Ljava/lang/String;Ljava/lang/Object;)V
    //   87: aload_2
    //   88: ldc 106
    //   90: aload_1
    //   91: ldc 106
    //   93: invokevirtual 1104	java/net/HttpURLConnection:getRequestProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   96: invokevirtual 1094	com/facebook/internal/Logger:appendKeyValue	(Ljava/lang/String;Ljava/lang/Object;)V
    //   99: aload_2
    //   100: ldc 44
    //   102: aload_1
    //   103: ldc 44
    //   105: invokevirtual 1104	java/net/HttpURLConnection:getRequestProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   108: invokevirtual 1094	com/facebook/internal/Logger:appendKeyValue	(Ljava/lang/String;Ljava/lang/Object;)V
    //   111: aload_1
    //   112: aload_0
    //   113: invokevirtual 1107	com/facebook/RequestBatch:getTimeout	()I
    //   116: invokevirtual 1110	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   119: aload_1
    //   120: aload_0
    //   121: invokevirtual 1107	com/facebook/RequestBatch:getTimeout	()I
    //   124: invokevirtual 1113	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   127: aload 4
    //   129: getstatic 753	com/facebook/HttpMethod:POST	Lcom/facebook/HttpMethod;
    //   132: if_acmpne +24 -> 156
    //   135: iconst_1
    //   136: istore 6
    //   138: iload 6
    //   140: ifne +22 -> 162
    //   143: aload_2
    //   144: invokevirtual 1116	com/facebook/internal/Logger:log	()V
    //   147: return
    //   148: getstatic 753	com/facebook/HttpMethod:POST	Lcom/facebook/HttpMethod;
    //   151: astore 4
    //   153: goto -119 -> 34
    //   156: iconst_0
    //   157: istore 6
    //   159: goto -21 -> 138
    //   162: aload_1
    //   163: iconst_1
    //   164: invokevirtual 1120	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   167: aload_0
    //   168: invokestatic 1122	com/facebook/Request:hasOnProgressCallbacks	(Lcom/facebook/RequestBatch;)Z
    //   171: ifeq +95 -> 266
    //   174: new 1124	com/facebook/ProgressNoopOutputStream
    //   177: dup
    //   178: aload_0
    //   179: invokevirtual 997	com/facebook/RequestBatch:getCallbackHandler	()Landroid/os/Handler;
    //   182: invokespecial 1126	com/facebook/ProgressNoopOutputStream:<init>	(Landroid/os/Handler;)V
    //   185: astore 9
    //   187: aload_0
    //   188: aconst_null
    //   189: iload_3
    //   190: aload 5
    //   192: aload 9
    //   194: invokestatic 1128	com/facebook/Request:processRequest	(Lcom/facebook/RequestBatch;Lcom/facebook/internal/Logger;ILjava/net/URL;Ljava/io/OutputStream;)V
    //   197: aload 9
    //   199: invokevirtual 1131	com/facebook/ProgressNoopOutputStream:getMaxProgress	()I
    //   202: istore 10
    //   204: aload 9
    //   206: invokevirtual 1134	com/facebook/ProgressNoopOutputStream:getProgressMap	()Ljava/util/Map;
    //   209: astore 11
    //   211: new 1136	com/facebook/ProgressOutputStream
    //   214: dup
    //   215: new 1138	java/io/BufferedOutputStream
    //   218: dup
    //   219: aload_1
    //   220: invokevirtual 1142	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   223: invokespecial 1145	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   226: aload_0
    //   227: aload 11
    //   229: iload 10
    //   231: i2l
    //   232: invokespecial 1148	com/facebook/ProgressOutputStream:<init>	(Ljava/io/OutputStream;Lcom/facebook/RequestBatch;Ljava/util/Map;J)V
    //   235: astore 12
    //   237: aload 12
    //   239: astore 8
    //   241: aload_0
    //   242: aload_2
    //   243: iload_3
    //   244: aload 5
    //   246: aload 8
    //   248: invokestatic 1128	com/facebook/Request:processRequest	(Lcom/facebook/RequestBatch;Lcom/facebook/internal/Logger;ILjava/net/URL;Ljava/io/OutputStream;)V
    //   251: aload 8
    //   253: ifnull +8 -> 261
    //   256: aload 8
    //   258: invokevirtual 1153	java/io/OutputStream:close	()V
    //   261: aload_2
    //   262: invokevirtual 1116	com/facebook/internal/Logger:log	()V
    //   265: return
    //   266: new 1138	java/io/BufferedOutputStream
    //   269: dup
    //   270: aload_1
    //   271: invokevirtual 1142	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   274: invokespecial 1145	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   277: astore 8
    //   279: goto -38 -> 241
    //   282: astore 7
    //   284: aconst_null
    //   285: astore 8
    //   287: aload 8
    //   289: ifnull +8 -> 297
    //   292: aload 8
    //   294: invokevirtual 1153	java/io/OutputStream:close	()V
    //   297: aload 7
    //   299: athrow
    //   300: astore 7
    //   302: goto -15 -> 287
    //
    // Exception table:
    //   from	to	target	type
    //   167	237	282	finally
    //   266	279	282	finally
    //   241	251	300	finally
  }

  public static final void setDefaultBatchApplicationId(String paramString)
  {
    defaultBatchApplicationId = paramString;
  }

  // ERROR //
  public static HttpURLConnection toHttpConnection(RequestBatch paramRequestBatch)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 458	com/facebook/RequestBatch:size	()I
    //   4: iconst_1
    //   5: if_icmpne +34 -> 39
    //   8: new 188	java/net/URL
    //   11: dup
    //   12: aload_0
    //   13: iconst_0
    //   14: invokevirtual 936	com/facebook/RequestBatch:get	(I)Lcom/facebook/Request;
    //   17: invokevirtual 1159	com/facebook/Request:getUrlForSingleRequest	()Ljava/lang/String;
    //   20: invokespecial 1160	java/net/URL:<init>	(Ljava/lang/String;)V
    //   23: astore_2
    //   24: aload_2
    //   25: invokestatic 1162	com/facebook/Request:createConnection	(Ljava/net/URL;)Ljava/net/HttpURLConnection;
    //   28: astore 5
    //   30: aload_0
    //   31: aload 5
    //   33: invokestatic 1164	com/facebook/Request:serializeToUrlConnection	(Lcom/facebook/RequestBatch;Ljava/net/HttpURLConnection;)V
    //   36: aload 5
    //   38: areturn
    //   39: new 188	java/net/URL
    //   42: dup
    //   43: invokestatic 1169	com/facebook/internal/ServerProtocol:getGraphUrlBase	()Ljava/lang/String;
    //   46: invokespecial 1160	java/net/URL:<init>	(Ljava/lang/String;)V
    //   49: astore_2
    //   50: goto -26 -> 24
    //   53: astore_1
    //   54: new 222	com/facebook/FacebookException
    //   57: dup
    //   58: ldc_w 1171
    //   61: aload_1
    //   62: invokespecial 1174	com/facebook/FacebookException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   65: athrow
    //   66: astore 4
    //   68: new 222	com/facebook/FacebookException
    //   71: dup
    //   72: ldc_w 1176
    //   75: aload 4
    //   77: invokespecial 1174	com/facebook/FacebookException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   80: athrow
    //   81: astore_3
    //   82: new 222	com/facebook/FacebookException
    //   85: dup
    //   86: ldc_w 1176
    //   89: aload_3
    //   90: invokespecial 1174	com/facebook/FacebookException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   93: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	24	53	java/net/MalformedURLException
    //   39	50	53	java/net/MalformedURLException
    //   24	36	66	java/io/IOException
    //   24	36	81	org/json/JSONException
  }

  public static HttpURLConnection toHttpConnection(Collection<Request> paramCollection)
  {
    Validate.notEmptyAndContainsNoNulls(paramCollection, "requests");
    return toHttpConnection(new RequestBatch(paramCollection));
  }

  public static HttpURLConnection toHttpConnection(Request[] paramArrayOfRequest)
  {
    return toHttpConnection(Arrays.asList(paramArrayOfRequest));
  }

  private static <T extends GraphObject> List<T> typedListFromResponse(Response paramResponse, Class<T> paramClass)
  {
    GraphMultiResult localGraphMultiResult = (GraphMultiResult)paramResponse.getGraphObjectAs(GraphMultiResult.class);
    if (localGraphMultiResult == null)
      return null;
    GraphObjectList localGraphObjectList = localGraphMultiResult.getData();
    if (localGraphObjectList == null)
      return null;
    return localGraphObjectList.castToListOf(paramClass);
  }

  public final Response executeAndWait()
  {
    return executeAndWait(this);
  }

  public final RequestAsyncTask executeAsync()
  {
    return executeBatchAsync(new Request[] { this });
  }

  public final String getBatchEntryDependsOn()
  {
    return this.batchEntryDependsOn;
  }

  public final String getBatchEntryName()
  {
    return this.batchEntryName;
  }

  public final boolean getBatchEntryOmitResultOnSuccess()
  {
    return this.batchEntryOmitResultOnSuccess;
  }

  public final Callback getCallback()
  {
    return this.callback;
  }

  public final GraphObject getGraphObject()
  {
    return this.graphObject;
  }

  public final String getGraphPath()
  {
    return this.graphPath;
  }

  public final HttpMethod getHttpMethod()
  {
    return this.httpMethod;
  }

  public final Bundle getParameters()
  {
    return this.parameters;
  }

  public final Session getSession()
  {
    return this.session;
  }

  public final Object getTag()
  {
    return this.tag;
  }

  final String getUrlForBatchedRequest()
  {
    if (this.overriddenURL != null)
      throw new FacebookException("Can't override URL for a batch request");
    String str = getGraphPathWithVersion();
    addCommonParameters();
    return appendParametersToBaseUrl(str);
  }

  final String getUrlForSingleRequest()
  {
    if (this.overriddenURL != null)
      return this.overriddenURL.toString();
    if ((getHttpMethod() == HttpMethod.POST) && (this.graphPath != null) && (this.graphPath.endsWith("/videos")));
    for (String str1 = ServerProtocol.getGraphVideoUrlBase(); ; str1 = ServerProtocol.getGraphUrlBase())
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = str1;
      arrayOfObject[1] = getGraphPathWithVersion();
      String str2 = String.format("%s/%s", arrayOfObject);
      addCommonParameters();
      return appendParametersToBaseUrl(str2);
    }
  }

  public final void setBatchEntryDependsOn(String paramString)
  {
    this.batchEntryDependsOn = paramString;
  }

  public final void setBatchEntryName(String paramString)
  {
    this.batchEntryName = paramString;
  }

  public final void setBatchEntryOmitResultOnSuccess(boolean paramBoolean)
  {
    this.batchEntryOmitResultOnSuccess = paramBoolean;
  }

  public final void setCallback(Callback paramCallback)
  {
    this.callback = paramCallback;
  }

  public final void setGraphObject(GraphObject paramGraphObject)
  {
    this.graphObject = paramGraphObject;
  }

  public final void setGraphPath(String paramString)
  {
    this.graphPath = paramString;
  }

  public final void setHttpMethod(HttpMethod paramHttpMethod)
  {
    if ((this.overriddenURL != null) && (paramHttpMethod != HttpMethod.GET))
      throw new FacebookException("Can't change HTTP method on request with overridden URL.");
    if (paramHttpMethod != null);
    while (true)
    {
      this.httpMethod = paramHttpMethod;
      return;
      paramHttpMethod = HttpMethod.GET;
    }
  }

  public final void setParameters(Bundle paramBundle)
  {
    this.parameters = paramBundle;
  }

  public final void setSession(Session paramSession)
  {
    this.session = paramSession;
  }

  public final void setSkipClientToken(boolean paramBoolean)
  {
    this.skipClientToken = paramBoolean;
  }

  public final void setTag(Object paramObject)
  {
    this.tag = paramObject;
  }

  public String toString()
  {
    return "{Request: " + " session: " + this.session + ", graphPath: " + this.graphPath + ", graphObject: " + this.graphObject + ", httpMethod: " + this.httpMethod + ", parameters: " + this.parameters + "}";
  }

  private static class Attachment
  {
    private final Request request;
    private final Object value;

    public Attachment(Request paramRequest, Object paramObject)
    {
      this.request = paramRequest;
      this.value = paramObject;
    }

    public Request getRequest()
    {
      return this.request;
    }

    public Object getValue()
    {
      return this.value;
    }
  }

  public static abstract interface Callback
  {
    public abstract void onCompleted(Response paramResponse);
  }

  public static abstract interface GraphPlaceListCallback
  {
    public abstract void onCompleted(List<GraphPlace> paramList, Response paramResponse);
  }

  public static abstract interface GraphUserCallback
  {
    public abstract void onCompleted(GraphUser paramGraphUser, Response paramResponse);
  }

  public static abstract interface GraphUserListCallback
  {
    public abstract void onCompleted(List<GraphUser> paramList, Response paramResponse);
  }

  private static abstract interface KeyValueSerializer
  {
    public abstract void writeString(String paramString1, String paramString2)
      throws IOException;
  }

  public static abstract interface OnProgressCallback extends Request.Callback
  {
    public abstract void onProgress(long paramLong1, long paramLong2);
  }

  private static class ParcelFileDescriptorWithMimeType
    implements Parcelable
  {
    public static final Parcelable.Creator<ParcelFileDescriptorWithMimeType> CREATOR = new Parcelable.Creator()
    {
      public Request.ParcelFileDescriptorWithMimeType createFromParcel(Parcel paramAnonymousParcel)
      {
        return new Request.ParcelFileDescriptorWithMimeType(paramAnonymousParcel, null);
      }

      public Request.ParcelFileDescriptorWithMimeType[] newArray(int paramAnonymousInt)
      {
        return new Request.ParcelFileDescriptorWithMimeType[paramAnonymousInt];
      }
    };
    private final ParcelFileDescriptor fileDescriptor;
    private final String mimeType;

    private ParcelFileDescriptorWithMimeType(Parcel paramParcel)
    {
      this.mimeType = paramParcel.readString();
      this.fileDescriptor = paramParcel.readFileDescriptor();
    }

    public ParcelFileDescriptorWithMimeType(ParcelFileDescriptor paramParcelFileDescriptor, String paramString)
    {
      this.mimeType = paramString;
      this.fileDescriptor = paramParcelFileDescriptor;
    }

    public int describeContents()
    {
      return 1;
    }

    public ParcelFileDescriptor getFileDescriptor()
    {
      return this.fileDescriptor;
    }

    public String getMimeType()
    {
      return this.mimeType;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.mimeType);
      paramParcel.writeFileDescriptor(this.fileDescriptor.getFileDescriptor());
    }
  }

  private static class Serializer
    implements Request.KeyValueSerializer
  {
    private boolean firstWrite = true;
    private final Logger logger;
    private final OutputStream outputStream;

    public Serializer(OutputStream paramOutputStream, Logger paramLogger)
    {
      this.outputStream = paramOutputStream;
      this.logger = paramLogger;
    }

    public void write(String paramString, Object[] paramArrayOfObject)
      throws IOException
    {
      if (this.firstWrite)
      {
        this.outputStream.write("--".getBytes());
        this.outputStream.write("3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f".getBytes());
        this.outputStream.write("\r\n".getBytes());
        this.firstWrite = false;
      }
      this.outputStream.write(String.format(paramString, paramArrayOfObject).getBytes());
    }

    public void writeBitmap(String paramString, Bitmap paramBitmap)
      throws IOException
    {
      writeContentDisposition(paramString, paramString, "image/png");
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, this.outputStream);
      writeLine("", new Object[0]);
      writeRecordBoundary();
      if (this.logger != null)
        this.logger.appendKeyValue("    " + paramString, "<Image>");
    }

    public void writeBytes(String paramString, byte[] paramArrayOfByte)
      throws IOException
    {
      writeContentDisposition(paramString, paramString, "content/unknown");
      this.outputStream.write(paramArrayOfByte);
      writeLine("", new Object[0]);
      writeRecordBoundary();
      if (this.logger != null)
      {
        Logger localLogger = this.logger;
        String str = "    " + paramString;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(paramArrayOfByte.length);
        localLogger.appendKeyValue(str, String.format("<Data: %d>", arrayOfObject));
      }
    }

    public void writeContentDisposition(String paramString1, String paramString2, String paramString3)
      throws IOException
    {
      write("Content-Disposition: form-data; name=\"%s\"", new Object[] { paramString1 });
      if (paramString2 != null)
        write("; filename=\"%s\"", new Object[] { paramString2 });
      writeLine("", new Object[0]);
      if (paramString3 != null)
        writeLine("%s: %s", new Object[] { "Content-Type", paramString3 });
      writeLine("", new Object[0]);
    }

    // ERROR //
    public void writeFile(String paramString1, ParcelFileDescriptor paramParcelFileDescriptor, String paramString2)
      throws IOException
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 4
      //   3: aload_3
      //   4: ifnonnull +6 -> 10
      //   7: ldc 101
      //   9: astore_3
      //   10: aload_0
      //   11: aload_1
      //   12: aload_1
      //   13: aload_3
      //   14: invokevirtual 56	com/facebook/Request$Serializer:writeContentDisposition	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   17: aload_0
      //   18: getfield 21	com/facebook/Request$Serializer:outputStream	Ljava/io/OutputStream;
      //   21: instanceof 123
      //   24: ifeq +98 -> 122
      //   27: aload_0
      //   28: getfield 21	com/facebook/Request$Serializer:outputStream	Ljava/io/OutputStream;
      //   31: checkcast 123	com/facebook/ProgressNoopOutputStream
      //   34: aload_2
      //   35: invokevirtual 129	android/os/ParcelFileDescriptor:getStatSize	()J
      //   38: invokevirtual 133	com/facebook/ProgressNoopOutputStream:addProgress	(J)V
      //   41: iconst_0
      //   42: istore 10
      //   44: aload_0
      //   45: ldc 70
      //   47: iconst_0
      //   48: anewarray 4	java/lang/Object
      //   51: invokevirtual 73	com/facebook/Request$Serializer:writeLine	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   54: aload_0
      //   55: invokevirtual 76	com/facebook/Request$Serializer:writeRecordBoundary	()V
      //   58: aload_0
      //   59: getfield 23	com/facebook/Request$Serializer:logger	Lcom/facebook/internal/Logger;
      //   62: ifnull +59 -> 121
      //   65: aload_0
      //   66: getfield 23	com/facebook/Request$Serializer:logger	Lcom/facebook/internal/Logger;
      //   69: astore 12
      //   71: new 78	java/lang/StringBuilder
      //   74: dup
      //   75: invokespecial 79	java/lang/StringBuilder:<init>	()V
      //   78: ldc 81
      //   80: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   83: aload_1
      //   84: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   87: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   90: astore 13
      //   92: iconst_1
      //   93: anewarray 4	java/lang/Object
      //   96: astore 14
      //   98: aload 14
      //   100: iconst_0
      //   101: iload 10
      //   103: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   106: aastore
      //   107: aload 12
      //   109: aload 13
      //   111: ldc 109
      //   113: aload 14
      //   115: invokestatic 48	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   118: invokevirtual 97	com/facebook/internal/Logger:appendKeyValue	(Ljava/lang/String;Ljava/lang/Object;)V
      //   121: return
      //   122: new 135	android/os/ParcelFileDescriptor$AutoCloseInputStream
      //   125: dup
      //   126: aload_2
      //   127: invokespecial 138	android/os/ParcelFileDescriptor$AutoCloseInputStream:<init>	(Landroid/os/ParcelFileDescriptor;)V
      //   130: astore 5
      //   132: new 140	java/io/BufferedInputStream
      //   135: dup
      //   136: aload 5
      //   138: invokespecial 143	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
      //   141: astore 6
      //   143: sipush 8192
      //   146: newarray byte
      //   148: astore 9
      //   150: iconst_0
      //   151: istore 10
      //   153: aload 6
      //   155: aload 9
      //   157: invokevirtual 147	java/io/BufferedInputStream:read	([B)I
      //   160: istore 11
      //   162: iload 11
      //   164: iconst_m1
      //   165: if_icmpeq +25 -> 190
      //   168: aload_0
      //   169: getfield 21	com/facebook/Request$Serializer:outputStream	Ljava/io/OutputStream;
      //   172: aload 9
      //   174: iconst_0
      //   175: iload 11
      //   177: invokevirtual 150	java/io/OutputStream:write	([BII)V
      //   180: iload 10
      //   182: iload 11
      //   184: iadd
      //   185: istore 10
      //   187: goto -34 -> 153
      //   190: aload 6
      //   192: ifnull +8 -> 200
      //   195: aload 6
      //   197: invokevirtual 153	java/io/BufferedInputStream:close	()V
      //   200: aload 5
      //   202: ifnull -158 -> 44
      //   205: aload 5
      //   207: invokevirtual 154	android/os/ParcelFileDescriptor$AutoCloseInputStream:close	()V
      //   210: goto -166 -> 44
      //   213: astore 7
      //   215: aconst_null
      //   216: astore 8
      //   218: aload 8
      //   220: ifnull +8 -> 228
      //   223: aload 8
      //   225: invokevirtual 153	java/io/BufferedInputStream:close	()V
      //   228: aload 4
      //   230: ifnull +8 -> 238
      //   233: aload 4
      //   235: invokevirtual 154	android/os/ParcelFileDescriptor$AutoCloseInputStream:close	()V
      //   238: aload 7
      //   240: athrow
      //   241: astore 7
      //   243: aload 5
      //   245: astore 4
      //   247: aconst_null
      //   248: astore 8
      //   250: goto -32 -> 218
      //   253: astore 7
      //   255: aload 6
      //   257: astore 8
      //   259: aload 5
      //   261: astore 4
      //   263: goto -45 -> 218
      //
      // Exception table:
      //   from	to	target	type
      //   122	132	213	finally
      //   132	143	241	finally
      //   143	150	253	finally
      //   153	162	253	finally
      //   168	180	253	finally
    }

    public void writeFile(String paramString, Request.ParcelFileDescriptorWithMimeType paramParcelFileDescriptorWithMimeType)
      throws IOException
    {
      writeFile(paramString, paramParcelFileDescriptorWithMimeType.getFileDescriptor(), paramParcelFileDescriptorWithMimeType.getMimeType());
    }

    public void writeLine(String paramString, Object[] paramArrayOfObject)
      throws IOException
    {
      write(paramString, paramArrayOfObject);
      write("\r\n", new Object[0]);
    }

    public void writeObject(String paramString, Object paramObject, Request paramRequest)
      throws IOException
    {
      if ((this.outputStream instanceof RequestOutputStream))
        ((RequestOutputStream)this.outputStream).setCurrentRequest(paramRequest);
      if (Request.isSupportedParameterType(paramObject))
      {
        writeString(paramString, Request.parameterToString(paramObject));
        return;
      }
      if ((paramObject instanceof Bitmap))
      {
        writeBitmap(paramString, (Bitmap)paramObject);
        return;
      }
      if ((paramObject instanceof byte[]))
      {
        writeBytes(paramString, (byte[])paramObject);
        return;
      }
      if ((paramObject instanceof ParcelFileDescriptor))
      {
        writeFile(paramString, (ParcelFileDescriptor)paramObject, null);
        return;
      }
      if ((paramObject instanceof Request.ParcelFileDescriptorWithMimeType))
      {
        writeFile(paramString, (Request.ParcelFileDescriptorWithMimeType)paramObject);
        return;
      }
      throw new IllegalArgumentException("value is not a supported type: String, Bitmap, byte[]");
    }

    public void writeRecordBoundary()
      throws IOException
    {
      writeLine("--%s", new Object[] { "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" });
    }

    public void writeRequestsAsJson(String paramString, JSONArray paramJSONArray, Collection<Request> paramCollection)
      throws IOException, JSONException
    {
      if (!(this.outputStream instanceof RequestOutputStream))
        writeString(paramString, paramJSONArray.toString());
      do
      {
        return;
        RequestOutputStream localRequestOutputStream = (RequestOutputStream)this.outputStream;
        writeContentDisposition(paramString, null, null);
        write("[", new Object[0]);
        Iterator localIterator = paramCollection.iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          Request localRequest = (Request)localIterator.next();
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          localRequestOutputStream.setCurrentRequest(localRequest);
          if (i > 0)
          {
            Object[] arrayOfObject2 = new Object[1];
            arrayOfObject2[0] = localJSONObject.toString();
            write(",%s", arrayOfObject2);
          }
          while (true)
          {
            i++;
            break;
            Object[] arrayOfObject1 = new Object[1];
            arrayOfObject1[0] = localJSONObject.toString();
            write("%s", arrayOfObject1);
          }
        }
        write("]", new Object[0]);
      }
      while (this.logger == null);
      this.logger.appendKeyValue("    " + paramString, paramJSONArray.toString());
    }

    public void writeString(String paramString1, String paramString2)
      throws IOException
    {
      writeContentDisposition(paramString1, null, null);
      writeLine("%s", new Object[] { paramString2 });
      writeRecordBoundary();
      if (this.logger != null)
        this.logger.appendKeyValue("    " + paramString1, paramString2);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.Request
 * JD-Core Version:    0.6.2
 */