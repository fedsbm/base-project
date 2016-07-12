package org.uk.softs.sample.api;

//import java.util.List;
//
//import retrofit.http.Body;
//import retrofit.http.DELETE;
//import retrofit.http.GET;
//import retrofit.http.Headers;
//import retrofit.http.POST;
//import retrofit.http.PUT;
//import retrofit.http.Path;
//import retrofit.http.Query;


import java.util.List;

import org.uk.softs.sample.model.api.SampleResponseData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SampleRetrofitService {

    @GET("/posts")
    Call<List<SampleResponseData>> getExample(@Query("userId") int userId);



/*
* *******   API Examples:  *******
*/

//
//    @Headers({
//            ApiHeaders.JSON_HEADER,
//            ApiHeaders.URL_ENCODED_HEADER_APPJSON,
//            ApiHeaders.CACHE_HEADER})
//    @POST(Apis.HEALTH_API)
//    String getHealth();
//
//    @Headers({
//            ApiHeaders.JSON_HEADER,
//            ApiHeaders.CACHE_HEADER})
//    @GET(Apis.GET_NOTIFICATION_LIST)
//    NotificationList getNotifications(@Query(Apis.PAGE_QUERY_PARAM) int page);
//
//    @Headers({
//            ApiHeaders.JSON_HEADER,
//            ApiHeaders.CACHE_HEADER})
//    @DELETE(Apis.DELETE_GROUP_CONVERSATION)
//    ResponseStatusDTO deleteGroupConversation(@Path("groupId") long groupId);
//
//    @Headers({
//            ApiHeaders.JSON_HEADER,
//            ApiHeaders.CACHE_HEADER})
//    @DELETE(Apis.LEAVE_GROUP)
//    User leaveGroup(@Path("groupId") long groupId);
//
//    @Headers({
//            ApiHeaders.JSON_HEADER,
//            ApiHeaders.CACHE_HEADER})
//    @GET(Apis.GET_USER_INTERESTS)
//    InterestList getUserInterests(
//            @Path(Apis.USER_ID_PARAM) long userId,
//            @Query(Apis.HIGHLIGHTED_PARAM) boolean highlighted);
//
//    @Headers({
//            ApiHeaders.JSON_HEADER,
//            ApiHeaders.URL_ENCODED_HEADER_APPJSON})
//    @POST(Apis.SIGN_UP)
//    User postSignUp(@Body SignUpDTO signUpDTO);
//
//    @Headers({
//            ApiHeaders.JSON_HEADER,
//            ApiHeaders.CACHE_HEADER})
//    @GET(Apis.GET_MESSAGE_INDIVIDUAL_LIST_V2)
//    List<MessageDetail> getIndividualMessages(@Path(Apis.USER_ID_PARAM) long userId,
//                                              @Query(Apis.TIMESTAMP_QUERY_PARAM) long timestamp,
//                                              @Query(Apis.OLDER_QUERY_PARAM) boolean older);
//
//    @Headers({
//            ApiHeaders.JSON_HEADER,
//            ApiHeaders.CACHE_HEADER})
//    @GET(Apis.GET_MESSAGE_GROUP_LIST_V2)
//    List<MessageDetail> getGroupMessages(@Path(Apis.GROUP_ID_PARAM) long groupId,
//                                         @Query(Apis.TIMESTAMP_QUERY_PARAM) long timestamp,
//                                         @Query(Apis.OLDER_QUERY_PARAM) boolean older);
//
//
//    @POST(Apis.POST_INDIVIDUAL_MESSAGE)
//    MessageDetail postIndividualMessage(@Body MessageContentDTO body,
//                                        @Path(Apis.USER_ID_PARAM) long userId);
//
//    @Headers({
//            ApiHeaders.CACHE_HEADER})
//    @GET(Apis.GET_PLAN_LIST_V2)
//    List<Plan> listPlansV2(@Query("timestamp") long timestamp, @Query("older") boolean older);
//
//    @GET(Apis.GET_FEED_MEDIA_STATUS)
//    StringDTO getFeedMediaStatus(
//            @Path(Apis.FEED_ID_PARAM) long messageId,
//            @Query(Apis.MEDIATYPEVALUE_QUERY_PARAM) int mediaTypeValue);
//
//    @Headers({
//            ApiHeaders.JSON_HEADER,
//            ApiHeaders.CACHE_HEADER})
//    @PUT(Apis.UPDATE_USER_LOCATION)
//    User updateUserLocation(@Body LocationDTO body);
//
//    @Headers({
//            ApiHeaders.JSON_HEADER,
//            ApiHeaders.CACHE_HEADER
//    })
//    @POST("/user/{userId}/report")
//    ResponseStatusDTO reportUserOrGroup(@Path("userId") long userId);
//
//
//    @Headers({ApiHeaders.JSON_HEADER})
//    @DELETE(Apis.BUDDY_URL)
//    Void deleteBuddy(
//            @Path(Apis.USER_ID_PARAM) long userId);

}
