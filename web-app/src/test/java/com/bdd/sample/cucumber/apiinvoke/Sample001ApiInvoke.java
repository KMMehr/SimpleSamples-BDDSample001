package com.bdd.sample.cucumber.apiinvoke;

import com.bdd.sample.domain.model.Sample001;
import com.bdd.sample.domain.resource.data.Sample001DC;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.Charset;
import java.util.Arrays;
import static org.junit.Assert.*;

@AutoConfigureMockMvc
public class Sample001ApiInvoke extends BDDAuthorizedInvoke {

    private String ConvertSample001RequestToJson(Sample001DC sample001DC) throws  Exception {
       return objectMapper.writeValueAsString(sample001DC);
    }

    public Sample001 PersistSample001(Sample001DC sample001DC) throws  Exception
    {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/bddSample/sample001")
                .accept(MediaType.APPLICATION_JSON)
                .content(ConvertSample001RequestToJson(sample001DC))
                .contentType(MediaType.APPLICATION_JSON)
                //.header("Authorization" , this.getAuthorizationHeaderValue())
                 ;
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
        Sample001 sample001= new Sample001();
        sample001= objectMapper.readValue(response.getContentAsString(), Sample001.class);
        return  sample001;
    }

    public void IsExistsSample001Request(Sample001DC sample001DC) throws Exception
    {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/bddSample/sample001")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                //.header("Authorization" , this.getAuthorizationHeaderValue())
                ;
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());


        Sample001[] sample001Array = objectMapper.readValue(response.getContentAsString(Charset.forName("UTF8")), Sample001[].class);
        assertEquals(true , Arrays.stream(sample001Array).anyMatch(smple001 -> smple001.
                isEqualToSample001RequestFieldByFieldCaseInsensetive(sample001DC)));
        assertNotNull(response.getContentAsString());
    }

    public void DeleteAllSample001s() throws  Exception
    {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/api/bddSample/sample001/delete-all")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                //.header("Authorization" , this.getAuthorizationHeaderValue())
                ;
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }



}