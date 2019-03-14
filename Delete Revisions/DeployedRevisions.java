package apigee.delete.undeployedrevision;

import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DeployedRevisions {

	public static ArrayList<String> deployedRevision(String protocol, Client client, String domainName, String orgName,
			String proxyName) {
		ArrayList<String> deployedR = new ArrayList<String>();
		int loopVar1 = 100;
		int loopVar2 = 100;
		// retrieving the deployed revisions details
		// resource url
		WebTarget target1 = client.target(
				protocol + "://" + domainName + "/v1/organizations/" + orgName + "/apis/" + proxyName + "/deployments");

		String responseValue = target1.request(MediaType.APPLICATION_JSON).get(String.class);

		JSONObject json;
		try {
			json = new JSONObject(responseValue);
			JSONArray name1 = json.getJSONArray("environment");

			for (loopVar1 = 0; loopVar1 < 100; loopVar1++) {
				try {
					JSONArray name2 = (JSONArray) name1.getJSONObject(loopVar1).get("revision");
					for (loopVar2 = 0; loopVar2 < 100; loopVar2++) {
						try {
							String element = (String) name2.getJSONObject(loopVar2).get("name");
							deployedR.add(element);
						} catch (Exception e) {
							break;
						}
					}

				} catch (Exception e) {
					break;
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return deployedR;
	}

}
