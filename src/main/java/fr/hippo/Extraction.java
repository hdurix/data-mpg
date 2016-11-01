package fr.hippo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by hippo on 13/09/2016.
 */
public class Extraction {

    public String callWebService(final String url, final String token) throws Exception {
        Client client = Client.create();
        WebResource webResource = client.resource(url);
        ClientResponse response = webResource.header("Authorization", token).get(ClientResponse.class);
        if (response.getStatus() != 200) {
            throw new Exception(response.toString());
        }
        return response.getEntity(String.class);
    }

    public PlayerList extractFromJson(String json) {
        ObjectMapper mapper = new ObjectMapper();
        PlayerList list;
        try {
            list = mapper.readValue(json, PlayerList.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    public void writeInFile(String fileName, List<String> lines) {
        try {
            Files.write(Paths.get(fileName), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
