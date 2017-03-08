package com.redrunner.rest.utils;

public final class Constants {

	// /home/ec2-user/reverseGeocodeRequest.json
	// /Users/michaellasso/Documents/hackatons/red-runners/red-runner-rest/reverseGeocodeRequest.json
	public static final String REVERSE_GEOCODE_REQUEST_SRC = "/Users/michaellasso/Documents/hackatons/red-runners/red-runner-rest/reverseGeocodeRequest.json";
	public static final String RESOURCES_PATH = "test.path";

	public static final String SEPARATOR = ":";
	public static final int VALID_TOKEN_TIME = 30;

	public static final String JSON_LATITUDE = "00000001";
	public static final String JSON_LONGITUDE = "00000002";

	// Pitney Bowes constants
	public static String API_FRAGMENT = "geocode-service/v1/transient/{bundleType}/";
	public static String OAUTH2_TOKEN_URL = "http://api.pitneybowes.com/oauth/token";
	public static String LOCATION_INTELLIGENCE_API_URL = "https://api.pitneybowes.com/location-intelligence/"
			+ API_FRAGMENT;
	public static final String ACCESS_TOKEN = "access_token";
	public static final String BEARER = "Bearer ";
	public static final String BASIC = "Basic ";
	public static final String CLIENT_CREDENTIALS = "client_credentials";
	public static final String GRANT_TYPE = "grant_type";
	public static final String AUTH_HEADER = "Authorization";
	public static final String COLON = ":";
	public static final String LINE_SEPERATOR = "line.separator";
	public static final String REVERSE_GEOCODE_API = "reverseGeocode";

}
