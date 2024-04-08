package com.bdd.sample.cucumber.apiinvoke;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.security.oauth2.client.OAuth2RestTemplate;
//import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
public class BDDAuthorizedInvoke {

//    private static OAuth2AccessToken QCBDDSampleToken =null;

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

//    @Autowired
//    @Qualifier("BDDSample_QC_ResourceOwnerPasswordRestTemplate")
//    private  OAuth2RestTemplate oAuth2RestTemplate;

//    protected String  getAuthorizationHeaderValue()
//    {
//        this.refreshAuthorizationToken();
//         return String.format("%s %s", QCBDDSampleToken.getTokenType(), QCBDDSampleToken.getValue());
//                //"bearer 23232d5f-624a-46f6-9505-737d1b6493b6";
//    }
//
//    private void refreshAuthorizationToken()  {
//        if(QCBDDSampleToken ==null)
//            QCBDDSampleToken = oAuth2RestTemplate.getAccessToken();
//        if(QCBDDSampleToken.isExpired()) {
//            oAuth2RestTemplate.getOAuth2ClientContext().setAccessToken(null);
//            QCBDDSampleToken =   oAuth2RestTemplate.getAccessToken();
//        }
//    }
}
