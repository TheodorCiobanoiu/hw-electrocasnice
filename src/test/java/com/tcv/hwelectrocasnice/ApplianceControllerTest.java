package com.tcv.hwelectrocasnice;

import com.tcv.hwelectrocasnice.controller.ApplianceController;
import com.tcv.hwelectrocasnice.model.Appliance;
import com.tcv.hwelectrocasnice.model.ApplianceType;
import com.tcv.hwelectrocasnice.service.ApplianceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ApplianceController.class)
public class ApplianceControllerTest {

    @MockBean
    ApplianceService applianceService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void it_should_add_appliance() throws Exception {
        String request = new String( "{\"name\":\"Aragaz\", \"applianceType\":\"ELB\", \"stock\":\"10\"}");
        mockMvc.perform(post("/appliance/save")
                        .content(request)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void it_should_get_all_appliances() throws Exception{
        Appliance testAppliance = new Appliance(null,"Aragaz", ApplianceType.ELB, 10, false);
        mockMvc.perform(get("appliance/all"))
                .andExpect(status().isOk());
    }

    @Test
    public void it_should_add_stock() throws Exception {
        Appliance testAppliance = new Appliance(null,"Aragaz", ApplianceType.ELB, 10, false);
        mockMvc.perform(post("/appliance/update-stock/1")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }

}
