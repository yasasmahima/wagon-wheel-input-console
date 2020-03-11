package httpRequestHandler;

public class ReqHandler{

	public static void addShot(int playerID, String playerTeam,int playerSession,int scoreShot, float scoreX, float scoreY){
		OkHttpClient client = new OkHttpClient().newBuilder()
			.build();
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, "playerID="+playerID+"&playerTeam="+playerTeam+"&playerSession="+playerSession+"&scoreShot="+scoreShot+"&scoreX="+scoreX+"&scoreY="+scoreY);
		Request request = new Request.Builder()
			.url("ec2-18-217-163-34.us-east-2.compute.amazonaws.com:8080/api/score")
			.method("POST", body)
			.addHeader("Content-Type", "application/x-www-form-urlencoded")
			.build();
	}
	
	public static Response playerList(String playerTeam){
		OkHttpClient client = new OkHttpClient().newBuilder()
			.build();
		Request request = new Request.Builder()
			.url("ec2-18-217-163-34.us-east-2.compute.amazonaws.com:8080/api/player/"+playerTeam)
			.method("GET", null)
			.build();
		Response response = client.newCall(request).execute();
		return response;
	}
}
